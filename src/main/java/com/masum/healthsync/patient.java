package com.masum.healthsync;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

import com.toedter.calendar.JDateChooser;

public class patient extends JFrame {
	public patient(int loc) {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------
        ImageIcon imi = new ImageIcon("E:/Project/HealthSync/storage/background2.jpg");
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
                gp2d.setColor(Color.white);
                gp2d.dispose();
            };
        };
        pn.setBounds(200,100,1150,620);
        pn.setLayout(null);
        //------------------------------------------------------------------------------------------------
        ImageIcon ic = new ImageIcon("E:/Project/HealthSync/storage/malePatient.png");
        JLabel pl = new JLabel();
        pl.setIcon(ic);
        int imw = pl.getPreferredSize().width;
        int imh = pl.getPreferredSize().height;
        pl.setBounds(100,105,imw,imh);
        pn.add(pl);
        //-------------------------------------------------------------------------------------------------
        JLabel ph = new JLabel("Patient Information");
        ph.setBounds(400,45,300,40);
        ph.setFont(new Font("Arial",Font.BOLD,30));
        ph.setForeground(Color.white);
        pn.add(ph);
        //-------------------------------------------------------------------------------------------------
        String filePath = "E:/Project/HealthSync/storage/data.xlsx";
        int rn = 4;
		try {
			Workbook workbook;
			Sheet sheet;
			Row pRow;
			
			File file = new File(filePath);
			
			FileInputStream fileIn = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileIn);
			sheet = workbook.getSheet("User Data");
			
			String[] values = new String[8];
			
			pRow = sheet.getRow(loc);
			
			for(int col=4; col<12; col++) {
				Cell cell = pRow.getCell(col);
				values[col-4] = cell.getStringCellValue();
			}
			
			workbook.close();
			
			JLabel nml = new JLabel("Name:");
	        nml.setBounds(400,105,100,30);
	        Font font = new Font(nml.getFont().getName(),Font.BOLD,20);
	        nml.setFont(font);
	        nml.setForeground(Color.white);
	        pn.add(nml);
	        //----------------------------------------------------------------------------------------------------
	        JLabel nmt = new JLabel(values[0]);
	        nmt.setBounds(500,105,400,30);
	        Font font2 = new Font(nmt.getFont().getName(),Font.BOLD,20);
	        nmt.setFont(font2);
	        nmt.setForeground(Color.white);
	        pn.add(nmt);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel agl = new JLabel("Age:");
	        agl.setBounds(400,155,100,30);
	        agl.setFont(font);
	        agl.setForeground(Color.white);
	        pn.add(agl);
	        //----------------------------------------------------------------------------------------------------
	        JLabel agt = new JLabel(values[1]);
	        agt.setBounds(500,155,200,30);
	        agt.setFont(font2);
	        agt.setForeground(Color.white);
	        pn.add(agt);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel ml = new JLabel("Mobile:");
	        ml.setBounds(400,205,100,30);
	        ml.setFont(font);
	        ml.setForeground(Color.white);
	        pn.add(ml);
	        //----------------------------------------------------------------------------------------------------
	        JLabel mt = new JLabel(values[2]);
	        mt.setBounds(500,205,200,30);
	        mt.setFont(font2);
	        mt.setForeground(Color.white);
	        pn.add(mt);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel gl = new JLabel("Gender:");
	        gl.setBounds(400,255,100,30);
	        gl.setFont(font);
	        gl.setForeground(Color.white);
	        pn.add(gl);
	        //----------------------------------------------------------------------------------------------------
	        JLabel gt = new JLabel(values[3]);
	        gt.setBounds(500,255,200,30);
	        gt.setFont(font2);
	        gt.setForeground(Color.white);
	        pn.add(gt);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel wgl = new JLabel("Weight:");
	        wgl.setBounds(400,305,100,30);
	        wgl.setFont(font);
	        wgl.setForeground(Color.white);
	        pn.add(wgl);
	        //----------------------------------------------------------------------------------------------------
	        JLabel wgt = new JLabel(values[4]);
	        wgt.setBounds(500,305,200,30);
	        wgt.setFont(font2);
	        wgt.setForeground(Color.white);
	        pn.add(wgt);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel hl = new JLabel("Height:");
	        hl.setBounds(400,355,100,30);
	        hl.setFont(font);
	        hl.setForeground(Color.white);
	        pn.add(hl);
	        //----------------------------------------------------------------------------------------------------
	        JLabel ht = new JLabel(values[5]);
	        ht.setBounds(500,355,200,30);
	        ht.setFont(font2);
	        ht.setForeground(Color.white);
	        pn.add(ht);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel adl = new JLabel("Admission Date:");
	        adl.setBounds(400,405,190,30);
	        adl.setFont(font);
	        adl.setForeground(Color.white);
	        pn.add(adl);
	        //------------------------------------------------------------------------------------------------------
	        JLabel adc = new JLabel(values[6]);
	        adc.setBounds(570,405,300,30);
	        adc.setFont(font2);
	        adc.setForeground(Color.white);
	        pn.add(adc);
	        //-----------------------------------------------------------------------------------------------------
	        JLabel pdl = new JLabel("Previous Diseases:");
	        pdl.setBounds(400,455,190,30);
	        pdl.setFont(font);
	        pdl.setForeground(Color.white);
	        pn.add(pdl);
	        //----------------------------------------------------------------------------------------------------
	        JLabel pdt = new JLabel(values[7]);
	        pdt.setBounds(600,455,400,30);
	        pdt.setFont(font2);
	        pdt.setForeground(Color.white);
	        pn.add(pdt);
	        //-----------------------------------------------------------------------------------------------------
	        
	        
			for(int i=rn; i<(rn+9); i++) {
				sheet.autoSizeColumn(i);
			}
			
			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				workbook.write(fileOutputStream);
			}
			
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		//-----------------------------------------------------------------------------------------------------
		JButton bc = new JButton("Back");
        bc.setBounds(150,515,90,30);
        pn.add(bc);
        
        bc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                search src = new search();
                src.getContentPane().setBackground(new Color(40,102,99));
                src.setVisible(true);
                dispose();
            }
        });
       //-----------------------------------------------------------------------------------------------------
        JButton del = new JButton("Delete");
        del.setBounds(900,515,110,30);
        pn.add(del);
        
        del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
            	String filePath = "E:/Project/HealthSync/storage/data.xlsx";
        		int rn = 4, total;
        		try {
        			Workbook workbook;
        			Sheet sheet;
        			
        			File file = new File(filePath);
        			
        			FileInputStream fileInput = new FileInputStream(file);
        			workbook = new XSSFWorkbook(fileInput);
        			sheet = workbook.getSheet("User Data");
        			
        			Row rowT = sheet.getRow(4);
        			Cell cellT = rowT.getCell(13);
        			total = (int)cellT.getNumericCellValue();
        			
        			int i, j;
                	for(i=loc; i<(total+4); i++) {
                		for(j=4; j<12; j++) {
                			Row dataRow = sheet.getRow(i);
                			Row nextRow = sheet.getRow(i+1);
                			dataRow.getCell(j).setCellValue(nextRow.getCell(j).getStringCellValue());
                		}
                	}
                	
                	for(j=4; j<12; j++) {
                		Row dataRow = sheet.getRow(i);
                		dataRow.getCell(j).setCellValue("");
                	}
                	
                	JOptionPane.showMessageDialog(null,"Done.!!");
                	
                	total--;
                	cellT.setCellValue(total);
        			
        			for(i=rn; i<(rn+15); i++) {
        				sheet.autoSizeColumn(i);
        			}
        			
        			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        				workbook.write(fileOutputStream);
        			}
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
            	
                search src = new search();
                src.getContentPane().setBackground(new Color(40,102,99));
                src.setVisible(true);
                dispose();
            }
        });
        
        
        
        iml.add(pn);
	}
}
