/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class TransactionListCellController implements Initializable {
    public Label transaction_date_lbl;
    public Label sender_lbl;
    public Label reciever_lbl;
    public Label amount_lbl;
    public FontAwesomeIconView out_icon;
    public FontAwesomeIconView in_icon;

    private final Transaction transaction;
    
    TransactionListCellController(Transaction transaction) {
        this.transaction = transaction;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
