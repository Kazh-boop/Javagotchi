package app.view;


import javax.swing.*;
import java.awt.GridBagLayout;
import app.controller.GameController;

import java.awt.GridLayout;
import java.awt.BorderLayout;


public class GameView {
    
    private GameController gC;
    private JFrame mainFrame;
	private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JButton save;
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
        this.leftPanel.setLayout(new GridLayout(0,2));
        this.rightPanel = new JPanel();
        this.bottomPanel = new JPanel();

        save = new JButton("Sauvegarder");
        name = new JLabel(gC.getFamiliar().getName());
        mood = new JLabel("Humeur : ");
        room = new JLabel(" Piece : " + gC.getCurrentRoom().getName());
        weather = new JLabel("Meteo : " + gC.getCurrentRoom().getWeatherName());
        vitality = new JLabel(" Vitalite : ");
        energy = new JLabel("Energie : ");
        hygiene = new JLabel(" Hygiene : ");
        hunger = new JLabel(" Faim : ");

        pbVitality = new JProgressBar();
        pbVitality.setValue(gC.getFamiliar().getVitality());
        pbVitality.setStringPainted(true);

        pbEnergy = new JProgressBar();
        pbEnergy.setValue(gC.getFamiliar().getEnergy());
        pbEnergy.setStringPainted(true);

        pbHygiene = new JProgressBar();
        pbHygiene.setValue(gC.getFamiliar().getHygiene());
        pbHygiene.setStringPainted(true);

        pbHunger = new JProgressBar();
        pbHunger.setValue(gC.getFamiliar().getHungriness());
        pbHunger.setStringPainted(true);

        leftPanel.add(save);
        leftPanel.add(name);
        leftPanel.add(mood);
        leftPanel.add(room);
        leftPanel.add(weather);
        leftPanel.add(vitality);
        leftPanel.add(pbVitality);
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
