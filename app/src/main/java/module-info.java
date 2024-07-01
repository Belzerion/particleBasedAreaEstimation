module com.pbae {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens com.pbae to javafx.fxml;
    exports com.pbae;
}
