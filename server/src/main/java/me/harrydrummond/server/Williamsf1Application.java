package me.harrydrummond.server;

import me.harrydrummond.domain.LapTime;
import me.harrydrummond.server.api.repositories.InMemoryRepository;
import me.harrydrummond.server.api.repositories.Repository;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.server.parser.CsvParser;
import me.harrydrummond.server.parser.mappers.DriverMapper;
import me.harrydrummond.server.parser.mappers.LapTimeMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// Entrypoint class.
@SpringBootApplication
public class Williamsf1Application {

    public static void main(String[] args) {
        SpringApplication.run(Williamsf1Application.class, args);
    }

    /**
     * Supply spring with the dependency for the laptime repository.
     * @return Repository for laptimes.
     */
    @Bean
    public Repository<LapTime> lapTimeRepository() {
        // Laptimes
        Repository<LapTime> lapTimeRepository = new InMemoryRepository<>();
        String laptimeCsv = ResourceUtils.getResourceFileAsString("lap_times.csv");
        CsvParser<LapTime> lapTimeCsvParser = new CsvParser<>(new LapTimeMapper());
        List<LapTime> laptimes = lapTimeCsvParser.parse(laptimeCsv);
        lapTimeRepository.addAll(laptimes);
        return lapTimeRepository;
    }

    /**
     * Supply spring with the dependency for the driver repository
     * @return Repository for drivers.
     */
    @Bean
    public Repository<Driver> driverRepository() {
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
