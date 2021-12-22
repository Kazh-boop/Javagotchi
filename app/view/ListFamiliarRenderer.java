package app.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


import app.model.Familiar;

/**
 * 
 * Permet de personnaliser une JList
 *
 */
public class ListFamiliarRenderer implements ListCellRenderer<Familiar> {
	

	@Override
	public Component getListCellRendererComponent(JList<? extends Familiar> list, Familiar familiar, int index,
			boolean isSelected, boolean cellHasFocus) {
		

		Box box = Box.createVerticalBox();
		
		// image du familier
		JLabel image = new JLabel(createImageIcon("../assets/images/cat.png"));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// nom du familier
		JLabel texteName = new CustomMenuLabel("Nom : "+familiar.getName(), 32f);
		texteName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// type du familier
		JLabel textType = new CustomMenuLabel("Type : "+familiar.getFamiliarType(), 32f);
		textType.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// ajout des elements dans la box
		box.add(image);
		box.add(texteName);
		box.add(textType);

		list.setOpaque(true);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
        list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION); // selectionner seul 1 element
        list.setBorder(null);
        list.setSelectionBackground(Color.blue);
        
		return box;
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

}
