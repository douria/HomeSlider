package slider;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FilterPanel extends JPanel{
	
	private String namePanel;
	
	
	public String getNamePanel() {
		return namePanel;
	}


	public void setNamePanel(String namePanel) {
		this.namePanel = namePanel;
	}


	public void paintComponent(Graphics g){
		System.out.println("Here!!");
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    this.setSize(250, 150);		      
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
	    this.add(slide, BorderLayout.CENTER);
	    this.add(label, BorderLayout.SOUTH);      
	
		this.setVisible(true);
	}
}
