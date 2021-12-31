package app.util;

import java.net.URL;
import java.awt.Image;
import javax.swing.ImageIcon;

public class IconUtil {

    private IconUtil() {}

    /**
	 * Check that the entered URL leads to a file
	 * @param path String
	 * @return imgURL ImageIcon
	 */
    public static ImageIcon createImageIcon(String path) {
        URL imgURL = IconUtil.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static ImageIcon createSizedImageIcon(String path, int width, int height) {
        Image image = createImageIcon(path).getImage(); 
        Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); 
        return new ImageIcon(newimg); 
    }
}