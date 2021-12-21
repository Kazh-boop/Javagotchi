package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import app.view.*;
import app.model.*;

public class MenuController implements ActionListener {
	
	private MainFrame mainFrame;
	private MainMenu mainMenu;
	private NewGameMenu newGameMenu;
	private SavesMenu savesMenu;
	
	private final int CURSOR_MAX = 3;
	private final int CURSOR_MIN = 0;
	private int cursorImage = 0;
	private final String[] familiarType = {"Chat", "Chien", "Robot", "Lapin"};
	private final String[] familiarTypeURL = {"../image/cat.png", "../image/dog.png", "../image/robot.png", "../image/rabbit.png"};
	
	private static Pattern invalidPattern;
    private static Matcher invalidMatcher;
	private static Pattern emptyPattern;
    private static Matcher emptyMatcher;
	
    /* MenuController()
	 * 
	 * Initialise les 3 pages de menu ainsi que la mainFrame,
	 * Affiche le menu principal
	 */
	public MenuController() {
		this.mainFrame = new MainFrame();
		this.mainMenu = new MainMenu(mainFrame);
		this.newGameMenu = new NewGameMenu(mainFrame);
		this.savesMenu = new SavesMenu(mainFrame);
		
		mainMenuDisplay();
	}
	
	/* actionPerformed()
	 * 
	 * Reception des actions lors de clics sur des boutons,
	 * Comparaison de la source de l'action et des différents boutons,
	 * Execution de l'action correspondante
	 */
	@Override
    public void actionPerformed(ActionEvent e) {
		
		// JButton form MainMenu
        if(e.getSource() == this.mainMenu.getNewGame()) {
        	newGameMenuDisplay();
        	
        }else if(e.getSource() == this.mainMenu.getSaves()) {
            savesMenuDisplay();
        	
        }else if(e.getSource() == this.mainMenu.getQuit()) {
        	System.exit(1);
        
        // JButton from newGameMenu
        }else if(e.getSource() == this.newGameMenu.getBackMenu()) {
			mainMenuDisplay();
			
        }else if(e.getSource() == this.newGameMenu.getLeftFamiliarType()) {
        	turnLeftFamiliar();
        	
        }else if(e.getSource() == this.newGameMenu.getRightFamiliarType()) {
        	turnRightFamiliar();
        	
        }else if(e.getSource() == this.newGameMenu.getLaunchGame()) {
        	launchNewGame();
	        	
        // JButton from savesMenu        	
        }else if(e.getSource() == this.savesMenu.getBackMenu()) {
			mainMenuDisplay();
        }
	}
	
	/* turnRightFamiliar()
	 * 
	 * Change le choix du familier avec celui a sa droite
	 */
	private void turnRightFamiliar() {
		if(cursorImage < CURSOR_MAX) {
			cursorImage++;
		}else{
			cursorImage = CURSOR_MIN;
		}
			this.newGameMenu.getSpeciesIcon().setIcon(createImageIcon(familiarTypeURL[cursorImage]));
		}
	
	/* turnLeftFamiliar()
	 * 
	 * Change le choix du familier avec celui a sa gauche
	 */
	private void turnLeftFamiliar() {
	if(cursorImage > CURSOR_MIN) {
		cursorImage--;
	}else{
		cursorImage = CURSOR_MAX;
	}
		this.newGameMenu.getSpeciesIcon().setIcon(createImageIcon(familiarTypeURL[cursorImage]));
	}
	
	/* mainMenuDisplay()
	 * 
	 * Affiche le menu principal sur la mainFrame
	 */
	public void mainMenuDisplay() {
		flush();
		mainMenu.display(this);
	}
	
	/* newGameMenuDisplay()
	 * 
	 * Affiche le menu de creation de familier sur la mainFrame
	 */
	public void newGameMenuDisplay() {
		flush();
		newGameMenu.display(this);
	}
	
	/* mainMenuDisplay()
	 * 
	 * Affiche le menu des sauvegardes sur la mainFrame
	 */
	public void savesMenuDisplay() {
		flush();
		savesMenu.display(this);
	}
	
	/* flush()
	 * 
	 * Vide la mainFrame de tous ses composants
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
	/* launchNewGame()
	 * 
	 * Verifie la validite du nom rentre
	 * Creer un familier et lance le jeu
	 */
	private void launchNewGame() {
		String fName = this.newGameMenu.getName().getText();
		String fType = familiarType[cursorImage];
		
    	// verification de la validite du nom
    	// recherche en fonction du matcher
    	invalidPattern = Pattern.compile("<|>|:|“|/");
    	invalidMatcher = invalidPattern.matcher(fName);
    	
    	emptyPattern = Pattern.compile("^(\s{1,21})");
    	emptyMatcher = emptyPattern.matcher(fName);
    	
    	if(fName.length()>=20){
    		JOptionPane maxLenghtProb = new JOptionPane("Le nom du familier ne peut pas dépasser 20 caractères.",JOptionPane.WARNING_MESSAGE);
    		setOptionBoxVisual(maxLenghtProb);
    		
    	}else if((fName.isEmpty()) || (emptyMatcher.find())) {
    		JOptionPane emptyNameProb = new JOptionPane("Le nom du familier doit comporter au moins 1 caractère.",JOptionPane.WARNING_MESSAGE);
    		setOptionBoxVisual(emptyNameProb);
    		
    	}else if((invalidMatcher.find())) {
    		JOptionPane invalidNameProb = new JOptionPane("Les caractères <, >, :, “, /, \\, |, ?, * sont interdits dans le nom du familier.",JOptionPane.WARNING_MESSAGE);
    		setOptionBoxVisual(invalidNameProb);
    	
    	}else {
    		String confirm_msg = "Création de "+fName+" le "+fType+" ?";
    		String[] confirm_options = {"Oui", "Non"};
    		int confirm_answer = JOptionPane.showOptionDialog(null, confirm_msg, "Tamagotchi", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirm_options, confirm_options[0]);
    		
    		switch(confirm_answer){
	    		case 0:
	    		    // create a new Familiar
	    	        	// attributes for the new Familiar
	    	        	Familiar newFamiliar;
	    	        	
	    	        	switch(fType) {
	    	        		case "Cat":
	    	        			newFamiliar = new Cat(fName);
	    	        			break;
	    	        			
	    	        		case "Dog":
	    	        			newFamiliar = new Dog(fName);
	    	        			break;
	    	        			
	    	        		case "Rabbit":
	    	        			newFamiliar = new Rabbit(fName);
	    	        			break;
	    	        			
	    	        		case "Robot":
	    	        			newFamiliar = new Robot(fName);
	    	        			break;
	    	        		
	    	        		default:
	    	        			mainMenuDisplay();
	    	        			JOptionPane launchProb = new JOptionPane("Erreur lors de la création du familier.",JOptionPane.WARNING_MESSAGE);
	    	        			setOptionBoxVisual(launchProb);
	    	        			break;
	    	        	}
	    		        	
	    	        	GameController(newFamiliar, mainFrame);
	    	        	break;
	    		
	    		case 1:
	    			break;
    		
    			default:
    				mainMenuDisplay();
    				break;
    		}
    	}
	}
	
	private JOptionPane setOptionBoxVisual(JOptionPane pane) {
		JDialog boite = pane.createDialog("Robot vérificateur");
	    boite.setVisible(true);
		return pane;
	}
	
	/* createImageIcon(String)
	 * 
	 * Verifie que l'URL rentree mene bien vers un fichier
	 * Creer et retourne un ImageIcon à partir du fichier source
	 */
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
