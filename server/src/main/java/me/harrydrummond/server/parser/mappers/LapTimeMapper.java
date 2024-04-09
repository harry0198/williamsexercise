package me.harrydrummond.server.parser.mappers;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.parser.Mapper;

import java.util.Map;

/**
 * Maps csv line to a {@link LapTime}.
 */
public class LapTimeMapper implements Mapper<LapTime> {

    private static final String RACE_ID_HEADER = "raceId";
    private static final String DRIVER_ID_HEADER = "driverId";
    private static final String LAP_HEADER = "lap";
    private static final String POSITION_HEADER = "position";
    private static final String TIME_HEADER = "time";
    private static final String MILLISECONDS_HEADER = "milliseconds";

    /**
     * {@inheritDoc}
     */
    @Override
    public LapTime map(Map<String, Integer> headerToColumn, String[] lineParts) {
        return new LapTime(
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, RACE_ID_HEADER, lineParts),
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, DRIVER_ID_HEADER, lineParts),
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, LAP_HEADER, lineParts),
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, POSITION_HEADER, lineParts),
                Mapper.getStringValueWithHeaderOrNull(headerToColumn, TIME_HEADER, lineParts),
                Mapper.getIntegerValueWithHeaderOrNull(headerToColumn, MILLISECONDS_HEADER, lineParts)
        );
    }
}
