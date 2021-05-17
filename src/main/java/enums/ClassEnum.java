package enums;

/**
 * Enum class to get the name of classes.
 */
public enum ClassEnum {
    AUTHORIZATION("Authorization"),
    FORMAT_XML("xml"),
    FORMAT_JSON("json");

    private String field;

    /**
     * Constructor of class.
     *
     * @param field to choose.
     */
    ClassEnum(final String field) {
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
