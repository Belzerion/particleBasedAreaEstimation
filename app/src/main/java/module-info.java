module com.pbae {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pbae to javafx.fxml;
    exports com.pbae;
}
