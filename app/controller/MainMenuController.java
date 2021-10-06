package app.controller;

import app.view.*;
import java.awt.event.*;

public class MainMenuController implements ActionListener {

    MainMenu m;

    public MainMenuController(MainMenu m) {
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.m.getB1()) {
            System.out.println("end");
            System.exit(0);
        }
    }


}