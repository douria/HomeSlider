package slider;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		//Define a title
	    window.setTitle("Welcome to Home Finder!");
	    //define the size of the frame: width & height in pixels
	    window.setSize(1000, 1000);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    window.setLocationRelativeTo(null);
	    //Stop the process when we click on the red button 
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Make it visible      
		window.setVisible(true);
		
		int max_posX = 300;
		int min_posX = 0;
		int max_posY = 500;
		int min_posY = 0;
		int max_nb_bedroom = 6;
		int max_Value = 100000000;
		int min_Value = 10000;
		
		Home tab_apart[] = new Home[100];
		for (int i = 0; i<tab_apart.length; i++){
			tab_apart[i] = new Home((int)(Math.random() * (max_posX-min_posX)) + min_posX, (int)(Math.random() * (max_posY-min_posY)) + min_posY, (int)(Math.random() * (max_nb_bedroom-1)) + 1, (int)(Math.random() * (max_Value-min_Value)) + max_Value);
		}
		
		MapGeo map = new MapGeo();
		window.setContentPane(map);
		
		map.setTabApart(tab_apart);
		
		map.setMaxNbBedroom(max_nb_bedroom);
		map.setMinNbBedroom(1);
		
		map.setMaxValue(max_Value);
		map.setMinValue(min_Value);
		
		map.setMaxX(max_posX);
		map.setMinX(min_posX);
		
		map.setMaxY(max_posY);
		map.setMinY(min_posY);
		
		
		map.setVisible(true);
		map.repaint();
		
	}

}
