/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author umerh
 */
public class Transaction {
private final StringProperty sender;
private final StringProperty receiver;
private final DoubleProperty amount;
private final ObjectProperty<LocalDate> date;
private final StringProperty message;

    public Transaction(String sender, String receiver, double amount, LocalDate date, String message) {
        this.sender = new SimpleStringProperty(this,"sender",sender);
        this.receiver =  new SimpleStringProperty(this,"receiver",receiver);
        this.amount = new SimpleDoubleProperty(this,"amount",amount);
        this.date = new SimpleObjectProperty<>(this,"Date",date);
        this.message =   new SimpleStringProperty(this,"message",message);
    }
    
     public StringProperty senderProperty() {
        return this.sender;
    }

    public StringProperty receiverProperty() {
        return this.receiver;
    }

    public DoubleProperty amountProperty() {
        return this.amount;
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return this.date;
    }

    public StringProperty messageProperty() {
        return this.message;
    }




}
