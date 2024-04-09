package me.harrydrummond.server.parser;

import java.util.Map;

public interface Mapper<T> {

    T map(Map<String, Integer> headerToColumn, String[] lineParts);

    /**
     * Get the string value associated to the given header or return null.
     * @param headerToColumn Map containing the header string mappings to their columns.
     * @param header Header to fetch value of.
     * @param lineParts A single csv line split into each part.
     * @return The string value from the provided header or null if does not exist.
     */
    static String getStringValueWithHeaderOrNull(Map<String, Integer> headerToColumn, String header, String[] lineParts) {
        try {
            int column = headerToColumn.get(header);
            return lineParts[column].trim();
        } catch (NullPointerException npe) {
            // column does not exist.
            return null;
        }
    }

    /**
     * Get the double value associated to the given header or return null.
     * @param headerToColumn Map containing the header string mappings to their columns.
     * @param header Header to fetch value of.
     * @param lineParts A single csv line split into each part.
     * @return The double value from the provided header or null if does not exist.
     */
    static Double getDoubleValueWithHeaderOrNull(Map<String, Integer> headerToColumn, String header, String[] lineParts) {
        String value = getStringValueWithHeaderOrNull(headerToColumn, header, lineParts);
        if (value == null) return null;
        double num;
        try {
            num = Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return null;
        }

        return num;
    }

    /**
     * Get the integer value associated to the given header or return null.
     * @param headerToColumn Map containing the header string mappings to their columns.
     * @param header Header to fetch value of.
     * @param lineParts A single csv line split into each part.
     * @return The integer value from the provided header or null if does not exist.
     */
    static Integer getIntegerValueWithHeaderOrNull(Map<String, Integer> headerToColumn, String header, String[] lineParts) {
        String value = getStringValueWithHeaderOrNull(headerToColumn, header, lineParts);
        if (value == null) return null;
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return null;
        }

        return num;
    }
}
