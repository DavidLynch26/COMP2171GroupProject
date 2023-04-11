/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guicontroller;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import databasemanager.DatabaseController;
import java.awt.Component;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import screens.*;

/**
 *
 * @author lynch
 */

public final class MainFrame extends javax.swing.JFrame {

    private static DefaultTableModel driverModel;
    private static DefaultTableModel inventoryModel;
    private static DefaultTableModel custOrderModel;
    private static DefaultTableModel OrderModel;
    private static DefaultTableModel customerModel;
    private static DefaultComboBoxModel comboBoxModel;
    private static ArrayList<String> items = new ArrayList<String>();
    private static ArrayList<String> customers = new ArrayList<String>();

    private final static DatabaseController database = new databasemanager.DatabaseController();
    private final static DriverScreen driverScreen = new screens.DriverScreen();
    private final static AdminScreen adminScreen = new screens.AdminScreen();
    
    /**
     * Creates new form LoaderFrame
     */
    public MainFrame(){
        initComponents();
        loadTabs("Login");
    }
    
    public static void updateTable(String table) throws SQLException{
//        custOrderModel = null;
        ResultSet rs = database.getAllData(table);
        ResultSetMetaData rsmd = rs.getMetaData();
        
        String[] columnNames = new String[rsmd.getColumnCount()];
        String[] columnData = new String[rsmd.getColumnCount()];
       
//        while(rs.next()){
//            System.out.println("asd");
//            for(int i = 1; i < rsmd.getColumnCount(); i++){
//                System.out.print(rs.getString(i) + " ");
//                System.out.println("asd");
//            }
//        }
        
        for(Integer counter = 1; counter <= columnNames.length; counter++){
            columnNames[counter-1] = rsmd.getColumnName(counter);
//            System.out.println(columnNames[counter-1]);
        }       
//        System.out.println(columnNames);
        switch (table) {
            case "Customer" -> {
                customerModel=new DefaultTableModel(columnNames,0);
                adminScreen.getTable(table).setModel(customerModel);
            }
            case "Driver" -> {
                driverModel=new DefaultTableModel(columnNames,0);
                adminScreen.getTable(table).setModel(driverModel);
            }
            case "Inventory" -> {
                inventoryModel=new DefaultTableModel(columnNames,0);
                adminScreen.getTable(table).setModel(inventoryModel);
            }
            case "CustOrder" -> {
                custOrderModel=new DefaultTableModel(columnNames,0);
                adminScreen.getTable(table).setModel(custOrderModel);
            }
            default -> {
            }
        }

        while(rs.next()){
            if(table.equals("Inventory")){
                items.add(rs.getString("item"));
//                System.out.println(items);
                adminScreen.getComboBox("items").addItem(rs.getString("item"));
            }
            
            if(table.equals("Customer")){
                customers.add(rs.getString("firstname") + " " + rs.getString("lastname"));
//                System.out.println(customers);
                adminScreen.getComboBox("customers").addItem(rs.getString("firstname") + rs.getString("lastname"));                            }
            
            for(Integer counter = 1; counter <= columnNames.length; counter++){
                columnData[counter-1] = rs.getString(columnNames[counter-1]);
//                System.out.println(columnData[counter-1]);
            } 
            switch (table) {
                case "Customer" -> {
                    customerModel.addRow(columnData);
                }
                case "Driver" -> {
                    driverModel.addRow(columnData);
                }
                case "Inventory" -> {
                    inventoryModel.addRow(columnData);
                }
                case "CustOrder" -> {
                    custOrderModel.addRow(columnData);
                }
                default -> {
                }
            }
        }
        String[] itemList = items.toArray(new String[0]);
        adminScreen.getComboBox("items").setModel(new javax.swing.DefaultComboBoxModel<>(itemList));
        
        String[] customerList = customers.toArray(new String[0]);
        adminScreen.getComboBox("customers").setModel(new javax.swing.DefaultComboBoxModel<>(customerList)); 
    }
    
    public void loadTabs(String userType){
        switch (userType) {
            case "Login" -> {
                this.remove(panelHolder);
                this.add(jPanel1);
            }
            case "Driver" -> {
                for(Map.Entry<String, Component> entry : driverScreen.getAllPanels().entrySet()){
                    panelHolder.add(entry.getKey(), entry.getValue());
                }
                this.remove(jPanel1);
                this.add(panelHolder);
            }
            case "Admin" -> {
                for(Map.Entry<String, Component> entry : adminScreen.getAllPanels().entrySet()){
                    panelHolder.add(entry.getKey(), entry.getValue());
                }
                this.remove(jPanel1);
                this.add(panelHolder);
            }
            default -> {
            }
        }
        this.setLocationRelativeTo(null);
        revalidate();
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        driverRadioButton = new javax.swing.JRadioButton();
        adminRadioButton = new javax.swing.JRadioButton();
        passwordField = new javax.swing.JPasswordField();
        panelHolder = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Black Hard Sweet Company");
        setPreferredSize(new java.awt.Dimension(500, 500));

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        buttonGroup1.add(driverRadioButton);
        driverRadioButton.setText("Driver");
        driverRadioButton.setName("Driver"); // NOI18N
        driverRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(adminRadioButton);
        adminRadioButton.setText("Admin");
        adminRadioButton.setName("Admin"); // NOI18N

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(209, 209, 209))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loginButton, javax.swing.GroupLayout.Alignment.CENTER))
                .addGap(209, 209, 209))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(driverRadioButton)
                .addGap(30, 30, 30)
                .addComponent(adminRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        if(userNameTextField.getText().equals("") ||
            passwordField.getPassword().equals("") ||
            buttonGroup1.getSelection() == null){
            JOptionPane.showMessageDialog(this, "Please ensure ALL fields are filled", "Incomplete Login Credentials", JOptionPane.ERROR_MESSAGE);
        }else{
            Boolean loginStatus;
            String[] loginCredentials = {userNameTextField.getText(), String.valueOf(passwordField.getPassword())};
            Enumeration buttons = buttonGroup1.getElements();

            while(buttons.hasMoreElements()){
                AbstractButton button = (AbstractButton)buttons.nextElement();
                if(button.isSelected()){
                    String userType = button.getName();
                    loginStatus = MainFrame.getDatabase().login(userType, loginCredentials);
                    if(loginStatus){
                        JOptionPane.showMessageDialog(this, "Successful Login");
                        this.remove(jPanel1);
                        try {
                            updateTable("Customer");
                            updateTable("Driver");
                            updateTable("Inventory");
                            updateTable("CustOrder");
                            this.revalidate();
                            this.repaint();
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        loadTabs(userType);
                    }else{
                        JOptionPane.showMessageDialog(this, "Unsuccessful Login", "Incorrect Details", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void driverRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_driverRadioButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton driverRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JTabbedPane panelHolder;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    public static DatabaseController getDatabase() {
        return database;
    }

    public static DefaultTableModel getDriverModel() {
        return driverModel;
    }

    public static DefaultTableModel getInventoryModel() {
        return inventoryModel;
    }

    public static DefaultTableModel getCustOrderModel() {
        return custOrderModel;
    }
    
    public static DefaultTableModel getCustomerModel() {
        return customerModel;
    }    
    
    public static DefaultTableModel getOrderModel() {
        return customerModel;
    } 
}