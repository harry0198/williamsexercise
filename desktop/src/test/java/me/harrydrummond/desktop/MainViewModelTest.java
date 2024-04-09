package me.harrydrummond.desktop;

import me.harrydrummond.desktop.repository.LapTimeRepository;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.domain.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MainViewModelTest {

    @Mock
    private Repository<Driver> driverRepository;
    @Mock
    private LapTimeRepository lapTimeRepository;
    private MainViewModel mvm;

    @BeforeEach
    public void beforeEach() {
        mvm = new MainViewModel(driverRepository, lapTimeRepository);

        // Arrange
        Driver driver1 = new Driver(3,null,null,null,null,"HaMiLtON", null, null, null);
        Driver driver2 = new Driver(3,null,null,null,null,"Rosberg", null, null, null);

        mvm = new MainViewModel(null,null);

        // Add sample data
        List<Driver> drivers = mvm.getUnFilteredDrivers();
        drivers.add(driver1);
        drivers.add(driver2);
    }
    @Test
    public void searchSurname_Exists() {
        // Act
        String searchTerm = "hamilton";
        mvm.searchSurname(searchTerm);

        // Assert
        List<Driver> driverList = mvm.driverListProperty();
        Assertions.assertEquals(1, driverList.size(), "Size should contain 1 driver.");
        Assertions.assertTrue(driverList.get(0).surname().toLowerCase().contains(searchTerm), "Incorrect driver filtered.");
    }

    @Test
    public void searchSurname_Missing() {
        // Act
        mvm.searchSurname("Not a driver's name");

        // Assert
        List<Driver> driverList = mvm.driverListProperty();
        Assertions.assertEquals(0, driverList.size());
    }

    @Test
    public void searchPartialSurname_Success() {
        // Act
        String searchTerm = "hami";
        mvm.searchSurname(searchTerm);

        // Assert
        List<Driver> driverList = mvm.driverListProperty();
        Assertions.assertEquals(1, driverList.size(), "Size should contain 1 driver.");
        Assertions.assertTrue(driverList.get(0).surname().toLowerCase().contains(searchTerm), "Incorrect driver filtered.");

    }

}