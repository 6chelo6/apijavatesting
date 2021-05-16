package config;

/**
 * Endpoint enum.
 */
public enum Endpoint {
    TOKEN_FORMAT("/authentication/token.%s");

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
