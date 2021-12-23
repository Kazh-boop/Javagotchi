package app.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import app.model.Familiar;

/**
 * 
 * Permet de personnaliser une JList
 *
 */
public class ListFamiliarRenderer implements ListCellRenderer<Familiar> {
	
	private static final float DEFAULT_BUTTON_SIZE = 32f;

	@Override
	public Component getListCellRendererComponent(JList<? extends Familiar> list, Familiar familiar, int index,
			boolean isSelected, boolean cellHasFocus) {
		

		Box box = Box.createVerticalBox();
		
		// image du familier
		JLabel image = new JLabel(createImageIcon("../assets/images/cat.png"));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// nom du familier
		JLabel texteName = new CustomMenuLabel("Nom : "+familiar.getName(), DEFAULT_BUTTON_SIZE);
		texteName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// type du familier
		JLabel textType = new CustomMenuLabel("Type : "+familiar.getFamiliarType(), DEFAULT_BUTTON_SIZE);
		textType.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// ajout des elements dans la box
		box.add(image);
		box.add(texteName);
		box.add(textType);

		list.setOpaque(true);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // selectionner seul 1 element
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
