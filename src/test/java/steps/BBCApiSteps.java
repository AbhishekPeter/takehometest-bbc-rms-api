package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import helperutil.BBCApiHelper;

public class BBCApiSteps {

    BBCApiHelper apiHelper = new BBCApiHelper();

    @Given("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        apiHelper.sendGetRequest(endpoint);
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int expectedStatusCode) {
        apiHelper.verifyStatusCode(expectedStatusCode);
    }

    @And("response time should be below {int} milliseconds")
    public void responseTimeShouldBeBelowMilliseconds(int limit) {
        apiHelper.validateResponseTime(limit);
    }

    @Then("all elements should have non-empty id and episode type episode")
    public void allElementsShouldHaveNonEmptyIdAndEpisodeTypeEpisode() {
        apiHelper.validateElements();
    }

    @Then("all episode titles should be non-null and non-empty")
    public void allEpisodeTitlesShouldBeNonNullAndNonEmpty() {
        apiHelper.validateEpisodeTitles();
    }

    @Then("only one episode should be live")
    public void onlyOneEpisodeShouldBeLive() {
        apiHelper.onlyOneLiveEpisode();
    }

    @Then("transmission start should be before transmission end")
    public void transmissionStartShouldBeBeforeTransmissionEnd() {
        apiHelper.transmissionDatesValid();
    }

    @Then("response header should contain Date")
    public void responseHeaderShouldContainDate() {
        apiHelper.validateresponseheader();
    }

    @And("the response should contain {string}")
    public void theResponseShouldContain(String key) {
        apiHelper.verifyResponseContains(key);
    }

}
