package com.ejournal.java.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by kristiyan.parvanov on 16.02.20 г.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

    public static String formatName(final String name) {
        return name.replaceAll("\\s+", "% %");
    }
}
