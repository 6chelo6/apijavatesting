package conditions;

import entity.ProjectBody;
import enums.ClassEnum;
import helpers.ProjectHelper;
import io.restassured.response.Response;

/**
 * Project Conditions class.
 */
public class ProjectConditions {
    private ProjectHelper projectHelper;

    /**
     * Constructor {@link ProjectConditions} initializes class settings.
     */
    public ProjectConditions() {
        projectHelper = new ProjectHelper();
    }

    /**
     * A method to post new project.
     *
     * @return The response.
     */
    public Response post(final String format) {
        final ProjectBody projectBody = new ProjectBody.ProjectBodyBuilder().build();
        return projectHelper.post(projectBody, format);
    }

    /**
     * A method to get all projects.
     *
     * @return The response.
     */
    public Response getAll(final String format) {
        return projectHelper.getAll(format);
    }

    /**
     * A method to get all projects.
     *
     * @return The response.
     */
    public Response delete(final String id, final String format) {
        return projectHelper.delete(id, format);
    }
}
