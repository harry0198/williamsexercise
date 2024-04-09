package me.harrydrummond.desktop.repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {

    /**
     * Makes a get request to the server's api endpoint and retrieves the list
     * of T.
     * @return List of T or null if could not make connection.
     * @throws IOException if an error occurred while trying to fetch.
     */
    List<T> get();
}
