package me.harrydrummond.server.api.repositories;

import java.util.List;

/**
 * Signatures for a repository.
 * @param <T> Type the repository stores.
 */
public interface Repository<T> {

    /**
     * Adds all items to repository.
     * @param items to add to the repository.
     */
    void addAll(List<T> items);

    /**
     * Gets all the items in the repository.
     * @return All items in the repository.
     */
    List<T> getAll();
}
