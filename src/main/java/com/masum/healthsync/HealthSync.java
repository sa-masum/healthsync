package com.masum.healthsync;

import java.awt.Color;
import javax.swing.JFrame;

public class HealthSync {

    public static void main(String[] args) {
        JFrame hm = new home();
        hm.getContentPane().setBackground(new Color(50, 99, 159));    // color- 40, 48, 99 --0, 105, 167--0, 167, 189
        hm.setVisible(true);
    }
}