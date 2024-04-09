package me.harrydrummond.server.parser.mappers;

import me.harrydrummond.domain.Driver;
import me.harrydrummond.server.parser.Mapper;

import java.util.Map;

/**
 * Mapper for converting a single CSV line to a Driver.
 */
public class DriverMapper implements Mapper<Driver> {

    // CSV header names for each.
    public static final String DRIVER_ID_HEADER = "driverId";
    public static final String DRIVER_REF_HEADER = "driverRef";
    public static final String DRIVER_NUM_HEADER = "number";
    public static final String DRIVER_CODE_HEADER = "code";
    public static final String DRIVER_FORENAME_HEADER = "forename";
    public static final String DRIVER_SURNAME_HEADER = "surname";
    public static final String DRIVER_DOB_HEADER = "dob";
    public static final String DRIVER_NATIONALITY_HEADER = "nationality";
    public static final String DRIVER_URL_HEADER = "url";

    /**
     * {@inheritDoc}
     */
    @Override
    public Driver map(Map<String, Integer> headerToColumn, String[] lineParts) {
        return new Driver(
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, DRIVER_ID_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_REF_HEADER, lineParts),
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, DRIVER_NUM_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_CODE_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_FORENAME_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_SURNAME_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_DOB_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_NATIONALITY_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, DRIVER_URL_HEADER, lineParts)
        );
    }
}
