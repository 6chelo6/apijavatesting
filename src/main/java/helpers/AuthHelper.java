package helpers;

import api.RequestManager;
import config.Endpoint;
import io.restassured.response.Response;

/**
 * Class that manages Authentication Helper.
 */
public class AuthHelper {

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @return The response.
     */
    public Response getToken(final String format) {
        RequestManager.setEndpoint(String.format(Endpoint.GET_TOKEN_FORMAT.get(), format));
        return RequestManager.get();
    }

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @return The response.
     */
    public Response getTokenByValues(final String username, final String password, final String format) {
        RequestManager.restartRequestSpecification(username, password);
        RequestManager.setEndpoint(String.format(Endpoint.GET_TOKEN_FORMAT.get(), format));
        final Response response = RequestManager.get();
        RequestManager.restartRequestSpecification();
        return response;
    }

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @return The response.
     */
    public Response getDefaultToken(final String format) {
        RequestManager.restartRequestSpecification();
        RequestManager.setEndpoint(String.format(Endpoint.GET_TOKEN_FORMAT.get(), format));
        return RequestManager.get();
    }

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @param token  value.
     * @param format value.
     * @return The response.
     */
    public boolean isAuthenticated(final String token, final String format) {
        RequestManager.restartRequestSpecification(token);
        RequestManager.setEndpoint(String.format(Endpoint.GET_IS_AUTHENTICATED.get(), format));
        final boolean response = Boolean.parseBoolean(RequestManager.get().asString());
        RequestManager.restartRequestSpecification();
        return response;
    }

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @return The response.
     */
    public Response deleteToken(final String format) {
        RequestManager.restartRequestSpecification();
        RequestManager.setEndpoint(String.format(Endpoint.DELETE_TOKEN_FORMAT.get(), format));
        return RequestManager.delete();
    }
}
