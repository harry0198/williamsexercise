package me.harrydrummond.server.api.repositories;

import me.harrydrummond.domain.Driver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests that the in memory repository functions as expected.
 */
class InMemoryRepositoryTest {

    @Test
    public void doesAddAndFetch() {
        // Arrange
        InMemoryRepository<Driver> driverRepository = new InMemoryRepository<>();
        Driver driver = new Driver(null, null,null,null,null,null,null,null, null);

        // Act
        driverRepository.addAll(List.of(driver));
        List<Driver> driverList = driverRepository.getAll();

        // Assert
        assertEquals(1, driverList.size());
        assertEquals(driver, driverList.get(0));
    }
}