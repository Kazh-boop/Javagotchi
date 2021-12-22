package app.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JComponent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CustomMenuLabel extends JLabel {
	
private static final String FONT_LIKE_SNOW = "../assets/fonts/likesnow.ttf";
	
	/**
	 * Fait un habillage par defaut pour les JLabel du menu
	 * @param name String
	 */
	CustomMenuLabel(String name) {
		super(name);
		
		setCustomSize();
		setCustomBorder();
		setCustomFont(this,32f);
	}
	
	CustomMenuLabel(String name, int position) {
		super(name);
		
		setCustomSize();
		setCustomBorder();
		setCustomFont(this,24f);
	}
	
	CustomMenuLabel(String name, float size) {
		super(name);
		
		setCustomSize();
		setCustomBorder();
		setCustomFont(this,size);
	}
	
	CustomMenuLabel(String name, float size, int position) {
		super(name, position);
		
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
	 * Definit une nouvelle police
	 * @param jc JComponent
	 * @param fontSize float
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
