/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lynch
 */
public class DatabaseController {
    private static final String[] baseData= {"(id VARCHAR(12) not null,"
            + "firstname VARCHAR(255),"
            + "lastname VARCHAR(255),"
            + "username VARCHAR(255),"
            + "password VARCHAR(255),"
            + "PRIMARY KEY(id))",
        
            "(id VARCHAR(12) not null,"
            + "firstname VARCHAR(255),"
            + "lastname VARCHAR(255),"
            + "username VARCHAR(255),"
            + "password VARCHAR(255),"
            + "PRIMARY KEY(id))",
            
            "(id VARCHAR(12) not null,"
            + "firstname VARCHAR(255),"
            + "lastname VARCHAR(255),"
            + "address VARCHAR(255),"
            + "PRIMARY KEY(id))",
            
            "(id VARCHAR(12) not null,"
            + "item VARCHAR(255),"
            + "price DECIMAL(65),"
            + "PRIMARY KEY(id))", 
            
            "(id VARCHAR(12) not null,"
            + "itemid VARCHAR(255),"
            + "custid INTEGER,"
            + "drivid INTEGER,"
            + "price DECIMAL(65),"
            + "PRIMARY KEY(id))"};
    
    private static final String[] tableNames = {"Admin", "Driver", "Customer", "Inventory", "CustOrder"};
    private static final String DB_URL = "jdbc:mysql://localhost/" + getDB_NAME();
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DB_NAME = "BlackHardSweetCompany";

    public DatabaseController(){
        Statement stmt = setConnection();
//        drop(tableNames, "TABLE ", stmt);
        createDatabase(stmt);
        createTables(stmt);
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean login(String userType, String userCredentials[]){
        try {
            System.out.println(userType);
            Statement stmt = setConnection();

            String sql = "SELECT * "
                    + "FROM " + userType +" "
                    + "WHERE "
                    + "username LIKE '%" + userCredentials[0] + "%' "
                    + "AND password LIKE '%" + userCredentials[1] + "%'";
        
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1) != null){
                    return true;
                }
            } 
        }catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void createTables(Statement stmt){
        Integer count = 0;
        for(String table: getTableNames()){
            try {
                String sql = "CREATE TABLE " + table + baseData[count];
                System.out.println(table + " created successfully...");                   
                stmt.executeUpdate(sql);
                
                if(table.equals("Admin")){
                    String[] adminData = {"Owner", "Owner", "admin", "admin"};
                    addToTables(adminData, "Admin");
                }
            } catch (SQLException e) {
                if(e.getErrorCode() == 1050){
                    System.out.println(e.getMessage());
                }else{
                    e.printStackTrace();
                }              
            }
            count++;
        }
    }

    private void drop(String[] names, String type, Statement stmt){
        for(String name: names){
            try {
                String sql = "Drop " + type + name;
                stmt.executeUpdate(sql);
                System.out.println(name + " dropped successfully...");  
            } catch (SQLException e) {
                if(e.getErrorCode() == 3702){
                    System.out.println(e.getMessage());
                }else{
                    e.printStackTrace();
                }        
            }
        }
    }

    private Statement setConnection(){
        Statement stmt = null;
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS());
           if (conn == null ){
               System.out.println("asd");
           }
           
           stmt = conn.createStatement();
           return stmt;
           
        }catch (Exception e){
           e.printStackTrace();
        }
        return stmt;
    }

    private void createDatabase(Statement stmt){
        try{
            String sql = "CREATE DATABASE " + getDB_NAME();
            stmt.executeUpdate(sql);
            System.out.println(getDB_NAME()+ " created successfully...");  
            
            stmt.close();
        }catch (SQLException e){
            if(e.getErrorCode() == 1007){
                System.out.println(e.getMessage());
            }else{
                e.printStackTrace();
            }
        }
    }
    
    public void addToTables(String[] data, String tableName){
        try {
            Statement stmt = setConnection();
                        
            String sql = "SELECT *"
                    + "FROM "+tableName;
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            Integer columnTotal = rsmd.getColumnCount();
            Integer maxID = 0;
            
            ArrayList<String> columnNamesTmp = new ArrayList<String>();
            for(int counter = 1; counter <= columnTotal; counter++){
                columnNamesTmp.add(rsmd.getColumnName(counter));
            }
            
            while(rs.next()){
                maxID ++;
            }
            
            String[] columnNames = columnNamesTmp.toArray(new String[0]);
            
            sql = "INSERT INTO " + tableName + " (";
            
            for(String name : columnNames){
                sql += name + ",";
            }
            sql = sql.substring(0, sql.length()-1);
            sql += ") ";
            
            sql += "VALUES (" + '\'' + tableName.charAt(0) + maxID + '\'' + ", ";
            
            for(String input : data){
                sql += '\'' + input + '\'' + ",";
            }
            
            sql = sql.substring(0, sql.length()-1);
            sql += ")";
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
//INSERT INTO table_name (column1, column2, column3, ...)
//VALUES (value1, value2, value3, ...); INSERT TEMPLATE

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getDB_URL() {
        return DB_URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static String getDB_NAME() {
        return DB_NAME;
    }
    public static String[] getTableNames() {
       return tableNames;
    }
    
    public ResultSet getAllData(String table){
        ResultSet rs = null;
        String sql = "";
        
        try {
            switch (table) {
                case "Driver" -> sql = "SELECT id, firstname, lastname "
                            + "FROM driver";
                case "Inventory" -> sql = "SELECT * "
                            + "FROM inventory";
                case "CustOrder" -> sql = "SELECT * "
                            + "FROM custorder";
                default -> {
                }
            }
            Statement stmt = setConnection();
            rs = stmt.executeQuery(sql);
            
            return rs; 
        }catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return rs;
    }
}