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
public class ClientController implements Initializable {
public BorderPane client_parent;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Model.getInstance().getViewFactory().getClientMenuSelectedItem().addListener((cl , oldval , newval)-> {
            if (newval == ClientMenuOptions.Transaction){
                client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                
            }
            else if(newval == ClientMenuOptions.Account) {
                 client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
            }
            else
                client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                
        
    });
        
        
    }
        
        
    }


    

