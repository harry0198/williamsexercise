package me.harrydrummond.desktop.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public abstract class Repository<T> {

    private static final String HOST = "http://localhost:8080";
    private final String endpoint;

    public Repository(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Makes a get request to the server's api endpoint and retrieves the list
     * of T.
     * @return List of T or null if could not make connection.
     * @throws IOException if an error occurred while trying to fetch.
     */
    public abstract List<T> get();

    protected String request(String requestParam) {
        try {
            // Setup connection parameters.
            String urlStr = String.format("%s/%s", HOST, endpoint);
            if (requestParam != null && !requestParam.isEmpty()) {
                urlStr += "?" + requestParam;
            }
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000); // Time for connection to establish
            con.setReadTimeout(5000); // Time for data to be available for reading

            // Make request & get response
            int status = con.getResponseCode();

            if (status != 200) {
                System.out.println("Failed with status: " + status); // In production would use more robust logging here
                return null;
            }

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();
        } catch (IOException io) {
            System.out.println("Failed with error: " + io.getMessage()); // In prod would use better logging.
            return null;
        }
    }
}
