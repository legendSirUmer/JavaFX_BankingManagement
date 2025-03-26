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
public class TransactionCellFactory extends ListCell<Transaction> {
    
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if(empty){
            setText(null);
            setGraphic(null);
            
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransactionListCell.fxml"));
            TransactionListCellController controller = new TransactionListCellController(transaction);
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
