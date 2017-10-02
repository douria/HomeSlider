package slider;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapGeo extends JPanel{
	
	private Home tabApart[];
	private int minNbBedroom;
	private int maxNbBedroom;
	private int minValue;
	private int maxValue;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	
	
	public void paintComponent(Graphics g){
		int r= 5;
		int width = this.getWidth()-2*r;
		int height = this.getHeight()-2*r;
		
		int posx = 0;
		int posy = 0;
		for (int i = 0; i< tabApart.length; i++){
			
			if (minNbBedroom < tabApart[i].nb_bedroom && maxNbBedroom > tabApart[i].nb_bedroom && minValue < tabApart[i].value && maxValue > tabApart[i].value ){
				posx = tabApart[i].posX / ((minX+maxX)/width) + r;
				posy = height - tabApart[i].posY / ((minY+maxY)/height) + r;
				g.setColor(Color.red);
				g.fillOval(posx, posy, r, r);
			}
		}	
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
