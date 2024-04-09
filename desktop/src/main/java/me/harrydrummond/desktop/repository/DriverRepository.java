package me.harrydrummond.desktop.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.harrydrummond.domain.Driver;

import java.io.IOException;
import java.util.List;

/**
 * Access for the driver information.
 */
public class DriverRepository extends Repository<Driver> {

    /**
     * Initializes the repository.
     * @param endpoint Endpoint to access (e.g. api/drivers)
     */
    public DriverRepository(String endpoint) {
        super(endpoint);
    }

    /**
     * Makes a get request to the server's api endpoint and retrieves the list
     * of drivers. Uses jackson to map the json to java record.
     * @return List of drivers or null if could not make connection.
     * @throws IOException if an error occurred while trying to fetch.
     */
    public List<Driver> get() {
        try {
            String content = request(null);

            // Deserialize JSON string into Java record
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, new TypeReference<>() {});
        } catch (IOException io) {
            System.out.println("Failed with error: " + io.getMessage()); // In prod would use better logging.
            return null;
        }
    }
}
