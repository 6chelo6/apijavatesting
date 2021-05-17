package utils;

import java.util.Base64;

public final class Util {

    /**
     * This method encodes authentication Base64 with username:password value.
     */
    public static String getEncodedAuthentication(final String username, final String password) {
        String originalInput = String.format("%s:%s", username, password);
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }
}
