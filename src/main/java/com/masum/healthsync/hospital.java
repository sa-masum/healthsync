package com.masum.healthsync;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class hospital extends JFrame {
	public hospital() {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //--------------------------------------------------------------------------------------------------------------
        JButton register = new JButton(new ImageIcon("E:/Project/HealthSync/storage/register.jpg"));
        register.setBounds(50,200,240,297);  // 50-360
        register.setBackground(new Color(0, 167, 189));
        register.setFocusPainted(false);
        Border brr = new EmptyBorder(0,0,0,0);
        register.setBorder(brr);
        setLayout(null);
        
        register.addActionListener(e->{
            JFrame rg = new register();
            rg.getContentPane().setBackground(new Color(40,102,99));
            rg.setVisible(true);
            dispose();
        });
        //----------------------------------------------------------------------------------------------------------------
        JLabel r_label = new JLabel("Register");
        r_label.setBounds(100,510,240,35);
        Font font = new Font(r_label.getFont().getName(),Font.BOLD,30);
        r_label.setFont(font);
        r_label.setForeground(Color.WHITE);
        //-----------------------------------------------------------------------------------------------------------------
        JButton search = new JButton(new ImageIcon("E:/Project/HealthSync/storage/search.png"));
        search.setBounds(400,200,240,297);  
        setLayout(null);
        search.addActionListener(e->{
        	JFrame sc = new search();
            sc.getContentPane().setBackground(new Color(40,102,99));
            sc.setVisible(true);
            dispose();
        });
        //----------------------------------------------------------------------------------------------------------------
        JLabel s_label = new JLabel("Search");
        s_label.setBounds(460,510,240,35);
        s_label.setFont(font);
        s_label.setForeground(Color.WHITE);
        //-----------------------------------------------------------------------------------------------------------------
        JButton book = new JButton(new ImageIcon("E:/Project/HealthSync/storage/book.png"));
        book.setBounds(760,200,270,297);  
        setLayout(null);
        book.addActionListener(e->{
        	JFrame ba = new book();
            ba.getContentPane().setBackground(new Color(40,102,99));
            ba.setVisible(true);
            dispose();
        });
        //----------------------------------------------------------------------------------------------------------------
        JLabel b_label = new JLabel("Book Appoinment");
        b_label.setBounds(765,510,274,35);
        b_label.setFont(font);
        b_label.setForeground(Color.WHITE);
        //-----------------------------------------------------------------------------------------------------------------
        JButton doctors = new JButton(new ImageIcon("E:/Project/HealthSync/storage/doctors.jpg"));
        doctors.setBounds(1150,200,245,297);  
        setLayout(null);
        doctors.addActionListener(e->{
        	JFrame dc = new srcdoc();
            dc.getContentPane().setBackground(new Color(40,102,99));
            dc.setVisible(true);
            dispose();
        });
        //----------------------------------------------------------------------------------------------------------------
        JLabel d_label = new JLabel("Doctors");
        d_label.setBounds(1210,510,274,35);
        d_label.setFont(font);
        d_label.setForeground(Color.WHITE);
        //-----------------------------------------------------------------------------------------------
        JPanel pn = new JPanel(){
            @Override
            protected void paintComponent(Graphics gp){
                Graphics2D gp2d = (Graphics2D) gp.create();
                gp2d.setColor(new Color(40,48,99));
                gp2d.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
                gp2d.dispose();
            };
        };
        pn.setBounds(1350,700,110,55);
        pn.setLayout(null);
        //------------------------------------------------------------------------------------------------
        JButton logout = new JButton("Logout");
        logout.setBounds(3,3,102,47);
        Font fontl = new Font(logout.getFont().getName(),Font.BOLD,20);
        logout.setFont(fontl);
        logout.setForeground(Color.WHITE);
        logout.setBackground(new Color(40,48,99));
        logout.setFocusPainted(false);
        Border br = new EmptyBorder(0,0,0,0);
        logout.setBorder(br);
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                logout.setBackground(new Color(40,48,99));
                logout.setOpaque(true);
                home hm = new home();
                hm.getContentPane().setBackground(new Color(50, 99, 159));
                hm.setVisible(true);
                dispose();
            }
        });
        pn.add(logout);
        
        //------------------------------------------------------------------------------------------------
        
        JPanel pn2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics gp){
                Graphics2D gp2d = (Graphics2D) gp.create();
                gp2d.setColor(new Color(40,48,99));
                gp2d.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
                gp2d.dispose();
            };
        };
        pn2.setBounds(50,700,280,55);
        pn2.setLayout(null);
        //------------------------------------------------------------------------------------------------
        JButton change = new JButton("Change Login Credential");
        change.setBounds(3,3,272,47);
        //Font fontl = new Font(logout.getFont().getName(),Font.BOLD,20);
        change.setFont(fontl);
        change.setForeground(Color.RED);
        change.setBackground(new Color(40,48,99));
        change.setFocusPainted(false);
        Border br1 = new EmptyBorder(0,0,0,0);
        change.setBorder(br1);
        change.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                change ch = new change();
                ch.getContentPane().setBackground(new Color(50, 99, 159));
                ch.setVisible(true);
                dispose();
            }
        });
        pn2.add(change);
        //-----------------------------------------------------------------------------------------------------------------
        
        
        
        
        getContentPane().add(register);
        getContentPane().add(r_label);
        getContentPane().add(search);
        getContentPane().add(s_label);
        getContentPane().add(book);
        getContentPane().add(b_label);
        getContentPane().add(doctors);
        getContentPane().add(d_label);
        getContentPane().add(pn);
        getContentPane().add(pn2);
	}
}
