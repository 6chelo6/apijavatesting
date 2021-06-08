package conditions;

import config.ApiConfig;
import enums.ClassEnum;
import helpers.AuthHelper;
import io.restassured.response.Response;

/**
 * Class that manages Auth Conditions.
 */
public class AuthConditions {
    private AuthHelper authHelper;
    private static final ApiConfig API_CONFIG = ApiConfig.getInstance();

    /**
     * Constructor {@link AuthHelper} initializes class settings.
     */
    public AuthConditions() {
        authHelper = new AuthHelper();
    }

    /**
     * A method to get token for authentication given a username and password.
     *
     * @param username value.
     * @param password value.
     * @return The response.
     */
    public Response getAuthToken(final String username, final String password, final String format) {
        return authHelper.getTokenByValues(username, password, format);
    }

    /**
     * A method to get default token for authentication.
     *
     * @param format value.
     * @return The response.
     */
    public Response getDefaultAuthToken(final String format) {
        return authHelper.getDefaultToken(format);
    }

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @param token value.
     * @return The response.
     */
    public boolean isAuthenticated(final String token) {
        return authHelper.isAuthenticated(token, ClassEnum.FORMAT_JSON.get());
    }

    /**
     * A method to delete token value.
     *
     * @param format value.
     * @return The response.
     */
    public Response deleteToken(final String format) {
        return authHelper.deleteToken(format);
    }
}
