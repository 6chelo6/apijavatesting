package conditions;

import api.RequestManager;
import config.Endpoint;
import enums.ClassEnum;
import helpers.AuthHelper;
import io.restassured.RestAssured;

import java.net.Authenticator;

/**
 * Class that manages Auth Conditions.
 */
public class AuthConditions {
    private AuthHelper authHelper;

    /**
     * Constructor {@link AuthHelper} initializes class settings.
     */
    public AuthConditions() {
        authHelper = new AuthHelper();
    }

    /**
     * A method to get token for authentication given a username and password.
     *
     * @param username username.
     * @param password password.
     * @return The response.
     */
    public String getAuthToken(final String username, final String password) {
        RequestManager.setEndpoint(String.format(Endpoint.GET_TOKEN_FORMAT.get(), username, password));
        return RequestManager.get().jsonPath().get("data.token");
    }

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @param token value.
     * @return The response.
     */
    public boolean isAuthenticated(final String token) {
        return authHelper.isAuthenticated(token);
    }

}
