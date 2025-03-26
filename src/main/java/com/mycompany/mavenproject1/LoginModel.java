
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author umerh
 */
public class LoginModel {
  Connection conection;

    private static String clientname;
    
    private static int ch_acc_no;
    private  static int sv_acc_no;
    private static int ch_bal;
    private  static int sv_bal;
    private  static String payeeAdressofClient;
    private static String date;
    
   // DashboardController dcc = new DashboardController();
    
    String adminname="";

    public String getDate() {
        return date;
    }


    public String getCh_acc_no() {
        return ""+ch_acc_no;
    }

    public  String getSv_acc_no() {
        return ""+ sv_acc_no;
    }

    public  String getCh_bal() {
        return ""+ch_bal;
    }

    public  String getSv_bal() {
        return ""+sv_bal;
    }
    public String getClientname() {
        return clientname;
    }


    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    
    
    
    
    public LoginModel() {
        conection = SQLiteConnection.Connector();
        if (conection == null) {

            System.out.println("connection not successful");
            System.exit(1);
        }

    }

    public boolean isDbConnected() {
        try {
            return !conection.isClosed();
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    public boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from adminlogin where username = ? and password = ?";

        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                setAdminname(resultSet.getString("username"));
               
                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            return false;

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
    
 
}
    
    
    
       public boolean isClientLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client where username = ? and password = ?";

        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                clientname = resultSet.getString("username");
                ch_acc_no = resultSet.getInt("checking_no");
                sv_acc_no = resultSet.getInt("savings_no");
                ch_bal = resultSet.getInt("checking_bal");
                sv_bal = resultSet.getInt("savings_bal");
                date = resultSet.getString("date");
                payeeAdressofClient = resultSet.getString("payeeaddress");
                
                 System.out.println("Inside model "+resultSet.getString("username"));
                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            return false;

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
    
 
}
       
       
       public void InsertClient(String name, int password ,int ch_no,int sv_no , int ch_amount , int sv_amount,String payeeAdr,String date){
                    
           PreparedStatement ps = null;
           try {
               String sql = "INSERT INTO client(username, password, checking_no, savings_no,checking_bal,savings_bal,payeeaddress,date) VALUES(?,?,?,?,?,?,?,?)";
               ps = conection.prepareStatement(sql);
               ps.setString(1, name);
               ps.setInt(2, password);
               ps.setInt(3, ch_no);
               ps.setInt(4, sv_no);
               ps.setInt(5, ch_amount);
               ps.setInt(6, sv_amount);
               ps.setString(7, payeeAdr);
               ps.setString(8, date);
               
               ps.execute();
               System.out.println("Data has been inserted!");
           } catch (SQLException e) {
               System.out.println(e.toString());

           }
       
       }
       
       
       
       
       public void updateCheckingAmount(String user ,int amount) throws SQLException{
           System.out.println("LM "+user + amount);  
           
                 PreparedStatement ps = null;
           try {
               String sql = "UPDATE client set checking_bal = ? WHERE username = ? ";
               ps = conection.prepareStatement(sql);
               ps.setInt(1, amount);
               ps.setString(2, user);
               ps.execute();
               System.out.println("Data has been updated");
           } catch (SQLException e) {

               System.out.println(e.toString());

           }
            finally{
               try{
                   ps.close();
               }catch(Exception e){
                   e.printStackTrace();
               }
           }
       }
       
       
       
       public String Search_Payee(String payee) throws SQLException{
           String all=""; 
           PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client where payeeaddress = ?";

        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, payee);
            
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                clientname = resultSet.getString("username");
                ch_acc_no = resultSet.getInt("checking_no");
                sv_acc_no = resultSet.getInt("savings_no");
                ch_bal = resultSet.getInt("checking_bal");
                sv_bal = resultSet.getInt("savings_bal");
                
                
                all = clientname + "\t\t" + ch_acc_no + "\t\t" + sv_acc_no + "\t\t" + (sv_bal+ch_bal);
                
