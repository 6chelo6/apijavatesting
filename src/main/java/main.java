import conditions.AuthConditions;
import conditions.ProjectConditions;
import enums.ClassEnum;
import org.apache.log4j.Logger;

public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String args[]) {
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
        LOGGER.info(String.format("Response post project: %s", projectConditions.post(ClassEnum.FORMAT_JSON.get())
                .asString()));
    }
}
