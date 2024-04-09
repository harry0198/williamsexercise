package me.harrydrummond.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.harrydrummond.desktop.repository.LapTimeRepository;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.domain.LapTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Business logic for the UI. Contains bindings and methods to update
 * state for the UI to react to.
 */
public class MainViewModel {

    private final Repository<Driver> driverRepository;
    private final LapTimeRepository lapTimeRepository;
    private List<Driver> drivers = new ArrayList<>();

    // Drivers sublist (i.e. after filtering)
    private final ObservableList<Driver> driverSubList = FXCollections.observableArrayList();
    private final ObservableList<LapTime> laptimes = FXCollections.observableArrayList();

    public MainViewModel(Repository<Driver> driverRepository, LapTimeRepository lapTimeRepository) {
        this.driverRepository = driverRepository;
        this.lapTimeRepository = lapTimeRepository;
    }

    /**
     * Fetch and refresh all drivers from the repository.
     * Updates the driverlist.
     */
    public void fetchDrivers() {
        // Typically would do this async.
        List<Driver> driverList = driverRepository.get();
        if (driverList != null) {
            this.drivers = driverList;
            this.driverSubList.setAll(driverList);
        }
    }

    /**
     * Updates the laptimes list for the driver by driver id.
     * @param id Of the driver to get laptimes for.
     */
    public void lapTimesForDriver(int id) {
        List<LapTime> lapTimes = lapTimeRepository.getForDriver(id);
        if (lapTimes != null) {
            this.laptimes.setAll(lapTimes);
        }
    }

    /**
     * Updates the driver list based upon the surname. Surname can be partial (i.e. hamil -> Hamilton)
     * @param surname To Filter results by.
     */
    public void searchSurname(String surname) {
        this.driverSubList.setAll(drivers.stream()
                .filter(x -> x.surname().toLowerCase().contains(surname.toLowerCase()))
                .collect(Collectors.toList()));
    }

    public Map<Integer, List<LapTime>> getLapTimesGroupedByRace(List<Integer> ids) {
        return laptimes.stream().filter(x -> ids.contains(x.raceId())).collect(Collectors.groupingBy(LapTime::raceId));
    }

    public List<Integer> getRaceIds() {
        return lapTimesListProperty().stream().map(LapTime::raceId).distinct().toList();
    }

    public List<Driver> getUnFilteredDrivers() {
        return drivers;
    }

    public ObservableList<LapTime> lapTimesListProperty() {
        return laptimes;
    }

    public ObservableList<Driver> driverListProperty() {
        return driverSubList;
    }
}
