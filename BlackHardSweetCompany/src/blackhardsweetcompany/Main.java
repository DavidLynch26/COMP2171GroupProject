/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackhardsweetcompany;

import guicontroller.MainFrame;

/**
 *
 * @author lynch
 */
public class Main{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame gui = new MainFrame();
                gui.setVisible(true);
            }
        });         
    }   
}