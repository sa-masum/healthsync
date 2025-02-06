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

public class docs extends JFrame{
	public docs(Vector<Integer> itr) {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------------------
        int x = 0, y = 0, width = 1535, height = 200;
		String filePath = "E:/Project/HealthSync/storage/data.xlsx";
		for(Integer it: itr){
			JPanel pn = new JPanel(){
				@Override
				protected void paintComponent(Graphics gp){
				    Graphics2D gp2d = (Graphics2D) gp.create();
				    gp2d.setColor(new Color(40,48,99));
				    gp2d.fill(new Rectangle2D.Double(0,0,getWidth(),getHeight()));
				    gp2d.setColor(Color.blue);
				};
			};
			
			pn.setBounds(x, y, width, height);
			pn.setLayout(null);
			
			try {
				Workbook workbook;
				Sheet sheet;
				
				String[] values = new String[5];
				
				File file = new File(filePath);
				
				FileInputStream fileIn = new FileInputStream(file);
				workbook = new XSSFWorkbook(fileIn);
				sheet = workbook.getSheet("User Data");
	        
				Row row = sheet.getRow(it);
				for(int j=22; j<27; j++) {
					Cell cell = row.getCell(j);
					values[j-22] = cell.getStringCellValue();
				}
				
				JLabel nml = new JLabel("Name:");
		        nml.setBounds(50,50,100,30);
		        Font font = new Font(nml.getFont().getName(),Font.BOLD,20);
		        nml.setFont(font);
		        nml.setForeground(Color.white);
		        pn.add(nml);
		        //----------------------------------------------------------------------------------------------------
		        JLabel nmt = new JLabel(values[0]);
		        nmt.setBounds(150,50,400,30);
		        Font font2 = new Font(nmt.getFont().getName(),Font.BOLD,20);
		        nmt.setFont(font2);
		        nmt.setForeground(Color.white);
		        pn.add(nmt);
		        //-----------------------------------------------------------------------------------------------------
		        JLabel gl = new JLabel("Gender:");
		        gl.setBounds(580,50,100,30);
		        gl.setFont(font);
		        gl.setForeground(Color.white);
		        pn.add(gl);
		        //----------------------------------------------------------------------------------------------------
		        JLabel gt = new JLabel(values[2]);
		        gt.setBounds(690,50,100,30);
		        gt.setFont(font2);
		        gt.setForeground(Color.white);
		        pn.add(gt);
		        //-----------------------------------------------------------------------------------------------------
		        JLabel ml = new JLabel("Mobile:");
		        ml.setBounds(810,50,100,30);
		        ml.setFont(font);
		        ml.setForeground(Color.white);
		        pn.add(ml);
		        //----------------------------------------------------------------------------------------------------
		        JLabel mt = new JLabel(values[1]);
		        mt.setBounds(920,50,200,30);
		        mt.setFont(font2);
		        mt.setForeground(Color.white);
		        pn.add(mt);
		        //-----------------------------------------------------------------------------------------------------
		        JLabel dpl = new JLabel("Department:");
		        dpl.setBounds(50,90,150,30);
		        dpl.setFont(font);
		        dpl.setForeground(Color.white);
		        pn.add(dpl);
		        //----------------------------------------------------------------------------------------------------
		        JLabel dpt = new JLabel(values[3]);
		        dpt.setBounds(210,90,150,30);
		        dpt.setFont(font2);
		        dpt.setForeground(Color.white);
		        pn.add(dpt);
		        //-----------------------------------------------------------------------------------------------------
		        JLabel dgl = new JLabel("Degrees:");
		        dgl.setBounds(380,90,100,30);
		        dgl.setFont(font);
		        dgl.setForeground(Color.white);
		        pn.add(dgl);
		        //----------------------------------------------------------------------------------------------------
		        JLabel dgt = new JLabel(values[4]);
		        dgt.setBounds(490,90,150,30);
		        dgt.setFont(font2);
		        dgt.setForeground(Color.white);
		        pn.add(dgt);
		        //-----------------------------------------------------------------------------------------------------
				
		        getContentPane().add(pn);
		        
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			y = y + 220;
			
		}
		
		
	}
}
