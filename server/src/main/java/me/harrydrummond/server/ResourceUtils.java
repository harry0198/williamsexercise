package me.harrydrummond.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Utilities for accessing and manipulating the data in the resource directory.
 */
public class ResourceUtils {

    /**
     * Disclaimer - taken from stackoverflow, this is ridiculous from java.
     * https://stackoverflow.com/questions/6068197/read-resource-text-file-to-string-in-java
     *
     * Reads given resource file as a string.
     *
     * @param fileName path to the resource file
     * @return the file's contents
     * @throws RuntimeException if read fails for any reason
     */
    public static String getResourceFileAsString(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            try (InputStream is = classLoader.getResourceAsStream(fileName)) {
                if (is == null) return null;
                try (InputStreamReader isr = new InputStreamReader(is);
                     BufferedReader reader = new BufferedReader(isr)) {
                    return reader.lines().collect(Collectors.joining(System.lineSeparator()));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Cannot load file");
        }
    }
}
