package app.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import app.controller.GameController;
import app.util.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class GameView {

    private static final float SAVE_BUTTON_FONT_SIZE = 25f;
    private static final int SAVE_BUTTON_WIDTH = 200;
    private static final int SAVE_BUTTON_HEIGHT = 200;

    private static final float LABEL_FONT_SIZE = 20f;

    private static final int RIGHT_BORDER_VITALITY = 25;
    private static final int VITALITY_PB_WIDTH = 300;
    private static final int VITALITY_PB_HEIGHT = 20;

    private static final int LOWER_BOUND_PBAR = 0;
    private static final int HIGHER_BOUND_PBAR = 100;

    private static final int LEFT_PANEL_SPACING = 50;
    private static final int LEFT_PANEL_BORDER = 20;

    private static final int BOTTOM_BUTTON_WIDTH = 100;
    private static final int BOTTOM_BUTTON_HEIGHT = 50;
    private static final float BOTTOM_LABEL_FONT_SIZE = 16f;
    private static final int BOTTOM_PANEL_BORDER = 20;

    private static final int RIGHT_BORDER_PBAR = 20;


    private GameController gC;
    private JFrame mainFrame;
	private JPanel leftPanel;
    private MiddlePanel middlePanel;
    private JPanel bottomPanel;
    private CustomMenuButton save;
    private JLabel name;
    private JLabel mood;
    
    private JPanel roomSelector;
    private JLabel currentRoom;
    private JButton goLeftButton;
    private JButton goRightButton;
    
    
    private JLabel weather;
    private JLabel vitality;
    private JLabel energy;
    private JLabel hygiene;
    private JLabel hunger;
    
    private JProgressBar pbVitality;
    private JProgressBar pbEnergy;
    private JProgressBar pbHygiene;
    private JProgressBar pbHunger;
    
    private CustomMenuButton feedButton;
    private CustomMenuButton sleepButton;
    private CustomMenuButton washButton;
    
    private JLabel bgGame;
    
    public GameView(JFrame nFrame, GameController g){
        this.mainFrame = nFrame;
        this.gC = g;
        display();
    }

    /**
     * layout of the different items in the game
      */

    public void display(){
        mainFrame.setLayout(new BorderLayout());

        this.leftPanel = new JPanel();
        this.leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        this.middlePanel = new MiddlePanel(gC);
        this.bottomPanel = new JPanel();

        save = new CustomMenuButton("Sauvegarder", SAVE_BUTTON_FONT_SIZE);
        save.setMaximumSize(new Dimension(SAVE_BUTTON_WIDTH, SAVE_BUTTON_HEIGHT));
        save.setBackground(CustomMenuButton.getPearl());
        save.setForeground(CustomMenuButton.getColorGreen());
        save.setAlignmentX(Component.LEFT_ALIGNMENT);

        name = new CustomMenuLabel(gC.getFamiliar().getName(), LABEL_FONT_SIZE);
        name.setAlignmentX(Component.LEFT_ALIGNMENT);

        mood = new CustomMenuLabel("Humeur : " + gC.getFamiliar().getMood().getName(), LABEL_FONT_SIZE);
        mood.setAlignmentX(Component.LEFT_ALIGNMENT);

        weather = new CustomMenuLabel("Météo : " + gC.getCurrentRoom().getWeatherName(), LABEL_FONT_SIZE);
        weather.setAlignmentX(Component.LEFT_ALIGNMENT);

        // representation of the vitality of the familiar

        vitality = new CustomMenuLabel(" Vitalité : ", LABEL_FONT_SIZE);
        vitality.setBorder(new EmptyBorder(0, RIGHT_BORDER_VITALITY, 0, 0));
        vitality.setAlignmentX(Component.LEFT_ALIGNMENT);

        energy = new CustomMenuLabel(" Énergie : ", LABEL_FONT_SIZE);
        
        hygiene = new CustomMenuLabel(" Hygiène : ",LABEL_FONT_SIZE);

        hunger = new CustomMenuLabel(" Faim : ", LABEL_FONT_SIZE);

        // progressive bar

        pbEnergy = new JProgressBar(LOWER_BOUND_PBAR, HIGHER_BOUND_PBAR);
        pbEnergy.setValue(gC.getFamiliar().getEnergy());
        pbEnergy.setStringPainted(true);
        pbEnergy.setBorder(new EmptyBorder(0,0,0,RIGHT_BORDER_PBAR));

        pbHygiene = new JProgressBar(LOWER_BOUND_PBAR, HIGHER_BOUND_PBAR);
        pbHygiene.setValue(gC.getFamiliar().getHygiene());
        pbHygiene.setStringPainted(true);
        pbHygiene.setBorder(new EmptyBorder(0,0,0,RIGHT_BORDER_PBAR));

        pbHunger = new JProgressBar(LOWER_BOUND_PBAR, HIGHER_BOUND_PBAR);
        pbHunger.setValue(gC.getFamiliar().getHungriness());
        pbHunger.setStringPainted(true);

        pbVitality = new JProgressBar(LOWER_BOUND_PBAR, HIGHER_BOUND_PBAR);
        pbVitality.setValue(gC.getFamiliar().getVitality());
        pbVitality.setMaximumSize(new Dimension(VITALITY_PB_WIDTH,VITALITY_PB_HEIGHT));
        pbVitality.setSize(new Dimension(10,10));
        pbVitality.setStringPainted(true);

        // feedButton
        
        feedButton = new CustomMenuButton("Nourrir", BOTTOM_LABEL_FONT_SIZE);
        feedButton.setPreferredSize(new Dimension(BOTTOM_BUTTON_WIDTH, BOTTOM_BUTTON_HEIGHT));
        feedButton.setBackground(CustomMenuButton.getPearl());
        feedButton.setForeground(CustomMenuButton.getColorGreen());
        feedButton.setToolTipText(gC.getFamiliar().getPortions() + " portions de " + gC.getFamiliar().getFood() + " restantes ");

        // sleepButton

        sleepButton = new CustomMenuButton("Dormir", BOTTOM_LABEL_FONT_SIZE);
        sleepButton.setPreferredSize(new Dimension(BOTTOM_BUTTON_WIDTH, BOTTOM_BUTTON_HEIGHT));
        sleepButton.setBackground(CustomMenuButton.getPearl());
        sleepButton.setForeground(CustomMenuButton.getColorGreen());

        // washButton

        washButton = new CustomMenuButton("Laver", BOTTOM_LABEL_FONT_SIZE);
        washButton.setPreferredSize(new Dimension(BOTTOM_BUTTON_WIDTH, BOTTOM_BUTTON_HEIGHT));
        washButton.setBackground(CustomMenuButton.getPearl());
        washButton.setForeground(CustomMenuButton.getColorGreen());

        save.addActionListener(gC);
        washButton.addActionListener(gC);
        sleepButton.addActionListener(gC);
        feedButton.addActionListener(gC);

        roomSelector = new JPanel();
        roomSelector.setLayout(new BoxLayout(roomSelector, BoxLayout.LINE_AXIS));
        goLeftButton = new CustomMenuButton(IconUtil.createSizedImageIcon("../assets/images/left.png",30,30));
        goRightButton = new CustomMenuButton(IconUtil.createSizedImageIcon("../assets/images/right.png",30,30));
        
        goLeftButton.setPreferredSize(new Dimension(20,30));
        goRightButton.setPreferredSize(new Dimension(20,30));

        goLeftButton.setMaximumSize(new Dimension(20,30));
        goRightButton.setMaximumSize(new Dimension(20,30));
        
        goLeftButton.setBorderPainted(false);
        goRightButton.setBorderPainted(false);

        goLeftButton.addActionListener(gC);
        goRightButton.addActionListener(gC);
        
        currentRoom = new CustomMenuLabel("Pièce : " + gC.getCurrentRoom().getName(), LABEL_FONT_SIZE);
        currentRoom.setBorder(new EmptyBorder(0,10,0,10));

        roomSelector.add(goLeftButton);
        roomSelector.add(currentRoom);
        roomSelector.add(goRightButton);
        roomSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        bgGame = new JLabel(createImageIcon("../assets/images/cuisine/cuisine_cloudy.png"));

        /**
         * addition of the different items on the left of the screen
         */

        leftPanel.setBorder(new EmptyBorder(0, LEFT_PANEL_BORDER, 0, 0));     
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        leftPanel.add(save);
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        leftPanel.add(name);
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        leftPanel.add(mood);
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        leftPanel.add(roomSelector);
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        leftPanel.add(weather);
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        leftPanel.add(vitality);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(pbVitality);
        leftPanel.add(Box.createVerticalStrut(LEFT_PANEL_SPACING));
        

        /**
         * addition of the different items on the bottom of the screen
         */
     
        bottomPanel.add(sleepButton);
        bottomPanel.add(energy);
        bottomPanel.add(pbEnergy);
        bottomPanel.add(washButton);
        bottomPanel.add(hygiene);
        bottomPanel.add(pbHygiene);
        bottomPanel.add(feedButton);
        bottomPanel.add(hunger);
        bottomPanel.add(pbHunger);

        bottomPanel.setBorder(new EmptyBorder(0,0,BOTTOM_PANEL_BORDER,0));
        mainFrame.add(leftPanel, BorderLayout.LINE_START);
        mainFrame.add(middlePanel.getPane(), BorderLayout.CENTER);
        mainFrame.add(bottomPanel, BorderLayout.PAGE_END);

        mainFrame.setVisible(true);
        
    }

    /**
     * @return mood JLabel
     */
    public JLabel getMoodLabel() {
        return mood;
    }

    /**
     * @return save JButton
     */

    public JButton getSave() {
        return this.save;
    }

    /**
     * @return SleepButton JButton
     */
    
    public JButton getSleepButton() {
    	return sleepButton; 
    }

    /**
     * @return FeedButton JButton
     */
    
    public JButton getFeedButton() {
    	return feedButton; 
    }

    /**
     * @return WashButton JButton
     */
    
    public JButton getWashButton() {
    	return washButton; 
    }

    /**
     * @return GoLeftButton JButton 
     */
    
    public JButton getGoLeftButton() {
    	return goLeftButton; 
    }

    /**
     * @return GoRightButton JButton
     */
    
    public JButton getGoRightButton() {
    	return goRightButton;
    }

    /**
     * @return CurrentRoom JLabel
     */
    
    public JLabel getCurrentRoomLabel() {
    	return currentRoom;
    }

    /**
     * @return pbEnergy JProgressBar
     */
    
    public JProgressBar getPbEnergy() {
    	return pbEnergy;
    }

    /**
     * @return pbHunger JProgressBar
     */
    
    public JProgressBar getPbHunger() {
    	return pbHunger;
    }

    /**
     * @return pbVitality JProgressBar
     */
    
    public JProgressBar getPbVitality() {
    	return pbVitality;
    }
    
    /**
     * @return pbHygiene JProgressBar
     */

    public JProgressBar getPbhygiene() {
    	return pbHygiene;
    }


    /** 
     * displays a message to say that the backup was successful
     */

    public void successfulSave() {
        JOptionPane.showMessageDialog(
            mainFrame, 
    	    "Votre progression à bien été sauvegardé", "Succès", JOptionPane.INFORMATION_MESSAGE
        );
    }
    

    /**
     * display of error messages
     */

    public void errorSave(String error) {
        JOptionPane.showMessageDialog(
            null, 
            "Erreur lors de la sauvegarde : " + error);
    }
    
    public void errorFeed(String error) {
        JOptionPane.showMessageDialog(
            null, 
            "Le familier ne peut pas être nourri : " + error);
    }
    
    public void errorWash(String error) {
        JOptionPane.showMessageDialog(
            null, 
            "Le familier ne peut pas être lavé : " + error);
    }
    
    public void errorSleep(String error) {
        JOptionPane.showMessageDialog(
            null, 
            "Le familier ne peut pas dormir : " + error);
    }

    /**
     * enable of the various buttons
     */
    
    public void enableAll() {
    	sleepButton.setEnabled(true);
    	feedButton.setEnabled(true);
    	washButton.setEnabled(true);
    	goLeftButton.setEnabled(true);
    	goRightButton.setEnabled(true);
    }

    /**
     * disable of thne various buttons
     */
    
    public void disableAll() {
    	sleepButton.setEnabled(false);
    	feedButton.setEnabled(false);
    	washButton.setEnabled(false);
    	goLeftButton.setEnabled(false);
    	goRightButton.setEnabled(false);
    }

    /**
     * return the weather
     */

    public JLabel getCurrentWeatherLabel() {
        return this.weather;
    }
    
	private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = NewGameMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}