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

    /**
     * A method to get all projects.
     *
     * @return The response.
     */
    public Response getAll(final String format) {
        RequestManager.setEndpoint(String.format(Endpoint.GET_ALL_PROJECTS.get(), format));
        return RequestManager.get();
    }

    /**
     * A method to delete a project by id.
     *
     * @return The response.
     */
    public Response delete(final String id, final String format) {
        RequestManager.setEndpoint(String.format(Endpoint.DELETE_PROJECT.get(), id, format));
        return RequestManager.delete();
    }
}
