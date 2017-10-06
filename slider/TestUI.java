package slider;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestUI {
	public static JLabel values = new JLabel("");
	public static RangeSlider rs = new RangeSlider(50,0,100,0);
	public static JFrame window = new JFrame();
	
	public static void main(String[] args) {
		
		window.setTitle("RangeSlider");		
		window.add(rs,BorderLayout.NORTH);
		window.add(values,BorderLayout.SOUTH);
		values.setText("<html>min : "+rs.getMinimum() + " value : " + rs.getValue() + "<br>extent : " + rs.getExtent() + " max : " + rs.getMaximum()+"</html>");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		rs.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				values.setText("<html>min : "+rs.getMinimum() + " value : " + rs.getValue() + "<br>extent : " + rs.getExtent() + " max : " + rs.getMaximum()+"</html>");
				values.repaint();

			}
			
		});
	}

}