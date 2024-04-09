package me.harrydrummond.server.api.controllers;

import me.harrydrummond.server.api.services.DriverService;
import me.harrydrummond.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contains mappings for the api and exposes the driver data.
 */
@RequestMapping("/api/drivers")
@RestController
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }
}
