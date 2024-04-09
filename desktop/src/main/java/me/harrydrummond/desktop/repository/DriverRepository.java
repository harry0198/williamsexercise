package me.harrydrummond.desktop.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.harrydrummond.domain.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Access for the driver information.
 */
public class DriverRepository implements Repository<Driver> {

    private static final String HOST = "http://localhost:8080";
    private static final String ENDPOINT = "api/drivers";

    /**
     * Makes a get request to the server's api endpoint and retrieves the list
     * of drivers. Uses jackson to map the json to java record.
     * @return List of drivers or null if could not make connection.
     * @throws IOException if an error occurred while trying to fetch.
     */
    public List<Driver> get() {
        try {
            // Setup connection parameters.
            URL url = new URL(String.format("%s/%s", HOST, ENDPOINT));
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

            // Deserialize JSON string into Java record
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content.toString(), new TypeReference<>() {
            });
        } catch (IOException io) {
            System.out.println("Failed with error: " + io.getMessage()); // In prod would use better logging.
            return null;
        }
    }
}
