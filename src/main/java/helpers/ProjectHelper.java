package helpers;

import api.RequestManager;
import config.Endpoint;
import entity.ProjectBody;
import io.restassured.response.Response;

/**
 * Class that manages Project Helper.
 */
public class ProjectHelper {

    /**
     * A method to post new project.
     *
     * @return The response.
     */
    public Response post(final ProjectBody body, final String format) {
        RequestManager.setEndpoint(String.format(Endpoint.POST_PROJECT.get(), format));
        return RequestManager.post(body);
    }

}
