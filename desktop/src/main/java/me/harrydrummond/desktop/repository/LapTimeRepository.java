package me.harrydrummond.desktop.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.harrydrummond.domain.LapTime;

import java.io.IOException;
import java.util.List;

public class LapTimeRepository extends Repository<LapTime> {

    /**
     * {@inheritDoc}
     */
    public LapTimeRepository(String endpoint) {
        super(endpoint);
    }

    /**
     * Makes a get request to the server's api endpoint and retrieves the list
     * of drivers. Uses jackson to map the json to java record.
     * @return List of drivers or null if could not make connection.
     * @throws IOException if an error occurred while trying to fetch.
     */
    @Override
    public List<LapTime> get() {
        return getForDriver(null);
    }

    /**
     * Gets the latpimes for a driver.
     * @param id
     * @return
     */
    public List<LapTime> getForDriver(Integer id) {

        try {
            // Make request with Id or null.
            String content = request(id == null ? null :"id="+ id);

            // Deserialize JSON string into Java record
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, new TypeReference<>() {});
        } catch (IOException io) {
            System.out.println("Failed with error: " + io.getMessage()); // In prod would use better logging.
            return null;
        }
    }
}
