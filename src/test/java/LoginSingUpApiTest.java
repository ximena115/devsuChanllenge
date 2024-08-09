import api.ApiData.ApiDataGenerator;
import api.models.FailedResponse;
import api.models.UserCredentials;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;


public class LoginSingUpApiTest extends BaseAPITest {
    protected static final String LONGIN_API = "login";
    protected static final String SINGUP_API = "signup";
    protected static final String ERROR_MSG = "This user already exist.";
    protected static final String ERROR_INCORRECT_MSG = "User does not exist.";

    @Test
    public void successSingUp() {
        ApiDataGenerator apiDataGenerator = new ApiDataGenerator();
        UserCredentials user = apiDataGenerator.createUserCredentials();
        Response successSignUpResponse = postApiRequest(user, SINGUP_API);
        assertEquals(200, successSignUpResponse.getStatusCode());
    }

    @Test
    public void existingUserSignUp() {
        ApiDataGenerator apiDataGenerator = new ApiDataGenerator();
        UserCredentials user = apiDataGenerator.createUserCredentials();
        postApiRequest(user, SINGUP_API);
        Response singUpResponse = postApiRequest(user, SINGUP_API);
        FailedResponse failedResponse = singUpResponse.as(FailedResponse.class);
        assertEquals(200, singUpResponse.getStatusCode());
        assertEquals(ERROR_MSG, failedResponse.getErrorMessage());
    }

    @Test
    public void successLogin() {
        ApiDataGenerator apiDataGenerator = new ApiDataGenerator();
        UserCredentials user = apiDataGenerator.createUserCredentials();
        postApiRequest(user, SINGUP_API);
        Response successSignUpResponse = postApiRequest(user, LONGIN_API);
        assertEquals(200, successSignUpResponse.getStatusCode());
    }

    @Test
    public void incorrectLogin() {
        ApiDataGenerator apiDataGenerator = new ApiDataGenerator();
        UserCredentials user = apiDataGenerator.createUserCredentials();
        Response successSignUpResponse = postApiRequest(user, LONGIN_API);
        FailedResponse failedResponse = response.as(FailedResponse.class);
        assertEquals(200, successSignUpResponse.getStatusCode());
        assertEquals(ERROR_INCORRECT_MSG, failedResponse.getErrorMessage());
    }
}



