// API utility code

package utils;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;

public class ApiUtils {
    public static Response getResponse(String endpoint) {
        return given()
                .header("Accept", "application/json")
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}

