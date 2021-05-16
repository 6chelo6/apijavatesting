import api.Connection;
import config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.util.Base64;

public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String args[]) {
        System.out.println("Hello, WOrld!");

        // Using Rest-Assured class to setup a request
        RestAssured.baseURI = "https://todo.ly/api/authentication/token.json";

        // Getting the RequestSpecification of the request
        RequestSpecification httpRequest = RestAssured.given();
        final ApiConfig API_CONFIG = ApiConfig.getInstance();
        String originalInput = String.format("%s:%s", API_CONFIG.getUsername(), API_CONFIG.getPassword());
        httpRequest.header(new Header("Authorization", "Basic " +
                Base64.getEncoder().encodeToString(originalInput.getBytes())));
        Response response = null;

        try {
            // Making GET request directly by RequestSpecification.get() method
            response = httpRequest.get();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        System.out.println(response.asString());
    }
}
