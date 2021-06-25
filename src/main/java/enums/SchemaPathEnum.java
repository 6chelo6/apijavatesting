package enums;

/**
 * Represents a Schema paths.
 **/
public enum SchemaPathEnum {
    PROJECT("Project.json");

    private final String value;

    /**
     * Constructor.
     *
     * @param value to assign a value.
     */
    SchemaPathEnum(final String value) {
        this.value = value;
    }

    /**
     * Returns the respective value.
     *
     * @param method to define which schema will be used.
     * @return the value.
     */
    public String getValue(final String method) {
        final String schemaFilePath = "src/main/resources/schemaFiles/";
        return schemaFilePath + method.toLowerCase() + value;
    }
}
