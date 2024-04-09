package me.harrydrummond.server.parser;

import me.harrydrummond.server.ResourceUtils;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.server.parser.mappers.DriverMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the {@link CsvParser}
 */
class CsvParserTest {

    /**
     * Tests that the csv parser correctly parses the drivers.csv file.
     * Runs basic tests on first driver.
     */
    @Test
    public void test_CsvParsesDrivers_Success() {
        String csv = ResourceUtils.getResourceFileAsString("drivers.csv");
        CsvParser<Driver> driverCsvParser = new CsvParser<>(new DriverMapper());

        List<Driver> drivers = driverCsvParser.parse(csv);

        assertEquals(drivers.size(), 2, "Length of parsed drivers was incorrect");
        Driver hamilton = drivers.get(0);

        assertEquals(1, hamilton.driverId());
        assertEquals("hamilton", hamilton.driverRef());
        assertEquals(44, hamilton.number());
        assertEquals("HAM", hamilton.code());
        assertEquals("Lewis", hamilton.forename());
        assertEquals("Hamilton", hamilton.surname());
        assertEquals("1985-01-07", hamilton.dob());
        assertEquals("British", hamilton.nationality());
        assertEquals("http://en.wikipedia.org/wiki/Lewis_Hamilton", hamilton.url());
    }
}