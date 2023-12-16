module com.mycompany.os_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.os_project to javafx.fxml;
    exports com.mycompany.os_project;
}
