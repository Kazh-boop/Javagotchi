package app.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;

public class CustomMenuButton extends JButton {
	
	private static final String FONT_LIKE_SNOW = "../assets/fonts/likesnow.ttf";
	
	/**
	 * Fait un habillage par defaut pour les JButton du menu
	 * @param name String
	 */
	CustomMenuButton(String name) {
		super(name);
		
		setCustomSize(1000,100);
		setCustomBorder();
		setCustomFont(48f);
	}
	
	CustomMenuButton(String name, float size) {
		super(name);
		
		setCustomSize(1000, 100);
		setCustomBorder();
		setCustomFont(size);
	}
	
	protected void setCustomSize(int width, int height) {
	
    	setMaximumSize(new Dimension(width, height));

	}
	
	protected void setCustomBorder() {
		//TODO faire une bordure arroundi un peu cool
	}
	
	/**
	 * Definit une nouvelle police a l'objet en parametre
	 * @param jc JComponent
	 * @param path String
	 */
	protected void setCustomFont(float fontSize){
		InputStream inStrm = CustomMenuButton.class.getResourceAsStream(FONT_LIKE_SNOW);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, inStrm);
			Font sizedFont = font.deriveFont(fontSize);
			setFont(sizedFont);
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
