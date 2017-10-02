package slider;

public class Home {
	
	int posX,posY;
	int nb_bedroom;
	int value;
	/**
	 * Constructor
	 * @param x the geographical position horizontally
	 * @param y the geographical position vertically 
	 * @param nb_bedroom the number of bedroom in the apartment
	 * @param value the price of the apartment
	 */
	public Home(int x,int y, int nb_bedroom, int value) {
		this.posX = x;
		this.posY = y;
		this.nb_bedroom = nb_bedroom;
		this.value = value;
	}
	
	/**
	 * Constructor
	 * @param x the geographical position horizontally
	 * @param y the geographical position vertically 
	 * @param value the price of the apartment
	 */
	public Home(int x,int y, int value) {
		this.posX = x;
		this.posY = y;
		this.nb_bedroom = 1;
		this.value = value;
	}
}
