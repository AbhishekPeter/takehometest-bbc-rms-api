package helperutil;

import io.restassured.response.Response;
import model.Element;
import model.Root;
import utils.Config;
import utils.Log;

import java.time.Instant;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class BBCApiHelper {

    private Response response;

    public void sendGetRequest(String fullUrl) {
        try {
            Log.info("Sending GET request to endpoint: " + fullUrl);
            response = given().when().get(fullUrl);
            Log.info("Request sent successfully.");
        } catch (Exception e) {
            Log.error("Failed to send GET request: " + e.getMessage());
            throw e;
        }
    }

    public void verifyStatusCode(int expectedStatusCode) {
        try {
            int actualStatusCode = response.getStatusCode();
            Log.info("Verifying status code: Expected = " + expectedStatusCode + ", Actual = " + actualStatusCode);
            assertEquals("Status code mismatch", expectedStatusCode, actualStatusCode);
            Log.info("Status code verification passed.");
        } catch (Exception e) {
            Log.error("Status code assertion failed: " + e.getMessage());
            throw e;
        }
    }

    public void validateResponseTime(int limit) {
        try {
            long responseTime = response.getTime();
            Log.info("Actual response time: " + responseTime + " ms");
            assertTrue("Response time exceeded limit: " + responseTime + " ms", responseTime < limit);
            Log.info("Response time is within acceptable range.");
        } catch (Exception e) {
            Log.error("Response time validation failed: " + e.getMessage());
            throw e;
        }
    }

    public void validateElements() {
        try {
            Root root = response.as(Root.class);
            List<Element> elements = root.getSchedule().getElements();
            assertEquals("Element count mismatch", 5, elements.size());
            Log.info("Validating elements count = 5 and individual fields");

            for (Element e : elements) {
                assertNotNull("Element ID is null", e.getId());
                assertFalse("Element ID is empty", e.getId().trim().isEmpty());
                assertEquals("Incorrect episode type", "episode", e.getEpisode().getType());
            }
            Log.info("Elements validated successfully.");
        } catch (Exception e) {
            Log.error("Element validation failed: " + e.getMessage());
            throw e;
        }
    }

    public void validateEpisodeTitles() {
        try {
            Root root = response.as(Root.class);
            for (Element e : root.getSchedule().getElements()) {
                String title = e.getEpisode().getTitle();
                assertNotNull("Episode title is null", title);
                assertFalse("Episode title is empty", title.trim().isEmpty());
            }
            Log.info("Episode titles validated successfully.");
        } catch (Exception e) {
            Log.error("Episode title validation failed: " + e.getMessage());
            throw e;
        }
    }

    public void onlyOneLiveEpisode() {
        try {
            Root root = response.as(Root.class);
            long count = root.getSchedule().getElements().stream()
                    .filter(e -> e.getEpisode().isLive())
                    .count();
            assertEquals("More than one live episode found", 1, count);
            Log.info("Only one episode is marked live.");
        } catch (Exception e) {
            Log.error("Live episode validation failed: " + e.getMessage());
            throw e;
        }
    }

    public void transmissionDatesValid() {
        try {
            Root root = response.as(Root.class);
            for (Element e : root.getSchedule().getElements()) {
                Instant start = Instant.parse(e.getTransmission_start());
                Instant end = Instant.parse(e.getTransmission_end());
                assertTrue("Start is not before end", start.isBefore(end));
            }
            Log.info("Transmission dates validated successfully.");
        } catch (Exception e) {
            Log.error("Transmission date validation failed: " + e.getMessage());
            throw e;
        }
    }

    public void validateresponseheader() {
        try {
            String dateHeader = response.getHeader("Date");
            assertNotNull("Date header is missing", dateHeader);
            Log.info("'Date' header is present: " + dateHeader);
        } catch (Exception e) {
            Log.error("'Date' header missing in response: " + e.getMessage());
            throw e;
        }
    }

    public void verifyResponseContains(String key) {
        try {
            String body = response.getBody().asString();
            assertTrue("Response does not contain expected key: " + key, body.contains(key));
            Log.info("Response contains expected key: " + key);
        } catch (AssertionError e) {
            Log.error("Key '" + key + "' not found in response: " + e.getMessage());
            throw e;
        }
    }
}