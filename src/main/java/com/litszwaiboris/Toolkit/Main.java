package com.litszwaiboris.Toolkit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Boris' Toolkit");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton launchpad = new JButton("Delete Launchpad Application");
        launchpad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter launchpad application name", null);
                if (name != null) {try {Methods.del_launchpad_apps(name);} catch (IOException ex) {throw new RuntimeException(ex);}}}
        });

        JButton reset_launchpad = new JButton("Reset Launchpad Layout");
        reset_launchpad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {Methods.reset_launchpad();} catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });
        JButton desktop_icons = new JButton("Enable/Disable Desktop Icons");
        desktop_icons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {Methods.desktop_icons();} catch (InterruptedException ex) {throw new RuntimeException(ex);} catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(launchpad);
        panel.add(reset_launchpad);
        panel.add(desktop_icons);
        panel.add(exit);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Methods.MacCheck();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}