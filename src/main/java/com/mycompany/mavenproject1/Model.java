/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author umerh
 */
public class Model {

private static Model model;
private final ViewFactory viewFactory;


private Client client;
private boolean ClientLoginSuccess;
private AccountType loginAccountType = AccountType.Client;


//private constructor for single threading
    private Model()  {
        this.viewFactory = new ViewFactory();
        
        
        this.ClientLoginSuccess = false;
        this.client = new Client("","",null,null,null);
    }
    
    
    
    
    
    //singleton
   
    public static synchronized Model getInstance()  {
        if (model == null) {
            model = new Model();

        }
        return model;
    }
    
    
    
    
    //getters

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    
   
    
    
    
}
