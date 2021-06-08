package utils;

import java.io.File;
import java.util.regex.Matcher;

/**
 * handles the Path to be used in any environment.
 */
public final class PathUtils {

    private static final String CURRENT_DIRECTORY = ".";
    private static final String PATH_WINDOWS_REGEX = "^[A-Z]:\\\\.*";
    private static final String EMPTY_STRING = "";
    private static final String SLASH = "/";
    private static final String BACK_SLASH = "\\";
    private static final String REPLACE_DOT_REGEX = "\\.$";

    /**
     * Private constructor for {@link PathUtils} utility class.
     */
    private PathUtils() {
        //Default constructor.
    }

    /**
     * Gets the current absolute path of the working directory.
     *
     * @param path base directory path.
     * @return current absolute path.
     */
    public static String getAbsolutePath(final String path) {
        String currentPath = new File(CURRENT_DIRECTORY).getAbsolutePath();
        String relativePath = currentPath.replaceAll(REPLACE_DOT_REGEX, EMPTY_STRING).concat(path);
        return relativePath.matches(PATH_WINDOWS_REGEX)
                ? relativePath.replaceAll(SLASH, Matcher.quoteReplacement(BACK_SLASH)) : relativePath;
    }
}
