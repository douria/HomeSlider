package slider;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapGeo extends JPanel{
	
	private Home[] tabApart;
	private int minNbBedroom;
	private int maxNbBedroom;
	private int minValue;
	private int maxValue;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	public void paintComponent(Graphics g){
		System.out.println("minNbBedroom = "+minNbBedroom+" ; maxNbBedroom = "+maxNbBedroom+"; minValue = "+minValue+"; maxValue = "+maxValue+"; minX = "+minX+"; maxX"+maxX+"; minY = "+minY+"; maxY = "+maxY);
		int r= 10;
		int width = this.getWidth()-2*r;
		int height = this.getHeight()-2*r;
		System.out.println(width+" "+height);
		
		
		int posx = 0;
		int posy = 0;
		g.setColor(Color.red);
		for (int i = 0; i< tabApart.length; i++){
			// System.out.println(tabApart[i]);
			if (minNbBedroom <= tabApart[i].nb_bedroom && maxNbBedroom >= tabApart[i].nb_bedroom && minValue <= tabApart[i].value && maxValue >= tabApart[i].value ){
				float scale = Math.min(width/(float)(maxX-minX), height/(float)(maxY-minY));
				posx = (int) ((tabApart[i].posX) * scale + r); 
				posy = (int) (height - tabApart[i].posY * scale+ r);
				
				// System.out.println("posX "+posx+" posy "+posy);
				g.fillOval(posx, posy, r, r);
			}
		}

		this.setVisible(true);
	}



	public int getMinNbBedroom() {
		return minNbBedroom;
	}

	public void setMinNbBedroom(int minNbBedroom) {
		this.minNbBedroom = minNbBedroom;
	}

	public int getMaxNbBedroom() {
		return maxNbBedroom;
	}


	public void setMaxNbBedroom(int maxNbBedroom) {
		this.maxNbBedroom = maxNbBedroom;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public Home[] getTabApart() {
		return tabApart;
	}

	public void setTabApart(Home[] tabApart) {
		this.tabApart = tabApart;
	}
	

}
