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
	    window.setSize(1000, 800);
	    //Set the position of the frame in the center
	    window.setLocationRelativeTo(null);
	    //Stop the process when we click on the red button 
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Make it visible      
		window.setVisible(true);
		
		// 
		int max_posX = 1000;
		int min_posX = 0;
		int max_posY = 800;
		int min_posY = 0;
		int max_nb_bedroom = 6;
		int max_Value = 100000;
		int min_Value = 1000;
		// Instantiate new random values for apartments 
		Home[] tab_apart = new Home[100];
		for (int i = 0; i<tab_apart.length; i++){
			tab_apart[i] = new Home(max_posX, min_posX, max_posY, min_posY, max_nb_bedroom, max_Value, min_Value);
		}
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		
		MapGeo map = new MapGeo();
		// Set the values we need in MapGeo to display the correct houses
		map.setTabApart(tab_apart);
		map.setMaxNbBedroom(max_nb_bedroom);
		map.setMinNbBedroom(1);
		map.setMaxValue(max_Value);
		map.setMinValue(min_Value);
		map.setMaxX(max_posX);
		map.setMinX(min_posX);
		map.setMaxY(max_posY);
		map.setMinY(min_posY);
		
		// Make it Visible
		map.setVisible(true);
		// Repaint with the new values
		map.repaint();
		
		pan.add(map,BorderLayout.CENTER);
		// Telling to the Frame it need to display the Panel
		window.setContentPane(pan);
		
	}

}
