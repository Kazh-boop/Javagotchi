package app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

public class CustomMenuButton extends JButton {
	
	protected static final String FONT_LIKE_SNOW = "../assets/fonts/likesnow.ttf";
	protected static final Color COLOR_CACTUS_GREEN = new Color(104, 131, 53);
	protected static final Color COLOR_PEARL = new Color(245, 235, 218);
	private final RoundedBorder border;	
	
    public CustomMenuButton() {
        this(null, null, 48f);
    }

    public CustomMenuButton(Icon icon) {
        this(null, icon, 48f);
    }
    
	CustomMenuButton(String name) {
		this(name,null,48f);
	}
	
    public CustomMenuButton(String text, Icon icon) {
        this(text, icon, 48f);
    }
	
    public CustomMenuButton(String name, Float size) {
		this(name,null,size);
	}
    
    /**
     * Creer un JButton selon des criteres particuliers
     * @param name String
     * @param icon Icon
     * @param size float
     */
    public CustomMenuButton(String name, Icon icon, float size) {
		super(name,icon);
		
		this.border = new RoundedBorder(20);
		setBorder(border);
		setCustomSize(1000, 100);
		setCustomFont(size);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Shape oldClip = g2.getClip();
		g2.clip(border.createRoundrect(0, 0, getWidth(), getHeight()));
		super.paint(g);
		g2.clip(oldClip);
	}
	
	/**
	 * Definit une taille pour le composant
	 * @param width
	 * @param height
	 */
	protected void setCustomSize(int width, int height) {
    	setMaximumSize(new Dimension(width, height));
	}
	
	/**
	 * Definit une nouvelle police de taille a definir
	 * @param fontSize float
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