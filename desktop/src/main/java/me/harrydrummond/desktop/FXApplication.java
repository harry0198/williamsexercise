package me.harrydrummond.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.harrydrummond.desktop.repository.DriverRepository;
import me.harrydrummond.desktop.repository.Repository;
import me.harrydrummond.domain.Driver;

import java.io.IOException;

public class FXApplication extends Application {

    // The initial fxml file to load
    private static final String INITIAL_FXML = "main-view.fxml";
    @Override
    public void start(Stage stage) throws IOException {
        Repository<Driver> driverRepository = new DriverRepository();
        MainViewModel viewModel = new MainViewModel(driverRepository);
        MainViewController controller = new MainViewController(viewModel);
        FXMLLoader fxmlLoader = new FXMLLoader(FXApplication.class.getResource(INITIAL_FXML));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}