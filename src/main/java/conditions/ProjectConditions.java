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
        return projectHelper.post(projectBody, ClassEnum.FORMAT_JSON.get());
    }
}
