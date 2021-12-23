package app.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import app.controller.GameController;

import java.awt.BorderLayout;
import java.awt.Dimension;
public class GameView {
    

    private GameController gC;
    private JFrame mainFrame;
	private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private CustomMenuButton save;
    private JLabel name;
    private JLabel mood;
    private JLabel room;
    private JLabel weather;
    private JLabel vitality;
    private JLabel energy;
    private JLabel hygiene;
    private JLabel hunger;
    JProgressBar pbVitality;
    JProgressBar pbEnergy;
    JProgressBar pbHygiene;
    JProgressBar pbHunger;

    public GameView(JFrame nFrame, GameController g){
        this.mainFrame = nFrame;
        this.gC = g;
        display();
    }

    public void display(){
        mainFrame.setLayout(new BorderLayout());

        this.leftPanel = new JPanel();
        this.leftPanel.setLayout(new BoxLayout(leftPanel, 1));
        this.rightPanel = new JPanel();
        this.bottomPanel = new JPanel();

        save = new CustomMenuButton("Sauvegarder", 25f);
        save.setMaximumSize(new Dimension(200, 50));
        name = new CustomMenuLabel(gC.getFamiliar().getName(), 20f);
        mood = new CustomMenuLabel("Humeur : " + gC.getFamiliar().getMood(), 20f);
        room = new CustomMenuLabel(" Piece : " + gC.getCurrentRoom().getName(), 20f);
        weather = new CustomMenuLabel("Meteo : " + gC.getCurrentRoom().getWeatherName(), 20f);
        vitality = new CustomMenuLabel(" Vitalite : ", 20f);
        vitality.setBorder(new EmptyBorder(0, 25, 0, 0));
        energy = new CustomMenuLabel("Energie : ", 20f);
        hygiene = new CustomMenuLabel(" Hygiene : ",20f);
        hunger = new CustomMenuLabel(" Faim : ", 20f);

        pbEnergy = new JProgressBar(0, 100);
        pbEnergy.setValue(gC.getFamiliar().getEnergy());
        pbEnergy.setStringPainted(true);

        pbHygiene = new JProgressBar(0, 100);
        pbHygiene.setValue(gC.getFamiliar().getHygiene());
        pbHygiene.setStringPainted(true);

        pbHunger = new JProgressBar(0, 100);
        pbHunger.setValue(gC.getFamiliar().getHungriness());
        pbHunger.setStringPainted(true);

        pbVitality = new JProgressBar(0, 100);
        pbVitality.setValue(gC.getFamiliar().getVitality());
        pbVitality.setMaximumSize(new Dimension(300,20));
        pbVitality.setSize(new Dimension(10,10));
        pbVitality.setStringPainted(true);
        
        leftPanel.setBorder(new EmptyBorder(0, 20, 0, 0));        
        leftPanel.add(Box.createVerticalStrut(50));
        leftPanel.add(save);
        leftPanel.add(Box.createVerticalStrut(50));
        leftPanel.add(name);
        leftPanel.add(Box.createVerticalStrut(50));
        leftPanel.add(mood);
        leftPanel.add(Box.createVerticalStrut(50));
        leftPanel.add(room);
        leftPanel.add(Box.createVerticalStrut(50));
        leftPanel.add(weather);
        leftPanel.add(Box.createVerticalStrut(50));
        leftPanel.add(vitality);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(pbVitality);
        leftPanel.add(Box.createVerticalStrut(50));
        bottomPanel.add(energy);
        bottomPanel.add(pbEnergy);
        bottomPanel.add(hygiene);
        bottomPanel.add(pbHygiene);
        bottomPanel.add(hunger);
        bottomPanel.add(pbHunger);

        mainFrame.add(leftPanel, BorderLayout.LINE_START);
        mainFrame.add(rightPanel, BorderLayout.CENTER);
        mainFrame.add(bottomPanel, BorderLayout.PAGE_END);

        mainFrame.setVisible(true);
    }
}
