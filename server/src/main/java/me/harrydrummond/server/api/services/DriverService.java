package me.harrydrummond.server.api.services;

import me.harrydrummond.server.api.repositories.Repository;
import me.harrydrummond.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing the business logic / preprocessing for
 * the driver data.
 */
@Service
public class DriverService {

    private final Repository<Driver> driverRepository;

    /**
     * Initializes this class.
     * @param driverRepository Repository to use to fetch the driver information.
     */
    @Autowired
    public DriverService(Repository<Driver> driverRepository) {
        this.driverRepository = driverRepository;
    }

    /**
     * Gets all drivers.
     * @return All drivers.
     */
    public List<Driver> getDrivers() {
        return driverRepository.getAll();
    }
}
