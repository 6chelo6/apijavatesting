package config;

/**
 * Endpoint enum.
 */
public enum Endpoint {
    DELETE_TOKEN_FORMAT("/authentication/token.%s"),
    GET_TOKEN_FORMAT("/authentication/token.%s"),
    GET_IS_AUTHENTICATED("/authentication/isauthenticated.%s"),

    // PROJECT endpoints
    POST_PROJECT("/projects.%s"),
    GET_ALL_PROJECTS("/projects.%s"),
    DELETE_PROJECT("/projects/%s.%s");

    private String field;

    /**
     * Constructor endpoint.
     *
     * @param field to set
     */
    Endpoint(final String field) {
        this.field = field;
    }

    /**
     * Gets the field value.
     *
     * @return field value.
     */
    public String get() {
        return field;
    }
}
