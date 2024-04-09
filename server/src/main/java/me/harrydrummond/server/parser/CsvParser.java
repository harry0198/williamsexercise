package me.harrydrummond.server.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Parses CSV data where the columns can be in any order for the mapper.
 * @param <T> the type of object to convert each csv line into.
 */
public class CsvParser<T> {
    private static final String SEPARATOR = ",";
    private final Mapper<T> mapper;

    public CsvParser(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    /**
     * Parse a string of csv text.
     * @param csvText To parse.
     * @return List of T after parse.
     */
    public List<T> parse(String csvText) {
        // Split each line by the newline char
        String[] csvLines = csvText.split("\n");

        // First line should always be header otherwise is invalid file. For sake of simplicity, I assume it will be
        // valid format.
        String header = csvLines[0];
        Map<String, Integer> headersToColumn = assignHeadersToColumns(header);

        return Arrays.stream(csvLines)
                .skip(1)
                .parallel() // Process each line async
                .map(line -> mapper.map(headersToColumn, line.replaceAll("\"", "").split(SEPARATOR))) // Quickly just dump the quotes - data provided is safe enough for this exercise.
                .collect(Collectors.toList());
    }

    private Map<String, Integer> assignHeadersToColumns(String headerLine) {
        Map<String, Integer> headerToColumn = new HashMap<>();
        String[] headers = headerLine.split(SEPARATOR);

        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];

            // Match either return or new line character
            header = header.replaceAll("(\\r|\\n)", "");
            headerToColumn.put(header, i);
        }

        return headerToColumn;
    }

}
