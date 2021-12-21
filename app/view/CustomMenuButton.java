package app.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class CustomMenuButton extends JButton {
	
	private final static String FONT_LIKE_SNOW = "../assets/fonts/likesnow.ttf";
	
	/**
	 * Fait un habillage par defaut pour les JButton du menu
	 * @param name String
	 */
	CustomMenuButton(String name) {
		super(name);
		
		setCustomSize();
		setCustomBorder();
		setCustomFont(this,48f);
	}
	
	CustomMenuButton(String name, float size) {
		super(name);
		
		setCustomSize();
		setCustomBorder();
		setCustomFont(this,size);
	}
	
	protected void setCustomSize() {
		//TODO Definir une taille pour les boutons, surtout pour pas qu'ils ne prennent toutes la largeur de la page
	}
	
	protected void setCustomBorder() {
		//TODO faire une bordure arroundi un peu cool
	}
	
	/**
	 * Definit une nouvelle police a l'objet en parametre
	 * @param jc JComponent
	 * @param path String
	 */
	protected void setCustomFont(JComponent jc, float fontSize){
		InputStream inStrm = CustomMenuButton.class.getResourceAsStream(FONT_LIKE_SNOW);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, inStrm);
			Font sizedFont = font.deriveFont(fontSize);
			jc.setFont(sizedFont);
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
