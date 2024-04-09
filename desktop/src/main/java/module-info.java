module me.harrydrummond.desktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.harrydrummond.desktop to javafx.fxml;
    exports me.harrydrummond.desktop;
}