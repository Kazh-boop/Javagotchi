package app.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import app.model.Familiar;
import app.util.*;

/**
 * 
 * Allows you to customise a JList
 *
 */
public class ListFamiliarRenderer implements ListCellRenderer<Familiar> {
	
	private static final float DEFAULT_BUTTON_SIZE = 32f;

	@Override
	public Component getListCellRendererComponent(JList<? extends Familiar> list, Familiar familiar, int index,
			boolean isSelected, boolean cellHasFocus) {
		

		JPanel panFam = new JPanel();
		panFam.setLayout(new BoxLayout(panFam, BoxLayout.Y_AXIS));
		panFam.setPreferredSize(new Dimension(420, 350));
		// picture of the familiar
		JLabel image = new JLabel(createImageIcon(familiar.getUrlIcon()));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// name of the familiar
		JLabel textName = new CustomMenuLabel("Nom : "+ familiar.getName(), DEFAULT_BUTTON_SIZE);
		textName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// type of the familiar
		JLabel textType = new CustomMenuLabel("Type : "+familiar.getFamiliarType(), DEFAULT_BUTTON_SIZE);
		textType.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		// adding elements to the panel
		panFam.add(image);
		panFam.add(textName);
		panFam.add(textType);

		// setting up the list
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // select only 1 item
        
        if (isSelected) {
    		panFam.setBackground(Color.WHITE);
        	panFam.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        }
        
		return panFam;
	}
	
	/**
	 * Check that the entered URL leads to a file
	 * Create and return an ImageIcon from the source file
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

}
