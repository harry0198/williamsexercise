package me.harrydrummond.server.api.services;

import me.harrydrummond.server.api.repositories.Repository;
import me.harrydrummond.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final Repository<Driver> driverRepository;

    @Autowired
    public DriverService(Repository<Driver> driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getDrivers() {
        return driverRepository.getDrivers();
    }
}
