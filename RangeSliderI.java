import javax.swing.event.*;

public interface RangeSliderI {

	// les getters et setters des valeurs max et min ainsi que des valeurs courantes des deux sliders.
	
	// ces getters permettent de recuperer les valeurs max et min des sliders.
    int getMaxValue();
    int getMinValue();
    int getValue();
    int getExtent();
      
    // ces setters permettent de mettre a jour les valeurs max et min des sliders. 
    void setMaxValue(int newMaxValue);
    void setMinValue(int newMinValue);
    void setValue(int newValue);
    void setExtent(int newExtent);
      
	// cette fonction permet de detecter les ajustement et changements du slider et une fois qu"on arrete de cliquer alors le slider est mis a jour. 
      
    boolean getValueIsAdjusting();
    void setValueIsAdjusting(boolean b);
      
    void setRangeProperties(int value, int extent, int minValue, int maxValue, boolean adjusting);
      
    void addChangeListener(ChangeListener c);
    void removechangeListener(ChangeListener c);
	
}
