package me.harrydrummond.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.harrydrummond.desktop.repository.LapTimeRepository;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.domain.LapTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainViewModel {

    private final Repository<Driver> driverRepository;
    private final LapTimeRepository lapTimeRepository;
    private List<Driver> drivers = new ArrayList<>();
    private final ObservableList<Driver> driverList = FXCollections.observableArrayList();
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
            this.driverList.setAll(driverList);
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

    public void searchSurname(String surname) {
        this.driverList.setAll(drivers.stream()
                .filter(x -> x.surname().toLowerCase().contains(surname.toLowerCase()))
                .collect(Collectors.toList()));
    }

    public ObservableList<LapTime> lapTimesListProperty() {
        return laptimes;
    }

    public ObservableList<Driver> driverListProperty() {
        return driverList;
    }
}
