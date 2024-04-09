module me.harrydrummond.desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires domain;
    requires com.fasterxml.jackson.databind;

    opens me.harrydrummond.desktop to javafx.fxml;
    exports me.harrydrummond.desktop;
    exports me.harrydrummond.desktop.repository;
    opens me.harrydrummond.desktop.repository to javafx.fxml;
    exports me.harrydrummond.desktop.utils;
    opens me.harrydrummond.desktop.utils to javafx.fxml;
}