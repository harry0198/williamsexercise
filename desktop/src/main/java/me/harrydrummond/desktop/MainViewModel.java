package me.harrydrummond.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.domain.Driver;

import java.util.List;

public class MainViewModel {

    private final Repository<Driver> driverRepository;
    private final ObservableList<Driver> driverList = FXCollections.observableArrayList();

    public MainViewModel(Repository<Driver> driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void fetchDrivers() {
        // Typically would do this async.
        List<Driver> driverList = driverRepository.get();
        if (driverList != null) {
            this.driverList.setAll(driverList);
        }
    }

    public ObservableList<Driver> driverListProperty() {
        return driverList;
    }
}
