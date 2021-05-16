package helpers;

import api.RequestManager;
import config.Endpoint;
import enums.ClassEnum;

/**
 * Class that manages Authentication Helper.
 */
public class AuthHelper {

    /**
     * A method to verify if user is authenticated given a token value.
     *
     * @param token value.
     * @return The response.
     */
    public boolean isAuthenticated(final String token) {
        RequestManager.restartRequestSpecification(token);
        RequestManager.setEndpoint(String.format(Endpoint.GET_IS_AUTHENTICATED.get(), ClassEnum.FORMAT_JSON.get()));
        final boolean response = Boolean.parseBoolean(RequestManager.get().asString());
        RequestManager.restartRequestSpecification();
        return response;
    }

}
