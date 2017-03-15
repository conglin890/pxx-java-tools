package com.pxx.tools;


import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypt {

    public static String Encrypt(String src, String key)
            throws Exception {
        SecretKeySpec skeySpec = getSecretKeySpec(key);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, skeySpec);

        byte[] bytes = cipher.doFinal(src.getBytes());
        return String.valueOf(Base64Utils.encode(bytes));
    }

    public static String Decrypt(String src, String key) throws Exception {
        SecretKeySpec skeySpec = getSecretKeySpec(key);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, skeySpec);

        byte[] original = cipher.doFinal(Base64Utils.decode(src));
        return new String(original);
    }

    private static SecretKeySpec getSecretKeySpec(String sKey) {
        byte[] enCodeFormat = (byte[]) null;
        try {
            enCodeFormat = Base64Utils.decode(sKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SecretKeySpec(enCodeFormat, "AES");
    }

    public static String generateKey(String sKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(sKey.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        String key = String.valueOf(Base64Utils.encode(enCodeFormat));
        return key;
    }
}
