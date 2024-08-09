package api.ApiData;

import api.models.UserCredentials;
import com.github.javafaker.Faker;



public class ApiDataGenerator {

    public UserCredentials createUserCredentials() {
        Faker faker = new Faker();
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUserName((faker.name().firstName()+faker.name().lastName()).toLowerCase());
        userCredentials.setPassword(faker.animal().name().toLowerCase());
        return userCredentials;
    }

}
