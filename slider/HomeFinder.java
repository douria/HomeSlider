package slider;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		
		// Repaint with the new values
		map.repaint();
		
		JPanel filters = new JPanel();
		filters.setLayout(new GridLayout(2, 1, 0, 5));
		filters.setSize(300, 800);
		System.out.println("Width = "+ pan.getWidth()+" Height = "+pan.getHeight()+" filters: w = "+filters.getWidth()+" h = "+filters.getHeight());
		
		FilterPanel filterNbBedroom = new FilterPanel();
		FilterPanel filterValue = new FilterPanel();
		filterNbBedroom.setVisible(true);
		filterValue.setVisible(true);
		
		//filters.add(filterNbBedroom);
		//filters.add(filterValue);
		filters.setSize(250, 150);		      
	    JSlider slide = new JSlider();
	    JLabel label = new JLabel("Valeur actuelle : 30");
		   
	    slide.setMaximum(100);
	    slide.setMinimum(0);
	    slide.setValue(30);
	    slide.setPaintTicks(true);
	    slide.setPaintLabels(true);
	    slide.setMinorTickSpacing(10);
	    slide.setMajorTickSpacing(20);
	    slide.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("Valeur actuelle : " + ((JSlider)event.getSource()).getValue());
			}
	    });      
	    filters.add(slide, BorderLayout.CENTER);
	    filters.add(label, BorderLayout.SOUTH); 
		
		pan.add(map,BorderLayout.CENTER);
		pan.add(filters, BorderLayout.EAST);
		System.out.println("Width = "+ pan.getWidth()+" Height = "+pan.getHeight()+" filters: w = "+filters.getWidth()+" h = "+filters.getHeight());
		
		// Telling to the Frame it need to display the Panel
		window.setContentPane(pan);
		System.out.println("Width = "+ pan.getWidth()+" Height = "+pan.getHeight()+" filters: w = "+filters.getWidth()+" h = "+filters.getHeight());

	}

}
