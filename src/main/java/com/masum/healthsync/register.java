package com.masum.healthsync;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.Image;

import javax.swing.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class register extends JFrame {
	public register() {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------------------
        ImageIcon imi = new ImageIcon("E:/Project/HealthSync/storage/background1.jpg");
        Image imr = imi.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imf = new ImageIcon(imr);
        JLabel iml = new JLabel(imf);
        getContentPane().add(iml);
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
        pn.setBounds(200,90,1150,630);
        pn.setLayout(null);
        //------------------------------------------------------------------------------------------------
        JLabel pl = new JLabel("Registration");
        pl.setBounds(500, 50,200, 40);
        pl.setFont(new Font("Arial",Font.BOLD,30));
        pl.setForeground(Color.white);
        pn.add(pl);
        //-------------------------------------------------------------------------------------------------
        JLabel nml = new JLabel("Name:");
        nml.setBounds(200,150,100,30);
        Font font = new Font(nml.getFont().getName(),Font.BOLD,20);
        nml.setFont(font);
        nml.setForeground(Color.white);
        pn.add(nml);
        //----------------------------------------------------------------------------------------------------
        JTextField nmt = new JTextField();
        nmt.setBounds(400,150,400,30);
        Font font2 = new Font(nmt.getFont().getName(),Font.BOLD,17);
        nmt.setFont(font2);
        pn.add(nmt);
        //-----------------------------------------------------------------------------------------------------
        JLabel agl = new JLabel("Age:");
        agl.setBounds(200,200,100,30);
        agl.setFont(font);
        agl.setForeground(Color.white);
        pn.add(agl);
        //----------------------------------------------------------------------------------------------------
        JTextField agt = new JTextField();
        agt.setBounds(400,200,200,30);
        agt.setFont(font2);
        pn.add(agt);
        //-----------------------------------------------------------------------------------------------------
        JLabel ml = new JLabel("Mobile:");
        ml.setBounds(200,250,100,30);
        ml.setFont(font);
        ml.setForeground(Color.white);
        pn.add(ml);
        //----------------------------------------------------------------------------------------------------
        JTextField mt = new JTextField();
        mt.setBounds(400,250,200,30);
        mt.setFont(font2);
        pn.add(mt);
        //-----------------------------------------------------------------------------------------------------
        JLabel gl = new JLabel("Gender:");
        gl.setBounds(200,300,100,30);
        gl.setFont(font);
        gl.setForeground(Color.white);
        pn.add(gl);
        //----------------------------------------------------------------------------------------------------
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(400,300,100,30);
        pn.add(male);
        
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(550,300,100,30);
        pn.add(female);
        
        ButtonGroup gg = new ButtonGroup();
        gg.add(male);
        gg.add(female);
        //----------------------------------------------------------------------------------------------------
        JLabel wgl = new JLabel("Weight:");
        wgl.setBounds(200,350,100,30);
        wgl.setFont(font);
        wgl.setForeground(Color.white);
        pn.add(wgl);
        //----------------------------------------------------------------------------------------------------
        JTextField wgt = new JTextField();
        wgt.setBounds(400,350,200,30);
        wgt.setFont(font2);
        pn.add(wgt);
        //-----------------------------------------------------------------------------------------------------
        JLabel hl = new JLabel("Height:");
        hl.setBounds(200,400,100,30);
        hl.setFont(font);
        hl.setForeground(Color.white);
        pn.add(hl);
        //----------------------------------------------------------------------------------------------------
        JTextField ht = new JTextField();
        ht.setBounds(400,400,200,30);
        ht.setFont(font2);
        pn.add(ht);
        //-----------------------------------------------------------------------------------------------------
        JLabel adl = new JLabel("Admission Date:");
        adl.setBounds(200,450,190,30);
        adl.setFont(font);
        adl.setForeground(Color.white);
        pn.add(adl);
        //------------------------------------------------------------------------------------------------------
        JDateChooser adc = new JDateChooser();
        adc.setBounds(400,450,130,30);
        adc.setFont(font2);
        pn.add(adc);
        //-----------------------------------------------------------------------------------------------------
        JLabel pdl = new JLabel("Previous Diseases:");
        pdl.setBounds(200,500,190,30);
        pdl.setFont(font);
        pdl.setForeground(Color.white);
        pn.add(pdl);
        //----------------------------------------------------------------------------------------------------
        JTextField pdt = new JTextField();
        pdt.setBounds(400,500,400,30);
        pdt.setFont(font2);
        pn.add(pdt);
        //-----------------------------------------------------------------------------------------------------
        JButton sb = new JButton("Submit");
        sb.setBounds(400,550,100,30);
        pn.add(sb);
        
        sb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = nmt.getText();
                String age = agt.getText();
                String mobile = mt.getText();
                String gender ="";
                String weight = wgt.getText();
                String height = ht.getText();
                Date admiDate = adc.getDate();
                String prevD = pdt.getText();
                
                if(male.isSelected()){
                	gender = "Male";
                }else if(female.isSelected()) {
                	gender = "Female";
                }else {
                	JOptionPane.showMessageDialog(null,"Please select a gender.!!");
                }
                
                String filePath = "E:/Project/HealthSync/storage/data.xlsx";
        		int rn = 4;
        		try {
        			Workbook workbook;
        			Sheet sheet;
        			
        			File file = new File(filePath);
        			
        			FileInputStream fileInput = new FileInputStream(file);
        			workbook = new XSSFWorkbook(fileInput);
        			sheet = workbook.getSheet("User Data");
        			
        			Row rowT = sheet.getRow(rn);
        			Cell cellT = rowT.getCell(13);
        			int total = (int)cellT.getNumericCellValue();
        			
        			int x = rn+1+total;
        			Row dataRow = sheet.createRow(x);
        			dataRow.createCell(4).setCellValue(name);
        			dataRow.createCell(5).setCellValue(age);
        			dataRow.createCell(6).setCellValue(mobile);
        			dataRow.createCell(7).setCellValue(gender);
        			dataRow.createCell(8).setCellValue(weight);
        			dataRow.createCell(9).setCellValue(height);
        			dataRow.createCell(10).setCellValue(admiDate.toString());
        			dataRow.createCell(11).setCellValue(prevD);
        			total++;
        			cellT.setCellValue(total);
        			
        			for(int i=rn; i<(rn+15); i++) {
        				sheet.autoSizeColumn(i);
        			}
        			
        			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        				workbook.write(fileOutputStream);
        			}
        			
        			workbook.close();
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
                
                hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0, 167, 189));
                hp.setVisible(true);
                dispose();
            }
        });
        //-----------------------------------------------------------------------------------------------------
        JButton cn = new JButton("Cancel");
        cn.setBounds(800,550,100,30);
        pn.add(cn);
        
        cn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0, 167, 189));
                hp.setVisible(true);
                dispose();
            }
        });
        //-----------------------------------------------------------------------------------------------------
        
        iml.add(pn);
	}
}
