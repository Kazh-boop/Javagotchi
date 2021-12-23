package app.view;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;

public class RoundedBorder implements Border {

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
	        Graphics2D g2 = (Graphics2D)g;
	        Stroke stroke = g2.getStroke();
	        g2.setStroke(new BasicStroke(10f));
	        g2.draw(createRoundrect(x, y, width, height));
	        g2.setStroke(stroke);
	    }
	    
	    public RoundRectangle2D.Double createRoundrect(int x, int y, int width, int height) {
	    	 RoundRectangle2D.Double rounded = new RoundRectangle2D.Double(x, y, width, height, radius, radius);
	    	 return rounded;
	    }
	}
