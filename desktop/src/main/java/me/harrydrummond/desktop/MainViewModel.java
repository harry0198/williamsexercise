package me.harrydrummond.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.harrydrummond.desktop.repository.LapTimeRepository;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.domain.LapTime;

import java.util.List;

public class MainViewModel {

    private final Repository<Driver> driverRepository;
    private final LapTimeRepository lapTimeRepository;
    private final ObservableList<Driver> driverList = FXCollections.observableArrayList();
    private final ObservableList<LapTime> laptimes = FXCollections.observableArrayList();

    public MainViewModel(Repository<Driver> driverRepository, LapTimeRepository lapTimeRepository) {
        this.driverRepository = driverRepository;
        this.lapTimeRepository = lapTimeRepository;
    }

    public void fetchDrivers() {
        // Typically would do this async.
        List<Driver> driverList = driverRepository.get();
        if (driverList != null) {
            this.driverList.setAll(driverList);
        }
    }

    public void lapTimesForDriver(int id) {
        List<LapTime> lapTimes = lapTimeRepository.getForDriver(id);
        if (lapTimes != null) {
            this.laptimes.setAll(lapTimes);
        }
    }

    public ObservableList<LapTime> lapTimesListProperty() {
        return laptimes;
    }

    public ObservableList<Driver> driverListProperty() {
        return driverList;
    }
}
