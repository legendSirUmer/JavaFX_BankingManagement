
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author umerh
 */
public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button accounts_btn;
    public Button transaction_btn;
    public Button logout_btn;
    public Button report_btn;

                    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        ChangeCentreDisplay();
    }
    
    
    public void ChangeCentreDisplay(){
        
        //dashboard_btn.setOnAction(event -> setDashboard());
        //transaction_btn.setOnAction(event -> setTransactions());
       // accounts_btn.setOnAction(event -> setAccounts());
       logout_btn.setOnAction(event -> logout());
    }
    
    public void setDashboard(){
        Model.getInstance().getViewFactory().getClientMenuSelectedItem().set(ClientMenuOptions.Dashboard);
  
    }
    
    public void setTransactions(){
        Model.getInstance().getViewFactory().getClientMenuSelectedItem().set(ClientMenuOptions.Transaction);
    }

    public void setAccounts(){
        Model.getInstance().getViewFactory().getClientMenuSelectedItem().set(ClientMenuOptions.Account);
    }
   
    
    
    
    
    
      
     public void logout(){
     
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout and Exit?");
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
