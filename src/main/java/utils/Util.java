package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public final class Util {
    private static final Logger LOGGER = Logger.getLogger(Util.class);

    /**
     * This method encodes authentication Base64 with username:password value.
     */
    public static String getEncodedAuthentication(final String username, final String password) {
        String originalInput = String.format("%s:%s", username, password);
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }


    /**
     * Gets the Schema instance given the JSON Schema path, this schema instance is used to validate the response.
     *
     * @param schemaPath schema path file.
     * @return the schema instance.
     */
    public static Schema getSchemaInstance(final String schemaPath) {
        String schemaString;
        JSONObject schemaObject;
        Schema schemaToReturn = null;
        try {
            schemaString = new String(Files.readAllBytes(Paths.get(schemaPath)));
            schemaObject = new JSONObject(schemaString);
            schemaToReturn = SchemaLoader.load(schemaObject);
        } catch (IOException e) {
            LOGGER.error(String.format("Error reading the file: %s", e.getMessage()));
        }
        return schemaToReturn;
    }

    /**
     * Gets Object from given response.
     *
     * @param response the requested response.
     * @return the JSONObject or JSONArray.
     */
    public static Object getDataJSON(final Response response) {
        final Object data = response.jsonPath().get("");
        if (data instanceof ArrayList) {
            return getDataJSONArray(response);
        } else if (data instanceof HashMap) {
            return getDataJSONObject(response);
        } else if (data instanceof String) {
            return data;
        } else {
            final String errorMessage = "Error, the response does not have JSONObject, JSONArray or String objects";
            LOGGER.error(errorMessage);
            return null;
        }
    }

    /**
     * Gets JSONArray from given response.
     *
     * @param response the requested response.
     * @return the JSONArray.
     */
    public static JSONArray getDataJSONArray(final Response response) {
        try {
            Gson gson = new GsonBuilder().serializeNulls().create(); // keeps null values
            return new JSONArray(gson.toJson(response.jsonPath().getObject("", ArrayList.class)));
        } catch (Exception e) {
            final String errorMessage = "Error, the response cannot convert to JSONArray object: %s";
            LOGGER.error(String.format(errorMessage, e));
            return null;
        }
    }

    /**
     * Gets JSONObject from given response.
     *
     * @param response the requested response.
     * @return the JSONObject.
     */
    public static JSONObject getDataJSONObject(final Response response) {
        try {
            Gson gson = new GsonBuilder().serializeNulls().create(); // keeps null values
            return new JSONObject(gson.toJson(response.jsonPath().getObject("", HashMap.class)));
        } catch (Exception e) {
            final String errorMessage = "Error, the response cannot convert to JSONObject object: %s";
            LOGGER.error(String.format(errorMessage, e));
            return null;
        }
    }
}
