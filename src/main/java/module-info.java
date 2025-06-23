module com.catlantis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    

    opens com.catlantis to javafx.fxml;
    exports com.catlantis;
    
    opens Model.DBFunctions to javafx.fxml;
    exports Model.DBFunctions;
    opens Model.Tables to javafx.fxml;
    exports Model.Tables;
    
opens Utils to javafx.fxml;
    exports Utils;
}
