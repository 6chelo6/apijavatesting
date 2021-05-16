package utils;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Manages environment utilities.
 */
public class EnvUtils {
    private static final Logger LOGGER = Logger.getLogger(EnvUtils.class);
    private static EnvUtils envUtils;
    private static final String ENCODING = "UTF-8";

    /**
     * Private constructor for EnvUtils class.
     */
    private EnvUtils() {

    }

    /**
     * This method instances EnvUtils if it does not exist.
     *
     * @return EnvUtils instance.
     */
    public static EnvUtils getInstance() {
        if (envUtils == null) {
            envUtils = new EnvUtils();
        }
        return envUtils;
    }

    /**
     * Converts a Json String to a concrete Object.
     *
     * @param jsonString is the target Json String to convert.
     * @param valueType  is a concrete Object class type.
     * @param <T>        is an Object type.
     * @return a concrete Object holding the Json String original data.
     */
    public <T> T convertToEntity(final String jsonString, final Class<T> valueType) {
        final Gson g = new Gson();
        return g.fromJson(jsonString, valueType);
    }

    /**
     * This method reads a Json file and retrieves a JSONObject from it given the file path.
     *
     * @param filePath to use for file reading.
     * @return a JSONObject with the Json file data.
     */
    public JSONObject getJSONObjectFile(final String filePath) {
        JSONObject jsonObject = null;
        final JSONParser jsonParser = new JSONParser();
        try {
            final FileInputStream file = new FileInputStream(filePath);
            jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(file, ENCODING));
        } catch (IOException e) {
            LOGGER.info("The file couldn't be read", e);
        } catch (ParseException e) {
            LOGGER.info("The file couldn't be parsed", e);
        }
        return jsonObject;
    }
}
