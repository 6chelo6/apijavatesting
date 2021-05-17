import conditions.AuthConditions;
import enums.ClassEnum;
import org.apache.log4j.Logger;

public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String args[]) {
        LOGGER.info("Hello, WOrld!");

        final String tokenValue = "abc123";
        final AuthConditions authConditions = new AuthConditions();
        LOGGER.info(String.format("Is user authenticated with token '%s'? %s", tokenValue,
                authConditions.isAuthenticated(tokenValue)));
        LOGGER.info(String.format("Response default token: %s", authConditions.getDefaultAuthToken(ClassEnum.FORMAT_JSON.get())
                .asString()));
        final String username = "test@test.com";
        final String password = "password";
        LOGGER.info(String.format("Response token by values: %s", authConditions.getAuthToken(username, password,
                ClassEnum.FORMAT_JSON.get()).asString()));
    }
}
