package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private static final String salt = "314";

    public static String hashPassword(String s) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        StringBuilder a = new StringBuilder();
        for (byte b : hash) {
            a.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return a.toString();
    }
}
