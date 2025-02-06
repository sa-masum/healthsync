package com.masum.healthsync;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;

import javax.swing.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class search extends JFrame {
	public search() {
		setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------------------
        JLabel hd = new JLabel("Search Patient");
        Font fonth = new Font(hd.getFont().getName(),Font.BOLD,25);
        hd.setBounds(280,20,300,30);
        hd.setFont(fonth);
        hd.setForeground(Color.white);
        //-----------------------------------------------------------------------------------------------------
        JLabel mbl = new JLabel("Mobile Number:");
        Font font = new Font(mbl.getFont().getName(),Font.BOLD,20);
        mbl.setBounds(80,120,300,30);
        mbl.setFont(font);
        mbl.setForeground(Color.white);
        //-----------------------------------------------------------------------------------------------------
        JTextField mbt = new JTextField();
        mbt.setBounds(250,120,200,30);
        mbt.setFont(font);
        //------------------------------------------------------------------------------------------------
        JButton src = new JButton("Search");
        src.setBounds(80,190,100,30);
        
        src.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String filePath = "E:/Project/HealthSync/storage/data.xlsx";
                int rn = 4;
        		try {
        			Workbook workbook;
        			Sheet sheet;
        			
        			File file = new File(filePath);
        			
        			FileInputStream fileIn = new FileInputStream(file);
        			workbook = new XSSFWorkbook(fileIn);
    				sheet = workbook.getSheet("User Data");
    				Row rowT = sheet.getRow(4);
    				Cell cellT = rowT.getCell(13);
    				int total = (int)cellT.getNumericCellValue();
    				int flag = 0;
    				
    				String mbs = mbt.getText();
    				
    				for(int i=5; i<(total+5); i++) {
    					Row row = sheet.getRow(i);
    					Cell cell = row.getCell(6);
    					if(cell.getStringCellValue().equals(mbs)) {
    						flag = 1;
    						patient sp = new patient(i);
    						sp.getContentPane().setBackground(new Color(40,102,99));
    						sp.setVisible(true);
    						dispose();
    					}
    				}
    				
    				if(total == 0 || flag == 0) {
    					JOptionPane.showMessageDialog(null,"Not found.!!");
    				}
        			
        			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        				workbook.write(fileOutputStream);
        			}
        			
        			workbook.close();
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
                /*
                hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0,105,167));
                hp.setVisible(true);
                dispose();*/
            }
        });
        //-----------------------------------------------------------------------------------------------------
        JButton cn = new JButton("Cancel");
        cn.setBounds(400,190,100,30);
        
        cn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0, 167, 189));
                hp.setVisible(true);
                dispose();
            }
        });
        
        
        getContentPane().setLayout(null);
        getContentPane().add(hd);
        getContentPane().add(mbl);
        getContentPane().add(mbt);
        getContentPane().add(src);
        getContentPane().add(cn);
	}
}
