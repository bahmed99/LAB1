/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;

import javax.swing.*;

/**
 *
 * @author Ahmed
 */
public class NewMain {

  
    public static void main(String[] args) {
        Tictactoe frame = new Tictactoe();
        frame.setTitle("Tic Tac Toe");
        frame.setSize(500,500); 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }
    
}
