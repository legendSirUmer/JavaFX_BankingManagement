module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires java.base;

    opens com.mycompany.mavenproject1 to javafx.fxml;
    exports com.mycompany.mavenproject1;
    
    
}
