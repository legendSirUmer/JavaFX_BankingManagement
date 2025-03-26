/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class ClientsListController implements Initializable {
public ListView clients_listview;
public ObservableList<String> ol = FXCollections.observableArrayList();
LoginModel lm = new LoginModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        // TODO
        
        ol.addAll(lm.Client_arr());
        clients_listview.setItems(ol);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
        
    }    
    
    
   
    
}
