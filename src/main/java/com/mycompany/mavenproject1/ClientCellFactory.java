/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

/**
 *
 * @author umerh
 */
public class ClientCellFactory extends ListCell<Client> {
    
    
    
    
    
    
    
    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if(empty){
            setText(null);
            setGraphic(null);
            
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientCell.fxml"));
            ClientCellController controller = new ClientCellController(client);
            loader.setController(controller);
            setText(null);
            
            try{
                setGraphic(loader.load());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
}
