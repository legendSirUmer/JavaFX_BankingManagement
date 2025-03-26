/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class ClientCellController implements Initializable {
    public Button delete_btn;
    public Label date_created_lbl;
    public Label client_balance_lbl;
    public Label payee_address_lbl;
    public Label ch_acc_no_lbl;
    public Label sv_acc_no_lbl;
    public Label client_name_lbl;

    private final Client client;
    
    ClientCellController(Client client) {
        this.client = client;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
