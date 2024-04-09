package me.harrydrummond.desktop;

import me.harrydrummond.desktop.repository.DriverRepository;
import me.harrydrummond.domain.Driver;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class DriverRepositoryTest {

    @Test
    void testDriverRequest() throws IOException {
        DriverRepository driverRepository = new DriverRepository();
        List<Driver> drivers = driverRepository.get();
        System.out.println(drivers);
    }
}