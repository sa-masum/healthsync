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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class change extends JFrame {
	public change() {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------
        
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
        //-----------------------------------------------------------------------------------------------------
        JLabel hd = new JLabel("Change User Id & Password:");
        Font fonth = new Font(hd.getFont().getName(),Font.BOLD,25);
        hd.setBounds(400,90,380,30);
        hd.setFont(fonth);
        hd.setForeground(Color.red);
        pn.add(hd);
        //-----------------------------------------------------------------------------------------------------
        JLabel nul = new JLabel("New User Id:");
        Font font = new Font(nul.getFont().getName(),Font.BOLD,20);
        nul.setBounds(200,180,190,30);
        nul.setFont(font);
        nul.setForeground(Color.white);
        pn.add(nul);
        //----------------------------------------------------------------------------------------------------
        JTextField nut = new JTextField();
        nut.setBounds(400,180,400,30);
        nut.setFont(font);
        pn.add(nut);
        //-----------------------------------------------------------------------------------------
        JLabel npl = new JLabel("New Password:");
        npl.setBounds(200,250,190,30);
        npl.setFont(font);
        npl.setForeground(Color.white);
        pn.add(npl);
        //----------------------------------------------------------------------------------------------------
        JTextField npt = new JTextField();
        npt.setBounds(400,250,400,30);
        npt.setFont(font);
        pn.add(npt);
        //------------------------------------------------------------------------------------------------
        JButton sb = new JButton("Change");
        sb.setBounds(400,320,100,30);
        pn.add(sb);
        
        sb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String ui = nut.getText();
                String pw = npt.getText();
                
                String filePath = "E:/Project/HealthSync/storage/data.xlsx";
                int rn = 4;
        		try {
        			Workbook workbook;
        			Sheet sheet;
        			Row headerRow;
        			
        			File file = new File(filePath);
        			
        			FileInputStream fileIn = new FileInputStream(file);
        			workbook = new XSSFWorkbook(fileIn);
    				sheet = workbook.getSheet("User Data");
    				headerRow = sheet.getRow(4);
        			headerRow.createCell(17).setCellValue(ui);
        			headerRow.createCell(19).setCellValue(pw);
        			
        			for(int i=rn; i<(rn+9); i++) {
        				sheet.autoSizeColumn(i);
        			}
        			
        			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        				workbook.write(fileOutputStream);
        			}
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
                
                hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0,105,167));
                hp.setVisible(true);
                dispose();
            }
        });
        //-----------------------------------------------------------------------------------------------------
        JButton cn = new JButton("Cancel");
        cn.setBounds(800,320,100,30);
        pn.add(cn);
        
        cn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hospital hp = new hospital();
                hp.getContentPane().setBackground(new Color(0, 167, 189));
                hp.setVisible(true);
                dispose();
            }
        });
        
        getContentPane().setLayout(null);
        getContentPane().add(pn);
	}

}
