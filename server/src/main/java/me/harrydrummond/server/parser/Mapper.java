package me.harrydrummond.server.parser;

import java.util.Map;

/**
 * Signatures for mapping the csv to T
 * @param <T> to map to.
 */
public interface Mapper<T> {

    /**
     * Map the given line to T
     * @param headerToColumn header to column mappings in lineParts.
     * @param lineParts The split csv line.
     * @return The mapped line to T.
     */
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
