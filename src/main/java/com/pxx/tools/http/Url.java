package com.pxx.tools.http;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Url {

    public static String decodeURIComponent (String url) throws UnsupportedEncodingException {

        String [] urlList = url.split("://");

        if (urlList.length > 1) {

            return urlList[0] + "://" + URLDecoder.decode(urlList[1], "UTF-8");

        } else {
            return URLDecoder.decode(urlList[0], "UTF-8");
        }




    }


    private void encodeURIComponent (String url) {

    }
}
