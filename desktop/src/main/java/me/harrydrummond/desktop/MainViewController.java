package me.harrydrummond.desktop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import me.harrydrummond.domain.Driver;

import java.util.List;

public class MainViewController {
    @FXML
    private TableColumn<Driver, String> refCol;
    @FXML
    private TableColumn<Driver, String> numCol;
    @FXML
    private TableColumn<Driver, String> codeCol;
    @FXML
    private TableColumn<Driver, String> forenameCol;
    @FXML
    private TableColumn<Driver, String> surnameCol;
    @FXML
    private TableColumn<Driver, String> dobCol;
    @FXML
    private TableColumn<Driver, String> nationalityCol;
    @FXML
    private TableColumn<Driver, String> urlCol;
    @FXML
    private TableColumn<Driver, String> laptimeCol;
    @FXML
    private TableView<Driver> driverTable;
    private final MainViewModel viewModel;

    public MainViewController(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    // Is called by JavaFX when fxml is loaded.
    public void initialize() {
        refCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().driverRef()));
        numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().number() + ""));
        codeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().code()));
        forenameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().forename()));
        surnameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().surname()));
        dobCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().dob()));
        nationalityCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nationality()));
        urlCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().url()));

        bindings();
        viewModel.fetchDrivers();
    }

    private void bindings() {
        // Bind the items in the table to the viewmodel list.
        driverTable.setItems(viewModel.driverListProperty());
    }
}