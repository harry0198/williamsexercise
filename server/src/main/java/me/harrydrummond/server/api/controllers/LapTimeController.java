package me.harrydrummond.server.api.controllers;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.services.LapTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/laptimes")
@RestController
public class LapTimeController {

    private final LapTimeService lapTimeService;

    /**
     * Initializes the controller
     * @param service Service to use to interact with the laptime data.
     */
    @Autowired
    public LapTimeController(LapTimeService service) {
        this.lapTimeService = service;
    }

    /**
     * Gets the laptimes.
     * @return List of laptimes.
     */
    @GetMapping
    public List<LapTime> getLapTimes() {
        return lapTimeService.getLapTimes();
    }
}
