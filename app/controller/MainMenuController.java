package app.controller;

import app.view.*;
import java.awt.event.*;

public class MainMenuController implements ActionListener {

    MainMenu main;

    public MainMenuController(MainMenu m) {
        this.main = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.m.getB1()) {
            System.out.println("end");
        if(e.getSource() == this.main.getNouvellePartie()) {
        	new NouvellePartieMenu();
            
        }else if(e.getSource() == this.main.getSauvegardes()) {
        	new SauvegardesMenu();
            
        }else if(e.getSource() == this.main.getQuitter()) {
            System.exit(0);
        }
    }
}