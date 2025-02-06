package com.masum.healthsync;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class home extends JFrame {
    public home(){
        setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //-----------------------------------------------------------------------------------------------
        JPanel pn = new JPanel(){
            @Override
            protected void paintComponent(Graphics gp){
                Graphics2D gp2d = (Graphics2D) gp.create();
                gp2d.setColor(new Color(40,48,99));
                gp2d.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
                gp2d.setColor(Color.white);
                gp2d.draw(new Line2D.Double(getWidth()/2,110,getWidth()/2,getHeight()-80));
                gp2d.dispose();
            };
        };
        pn.setBounds(200,100,1150,620);
        pn.setLayout(null);
        //------------------------------------------------------------------------------------------------
        JLabel pl = new JLabel("Login");
        pl.setBounds(527, 50,200, 40);
        pl.setFont(new Font("Arial",Font.BOLD,30));
        pl.setForeground(Color.white);
        pn.add(pl);
        //------------------------------------------------------------------------------------------------
        ImageIcon ic = new ImageIcon("E:/Project/HealthSync/storage/doctors.jpg");
        JLabel iml = new JLabel();
        iml.setIcon(ic);
        int imw = iml.getPreferredSize().width;
        int imh = iml.getPreferredSize().height;
        iml.setBounds(150,150,imw,imh);
        pn.add(iml);
        //-------------------------------------------------------------------------------------------------
        JLabel idl = new JLabel("User ID:");
        idl.setForeground(Color.white);
        idl.setFont(new Font("Arial",Font.PLAIN,20));
        idl.setBounds(410+imw,200,100,30);
        pn.add(idl);
        //--------------------------------------------------------------------------------------------------
        JTextField idt = new JTextField();
        idt.setBounds(530+imw,200,300,30);
        Font font1 = new Font(idt.getFont().getName(),Font.BOLD,17);
        idt.setFont(font1);
        pn.add(idt);
        //---------------------------------------------------------------------------------------------------
        JLabel passl = new JLabel("Password:");
        passl.setForeground(Color.white);
        passl.setFont(new Font("Arial",Font.PLAIN,20));
        passl.setBounds(410+imw,270,100,30);
        pn.add(passl);
        //--------------------------------------------------------------------------------------------------
        JPasswordField passt = new JPasswordField();
        passt.setBounds(530+imw,270,300,30);
        passt.setFont(font1);
        pn.add(passt);
        //---------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------
        JPanel pn2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics gp2){
                Graphics2D gp2d2 = (Graphics2D) gp2.create();
                gp2d2.setColor(Color.WHITE);
                gp2d2.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
                gp2d2.dispose();
            };
        };
        pn2.setBounds(530+imw,340,85,37);
        pn2.setLayout(null);
        //------------------------------------------------------------------------------------------------
        String filePath = "E:/Project/HealthSync/storage/data.xlsx";
		int rn = 4;
		try {
			Workbook workbook;
			Sheet sheet;
			Row headerRow;
			
			File file = new File(filePath);
			if(file.exists()) {
				FileInputStream fileInput = new FileInputStream(file);
				workbook = new XSSFWorkbook(fileInput);
				sheet = workbook.getSheet("User Data");
			}
			else{
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("User Data");
				headerRow = sheet.createRow(rn);
				headerRow.createCell(4).setCellValue("Name");
				headerRow.createCell(5).setCellValue("Age");
				headerRow.createCell(6).setCellValue("Mobile");
				headerRow.createCell(7).setCellValue("Gender");
				headerRow.createCell(8).setCellValue("Weight");
				headerRow.createCell(9).setCellValue("Height");
				headerRow.createCell(10).setCellValue("Admission Date");
				headerRow.createCell(11).setCellValue("Previous Diseases");
				headerRow.createCell(12).setCellValue("Total->");
				headerRow.createCell(13).setCellValue(0);
				headerRow.createCell(16).setCellValue("User Id");
				headerRow.createCell(17).setCellValue("admin");
				headerRow.createCell(18).setCellValue("Password");
				headerRow.createCell(19).setCellValue("abc123");
				
				headerRow.createCell(22).setCellValue("Doctor");
				headerRow.createCell(23).setCellValue("Mobile");
				headerRow.createCell(24).setCellValue("Gender");
				headerRow.createCell(25).setCellValue("Department");
				headerRow.createCell(26).setCellValue("Degrees");
				headerRow.createCell(27).setCellValue("TotalD->");
				headerRow.createCell(28).setCellValue(0);
				
			}
			
			
			for(int i=rn; i<30; i++) {
				sheet.autoSizeColumn(i);
			}
			
			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				workbook.write(fileOutputStream);
			}
			
			workbook.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
        //------------------------------------------------------------------------------------------------
        JButton login = new JButton("Login");
        login.setBounds(3,3,80,32);
        Font fontl = new Font(login.getFont().getName(),Font.BOLD,20);
        login.setFont(fontl);
        login.setForeground(new Color(40,48,99));
        login.setBackground(Color.WHITE);
        login.setFocusPainted(false);
        Border br = new EmptyBorder(0,0,0,0);
        login.setBorder(br);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userId = idt.getText();
                char[] passC = passt.getPassword();
                String password = new String(passC);
               
                String filePath = "E:/Project/HealthSync/storage/data.xlsx";
        		String user = null;
        		String pass = null;
                
        		try {
        			Workbook workbook;
        			Sheet sheet;
        			
        			File file = new File(filePath);
        			
        			FileInputStream fileInput = new FileInputStream(file);
        			workbook = new XSSFWorkbook(fileInput);
        			sheet = workbook.getSheet("User Data");
        			
        			Row rowUP = sheet.getRow(4);
        			Cell cellU = rowUP.getCell(17);
        			Cell cellP = rowUP.getCell(19);
        			
        			DataFormatter dataF = new DataFormatter();
        			user = dataF.formatCellValue(cellU);
        			pass = dataF.formatCellValue(cellP);
        			
        			
        			for(int i=rn; i<(rn+9); i++) {
        				sheet.autoSizeColumn(i);
        			}
        			
        			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        				workbook.write(fileOutputStream);
        			}
        			
        			workbook.close();
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
                
                if(userId.equals(user) && password.equals(pass)){
                    JFrame hp = new hospital();
                    hp.getContentPane().setBackground(new Color(0, 167, 189));
                    hp.setVisible(true);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong Password, Please try again.!!");
                }
            }
        });
        pn2.add(login);
        pn.add(pn2);
        //-----------------------------------------------------------------------------------------------
        JPanel pn3 = new JPanel(){
            @Override
            protected void paintComponent(Graphics gp2){
                Graphics2D gp2d2 = (Graphics2D) gp2.create();
                gp2d2.setColor(Color.WHITE);
                gp2d2.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
                gp2d2.dispose();
            };
        };
        pn3.setBounds(1000,500,85,37);
        pn3.setLayout(null);
        //------------------------------------------------------------------------------------------------
        JButton close = new JButton("Close");
        close.setBounds(3,3,80,32);
        close.setFont(fontl);
        close.setForeground(new Color(40,48,99));
        close.setBackground(Color.WHITE);
        close.setFocusPainted(false);
        close.setBorder(br);
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        pn3.add(close);
        pn.add(pn3);
        
        getContentPane().setLayout(null);
        getContentPane().add(pn);
    }
}
