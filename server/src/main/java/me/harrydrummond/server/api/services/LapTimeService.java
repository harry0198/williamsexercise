package me.harrydrummond.server.api.services;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    @GetMapping
    public List<LapTime> getLapTimes() {
        return lapTimeRepository.getAll();
    }
}
