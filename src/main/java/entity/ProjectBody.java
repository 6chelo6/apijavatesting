package entity;

import com.github.javafaker.Faker;
import com.google.gson.annotations.SerializedName;

/**
 * Manages the Project body class.
 */
public class ProjectBody {
    @SerializedName("Content")
    private String content;
    private byte icon;

    private ProjectBody(ProjectBodyBuilder builder) {
        this.content = builder.content;
        this.icon = builder.icon;
    }

    public String getContent() {
        return content;
    }

    public byte getIcon() {
        return icon;
    }

    public static class ProjectBodyBuilder {
        @SerializedName("Content")
        private String content;
        private byte icon;

        /**
         * Constructor {@link ProjectBodyBuilder} initializes class settings.
         */
        public ProjectBodyBuilder() {
            this.content = Faker.instance().company().name();
            this.icon = 4;
        }

        public ProjectBodyBuilder content(final String content) {
            this.content = content;
            return this;
        }

        public ProjectBodyBuilder icon(final byte icon) {
            this.icon = icon;
            return this;
        }

        /**
         * Return the finally constructed ProjectBody object.
         *
         * @return project body.
         */
        public ProjectBody build() {
            return new ProjectBody(this);
        }
    }
}
