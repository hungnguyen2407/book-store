package vn.edu.hcmuaf.bookstore.services;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Ultilities {

    public static String encryptText(String text) {
        String encryptedStr = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            encryptedStr = Base64.getEncoder().encodeToString(md.digest(text.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedStr;
    }

}
