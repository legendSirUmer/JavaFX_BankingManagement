/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button client_list_btn;
    public Button deposit_btn;
    public Button logout_btn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ChangeCentreDisplay();
    }    
    
    
    
    public void ChangeCentreDisplay(){
        
        create_client_btn.setOnAction(event -> setCreateClient2());
        client_list_btn.setOnAction(event -> setClientsList2() );
        deposit_btn.setOnAction(event -> setDeposit());
        logout_btn.setOnAction(event-> logout());
    }
    
    public void setCreateClient(){
        Model.getInstance().getViewFactory().getAdminMenuSelectedItem().set(AdminMenuOptions.Create_Clients);
  
    }
     public void setClientsList(){
        Model.getInstance().getViewFactory().getAdminMenuSelectedItem().set(AdminMenuOptions.Clients);
  
    }
     
     
     
     public void setDeposit(){
         Model.getInstance().getViewFactory().getAdminMenuSelected().set("Deposit");
     }
     
     
       public void setCreateClient2(){
        Model.getInstance().getViewFactory().getAdminMenuSelected().set("CreateClient");
  
    }
     public void setClientsList2(){
        Model.getInstance().getViewFactory().getAdminMenuSelected().set("ClientList");
  
    }
     
     
    
     
     public void logout(){
     
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout and exit?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout_btn.getScene().getWindow().hide();
                System.exit(0);
                Model.getInstance().getViewFactory().showLoginWindow();
  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

         
         
     }
     
     
    
    
    
}
