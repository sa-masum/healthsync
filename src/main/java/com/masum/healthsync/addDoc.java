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

public class addDoc extends JFrame {
	public addDoc() {
		setSize(1535,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------------------------------------------------------
        ImageIcon imi = new ImageIcon("E:/Project/HealthSync/storage/background2.jpg");
        Image imr = imi.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imf = new ImageIcon(imr);
        JLabel iml = new JLabel(imf);
        getContentPane().add(iml);
        //-------------------------------------------------------------------------------------------
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
        JLabel pl = new JLabel("New Doctor");
        pl.setBounds(470, 30,200, 40);
        pl.setFont(new Font("Arial",Font.BOLD,30));
        pl.setForeground(Color.white);
        pn.add(pl);
        //-------------------------------------------------------------------------------------------------
        JLabel nml = new JLabel("Name:");
        nml.setBounds(200,120,100,30);
        Font font = new Font(nml.getFont().getName(),Font.BOLD,20);
        nml.setFont(font);
        nml.setForeground(Color.white);
        pn.add(nml);
        //----------------------------------------------------------------------------------------------------
        JTextField nmt = new JTextField();
        nmt.setBounds(400,120,400,30);
        Font font2 = new Font(nmt.getFont().getName(),Font.BOLD,17);
        nmt.setFont(font2);
        pn.add(nmt);
        //-----------------------------------------------------------------------------------------------------
        JLabel ml = new JLabel("Mobile:");
        ml.setBounds(200,190,100,30);
        ml.setFont(font);
        ml.setForeground(Color.white);
        pn.add(ml);
        //----------------------------------------------------------------------------------------------------
        JTextField mt = new JTextField();
        mt.setBounds(400,190,200,30);
        mt.setFont(font2);
        pn.add(mt);
        //-----------------------------------------------------------------------------------------------------
        JLabel gl = new JLabel("Gender:");
        gl.setBounds(200,260,100,30);
        gl.setFont(font);
        gl.setForeground(Color.white);
        pn.add(gl);
        //----------------------------------------------------------------------------------------------------
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(400,260,100,30);
        pn.add(male);
        
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(550,260,100,30);
        pn.add(female);
        
        ButtonGroup gg = new ButtonGroup();
        gg.add(male);
        gg.add(female);
        //----------------------------------------------------------------------------------------------------
        JLabel dl = new JLabel("Department:");
        dl.setBounds(200,330,150,30);
        dl.setFont(font);
        dl.setForeground(Color.white);
        pn.add(dl);
        //----------------------------------------------------------------------------------------------------
        String[] dpList = {"Accident & Emergency","Anaesthesia","Cardiology", "Dental & Maxillofacial Surgery", "Dermatology & Venereology","Diabetology & Endocrinology", "ENT","Gastroenterology & Hepatology", "Neurology","Obstetrics and Gynaecology","Orthopaedics","Urology"}; 
        JComboBox<String> list = new JComboBox<>(dpList);
        list.setBounds(400,330,280,30);
        list.setFont(font2);
        pn.add(list);
        //-----------------------------------------------------------------------------------------------------
        JLabel dgl = new JLabel("Degrees:");
        dgl.setBounds(200,400,150,30);
        dgl.setFont(font);
        dgl.setForeground(Color.white);
        pn.add(dgl);
        //----------------------------------------------------------------------------------------------------
        JTextField dgt = new JTextField();
        dgt.setBounds(400,400,400,30);
        dgt.setFont(font2);
        pn.add(dgt);
        //-----------------------------------------------------------------------------------------------------
        JButton sb = new JButton("Submit");
        sb.setBounds(400,470,100,30);
        pn.add(sb);
        
        sb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = nmt.getText();
                String mobile = mt.getText();
                String gender ="";
                String department = (String) list.getSelectedItem();
                String degrees = dgt.getText();
                
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
        			Cell cellT = rowT.getCell(28);
        			int total = (int)cellT.getNumericCellValue();
        			
        			int x = rn+1+total;
        			Row dataRow = sheet.createRow(x);
        			dataRow.createCell(22).setCellValue(name);
        			dataRow.createCell(23).setCellValue(mobile);
        			dataRow.createCell(24).setCellValue(gender);
        			dataRow.createCell(25).setCellValue(department);
        			dataRow.createCell(26).setCellValue(degrees);
        			total++;
        			cellT.setCellValue(total);
        			
        			for(int i=rn; i<30; i++) {
        				sheet.autoSizeColumn(i);
        			}
        			
        			try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        				workbook.write(fileOutputStream);
        			}
        			
        			workbook.close();
        			
        		}catch(IOException e1) {
        			e1.printStackTrace();
        		}
                
                JFrame dc = new srcdoc();
                dc.getContentPane().setBackground(new Color(40,102,99));
                dc.setVisible(true);
                dispose();
            }
        });
        //-----------------------------------------------------------------------------------------------------
        JButton cn = new JButton("Cancel");
        cn.setBounds(600,470,80,30);
        Font fontl = new Font(cn.getFont().getName(),Font.BOLD,20);
        cn.setFont(fontl);
        cn.setForeground(new Color(40,48,99));
        cn.setBackground(Color.WHITE);
        cn.setFocusPainted(false);
        Border br = new EmptyBorder(0,0,0,0);
        cn.setBorder(br);
        pn.add(cn);
        cn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	srcdoc doc = new srcdoc();
                doc.getContentPane().setBackground(new Color(40,102,99));
                doc.setVisible(true);
                dispose();;
            }
        });
        //------------------------------------------------------------------------------------------------
        
        
        iml.add(pn);
	}
}
