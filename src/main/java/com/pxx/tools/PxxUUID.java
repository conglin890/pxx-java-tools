package com.pxx.tools;


import java.util.UUID;

public class PxxUUID {

    static String generate() {
        UUID uuid = UUID.randomUUID();
        return  uuid.toString();
    }

}
