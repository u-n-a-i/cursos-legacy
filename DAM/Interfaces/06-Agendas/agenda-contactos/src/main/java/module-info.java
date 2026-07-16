module com.unai.agenda {

    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.unai.agenda.view to javafx.fxml;

    exports com.unai.agenda.view;

    opens com.unai.agenda.controller to javafx.fxml;

    exports com.unai.agenda.controller;

    opens com.unai.agenda.model to javafx.fxml;

    exports com.unai.agenda.model;
}
