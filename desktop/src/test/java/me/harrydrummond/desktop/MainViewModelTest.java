package me.harrydrummond.desktop;

import me.harrydrummond.domain.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MainViewModelTest {

    @Test
    public void searchSurname_Exists() {
        // Arrange
        Driver driver = new Driver(3,null,null,null,null,"HaMiLtON", null, null, null);
        Driver driver2 = new Driver(3,null,null,null,null,"Rosberg", null, null, null);

        MainViewModel mvm = new MainViewModel(null,null);
        List<Driver> drivers = mvm.getUnFilteredDrivers();
        drivers.add(driver);
        drivers.add(driver2);

        // Act
        mvm.searchSurname("hamilton");

        // Assert
        List<Driver> driverList = mvm.driverListProperty();
        Assertions.assertEquals(1, driverList.size(), "Size should contain 1 driver.");
        Assertions.assertEquals(driver.surname(), driverList.get(0).surname(), "Incorrect driver filtered.");
    }

}