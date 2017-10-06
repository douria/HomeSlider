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
	
	public Home (int max_posX, int min_posX, int max_posY, int min_posY, int max_nb_bedroom, int min_nb_bedroom, int max_Value, int min_Value){
		this.posX = (int) (Math.random() * (max_posX-min_posX)) + min_posX;
		this.posY = (int)(Math.random() * (max_posY-min_posY)) + min_posY;
		this.value = (int)(Math.random() * (max_Value-min_Value)) + min_Value;
		this.nb_bedroom = (int)(Math.random() * (max_nb_bedroom-1)) + 1;
	}

	@Override
	public String toString() {
		return "Home [posX=" + posX + ", posY=" + posY + ", nb_bedroom="
				+ nb_bedroom + ", value=" + value + "]";
	}

}
