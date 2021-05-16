package api;

import config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

/**
 * Class to manage the connection to API.
 */
public class Connection {
    private static Connection connection;
    private static RequestSpecification requestSpecification;
    private static final ApiConfig API_CONFIG = ApiConfig.getInstance();

    static {
        RestAssured.baseURI = String.format("%s%s", API_CONFIG.getBaseUri(), API_CONFIG.getApiVersion());
    }

    /**
     * This method is in charge to initialize the connection.
     */
    private Connection() {
        requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.header(new Header("Authorization", "Basic " + getEncodedAuthentication()));
    }

    /**
     * This method is in charge to initialize the connection.
     *
     * @param token the APi Token information.
     */
    private Connection(final String token) {
        requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.header(new Header("Authorization", "Basic " + token));
    }

    /**
     * Restart the connection to change the API Token.
     *
     * @return a new connection.
     */
    public static Connection restartConnection() {
        requestSpecification = new RequestSpecBuilder().build();
        connection = new Connection();
        return connection;
    }

    /**
     * Create new connection with new token.
     * Before creation save old headers in case you need to restore them (you can do it via new Connection())
     *
     * @param token the APi Token information.
     * @return {@link Connection}
     */
    public static Connection setConnectionByToken(final String token) {
        requestSpecification = new RequestSpecBuilder().build();
        connection = new Connection(token);
        return connection;
    }

    /**
     * this method initiate the connection if this does not exist.
     *
     * @return {@link Connection}
     */
    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    /**
     * Gets request specification.
     *
     * @return {@link RequestSpecification}
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    /**
     * Adds header to the RequestSpecification.
     *
     * @param header is header.
     */
    public void addHeader(final Header header) {
        requestSpecification.header(header);
    }

    /**
     * This method encodes authetication Base64 with username:password value.
     */
    private String getEncodedAuthentication() {
        String originalInput = String.format("%s:%s", API_CONFIG.getUsername(), API_CONFIG.getPassword());
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }
}
