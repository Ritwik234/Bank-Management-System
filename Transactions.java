package com.Banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;




public class Transactions extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    Transactions(){
        setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("STATEE BANK OF INDIA");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (2*x);
        int w = z/y;
        String pad ="";

        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"STATEE BANK OF INDIA");  // title of gui page setted

        l1 = new JLabel("[Please Select Your Process Of Transaction]");   // first layout described ..
        l1.setFont(new Font("Serif" + "", Font.BOLD|Font.ITALIC, 30));


        b1 = new JButton("CASH WITHDRAWAL");     // button details are given like color , font and size ..
        b1.setFont(new Font("Serif", Font.BOLD, 18));
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("DEPOSIT");
        b2.setFont(new Font("Serif", Font.BOLD, 18));
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("MINI STATEMENT");
        b3.setFont(new Font("Serif", Font.BOLD, 18));
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("FAST CASH");
        b4.setFont(new Font("Serif", Font.BOLD, 18));
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);

        b5 = new JButton("BALANCE ENQUIRY");
        b5.setFont(new Font("Serif", Font.BOLD, 18));
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.WHITE);

        b6 = new JButton("PIN CHANGE");
        b6.setFont(new Font("Serif", Font.BOLD, 18));
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);

        b7 = new JButton("EXIT");
        b7.setFont(new Font("Serif", Font.BOLD, 18));
        b7.setBackground(Color.BLUE);
        b7.setForeground(Color.WHITE);


        setLayout(null);

        l1.setBounds(100,100,700,60);     //layout sizes are given here ..
        add(l1);

        b1.setBounds(40,250,300,60);
        add(b1);

        b2.setBounds(440,250,300,60);
        add(b2);

        b3.setBounds(40,360,300,60);
        add(b3);

        b4.setBounds(440,360,300,60);
        add(b4);

        b5.setBounds(40,470,300,60);
        add(b5);

        b6.setBounds(440,470,300,60);
        add(b6);

        b7.setBounds(240,600,300,60);
        add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


        getContentPane().setBackground(Color.ORANGE);

        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new Withdrawl().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b2){
            new Deposit().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b3){
            new Cash().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b4){
//            new MiniStatement().setVisible(true);
//            setVisible(false);
        }
        else if(ae.getSource()==b5){
         //   new Pin().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b6){

            String pinn = JOptionPane.showInputDialog("Enter PIN");
           connec c1 = new connec();

            try {
                ResultSet rs = c1.s.executeQuery(" SELECT balance From bank ORDER BY pin  = '"+pinn+"' DESC LIMIT 1");
                if(rs.next()){
                    String balance = rs.getString("balance");
                    JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource()==b7){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Transactions().setVisible(true);
    }
}
