package com.mycompany.mavenproject1;

import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * FXML Controller class
 *
 * @author umerh
 */
public class LoginController implements Initializable {
    public LoginModel loginmodel = new LoginModel();
       public TextField username_txt;
       public TextField psswrd_txt;
       public ChoiceBox<AccountType> accont_chooser;
       public Button login_btn;
       
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       accont_chooser.setItems(FXCollections.observableArrayList(AccountType.Admin,AccountType.Client));
       accont_chooser.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        accont_chooser.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(accont_chooser.getValue()));
        
        
        
    }

    public void openClient()
    {
        Alert alert;
        
       Stage stage = (Stage) username_txt.getScene().getWindow();
       //Model.getInstance().getViewFactory().StageClose(stage);
       
       
        for (int i = 0; i < 1; i++) {

            if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.Client && clientVerification() == true) {
                Model.getInstance().getViewFactory().StageClose(stage);
                Model.getInstance().getViewFactory().showClientwindow();
            } else if (adminVerification() == true && Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.Admin) {
                Model.getInstance().getViewFactory().StageClose(stage);
                Model.getInstance().getViewFactory().showAdminWindow();
            } else {
                System.out.println("Wrong ID or Password ");
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Username/Password or type");
                alert.showAndWait();
                
            }
        }
    }
   
   
          public boolean adminVerification(){
              boolean ver=false;
              try{
                  
                  if(loginmodel.isLogin(username_txt.getText(), psswrd_txt.getText())){
                      ver = true;
                  }
                  else
                      ver = false;
                  
              }catch(SQLException e){
                  
              }
              
              return ver;
              
          }
          
          
          public boolean clientVerification(){
              boolean ver=false;
              try{
                  
                  if(loginmodel.isClientLogin(username_txt.getText(), psswrd_txt.getText())){
                      ver = true;
                  }
                  else
                      ver = false;
                  
              }catch(SQLException e){
                  
              }
              
              return ver;
              
          }
          
          
          
    
    
   
    }
    

    
    
