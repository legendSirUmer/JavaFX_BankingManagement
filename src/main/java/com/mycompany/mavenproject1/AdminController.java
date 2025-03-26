/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class AdminController implements Initializable {
public BorderPane admin_parent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         Model.getInstance().getViewFactory().getAdminMenuSelected().addListener((cl , oldval , newval)-> {
                if(newval == "ClientList"){
                    System.out.println("CLientList");
                admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
             }
                else if(newval == "Deposit"){
                    System.out.println("Deposit");
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getDepositView());
                    
                }
                else
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
                
        
        
        });
    }    
    
}
