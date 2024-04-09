package me.harrydrummond.server.api.controllers;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.services.LapTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * Gets the laptimes for a driver id.
     * @param id of driver.
     * @return Lap times for the requested driver.
     */
    @GetMapping()
    public List<LapTime> getLapTimesForDriverId(@RequestParam(required = false) Integer id) {
        if (id == null) {
            return lapTimeService.getLapTimes();
        }
        return lapTimeService.getLapTimeForDriverId(id);
    }
}
