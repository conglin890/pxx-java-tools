package com.pxx.tools;

import it.sauronsoftware.base64.Base64;

public class Base64Utils {
    public static byte[] decode(String base64)
            throws Exception
    {
        return Base64.decode(base64.getBytes());
    }
    public static String encode(byte[] bytes) throws Exception {
        return new String(Base64.encode(bytes));
    }
}
