/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author umerh
 */
public class SQLiteConnection {
    
    //
    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\umerh\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1\\test.db");
            return conn;
        } catch (Exception e) {
// TODO: handle exception

        }
        return null;
    }
    
}
