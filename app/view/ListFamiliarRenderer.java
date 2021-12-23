package app.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
		

		JPanel panFam = new JPanel();
		panFam.setLayout(new BoxLayout(panFam, BoxLayout.Y_AXIS));
		
		// image du familier
		JLabel image = new JLabel(createImageIcon("../assets/images/cat.png"));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// nom du familier
		JLabel textName = new CustomMenuLabel("Nom : "+familiar.getName(), DEFAULT_BUTTON_SIZE);
		textName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// type du familier
		JLabel textType = new CustomMenuLabel("Type : "+familiar.getFamiliarType(), DEFAULT_BUTTON_SIZE);
		textType.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel textClass = new CustomMenuLabel("Classe : "+familiar.getClass(), DEFAULT_BUTTON_SIZE);
		textClass.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		// ajout des elements dans le panel
		panFam.add(image);
		panFam.add(textName);
		panFam.add(textType);
		panFam.add(textClass);

		// parametrage de la list
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // selectionner seul 1 element
        
        if (isSelected) {
    		panFam.setBackground(Color.WHITE);
        	panFam.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        }
        
		return panFam;
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
