package app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Color;

public class CustomMenuButton extends JButton {
	
	private static final String FONT_LIKE_SNOW = "../assets/fonts/likesnow.ttf";
	public static final Color COLOR_CACTUS_GREEN = new Color(104, 131, 53);
	public static final Color COLOR_PEARL = new Color(245, 235, 218);
	
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

		setBorder(new RoundedBorder(20));
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
        setBackground(COLOR_PEARL);
	}
}

class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}