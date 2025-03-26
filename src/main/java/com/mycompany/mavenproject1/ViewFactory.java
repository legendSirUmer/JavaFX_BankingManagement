package com.mycompany.mavenproject1;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
// Client Views

private AnchorPane dashboardView;
private AnchorPane transactionView;
private AnchorPane accountsView;


//admin view
private AnchorPane clientsView;
private AnchorPane createclientView;
private AnchorPane depositView;

private final ObjectProperty<ClientMenuOptions> ClientMenuSelectedItem;
private final ObjectProperty<AdminMenuOptions> AdminMenuSelectedItem;
private final StringProperty AdminMenuSelected;

private AccountType loginAccountType;


public ViewFactory(){

this.ClientMenuSelectedItem = new SimpleObjectProperty<>();
this.AdminMenuSelectedItem = new SimpleObjectProperty<>();
this.AdminMenuSelected = new SimpleStringProperty("");
this.loginAccountType = AccountType.Client;
}


    public ObjectProperty<ClientMenuOptions> getClientMenuSelectedItem() {
        
        
        return ClientMenuSelectedItem;
        
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }
    

    public StringProperty getAdminMenuSelected() {
        return AdminMenuSelected;
    }

   
    
    
//admin gertters
    
   
    
    public AnchorPane getCreateClientView(){
        if (createclientView ==null){
        try {
            createclientView = new FXMLLoader(getClass().getResource("CreateClient.fxml")).load();
        } catch (Exception e){
            e.printStackTrace();
            }
        }
        
    return createclientView;
    }
    
    
    public AnchorPane getDepositView(){
        if (depositView ==null){
        try {
            depositView = new FXMLLoader(getClass().getResource("Deposit.fxml")).load();
        } catch (Exception e){
            e.printStackTrace();
            }
        }
        
    return depositView;
    }

 
public AnchorPane getClientsView(){
        if (clientsView ==null){
        try {
            clientsView = new FXMLLoader(getClass().getResource("ClientsList.fxml")).load();
        } catch (Exception e){
            e.printStackTrace();
            }
        }
        
    return clientsView;
    }


    public ObjectProperty<AdminMenuOptions> getAdminMenuSelectedItem() {
        return AdminMenuSelectedItem;
    }

    
    
    
//client getters    
public AnchorPane getDashboardView(){
        if (dashboardView ==null){
        try {
            dashboardView = new FXMLLoader(getClass().getResource("Dashboard.fxml")).load();
        } catch (Exception e){
            e.printStackTrace();
            }
        }
        
    return dashboardView;
    }
    
    
    

    public AnchorPane getTransactionView(){
        if(transactionView == null)
        {
            try{
            transactionView = new FXMLLoader(getClass().getResource("Transaction.fxml")).load();
            
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return transactionView;
    }
    
  
    public AnchorPane getAccountsView(){
        if(accountsView == null)
        {
            try{
            accountsView = new FXMLLoader(getClass().getResource("Accounts.fxml")).load();
            
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return accountsView;
    }
    
  



public void showLoginWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        stageShowingMethod(loader);

    }

public void showClientwindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
        ClientController cc = new ClientController();
        loader.setController(cc);
        stageShowingMethod(loader);
        

    }


public void showDashboardwindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        stageShowingMethod(loader);

    }

public void showClientMenuWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientMenu.fxml"));
        stageShowingMethod(loader);

    }


public void showTransactionWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction.fxml"));
        stageShowingMethod(loader);
    }


public void showAccountWindow(){
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Accounts.fxml"));
        stageShowingMethod(loader);
}






//Admin

public void showAdminWindow(){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        stageShowingMethod(loader);
}

public void showClientListWindow(){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientsList.fxml"));
        stageShowingMethod(loader);
}







public void StageClose(Stage stage)
{
    stage.close();
}


public void stageShowingMethod(FXMLLoader loader)
    {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Apple Bank");
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("Images/icon.jpeg"))));
        stage.show();
    
    }




}