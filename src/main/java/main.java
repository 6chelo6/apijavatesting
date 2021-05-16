import api.Connection;
import org.apache.log4j.Logger;

public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String args[]) {
        System.out.println("Hello, WOrld!");

        Connection connection = Connection.getInstance();
    }
}
