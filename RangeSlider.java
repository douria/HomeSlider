import javax.swing.event.ChangeListener;
import javax.swing.JComponent;
public class RangeSlider extends JComponent implements RangeSliderI {

	private int maxValue;
	private int minValue;
	private int value;
	private int extent;
	private boolean isAdjusting;
	
	
	public int getMaxValue() {
		// TODO Auto-generated method stub
		return maxValue;
	}

	public int getMinValue() {
		// TODO Auto-generated method stub
		return minValue;
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public int getExtent() {
		// TODO Auto-generated method stub
		return extent;
	}

	public void setMaxValue(int newMaxValue) {
		// TODO Auto-generated method stub
		maxValue = newMaxValue;
	}

	public void setMinValue(int newMinValue) {
		// TODO Auto-generated method stub
		minValue = newMinValue;
	}

	public void setValue(int newValue) {
		// TODO Auto-generated method stub
		value = newValue;
	}

	public void setExtent(int newExtent) {
		// TODO Auto-generated method stub
		extent = newExtent;
	}

	public boolean getValueIsAdjusting() {
		// TODO Auto-generated method stub
		return isAdjusting;
	}

	public void setValueIsAdjusting(boolean b) {
		// TODO Auto-generated method stub
		isAdjusting = b;
	}

	public void setRangeProperties(int value, int extent, int minValue,
			int maxValue, boolean adjusting) {
		// TODO Auto-generated method stub
		setMinValue(minValue);
		setMaxValue(maxValue);
		setValue(value);
		setExtent(extent);
		setValueIsAdjusting(adjusting);
	}

	public void addChangeListener(ChangeListener c) {
		// TODO Auto-generated method stub

	}

	public void removechangeListener(ChangeListener c) {
		// TODO Auto-generated method stub

	}

}
