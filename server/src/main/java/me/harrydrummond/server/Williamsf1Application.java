package me.harrydrummond.server;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.repositories.InMemoryRepository;
import me.harrydrummond.server.api.repositories.Repository;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.server.parser.CsvParser;
import me.harrydrummond.server.parser.mappers.DriverMapper;
import me.harrydrummond.server.parser.mappers.LapTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class Williamsf1Application {

    public static void main(String[] args) {
        SpringApplication.run(Williamsf1Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {

    }

    @Bean
    public Repository<LapTime> l() {
        // Laptimes
        Repository<LapTime> lapTimeRepository = new InMemoryRepository<>();
        String laptimeCsv = ResourceUtils.getResourceFileAsString("lap_times.csv");
        CsvParser<LapTime> lapTimeCsvParser = new CsvParser<>(new LapTimeMapper());
        List<LapTime> laptimes = lapTimeCsvParser.parse(laptimeCsv);
        lapTimeRepository.addAll(laptimes);
        return lapTimeRepository;
    }

    @Bean
    public Repository<Driver> d() {
        // Process all csv files and store in repositories.
        Repository<Driver> driverRepository = new InMemoryRepository<>();
        // Drivers
        String csv = ResourceUtils.getResourceFileAsString("drivers.csv");
        CsvParser<Driver> driverCsvParser = new CsvParser<>(new DriverMapper());
        List<Driver> driverList = driverCsvParser.parse(csv);
        driverRepository.addAll(driverList);
        return driverRepository;
    }

}
