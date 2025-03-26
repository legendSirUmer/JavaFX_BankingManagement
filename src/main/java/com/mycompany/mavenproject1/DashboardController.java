
package com.mycompany.mavenproject1;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 *
 * @author umerh
 */
public class DashboardController implements Initializable {
    
  LoginModel lm = new LoginModel();
public Label username_lbl;
public Label login_date_lbl;
public Label current_acc_amount_lbl;
public Label current_acc_no_lbl;
public Label saving_acc_amount_lbl;
public Label saving_acc_no_lbl;
public Label income_lbl;
public Label expense_lbl;
public ListView transaction_listview;
public TextField payee_tf;
public TextField amount_tf;
public TextArea message_ta;
public Button send_btn;
int count= 0;
int fin_amount=0;
    public void setCurrent_acc_amount_lbl(String string) {
        this.current_acc_amount_lbl.setText(string);
    }

    public void setSaving_acc_amount_lbl(String string) {
        this.saving_acc_amount_lbl.setText(string);
    }





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        username_lbl.setText("Hi "+lm.getClientname());
        System.out.println("inside dash "+lm.getClientname());
        
        
         LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDateTime = now.format(formatter);
        
        login_date_lbl.setText(formattedDateTime);
        
        current_acc_amount_lbl.setText("Rs. "+lm.getCh_bal());
        current_acc_no_lbl.setText(lm.getCh_acc_no());
        saving_acc_amount_lbl.setText("Rs. "+lm.getSv_bal());
        saving_acc_no_lbl.setText(lm.getSv_acc_no());
      try {
          transaction_listview.setItems(lm.addTransactionListData());
      } catch (SQLException ex) {
          
      }
        
        
           
        
      
    }
    
    
    
    
    public void SendingMoney(){
        count +=1;
        
        
            

            int amount = Integer.parseInt(amount_tf.getText());
            String payee = payee_tf.getText();
            System.out.println("" + lm.getClientname() + lm.getCh_bal());

            int remianingamount = Integer.parseInt(lm.getCh_bal()) - amount;

            try {

                lm.addTransactions(lm.getClientname(), (amount - amount - amount), payee_tf.getText(), login_date_lbl.getText());
                lm.updateCheckingAmount(lm.getClientname(), remianingamount);
                lm.addToPayee(payee, amount);
                transaction_listview.setItems(lm.addTransactionListData());

            } catch (SQLException ex) {

            }
            fin_amount = Integer.parseInt(lm.getCh_bal());
            fin_amount -= Integer.parseInt(amount_tf.getText());
            
            current_acc_amount_lbl.setText("Rs. " + fin_amount);
            
         Alert alert;
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Transferred");
                    alert.showAndWait();

        
      
       
        
        
        
      
        
                   
                    
                  
                
    }
    
    
    
    
    

}
