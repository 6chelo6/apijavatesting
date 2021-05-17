package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import utils.Util;

import static io.restassured.RestAssured.given;

public class RequestManager {
    private static final Logger LOGGER = Logger.getLogger(RequestManager.class);
    private static String endPoint;
    private static RequestSpecification requestSpecification = Connection.getInstance().getRequestSpecification();

    /**
     * private constructor for RequestManager class.
     */
    private RequestManager() {
        throw new AssertionError("Instantiating utility class.");
    }

    /**
     * Sets the endPoint value.
     *
     * @param endpoint the new endpoint value.
     */
    public static void setEndpoint(final String endpoint) {
        RequestManager.endPoint = endpoint;
    }

    /**
     * Restart the request specification value with specified token.
     *
     * @param token The API token information.
     */
    public static void restartRequestSpecification(final String token) {
        requestSpecification = Connection.setConnectionByToken(token).getRequestSpecification();
    }

    /**
     * Restart the request specification value with specified token.
     *
     * @param username value.
     * @param password value.
     */
    public static void restartRequestSpecification(final String username, final String password) {
        requestSpecification = Connection.setConnectionByToken(Util.getEncodedAuthentication(username, password))
                .getRequestSpecification();
    }

    /**
     * Restart the request specification values.
     */
    public static void restartRequestSpecification() {
        requestSpecification = Connection.restartConnection().getRequestSpecification();
    }

    /**
     * Method that execute a get request.
     *
     * @return response of the request.
     */
    public static Response get() {
        final Response response = given().spec(requestSpecification)
                .when()
                .get(endPoint);
        return response;
    }

}
