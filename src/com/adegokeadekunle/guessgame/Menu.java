/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adegokeadekunle.guessgame;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Adekunle
 */
public class Menu extends JFrame implements ActionListener  { 
    JButton but1,but2,but3;
    JLabel name;

    public Menu() {
        but1 = new JButton("Play Game");
        but2 = new JButton("Instructions");
        but3 = new JButton("Exit Game");
        
        name = new JLabel("Hangman Game");
        name.setFont(new Font("serif",Font.ITALIC,25));
        
        setTitle("HANGMAN GAME");
        setSize(500,300);
        setResizable(false);
        setVisible(true);
        
        but1.addActionListener( this);
        but2.addActionListener(this);
        but3.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
            if(e.getSource() == but1){
                GameWindow newGame = new GameWindow();
                newGame.startGame();
                this.dispose();
    
    }
            else if (e.getSource() == but2){
                JOptionPane.showMessageDialog(this, "1. You can guess the word by clicking from the virtual keypad\n2. You can only select a maximum of 5 incorrect letters \n3. The incorrect one will be highlighted with a red color ,and the correct one with a green color","instructions",JOptionPane.INFORMATION_MESSAGE);
 
    
    }
            else if (e.getSource() == but3) {
                System.exit(0);
            }
            
            
        }
    public void addComponent(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
         //define position of the label
         
         c.gridx = 0;
         c.gridy = 0;
         c.weighty = 0.1;
         c.anchor = c.CENTER;
         add(name,c);
         
         //define the position for button 1
         
         c.gridx = 0;
         c.gridy = 1;
         c.fill = c.HORIZONTAL;
         add(but1,c);
    
         //define the position for button 1
         
         c.gridx = 0;
         c.gridy = 2;
         c.fill = c.HORIZONTAL;
         add(but2,c);
         
         //define the position for button 1
         
         c.gridx = 0;
         c.gridy = 3;
         c.fill = c.HORIZONTAL;
         add(but3,c);
    }
}
 