package me.harrydrummond.server.api.services;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LapTimeService {

    private final Repository<LapTime> lapTimeRepository;

    /**
     * Initialize the service
     * @param lapTimeRepository Repository for the laptimes.
     */
    @Autowired
    public LapTimeService(Repository<LapTime> lapTimeRepository) {
        this.lapTimeRepository = lapTimeRepository;
    }

    /**
     * Gets all the laptimes.
     * @return All laptimes.
     */

    public List<LapTime> getLapTimes() {
        return lapTimeRepository.getAll();
    }

    /**
     * Gets the laptimes for a driver
     * @param id ID of the driver.
     * @return List of the laptimes for the driver.
     */
    public List<LapTime> getLapTimeForDriverId(Integer id) {
        if (id == null) return List.of();

        // Get all and filter out drivers by id.
        return lapTimeRepository.getAll().stream()
                .filter(x -> x.driverId().equals(id))
                .collect(Collectors.toList());
    }
}
