package api;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Util;

import static io.restassured.RestAssured.given;

public class RequestManager {
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
        return given().spec(requestSpecification)
                .when()
                .get(endPoint);
    }

    /**
     * Method that execute a post account request given an object as a data.
     *
     * @param body data to be send as params.
     * @return response of the request.
     */
    public static Response post(final Object body) {
        final String json = new Gson().toJson(body);
        return given().spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(endPoint);
    }

    /**
     * Method that execute a get request.
     *
     * @return response of the request.
     */
    public static Response delete() {
        return given().spec(requestSpecification)
                .when()
                .delete(endPoint);
    }
}
