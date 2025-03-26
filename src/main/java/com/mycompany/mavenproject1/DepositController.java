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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class DepositController implements Initializable {
String client;
    LoginModel lm = new LoginModel();
    public Button search_btn;
public Button deposit_btn;
public TextField payee_address_txt;
public TextField amount_txt;
public ListView result_listview;
ObservableList<String> ol = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
        search_btn.setOnAction(event ->  payeefinder());
        result_listview.setItems(ol);
        deposit_btn.setOnAction(event -> addAmount());
        
    }    
    
    
    
    public void payeefinder(){
        
        
    try {
       client= lm.Search_Payee(payee_address_txt.getText());
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
        ol.add(client);
    }
    
    public void addAmount(){
   int amount = Integer.parseInt(amount_txt.getText());
        String payee = payee_address_txt.getText();
        System.out.println(""+lm.getClientname() + lm.getCh_bal());
 
        
      try {  
          
          lm.addToPayee(payee, amount);
        
          
          
      } catch (SQLException ex) {
          
      }
          result_listview.getItems().removeAll(ol);
          result_listview.refresh();
          payeefinder();
          result_listview.setItems(ol);
        
          Alert alert;
          alert = new Alert(AlertType.INFORMATION);
                  alert.setTitle("Information Message");
                  alert.setHeaderText(null);
                  alert.setContentText("Successfully Deposited");
                  alert.showAndWait();
          
    
    }
    
   
    
}
