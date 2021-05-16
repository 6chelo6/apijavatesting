package config;

import entity.Environment;
import org.json.simple.JSONObject;
import utils.EnvUtils;
import utils.PathUtils;

import java.util.Objects;

/**
 * Manages reading of the API environment variables.
 */
public class ApiConfig {
    private static final String ENV_PATH = "/src/main/resources/environment.json";
    private static final EnvUtils ENV_UTILS = EnvUtils.getInstance();
    private static ApiConfig instance;
    private JSONObject jsonConfigObject;
    private String baseUri;
    private String apiVersion;
    private String username;
    private String password;

    /**
     * Initializes an instance of {@link ApiConfig}.
     */
    private ApiConfig() {
        readJsonEnvFile();
        setEnvironmentConfigVars();
    }

    /**
     * Initializes the Singleton {@link ApiConfig} instance.
     *
     * @return singleton instance.
     */
    public static synchronized ApiConfig getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ApiConfig();
        }
        return instance;
    }

    /**
     * <p>This method gets baseUri value.</p>
     *
     * @return baseUri value.
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * <p>This method gets apiVersion value.</p>
     *
     * @return apiVersion value.
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * <p>This method gets username value.</p>
     *
     * @return username value.
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>This method gets password value.</p>
     *
     * @return password value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Reads API Json environment configuration file.
     */
    private void readJsonEnvFile() {
        jsonConfigObject = ENV_UTILS.getJSONObjectFile(PathUtils.getAbsolutePath(ENV_PATH));
    }

    /**
     * Sets the environment configuration variables.
     */
    private void setEnvironmentConfigVars() {
        final Environment environment = ENV_UTILS.convertToEntity(String.valueOf(jsonConfigObject), Environment.class);
        baseUri = environment.getBaseUri();
        apiVersion = environment.getApiVersion();
        username = environment.getUsername();
        password = environment.getPassword();
    }
}
