/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class CreateClientController implements Initializable {

    LoginModel lm = new LoginModel();
    public TextField fname_txt;
    public TextField psswrd_txt;
    public TextField payee_address_tf;
    public TextField ch_account_balance_txt;
    public TextField sv_account_balance_txt;
    public TextField sv_acc_no_tf;
    public TextField ch_acc_no_tf;
    public Button create_client_btn;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        // TODO
        
        create_client_btn.setOnAction(event-> creatingClient());
        
    }   
    
    public void creatingClient(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDateTime = now.format(formatter);
        lm.InsertClient(fname_txt.getText(), Integer.parseInt(psswrd_txt.getText()), Integer.parseInt(ch_acc_no_tf.getText()), Integer.parseInt(ch_acc_no_tf.getText()), Integer.parseInt(ch_account_balance_txt.getText()), Integer.parseInt(sv_account_balance_txt.getText()), payee_address_tf.getText(),  formattedDateTime);
        
        Alert alert;
         alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Created");
                    alert.showAndWait();
                    
                    
    }
    
    
    
}
