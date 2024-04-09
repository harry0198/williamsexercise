package me.harrydrummond.server.api.repositories;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple in-memory repository that runs simple get and set commands.
 * @param <T> Type of object to store.
 */
@org.springframework.stereotype.Repository
public class InMemoryRepository<T> implements Repository<T> {

    private final List<T> storedData = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDrivers(List<T> driverList) {
        this.storedData.addAll(driverList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> getDrivers() {
        return this.storedData;
    }
}
