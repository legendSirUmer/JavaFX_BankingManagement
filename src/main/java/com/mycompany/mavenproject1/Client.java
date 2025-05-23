/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author umerh
 */
public class Client {
 
  
    private final StringProperty firstName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingsAccount;
    private final ObjectProperty<LocalDate> dateCreated;

  

    
    
    public Client(String fName,  String pAddress, Account cAccount, Account sAccount, LocalDate date) {
        
        this.firstName = new SimpleStringProperty(this, "FirstName", fName);
        this.payeeAddress = new SimpleStringProperty(this, "Payee Address", pAddress);
        this.checkingAccount = new SimpleObjectProperty(this, "Checking Account", cAccount);
        this.savingsAccount = new SimpleObjectProperty(this, "Savings Account", sAccount);
        this.dateCreated = new SimpleObjectProperty(this, "Date", date);

    }


public StringProperty NameProperty() {return firstName;}

public StringProperty pAddressProperty() {return payeeAddress;}

public ObjectProperty<Account> checkingAccountProperty() {return checkingAccount;}

public ObjectProperty<Account> savingsAccountProperty() {return savingsAccount;}

public ObjectProperty<LocalDate> dateProperty() {return dateCreated;}







    
}