                 System.out.println("Inside model "+resultSet.getString("username"));
               
            } else {
                Alert alert;
                 alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Payee Address");
                    alert.showAndWait();
                

            }

        } catch (Exception e) {
           e.printStackTrace();

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
            return all;
        }
       
       
       public void addToPayee(String payee,int amount)throws SQLException {
           String usernameOfPayee;
           int final_amount = 0;
           LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDateTime = now.format(formatter);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client where payeeaddress = ?";

        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, payee);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameOfPayee = resultSet.getString("username");
                 final_amount = resultSet.getInt("checking_bal");
                final_amount += amount;
               
                addTransactions(usernameOfPayee,amount,payeeAdressofClient,formattedDateTime);
                
                
            } 

        } catch (Exception e) {

        }
        finally{
            preparedStatement.close();
            resultSet.close();
            
        }
        
        
         
        
               PreparedStatement ps = null;
           try {
               String sql = "UPDATE client set checking_bal = ? WHERE payeeaddress = ? ";
               ps = conection.prepareStatement(sql);
               ps.setInt(1, final_amount);
               ps.setString(2, payee);
               
               ps.execute();
               System.out.println("Payee Data has been updated");
           } catch (SQLException e) {

               System.out.println(e.toString());

           }
           finally{
               try{
                   ps.close();
               }catch(Exception e){
                   e.printStackTrace();
               }
           }
        
        
        
            System.out.println("amount updated of payee "+resultSet.getString("checking_bal"));
       }
       
       
       
       public int countofClients() throws SQLException{
           int count=0;  
           PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client";

        try {
            preparedStatement = conection.prepareStatement(query);       
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
              count++;  
               
            } 
          

        } catch (Exception e) {
           e.printStackTrace();

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
            return count;
          
       }
       
       
       public String[] Client_arr() throws SQLException{
           ClientsListController controller = new ClientsListController();
               String[] allList = new String[countofClients()];
               String all;
               int i = 0;
           PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client";

        try {
            preparedStatement = conection.prepareStatement(query);       
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                
                String clientnamen = resultSet.getString("username");
                int ch_acc_non = resultSet.getInt("checking_no");
                int sv_acc_non = resultSet.getInt("savings_no");
                int ch_baln = resultSet.getInt("checking_bal");
                int sv_baln = resultSet.getInt("savings_bal");
                
               
                
                all = clientnamen + "\t\t" + ch_acc_non + "\t\t" + sv_acc_non + "\t\t" + (sv_baln+ch_baln);
                allList[i] = all;
                controller.ol.add(all);
                    System.out.println(""+allList[i]);
                i++;
                
               
            } 
                
                

            

        } catch (Exception e) {
           e.printStackTrace();

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
            return allList;
           
       }
       
       
    
       
       public void addTransactions(String user,int amount, String payee , String date) throws SQLException{
           
           try {
               PreparedStatement ps = null;
               String sql = "INSERT INTO transactions(username, Amount, payeeaddress, date) VALUES(?,?,?,?)";
               ps = conection.prepareStatement(sql);
               ps.setString(1, user);
               ps.setInt(2, amount);
               ps.setString(3, payee);
               ps.setString(4, date);
               
               ps.execute();
               System.out.println("Transaction has been inserted!");
           } catch (SQLException e) {
               System.out.println(e.toString());

           }
           
       
           
           
       }
       
     
       
           public ObservableList<String> addTransactionListData() throws SQLException {

        ObservableList<String> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM transactions WHERE username = ?";

       PreparedStatement prepare = null;
       ResultSet result = null;

        try {
            prepare = conection.prepareStatement(sql);
            prepare.setString(1, clientname);
            result = prepare.executeQuery();
            String all="";

            while (result.next()) {
                all = (result.getInt("Amount")+ "\t\t"+
                        result.getString("username")+ "\t\t")
                        +result.getString("payeeaddress")+"\t\t"+ result.getString("date");
                       
                listData.add(all);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
       
       
     
       
       //funds transfer
       
       
       public void fundsTransferToSv(int amount) throws SQLException{
            int ch_amount = 0;
            int sv_amount= 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client where username = ?";

        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, clientname);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                 ch_amount = resultSet.getInt("checking_bal");
                 sv_amount = resultSet.getInt("savings_bal");
                ch_amount -= amount;
                sv_amount += amount;
              
                
            } 

        } catch (Exception e) {

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
        
        
         
        
               PreparedStatement ps = null;
           try {
               String sql = "UPDATE client set checking_bal = ?,savings_bal=? WHERE username = ? ";
               ps = conection.prepareStatement(sql);
               ps.setInt(1, ch_amount);
               ps.setInt(2, sv_amount);
               ps.setString(3, clientname);
               ps.execute();
               System.out.println("Funds have been moved to Savings");
           } catch (SQLException e) {

               System.out.println(e.toString());

           }
           finally{
               try{
                   ps.close();
               }catch(Exception e){
                   e.printStackTrace();
               }
               
          
           }
        
        
       }
       
       
       
       
        
       public void fundsTransferToCh(int amount) throws SQLException{
            int ch_amount = 0;
            int sv_amount= 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client where username = ?";

        try {
            preparedStatement = conection.prepareStatement(query);
            preparedStatement.setString(1, clientname);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                 ch_amount = resultSet.getInt("checking_bal");
                 sv_amount = resultSet.getInt("savings_bal");
                ch_amount += amount;
                sv_amount -= amount;
              
                
            } 

        } catch (Exception e) {

        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
        
        
         
        
               PreparedStatement ps = null;
           try {
               String sql = "UPDATE client set checking_bal = ?,savings_bal=? WHERE username = ? ";
               ps = conection.prepareStatement(sql);
               ps.setInt(1, ch_amount);
               ps.setInt(2, sv_amount);
               ps.setString(3, clientname);
               ps.execute();
               System.out.println("Funds have been moved to Checking");
           } catch (SQLException e) {

               System.out.println(e.toString());

           }
           finally{
               try{
                   ps.close();
               }catch(Exception e){
                   e.printStackTrace();
               }
               
          
           }
        
        
       }
       
       
       
       
       
       
       
    
    
    
    
}
