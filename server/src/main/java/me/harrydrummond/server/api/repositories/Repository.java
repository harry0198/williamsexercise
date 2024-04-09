package me.harrydrummond.server.api.repositories;

import java.util.List;

public interface Repository<T> {

    void addDrivers(List<T> driverList);

    List<T> getDrivers();
}
