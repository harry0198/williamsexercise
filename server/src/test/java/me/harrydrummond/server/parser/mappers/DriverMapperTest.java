package me.harrydrummond.server.parser.mappers;

import me.harrydrummond.domain.Driver;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DriverMapperTest {

    /**
     * Tests that the mapper correctly maps a csv line with all valid inputs.
     */
    @Test
    void testDriverMapsCSVLine() {
        // Arrange
        Map<String, Integer> mappings = new HashMap<>();
        mappings.put(DriverMapper.DRIVER_ID_HEADER, 0);
        mappings.put(DriverMapper.DRIVER_REF_HEADER, 1);
        mappings.put(DriverMapper.DRIVER_NUM_HEADER, 2);
        mappings.put(DriverMapper.DRIVER_CODE_HEADER, 3);
        mappings.put(DriverMapper.DRIVER_FORENAME_HEADER, 4);
        mappings.put(DriverMapper.DRIVER_SURNAME_HEADER, 5);
        mappings.put(DriverMapper.DRIVER_DOB_HEADER, 6);
        mappings.put(DriverMapper.DRIVER_NATIONALITY_HEADER, 7);
        mappings.put(DriverMapper.DRIVER_URL_HEADER, 8);
        String id = "1";
        String ref = "2";
        String num = "3";
        String code = "code";
        String forename = "fore";
        String surname = "sur";
        String dob = "dob";
        String nat = "nat";
        String url = "url";
        String[] line = new String[] {id, ref, num, code, forename, surname, dob, nat, url};
        DriverMapper driverMapper = new DriverMapper();

        // Act
        Driver driver = driverMapper.map(mappings, line);

        assertNotNull(driver);
        assertEquals(id, driver.driverId().toString());
        assertEquals(ref, driver.driverRef());
        assertEquals(num, driver.number().toString());
        assertEquals(code, driver.code());
        assertEquals(forename, driver.forename());
        assertEquals(surname, driver.surname());
        assertEquals(dob, driver.dob());
        assertEquals(nat, driver.nationality());
        assertEquals(url, driver.url());
    }

}