package slider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class RangeSliderUI extends BasicSliderUI{

	private Rectangle left, right;
	RangeSlider rangeSlider;
	enum States {IDLE,CLICK_RIGHT_SIDE,CLICK_LEFT_SIDE,CLICK_RECT_LEFT,CLICK_RECT_RIGHT};
	States state;

	
	/* the constructor 
	 * we just initialize every variable*/
	
	public RangeSliderUI(RangeSlider rangeSlider) {
		super(rangeSlider);
		this.rangeSlider= rangeSlider;
		state = States.IDLE;
		left = new Rectangle(rangeSlider.getValue(),0,rangeSlider.thumbWidth,rangeSlider.thumbHeight);
		right = new Rectangle(rangeSlider.getRightValue(),0,rangeSlider.thumbWidth,rangeSlider.thumbHeight);	
	}
	
	@Override
	protected TrackListener createTrackListener(JSlider slider) {
		return new RangeSliderEvent();
	}
	
	/* this class implements all the events with the clics ! */
	private class RangeSliderEvent extends TrackListener{

		States getPosition(MouseEvent e) {
			if(right.contains(e.getPoint())){
				return States.CLICK_RECT_RIGHT;
			}else if(left.contains(e.getPoint())){
				return States.CLICK_RECT_LEFT;
			}else if(e.getX()<left.x){
				return States.CLICK_LEFT_SIDE;
			}else if(e.getX()>right.x){
				return States.CLICK_RIGHT_SIDE;
			}else{
				/*if we clic on the middle. nothing happens */
				return States.IDLE;
			}
		}

	
		@Override
		public void mousePressed(MouseEvent e) {
			state = getPosition(e);
			switch(state){
			case CLICK_LEFT_SIDE:
				rangeSlider.setSliderLeft(e.getX());
				break;
			case CLICK_RIGHT_SIDE:
				rangeSlider.setSliderRight(e.getX());
				break;
			default:
				break;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			switch(state) {
			case CLICK_RECT_LEFT:
				rangeSlider.setSliderLeft(e.getX());
				break;
			case CLICK_RECT_RIGHT:
				rangeSlider.setSliderRight(e.getX());
				break;
			default:
				break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			/*we come back to first state */
			state = States.IDLE;
		}

	}
	
	// To add a thumb
	@Override
	public void installUI(JComponent component) {
		super.installUI(component);
	}

	// to draw the two thumbs
	@Override
	public void paint(Graphics g, JComponent c) {
		TestUI.setvalUI();
		super.paint(g, c);
	}

	@Override
	public void paintThumb(Graphics g) {
		Graphics2D g2D = (Graphics2D) g.create();

		left.x = rangeSlider.getValue();
		right.x = rangeSlider.getRightValue();

		// middle
		g2D.setColor(Color.RED);
		g2D.fillRect(left.x+left.width,left.height/4,right.x-left.x,left.height/2);
		//left cursor
		g2D.setColor(Color.black);
		g2D.fillRect(left.x, left.y, left.width, left.height);
		//right cursor
		g2D.setColor(Color.black);
		g2D.fillRect(right.x,right.y,right.width,right.height);
		
		g2D.dispose();
	}


	
}