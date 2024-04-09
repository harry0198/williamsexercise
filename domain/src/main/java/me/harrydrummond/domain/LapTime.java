package me.harrydrummond.domain;

public record LapTime(
        Integer raceId,
        Integer driverId,
        Integer lap,
        Integer position,
        String time, // Could convert to Date
        Integer milliseconds // Data doesn't appear to be exceeding maximum threshold
) {
}
