package util;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;

/**
 * defines the shape and opacity of the borders 
 */

public class RoundedBorder implements Border {
	
	    private int radius;

	    /**
	     * Constructor
	     * @param radius
	     */
	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    /**
	     * @return insets
	     */
	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }

	    /**
	     * @return true
	     */
	    public boolean isBorderOpaque() {
	        return true;
	    }

	    /**
	     * Draw the border
	     * @param c
	     * @param g
	     * @param x
	     * @param y
	     * @param width
	     * @param height
	     */
	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        Graphics2D g2 = (Graphics2D)g;
	        Stroke stroke = g2.getStroke();
	        g2.setStroke(new BasicStroke(10f));
	        g2.draw(createRoundRect(x, y, width, height));
	        g2.setStroke(stroke);
	    }
	    
	    /**
	     * Create a RoundRectangle2D
	     * @param x
	     * @param y
	     * @param width
	     * @param height
	     * @return RoundRectangle2D.Double
	     */
	    public RoundRectangle2D.Double createRoundRect(int x, int y, int width, int height) {
	    	 return new RoundRectangle2D.Double(x, y, width, height, radius, radius);
	    }
	}
