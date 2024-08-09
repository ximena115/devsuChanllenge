
import api.models.UserCredentials;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class BaseAPITest {
    protected static Response response;
    protected static final String baseurl = "https://api.demoblaze.com/";

    public static Response postApiRequest(UserCredentials userCredentials, String api) {
        response = given()
                .header("Content-Type", "application/json")
                .body(userCredentials)
                .when()
               .post(baseurl+api);
        return response;
    }
}
