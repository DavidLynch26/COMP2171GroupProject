/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import guicontroller.MainFrame;
import java.awt.Component;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lynch
 */
public class AdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form AdminScreen
     */
    public AdminScreen() {
        initComponents();
        
    }
    
    public Boolean isInteger(String test){
        if(test == null){
            return false;
        }
        
        try{
            Double.parseDouble(test);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public void setTable(String table){
        switch (table) {
            case "Driver" -> {
                JTable jTable1 = new JTable(MainFrame.getDriverModel());
                JScrollPane scrollPane1 = new JScrollPane(jTable1);
                scrollPane1.setName("View Driver");
                this.add(scrollPane1);
            }
            case "Inventory" -> {
                JTable jTable2 = new JTable(MainFrame.getInventoryModel());
                JScrollPane scrollPane2 = new JScrollPane(jTable2);
                scrollPane2.setName("View Inventory");
                this.add(scrollPane2);
            }
            case "CustOrder" -> {
                JTable jTable3 = new JTable(MainFrame.getCustOrderModel());
                JScrollPane scrollPane3 = new JScrollPane(jTable3);
                scrollPane3.setName("View Order");
                this.add(scrollPane3);
            }
            default -> {
            }
        }
    }
    
    public Map <String, Component> getAllPanels(){
        Map<String, Component> coordinates = new HashMap<>();
        
        for(Component comp : this.getContentPane().getComponents()){
            coordinates.put(comp.getName(), comp);
        }
        return coordinates;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        makeOrder = new javax.swing.JPanel();
        driverComboBox = new javax.swing.JComboBox<>();
        candyComboBox = new javax.swing.JComboBox<>();
        confirmOrderButton = new javax.swing.JButton();
        quantityTextField = new javax.swing.JTextField();
        candyAmountLabel = new javax.swing.JLabel();
        addDriver = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passWordTextField = new javax.swing.JTextField();
        addDriverButton = new javax.swing.JButton();
        addInventory = new javax.swing.JPanel();
        firstNameLabel1 = new javax.swing.JLabel();
        itemNameTextField = new javax.swing.JTextField();
        lastNameLabel1 = new javax.swing.JLabel();
        itemPriceTextField = new javax.swing.JTextField();
        addItemButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        makeOrder.setName("Make Order"); // NOI18N

        driverComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        candyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        confirmOrderButton.setText("Confirm Order");

        candyAmountLabel.setText("Candy Amount");

        javax.swing.GroupLayout makeOrderLayout = new javax.swing.GroupLayout(makeOrder);
        makeOrder.setLayout(makeOrderLayout);
        makeOrderLayout.setHorizontalGroup(
            makeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makeOrderLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(makeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(makeOrderLayout.createSequentialGroup()
                        .addComponent(candyAmountLabel)
                        .addGap(47, 47, 47)
                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(confirmOrderButton)
                    .addComponent(candyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        makeOrderLayout.setVerticalGroup(
            makeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makeOrderLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(driverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(candyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(makeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(candyAmountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(confirmOrderButton)
                .addGap(31, 31, 31))
        );

        addDriver.setName("Add Driver"); // NOI18N
        addDriver.setLayout(new java.awt.GridBagLayout());

        firstNameLabel.setText("First Name");
        firstNameLabel.setAlignmentX(1.0F);
        firstNameLabel.setAlignmentY(1.0F);
        addDriver.add(firstNameLabel, new java.awt.GridBagConstraints());

        firstNameTextField.setToolTipText("");
        firstNameTextField.setAlignmentX(2.0F);
        firstNameTextField.setAlignmentY(1.0F);
        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });
        addDriver.add(firstNameTextField, new java.awt.GridBagConstraints());

        lastNameLabel.setText("Last Name");
        lastNameLabel.setAlignmentX(1.0F);
        lastNameLabel.setAlignmentY(2.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        addDriver.add(lastNameLabel, gridBagConstraints);

        userNameTextField.setAlignmentX(1.0F);
        userNameTextField.setAlignmentY(2.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        addDriver.add(userNameTextField, gridBagConstraints);

        userNameLabel.setText("Username");
        userNameLabel.setAlignmentX(1.0F);
        userNameLabel.setAlignmentY(3.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        addDriver.add(userNameLabel, gridBagConstraints);

        lastNameTextField.setAlignmentX(2.0F);
        lastNameTextField.setAlignmentY(3.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        addDriver.add(lastNameTextField, gridBagConstraints);

        passwordLabel.setText("Password");
        passwordLabel.setAlignmentX(1.0F);
        passwordLabel.setAlignmentY(4.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        addDriver.add(passwordLabel, gridBagConstraints);

        passWordTextField.setAlignmentX(2.0F);
        passWordTextField.setAlignmentY(4.0F);
        passWordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWordTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        addDriver.add(passWordTextField, gridBagConstraints);

        addDriverButton.setText("Add Driver");
        addDriverButton.setAlignmentY(5.0F);
        addDriverButton.setName("Add Driver"); // NOI18N
        addDriverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDriverButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        addDriver.add(addDriverButton, gridBagConstraints);

        addInventory.setName("Add Item"); // NOI18N
        addDriver.setName("Add Employee");
        addInventory.setLayout(new java.awt.GridBagLayout());

        firstNameLabel1.setText("Item Name");
        firstNameLabel1.setAlignmentX(1.0F);
        firstNameLabel1.setAlignmentY(1.0F);
        addInventory.add(firstNameLabel1, new java.awt.GridBagConstraints());

        itemNameTextField.setToolTipText("");
        itemNameTextField.setAlignmentX(2.0F);
        itemNameTextField.setAlignmentY(1.0F);
        itemNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameTextFieldActionPerformed(evt);
            }
        });
        addInventory.add(itemNameTextField, new java.awt.GridBagConstraints());

        lastNameLabel1.setText("Item Price");
        lastNameLabel1.setAlignmentX(1.0F);
        lastNameLabel1.setAlignmentY(2.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        addInventory.add(lastNameLabel1, gridBagConstraints);

        itemPriceTextField.setAlignmentX(2.0F);
        itemPriceTextField.setAlignmentY(3.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        addInventory.add(itemPriceTextField, gridBagConstraints);

        addItemButton.setText("Add Item");
        addItemButton.setAlignmentY(5.0F);
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        addInventory.add(addItemButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(makeOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(makeOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passWordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passWordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passWordTextFieldActionPerformed

    private void addDriverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDriverButtonActionPerformed
        // TODO add your handling code here:
        if(userNameTextField.getText().equals("") ||
                lastNameTextField.getText().equals("") ||
                passWordTextField.getText().equals("") ||
                firstNameTextField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please ensure ALL fields are filled", "Incomplete Driver Information", JOptionPane.ERROR_MESSAGE);
        }else{
            String[] data = {firstNameTextField.getText(), 
                userNameTextField.getText(),
                lastNameTextField.getText(),
                passWordTextField.getText()};
            MainFrame.getDatabase().addToTables(data, "Driver");
            try {
                MainFrame.updateTable("Driver");
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addDriverButtonActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void itemNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameTextFieldActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        if(itemNameTextField.getText().equals("") ||
                !isInteger(itemPriceTextField.getText())){
            JOptionPane.showMessageDialog(this, "Please ensure ALL fields are filled and are of the right type", "Incomplete Item Information", JOptionPane.ERROR_MESSAGE);
        }else{
            String data[] = {itemNameTextField.getText(),
                itemPriceTextField.getText()
            };
            MainFrame.getDatabase().addToTables(data, "Inventory");
            try {
                MainFrame.updateTable("Inventory");
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addItemButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addDriver;
    private javax.swing.JButton addDriverButton;
    private javax.swing.JPanel addInventory;
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel candyAmountLabel;
    private javax.swing.JComboBox<String> candyComboBox;
    private javax.swing.JButton confirmOrderButton;
    private javax.swing.JComboBox<String> driverComboBox;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel firstNameLabel1;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JTextField itemPriceTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel lastNameLabel1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JPanel makeOrder;
    private javax.swing.JTextField passWordTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}