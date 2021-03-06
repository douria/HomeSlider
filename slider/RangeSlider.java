package slider;

import javax.swing.JSlider;
import javax.swing.DefaultBoundedRangeModel;

/**
 * ADefines the data model used by components like Sliders and ProgressBars. 
 * Defines four interrelated integer properties: minimum, maximum, extent and value.
 * These four integers define two nested ranges like this:
 * minimum <= value <= value+extent <= maximum
 * The outer range is minimum,maximum and the inner range is value,value+extent.
 * The inner range must lie within the outer one, i.e. 
 * value must be less than or equal to maximum and value+extent must greater than or equal to minimum,
 * and maximum must be greater than or equal to minimum. 
 * There are a few features of this model that one might find a little surprising. 
 * These quirks exist for the convenience of the Swing BoundedRangeModel clients, 
 * such as Slider and ScrollBar. 
 */
public class RangeSlider extends JSlider {
	/**
	 * We need this serial number because we have a serialisable class
	 */
	private static final long serialVersionUID = 1L;
	//these variables define the width and height of the thumb
	public int thumbWidth = 10;
	public int thumbHeight = 20;

	// the constructor of a rangeSlider
	public RangeSlider(int extent, int min, int max, int value){

		
		super(min,max,value);
		this.setExtent(extent);

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
	public int getRightValue() {
		return (this.getValue() + this.getExtent());
	}
	/**
	 * 
	 * @param newPosition the desired position
	 */
	public void setSliderLeft(int newPosition) {
		int old = this.getValue();
		// We make sure that the new value is lower than the right rectangle's value or minimum 
		int new_value = Math.min(Math.max(getMinimum(),newPosition),getRightValue()+thumbWidth);
		int new_extent = old-new_value+getExtent();
		this.getModel().setRangeProperties(new_value,new_extent,getMinimum(),getMaximum(),getValueIsAdjusting());
	}

	/**
	 * Set the right value of the rangeSlider which is also the extent 
	 * @param RightValue
	 */
	public void setSliderRight(int RightValue) {
		if (this.getValue() < RightValue){
			this.setExtent(RightValue - this.getValue());
			this.getModel().setRangeProperties(this.getValue(),RightValue - this.getValue(),getMinimum(),getMaximum(),getValueIsAdjusting());

		}
		else{
			this.setExtent(this.getValue());
			this.getModel().setRangeProperties(this.getValue(),this.getValue(),getMinimum(),getMaximum(),getValueIsAdjusting());

		}
	}
	
}