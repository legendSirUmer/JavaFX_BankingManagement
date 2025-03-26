package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
      Model.getInstance().getViewFactory().showLoginWindow();
      //Model.getInstance().getViewFactory().showAdminWindow();
    }


}