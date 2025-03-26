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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class AccountsController implements Initializable {
    LoginModel lm = new LoginModel();
    public Button transfer_to_sv_btn;
    public Button transfer_to_ch_btn;
    public TextField transfer_to_sv_txt;
    public TextField transfer_to_ch_txt;
    public Label ch_account_no;
    public Label sv_account_no;
    public Label ch_transac_limit;
    public Label ch_account_date;
    public Label ch_account_balance;
    public Label sv_withdrawal_limit;
    public Label sv_account_date;
    public Label sv_account_balance;
DashboardController dc = new DashboardController();
int count =  0;
int count2 = 0;
 int final_sv;
 int final_ch;




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ch_account_no.setText(lm.getCh_acc_no());
        sv_account_no.setText(lm.getSv_acc_no());
        ch_account_date.setText(lm.getDate());
        sv_account_date.setText(lm.getDate());
        ch_account_balance.setText(lm.getCh_bal());
        sv_account_balance.setText(lm.getSv_bal());
        
        transfer_to_sv_btn.setOnAction(event -> fromChToSv());
        transfer_to_ch_btn.setOnAction(event -> fromSvToCh());
        
        
        
    }    
    
    
    
    public void fromChToSv(){
        {
            
                    Alert alert;
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Funds Moved");
                    alert.showAndWait();
            
            count+=1;
            if(count == 1){
             final_ch= Integer.parseInt((lm.getCh_bal())) - Integer.parseInt(transfer_to_sv_txt.getText());
             final_sv= Integer.parseInt((lm.getSv_bal())) + Integer.parseInt(transfer_to_sv_txt.getText());
            }
            else{
                final_ch = final_ch - Integer.parseInt(transfer_to_sv_txt.getText());
                final_sv = final_sv + Integer.parseInt(transfer_to_sv_txt.getText());
            }
            
            try {
                lm.fundsTransferToSv(Integer.parseInt(transfer_to_sv_txt.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ch_account_balance.setText(""+final_ch);
            sv_account_balance.setText(""+final_sv);
            
            
        }
    }
    
    
    public void fromSvToCh(){
       
               count2+=1;
            if(count2 == 1){
             final_ch= Integer.parseInt((lm.getCh_bal())) + Integer.parseInt(transfer_to_ch_txt.getText());
             final_sv= Integer.parseInt((lm.getSv_bal())) - Integer.parseInt(transfer_to_ch_txt.getText());
              try {
                lm.fundsTransferToCh(Integer.parseInt(transfer_to_ch_txt.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else if (count2 >= 10){
                 Alert alert;
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Warning Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Transaction Limit reached");
                    alert.showAndWait();
            
            }
            else{
                final_ch = final_ch + Integer.parseInt(transfer_to_ch_txt.getText());
                final_sv = final_sv - Integer.parseInt(transfer_to_ch_txt.getText());
                 try {
                lm.fundsTransferToCh(Integer.parseInt(transfer_to_ch_txt.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
           
            
            ch_account_balance.setText(""+final_ch);
            sv_account_balance.setText(""+final_sv);
            
                
                
    }
    
    
    
    
    
    
}
