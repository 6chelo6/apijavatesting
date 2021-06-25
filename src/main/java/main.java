import conditions.AuthConditions;
import conditions.ProjectConditions;
import entity.Project;
import enums.ClassEnum;
import enums.SchemaPathEnum;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import utils.EnvUtils;

import static utils.Util.getDataJSON;
import static utils.Util.getSchemaInstance;

/**
 * Manages Main class.
 */
public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class);

    /**
     * Main method.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        LOGGER.info("Hello, WOrld!");

        final String tokenValue = "abc123";
        final AuthConditions authConditions = new AuthConditions();
        // IS AUTHENTICATED WITH WRONG TOKEN
        LOGGER.info(String.format("Is user authenticated with token '%s'? %s", tokenValue,
                authConditions.isAuthenticated(tokenValue)));

        // GET TOKEN WITH DEFAULT JSON VALUES
        LOGGER.info(String.format("Response default token: %s", authConditions.getDefaultAuthToken(
                ClassEnum.FORMAT_JSON.get()).asString()));

        // GET TOKEN WITH WRONG VALUES
        final String username = "test@test.com";
        final String password = "password";
        LOGGER.info(String.format("Response token by non-existent values: %s", authConditions.getAuthToken(username, password,
                ClassEnum.FORMAT_JSON.get()).asString()));

        // DELETE TOKEN
        LOGGER.info(String.format("Response delete token: %s", authConditions.getDefaultAuthToken(
                ClassEnum.FORMAT_JSON.get()).asString()));

        // POST PROJECT
        final ProjectConditions projectConditions = new ProjectConditions();
        Response response = projectConditions.post(ClassEnum.FORMAT_JSON.get());
        final Project createdProject = EnvUtils.getInstance().convertToEntity(response.asString(), Project.class);
        LOGGER.info(String.format("Response post project: %s", response.asString()));

        // Validates schema response for Post Project request
        final String schemaName = "PROJECT";
        final String method = "post";
        final String filePath = SchemaPathEnum.valueOf(schemaName).getValue(method);
        final Schema schema = getSchemaInstance(filePath);
        final Object json = getDataJSON(response);
        try {
            schema.validate(json);
        } catch (ValidationException e) {
            throw new AssertionError(e.getAllMessages());
        }

        // GET ALL PROJECTS
        LOGGER.info(String.format("Response get all projects: %s", projectConditions.getAll(ClassEnum.FORMAT_JSON.get())
                .asString()));

        // DELETE PROJECT
        final String projectId = String.valueOf(createdProject.getId());
        response = projectConditions.delete(projectId, ClassEnum.FORMAT_JSON.get());
        LOGGER.info(String.format("Response delete project: %s", response.asString()));
        // Validate project isDeleted
        final Project deletedProject = EnvUtils.getInstance().convertToEntity(response.asString(), Project.class);
        LOGGER.info(String.format("Deleted project <%s>: %s", deletedProject.getId(), deletedProject.isDeleted()));
    }
}
