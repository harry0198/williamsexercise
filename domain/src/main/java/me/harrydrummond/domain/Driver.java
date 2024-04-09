package me.harrydrummond.domain;

/**
 * Fields for a driver.
 * @param driverId Unique identifier for driver
 * @param driverRef Driver reference
 * @param number Driver car number
 * @param code Driver name abbreviation
 * @param forename Driver first name
 * @param surname Driver last name
 * @param dob Driver date of birth
 * @param nationality Driver nationality
 * @param url Driver's information url.
 */
public record Driver(
        Integer driverId,
        String driverRef,
        Integer number,
        String code,
        String forename,
        String surname,
        String dob, // likely change to proper date.
        String nationality,
        String url
) {
}
