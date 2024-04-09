package me.harrydrummond.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.harrydrummond.desktop.repository.DriverRepository;
import me.harrydrummond.desktop.repository.LapTimeRepository;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.desktop.utils.Constants;
import me.harrydrummond.domain.Driver;
import me.harrydrummond.domain.LapTime;

import java.io.IOException;

public class FXApplication extends Application {

    // The initial fxml file to load
    private static final String INITIAL_FXML = "main-view.fxml";
    @Override
    public void start(Stage stage) throws IOException {
        // Setup dependencies
        Repository<Driver> driverRepository = new DriverRepository(Constants.DRIVERS_API_ENDPOINT);
        LapTimeRepository lapTimeRepository = new LapTimeRepository(Constants.LAPTIMES_API_ENDPOINT);
        MainViewModel viewModel = new MainViewModel(driverRepository, lapTimeRepository);
        MainViewController controller = new MainViewController(viewModel);

        // Load the fxml
        FXMLLoader fxmlLoader = new FXMLLoader(FXApplication.class.getResource(INITIAL_FXML));
        fxmlLoader.setController(controller);

        // Setup scene
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("WilliamsF1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}