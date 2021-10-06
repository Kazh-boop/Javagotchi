package app.view;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Image;

import app.controller.*;

public class MainMenu {

    MainMenuController m;
    MainFrame f;
    JPanel j;
    JPanel r;
    JButton b;
    JProgressBar p;
    JTextField t;

    public MainMenu() {

        this.m = new MainMenuController(this);
        this.f = new MainFrame();
        this.j = new JPanel();
        r = new JPanel();

        Image right = new ImageIcon("app/image/right.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        this.b = new JButton(" ", new ImageIcon(right));
        b.setIcon(new ImageIcon("app/image/bg.png"));
        b.setBorderPainted(false);
        b.setContentAreaFilled(false); 
        b.setFocusPainted(false); 
        b.setOpaque(false);

        b.setPreferredSize(new Dimension(150,100));
        this.b.addActionListener(this.m);
        t = new JTextField();
    
        p = new JProgressBar(0, 100);
        p.setValue(0);
        p.setStringPainted(true);

        r.add(p);
        r.setOpaque(false);
        j.add(b);
        j.setOpaque(false);
        f.add(j);
        f.add(r);

    
        f.setVisible(true); //if false then frame will be invisible
        f.setResizable(false);

        for(int i = 0; i <= p.getMaximum(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.setValue(i);
            System.out.println(p.getValue());
        }

        /*
        f.getContentPane().removeAll();
        f.repaint();
        */
    }

    public JButton getB1(){
        return b;
    }
    
    public JFrame getMainFrame(){
        return this.f;
    }
}