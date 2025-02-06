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

public class srcdoc extends JFrame {
	public srcdoc() {
		setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------------------
        JLabel dcl = new JLabel("Doctors");
        dcl.setBounds(200, 20,200, 40);
        dcl.setFont(new Font("Arial",Font.BOLD,30));
        dcl.setForeground(Color.white);
        //-----------------------------------------------------------------------------------------------
        String[] dpList = {"Accident & Emergency","Anaesthesia","Cardiology", "Dental & Maxillofacial Surgery", "Dermatology & Venereology","Diabetology & Endocrinology", "ENT","Gastroenterology & Hepatology", "Neurology","Obstetrics and Gynaecology","Orthopaedics","Urology"}; 
        JComboBox<String> list = new JComboBox<>(dpList);
        list.setBounds(100,90,280,30);
        Font font2 = new Font(list.getFont().getName(),Font.BOLD,17);
        list.setFont(font2);
        //-----------------------------------------------------------------------------------------------
        JButton src = new JButton("Search");
        src.setBounds(400, 90, 70, 35);
        Font fontl = new Font(src.getFont().getName(),Font.BOLD,20);
        src.setForeground(new Color(40,48,99));
        src.setBackground(Color.WHITE);
        src.setFocusPainted(false);
        Border br = new EmptyBorder(0,0,0,0);
        src.setBorder(br);
        src.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String department = (String) list.getSelectedItem();
                
                String filePath = "E:/Project/HealthSync/storage/data.xlsx";
        		Vector<Integer> itr = new Vector<>();
                try {
        			Workbook workbook;
        			Sheet sheet;
        			
        			int flag = 0;
        			
        			File file = new File(filePath);
        			
        			FileInputStream fileIn = new FileInputStream(file);
        			workbook = new XSSFWorkbook(fileIn);
        			sheet = workbook.getSheet("User Data");
        			
        			Row rowT = sheet.getRow(4);
        			Cell cellT = rowT.getCell(28);
        			int total = (int) cellT.getNumericCellValue();
        			
        			for(int i=5; i<(5+total); i++) {
        				Row rowD = sheet.getRow(i);
        				Cell cellD = rowD.getCell(25);
        				String dept = cellD.getStringCellValue();
        				if(dept.equals(department)) {
        					itr.add(i);
        					flag = 1;
        				}
        			}
        			if(flag == 0) {
        				JOptionPane.showMessageDialog(null, "Sorry, No doctors found.!!");
        			}else {
        				docs docss = new docs(itr);
                        docss.getContentPane().setBackground(Color.white);
                        docss.setVisible(true);
                        dispose();
        			}
        			workbook.close();
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
                
                
            }
        });
        //-----------------------------------------------------------------------------------------------
        JButton addD = new JButton("Add Doctor");
        addD.setBounds(400,150,150,35);
        addD.setFont(fontl);
        addD.setForeground(new Color(40,48,99));
        addD.setBackground(Color.WHITE);
        addD.setFocusPainted(false);
        addD.setBorder(br);
        addD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addDoc ad = new addDoc();
                ad.getContentPane().setBackground(new Color(40,102,99));
                ad.setVisible(true);
                dispose();
            }
        });
        //------------------------------------------------------------------------------------------------
        JButton cn = new JButton("Cancel");
        cn.setBounds(100,150,80,35);
        cn.setFont(fontl);
        cn.setForeground(new Color(40,48,99));
        cn.setBackground(Color.WHITE);
        cn.setFocusPainted(false);
        cn.setBorder(br);
        cn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0, 167, 189));
                hp.setVisible(true);
                dispose();;
            }
        });
        
      //------------------------------------------------------------------------------------------------
        
        
        getContentPane().setLayout(null);
        getContentPane().add(dcl);
        getContentPane().add(list);
        getContentPane().add(src);
        getContentPane().add(addD);
        getContentPane().add(cn);
	}
}
