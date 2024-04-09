package me.harrydrummond.server;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.repositories.Repository;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.server.parser.CsvParser;
import me.harrydrummond.server.parser.mappers.DriverMapper;
import me.harrydrummond.server.parser.mappers.LapTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class Williamsf1Application {

    @Autowired
    private Repository<Driver> driverRepository;

    @Autowired
    private Repository<LapTime> lapTimeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Williamsf1Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {
        // Process all csv files and store in repositories.

        // Drivers
        String csv = ResourceUtils.getResourceFileAsString("drivers.csv");
        CsvParser<Driver> driverCsvParser = new CsvParser<>(new DriverMapper());
        List<Driver> driverList = driverCsvParser.parse(csv);
        driverRepository.addAll(driverList);

        // Laptimes
        String laptimeCsv = ResourceUtils.getResourceFileAsString("laptime.csv");
        CsvParser<LapTime> lapTimeCsvParser = new CsvParser<>(new LapTimeMapper());
        List<LapTime> laptimes = lapTimeCsvParser.parse(laptimeCsv);
        lapTimeRepository.addAll(laptimes);
    }

}
