package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import app.model.Cat;
import app.model.Dog;
import app.model.Familiar;
import app.model.Rabbit;
import app.model.Robot;
import app.model.SaveManager;
import app.view.MainFrame;
import app.view.NewGameMenu;

public class NewGameMenuController implements ActionListener {

	private MainFrame mainFrame;
	private NewGameMenu newGameMenu;
	private MenuController menuController;
	private SaveManager saveManager;
	
	private static final int CURSOR_MAX = 3;
	private static final int CURSOR_MIN = 0;
	private int cursorImage = 0;
	private final String[] familiarType = {"Chat", "Chien", "Robot", "Lapin"};
	private final String[] familiarTypeURL = {"../assets/images/cat.png", "../assets/images/dog.png", "../assets/images/robot.png", "../assets/images/rabbit.png"};
	
	private Pattern invalidPattern;
    private Matcher invalidMatcher;
	private Pattern emptyPattern;
    private Matcher emptyMatcher;
	
	/**
	 * Constructeur
	 * @param menuController MenuController
	 * @param nFrame MainFrame
	 */
	public NewGameMenuController(MenuController menuController, MainFrame nFrame) {
		this.mainFrame = nFrame;
		this.menuController = menuController;
		this.newGameMenu = new NewGameMenu(this);
		this.saveManager = new SaveManager();
	}
	
	public void newGameMenuDisplay() {
		flush();
		setCursorImage(0);
		newGameMenu.display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.newGameMenu.getBackMenu()) {
			menuController.playsound(menuController.getClickSound());
			menuController.mainMenuDisplay();
			
        }else if(e.getSource() == this.newGameMenu.getLeftFamiliarType()) {
        	menuController.playsound(menuController.getClickSound());
        	turnLeftFamiliar();
        	
        }else if(e.getSource() == this.newGameMenu.getRightFamiliarType()) {
        	menuController.playsound(menuController.getClickSound());
        	turnRightFamiliar();
        	
        }else if(e.getSource() == this.newGameMenu.getLaunchGame()) {
        	menuController.playsound(menuController.getClickSound());
        	launchNewGame();
        }
		
	}
	
	/** 
	 * Vide la mainFrame de tous ses composants
	 */
	private void flush() {
		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
	}
	
	/** turnRightFamiliar()
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
	
	/** turnLeftFamiliar()
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
	
	/** launchNewGame()
	 * 
	 * Verifie la validite du nom rentre
	 * Creer un familier et lance le jeu
	 */
	private void launchNewGame() {
		String fName = this.newGameMenu.getName().getText();
		String fType = familiarType[cursorImage];
		
    	// verification de la validite du nom
    	// recherche en fonction du matcher
    	invalidPattern = Pattern.compile("[<>:\"/]");
    	invalidMatcher = invalidPattern.matcher(fName);
    	
    	emptyPattern = Pattern.compile("^(\s{1,21})");
    	emptyMatcher = emptyPattern.matcher(fName);
    	
    	if(fName.length()>=20){
    		JOptionPane maxLenghtProb = new JOptionPane("Le nom du familier ne peut pas depasser 20 caracteres.",JOptionPane.WARNING_MESSAGE);
    		setOptionBoxVisual(maxLenghtProb);
    		
    	}else if((fName.isEmpty()) || (emptyMatcher.find())) {
    		JOptionPane emptyNameProb = new JOptionPane("Le nom du familier doit comporter au moins 1 caract�re et ne pas commencer par des espaces.",JOptionPane.WARNING_MESSAGE);
    		setOptionBoxVisual(emptyNameProb);
    		
    	}else if((invalidMatcher.find())) {
    		JOptionPane invalidNameProb = new JOptionPane("Les caracteres <, >, :, \", /, \\, |, ?, * sont interdits dans le nom du familier.",JOptionPane.WARNING_MESSAGE);
    		setOptionBoxVisual(invalidNameProb);
    		
    	
    	}else if(!(saveManager.isEnableToSave())) {
    		String saveListFullMsg = "Vous ne pouvez pas creer de nouveau familier. Limite de 3 sauvegardes atteintes.";
    		String[] saveListFullOptions = {"Ok", "Menu sauvegardes", "Menu principal"};
    		int saveListFullAnswer = JOptionPane.showOptionDialog(null, saveListFullMsg, "Erreur nombre maximal de familier atteint", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, saveListFullOptions, saveListFullOptions[1]);
    		
    		switch(saveListFullAnswer){
    			case 0: // ok
    				menuController.playsound(menuController.getClickSound());
    				break;
    				
	    		case 1: // sauvegardes
	    			menuController.playsound(menuController.getClickSound());
	    			try {
	    				menuController.saveMenuController.savesMenuDisplay();
	    			} catch (ClassNotFoundException | IOException e) {
	    				e.printStackTrace();
	    			}
	    			break;
    		
    			default:
    				menuController.playsound(menuController.getClickSound());
    				menuController.mainMenuDisplay();
    				break;
    		}
    		
    	}else {
    		String confirmMsg = "Creation de "+fName+" le "+fType+" ?";
    		String[] confirmOptions = {"Oui", "Non"};
    		int confirmAnswer = JOptionPane.showOptionDialog(null, confirmMsg, "Confirmer creation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, confirmOptions, confirmOptions[0]);
    		
    		switch(confirmAnswer){
	    		case 0:
	    		    // create a new Familiar
	    	        	// attributes for the new Familiar
	    	        	Familiar newFamiliar = null;
	    	        	
	    	        	switch(fType) {
	    	        		case "Chat":
	    	        			newFamiliar = new Cat(fName);
	    	        			break;
	    	        			
	    	        		case "Chien":
	    	        			newFamiliar = new Dog(fName);
	    	        			break;
	    	        		
	    	        		case "Robot":
								newFamiliar = new Robot(fName);
	    	        			break;
	    	        			
	    	        		case "Lapin":
	    	        			newFamiliar = new Rabbit(fName);
	    	        			break;
	    	        		
	    	        		default:
	    	        			menuController.mainMenuDisplay();
	    	        			JOptionPane launchProb = new JOptionPane("Erreur lors du choix du type de familier.",JOptionPane.WARNING_MESSAGE);
	    	        			setOptionBoxVisual(launchProb);
	    	        			break;
	    	        	}
						if(newFamiliar != null) {
							menuController.playsound(menuController.getClickSound());
							try { 
								saveManager.openFile(newFamiliar.getUID());
								saveManager.writeSave(newFamiliar);
							} catch (IOException e) {
								e.printStackTrace();
							}
							new GameController(newFamiliar, mainFrame);
						}
					break;
					
	    		case 1:
	    			menuController.playsound(menuController.getClickSound());
	    			break;
    		
    			default:
    				menuController.playsound(menuController.getClickSound());
    				menuController.mainMenuDisplay();
    				break;
    		}
    	}
	}
	
	/**
	 * Fait un habillage standard d'un JOptionPane
	 * @param pane JOptionPane
	 * @return pane JOptionPane
	 */
	private JOptionPane setOptionBoxVisual(JOptionPane pane) {
		JDialog boite = pane.createDialog("Robot verificateur");
	    boite.setVisible(true);
		return pane;
	}
	
	/**
	 * Verifie que l'URL rentree mene bien vers un fichier
	 * Creer et retourne un ImageIcon a partir du fichier source
	 * 
	 * @param path String
	 * @return imgURL static ImageIcon
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
	
	/**
	 * @return mainFrame MainFrame
	 */
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}
	
	/**
	 * @param i int
	 */
	private void setCursorImage(int i) {
		cursorImage=0;
	}
}
