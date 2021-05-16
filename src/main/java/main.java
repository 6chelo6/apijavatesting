import conditions.AuthConditions;
import org.apache.log4j.Logger;

public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String args[]) {
        LOGGER.info("Hello, WOrld!");

        final String tokenValue = "abc123";
        final AuthConditions authConditions = new AuthConditions();
        LOGGER.info(String.format("Is user authenticated? %s", authConditions.isAuthenticated(tokenValue)));
    }
}
