module com.catlantis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires java.sql;
    

    opens com.catlantis to javafx.fxml;
    exports com.catlantis;
}
