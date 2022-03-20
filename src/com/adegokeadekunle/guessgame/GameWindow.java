/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adegokeadekunle.guessgame;

/**
 *
 * @author Adekunle
 */
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class GameWindow extends JFrame implements ActionListener{
    JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    JLabel wordLabel, messageLabel;
    JPanel keypad, panel1,panel2, panel3, screen, notify;

    //inbuilt variables declaration
    int len, count, flag, rnd, chance;
    String[] Country = {"EGYPT","JAPAN","SERBIA","QATAR","INDIA",
                        "MONGOLIA","BAHARAIN","SYRIA","PAKISTAN","AUSTRALIA" ,
                        "CHINA","AFGHANISTAN","AMERICA","BRITAIN","GHANA"};
    Random rd;
    StringBuffer blanks;

    //placing all gui components in the default constructor
    public GameWindow(){
        a = new JButton("A");
        b = new JButton("B");
        c = new JButton("C");
        d = new JButton("D");
        e = new JButton("E");
        f = new JButton("F");
        g = new JButton("G");
        h = new JButton("H");
        i = new JButton("I");
        j = new JButton("J");
        k = new JButton("K");
        l = new JButton("L");
        m = new JButton("M");
        n = new JButton("N");
        o = new JButton("O");
        p = new JButton("P");
        q = new JButton("Q");
        r = new JButton("R");
        s = new JButton("S");
        t = new JButton("T");
        u = new JButton("U");
        v = new JButton("V");
        w = new JButton("W");
        x = new JButton("X");
        y = new JButton("Y");
        z = new JButton("Z");

        wordLabel = new JLabel("Guess A Country");
        wordLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        messageLabel = new JLabel();
        messageLabel.setFont(new Font("Serif",Font.PLAIN,35));

        keypad = new JPanel();
        keypad.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));

        panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);

        panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);

        panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);

        screen =  new JPanel();
        screen.setBackground(Color.WHITE);
        screen.setSize(0,200);

        notify = new JPanel();
        notify.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));

        //variable initialization
        count = 0;
        chance = 0;
        rd =  new Random();
        blanks = new StringBuffer();

        setTitle("Hangman Game");
        setSize(500,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add action listeners
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
        h.addActionListener(this);
        i.addActionListener(this);
        j.addActionListener(this);
        k.addActionListener(this);
        l.addActionListener(this);
        m.addActionListener(this);
        n.addActionListener(this);
        o.addActionListener(this);
        p.addActionListener(this);
        q.addActionListener(this);
        r.addActionListener(this);
        s.addActionListener(this);
        t.addActionListener(this);
        u.addActionListener(this);
        v.addActionListener(this);
        w.addActionListener(this);
        x.addActionListener(this);
        y.addActionListener(this);
        z.addActionListener(this);

    }

    public void addComponents(){
        GridBagConstraints gc = new GridBagConstraints();

        notify.setLayout(new FlowLayout());
        notify.add(messageLabel);

        screen.setLayout(new GridBagLayout());
        screen.add(wordLabel, gc);

        keypad.setLayout(new GridBagLayout());

        panel1.setLayout(new FlowLayout());
        panel1.add(q);
        panel1.add(w);
        panel1.add(e);
        panel1.add(r);
        panel1.add(t);
        panel1.add(y);
        panel1.add(u);
        panel1.add(i);
        panel1.add(o);
        panel1.add(p);

        gc.gridx = 0;
        gc.gridy = 0;
        keypad.add(panel1, gc);

        panel2.setLayout(new FlowLayout());
        panel2.add(a);
        panel2.add(s);
        panel2.add(d);
        panel2.add(f);
        panel2.add(g);
        panel2.add(h);
        panel2.add(j);
        panel2.add(k);
        panel2.add(l);

        gc.gridx = 0;
        gc.gridy = 1;
        keypad.add(panel2, gc);

        panel3.setLayout(new FlowLayout());
        panel3.add(z);
        panel3.add(x);
        panel3.add(c);
        panel3.add(v);
        panel3.add(b);
        panel3.add(n);
        panel3.add(m);
    
        gc.gridx = 0;
        gc.gridy = 2;
        keypad.add(panel3, gc);

        setLayout(new BorderLayout());
        add(notify, BorderLayout.NORTH);
        add(screen, BorderLayout.CENTER);
        add(keypad, BorderLayout.SOUTH);



    }

    public void startGame() {
        addComponents();
        rnd = rd.nextInt(10);
        len = Country[rnd].length();

        for(int j=0;j<len;j++){
            blanks.append("_  ");
        }
        wordLabel.setText(blanks.toString());

    }


    //Event handler to carryout our required operation!
    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        JButton jb = (JButton)ae.getSource();
        String letter = ae.getActionCommand();

        flag = 0;
        for(int loop=0;loop<len;loop++){
            if(letter.charAt(0) == Country[rnd].charAt(loop)){
                flag = 1;
                blanks.replace((loop*3),((loop*3)+1),letter);
                count++;
            }
        }

        if(flag == 1){
            wordLabel.setText(blanks.toString());// converts the blanks to letters
            jb.setBackground(Color.GREEN);
            jb.setEnabled(false);
        }else{
            jb.setBackground(Color.RED);
            jb.setEnabled(false);
            chance++;
        }

        if(count == len){
            JOptionPane.showMessageDialog(this, "Congrats You have guessed the word correctly");
            int n = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart Game", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            
            if(n == JOptionPane.YES_OPTION) {
                GameWindow obj = new GameWindow();
                obj.startGame();
                this.dispose();
            }else{
                this.dispose();
                Menu obj = new Menu();
                obj.addComponent();
            }
        }
       if(chance > 5){// set the maximum chance a user gets
           JOptionPane.showMessageDialog(this, "Sorry you lost your chances");
           int n = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart Game", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            
            if(n == JOptionPane.YES_OPTION) {
                GameWindow obj = new GameWindow();
                obj.startGame();
                this.dispose();
            }else{
                this.dispose();
                Menu obj = new Menu();
                obj.addComponent();
            }
       } 
    }

}
