package slider;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HomeFinder {
	
	static MapGeo map;
	
	public static void updateMap_nb_bedroom(int max_nb_bedroom, int min_nb_bedroom){
		map.setMaxNbBedroom(max_nb_bedroom);
		map.setMinNbBedroom(min_nb_bedroom);
		map.repaint();
	};
	public static void updateMap_value(int max_Value, int min_Value){
		map.setMaxValue(max_Value);
		map.setMinValue(min_Value);
		map.repaint();
	};
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {			
			
		// FRAME
		JFrame window = new JFrame();
	    window.setTitle("Welcome to Home Finder!");
	    window.setSize(1000, 800);
	    window.setLocationRelativeTo(null);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setLayout(new BorderLayout());
		
		// Values min and max for the apartments
		int max_posX = 1000;
		int min_posX = 0;
		int max_posY = 800;
		int min_posY = 0;
		int max_nb_bedroom = 6;
		int min_nb_bedroom = 1;
		int max_Value = 100000;
		int min_Value = 1000;
		
		// Instantiate new random values for apartments 
		Home[] tab_apart = new Home[100];
		for (int i = 0; i<tab_apart.length; i++){
			tab_apart[i] = new Home(max_posX, min_posX, max_posY, min_posY, max_nb_bedroom, min_nb_bedroom, max_Value, min_Value);
		}
		
		

		// Declare the MAP PANEL
		map = new MapGeo();
		
		// Set the values we need in MapGeo to display the correct houses
		map.setTabApart(tab_apart);
		map.setMaxNbBedroom(max_nb_bedroom);
		map.setMinNbBedroom(min_nb_bedroom);
		map.setMaxValue(max_Value);
		map.setMinValue(min_Value);
		map.setMaxX(max_posX);
		map.setMinX(min_posX);
		map.setMaxY(max_posY);
		map.setMinY(min_posY);
		map.setPreferredSize(new Dimension(1000,800));
		
		// Repaint with the new values
		map.setBackground(Color.white);
		
		//map.setVisible(true);
		map.repaint();
		
		//Declare the  filters
		JPanel filters = new JPanel();
		filters.setLayout(new GridLayout(2, 1, 0, 5));
		filters.setSize(300, 800);
		
		// Number of bedroom
		JPanel filterNbB = new JPanel();
		RangeSlider slideNbB = new RangeSlider( max_nb_bedroom, 1, max_nb_bedroom, 1);
		slideNbB.setMaximum(max_nb_bedroom);
		slideNbB.setMinimum(1);
		//slideNbB.setValue(max_nb_bedroom);
		slideNbB.setPaintTicks(true);
		slideNbB.setPaintLabels(true);
		slideNbB.setMajorTickSpacing(1);
		
		slideNbB.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent event) {
				updateMap_nb_bedroom( ((JSlider)event.getSource()).getExtent()+((JSlider)event.getSource()).getValue(), ((JSlider)event.getSource()).getValue());
			}
			
		});
		JLabel labelNbB = new JLabel("Nombre de chambre:");
		
		filterNbB.setLayout(new GridLayout(2, 1, 0, 5));
		filterNbB.add(labelNbB);
		filterNbB.add(slideNbB);
		
		
		// Value of the apartment
		JPanel filterVal = new JPanel();
		RangeSlider slideVal = new RangeSlider(max_Value, min_Value, max_Value, min_Value);
		slideVal.setMaximum(max_Value);
		slideVal.setMinimum(min_Value);
		//slideVal.setValue(max_Value);
		slideVal.setPaintTicks(true);
		slideVal.setPaintLabels(true);
		slideVal.setMinorTickSpacing((max_Value-min_Value)/9);
		slideVal.setMajorTickSpacing((max_Value-min_Value)/3);
		
		slideVal.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent event) {
				updateMap_value( ((JSlider)event.getSource()).getExtent()+((JSlider)event.getSource()).getValue(), ((JSlider)event.getSource()).getValue());				
			}
			
		});
		
		
		JLabel labelVal = new JLabel("Valeur:");
		
		filterVal.setLayout(new GridLayout(2, 1, 0, 5));
		filterVal.add(labelVal);
		filterVal.add(slideVal);
		
		
		filters.add(filterNbB);
		filters.add(filterVal);
				
		// Telling to the Frame it need to display the Panel
		window.getContentPane().add(map, BorderLayout.CENTER);
		window.getContentPane().add(filters, BorderLayout.EAST);
		
		window.pack();		
		window.setVisible(true);
	}

}
