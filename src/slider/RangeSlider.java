package slider;

import javax.swing.JSlider;
import javax.swing.DefaultBoundedRangeModel;

/**
 * An extension of JSlider to select a range of values using two thumb controls.
 * The thumb controls are used to select the lower and upper value of a range
 * with predetermined minimum and maximum values.
 * 
 * <p>Note that RangeSlider makes use of the default BoundedRangeModel, which 
 * supports an inner range defined by a value and an extent.  The upper value
 * returned by RangeSlider is simply the lower value plus the extent.</p>
 */
public class RangeSlider extends JSlider {
	private static final long serialVersionUID = 1L;
	//these variables define the width and height of the thumb
	public int thumbWidth = 10;
	public int thumbHeight = 20;
	//this variables shifts the min value to the right position in the layout
	public final int Starting_point_thumb = 10;

	
	//ces getters permettent de repositionner correctement le rectangle de debut
		public int getStartPositionThumb() {
			return Starting_point_thumb;
		}

	public RangeSlider(int orientation, int extent, int min, int max, int value){
		this.orientation = orientation;
		sliderModel = new DefaultBoundedRangeModel(value, extent, min, max);
		sliderModel.setExtent(extent);
		sliderModel.addChangeListener(changeListener);

		updateUI();
	}

	@Override
	public void updateUI() {
		setUI(new RangeSliderUI(this));
		updateLabelUIs();
	}

	@Override
	public int getValue() {
		return super.getValue();
	}

	/**
	 * 
	 * @return right rectangle's position
	 */
	public int getUpValue() {
		return (this.getValue() + this.getExtent());
	}
	/**
	 * 
	 * @param n the desired position
	 */
	public void setSliderGauche(int newPosition) {
		int old = this.getValue();
		// We make sure that the new value is lower than the right rectangle's value or minimum 
		int new_value = Math.min(Math.max(getMinimum(),newPosition),getUpValue()-thumbWidth);
		int new_extent = old-new_value+getExtent();

		// On est obligé d'appeler cette méthode, vu qu'on a override setValue ;)
		this.getModel().setRangeProperties(new_value,new_extent,getMinimum(),getMaximum(),getValueIsAdjusting());
	}

	/**
	 * Set la val supérieur du RangeSlider
	 * @param val valeur souhaité pour la valeur supérieur du RangeSlider
	 */
	public void setSliderDroite(int val) {
		/* Cela revient à calculer une valeur d'extent, compte tenu des contraintes du slider :
		 * la valeur minimale entre
		 * l'incrément qu'on prévoit de faire par rapport à la valeur du Slider "de gauche" (le max assure la positivité)
		 * la valeur maximale d'un incrément (toujours par rapport au slider "de gauche")
		 * 
		 * remarque : 
		 * +TestUI.rect_width empeche les 2 rectangles de "fusionner" à l'affichage :)
		 */ 
		if (this.getValue() + thumbWidth <= val){
			this.setExtent(val - getValue());
		}
		else{
			this.setExtent(thumbWidth);
		}
	}

	public void moveRange(int offset){
		this.setValue(this.getValue() + offset);
	}
	
	
}