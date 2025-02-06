package com.masum.healthsync;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.Vector;

public class book extends JFrame {
	public book() {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------------------
        JPanel pn = new JPanel(){
            @Override
            protected void paintComponent(Graphics gp){
                Graphics2D gp2d = (Graphics2D) gp.create();
                gp2d.setColor(new Color(40,48,99));
                gp2d.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
                gp2d.dispose();
            };
        };
        pn.setBounds(200,100,1150,620);
        pn.setLayout(null);
        //------------------------------------------------------------------------------------------------
        JLabel pl = new JLabel("Book Appointment");
        pl.setBounds(450, 50,400, 40);
        pl.setFont(new Font("Arial",Font.BOLD,30));
        pl.setForeground(Color.white);
        pn.add(pl);
        //-------------------------------------------------------------------------------------------------
        
        getContentPane().setLayout(null);
        getContentPane().add(pn);
	}
}
