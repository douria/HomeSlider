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

	private Rectangle gauche, droite;
	RangeSlider self;
	enum States {IDLE,CLICK_RIGHT_SIDE,CLICK_LEFT_SIDE,CLICK_MIDDLE,CLICK_RECT_LEFT,CLICK_RECT_RIGHT};
	States state;
	
	private int oldValue = 0;
	
	public RangeSliderUI(RangeSlider o) {
		super(o);
		this.self = o;
		state = States.IDLE;
		gauche = new Rectangle(self.getValue(),0,self.tickWidth,self.tickHeight);
		droite = new Rectangle(self.getUpValue(),0,self.tickWidth,self.tickHeight);	
	}

	@Override
	protected TrackListener createTrackListener(JSlider slider) {
		return new RangeSliderEvent();
	}
	
	// To add a thumb
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
	}

	// to draw the two thumb
	@Override
	public void paint(Graphics g, JComponent c) {
		TestUI.setvalUI();// update values min/value/extent/max disp 
//		super.paint(g, c);
// appel à paintThunb dans le super...
		super.paint(g, c);
	}

	@Override
	public void paintThumb(Graphics g) {
		Graphics2D g2D = (Graphics2D) g.create();

		gauche.x = self.getValue();
		droite.x = self.getUpValue();

		// middle
		g2D.setColor(Color.ORANGE);
		g2D.fillRect(gauche.x+gauche.width,gauche.height/4,droite.x-gauche.x,gauche.height/2);
		
		// left cursor
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fillRect(gauche.x, gauche.y, gauche.width, gauche.height);
		
		//right cursor
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fillRect(droite.x,droite.y,droite.width,droite.height);


		g2D.dispose();
	}


	private class RangeSliderEvent extends TrackListener{

		States getPosition(MouseEvent e) {
			if(droite.contains(e.getPoint())){
				return States.CLICK_RECT_RIGHT;
			}else if(gauche.contains(e.getPoint())){
				return States.CLICK_RECT_LEFT;
			}else if(e.getX()<gauche.x){
				return States.CLICK_LEFT_SIDE;
			}else if(e.getX()>droite.x){
				return States.CLICK_RIGHT_SIDE;
			}else{
				return States.CLICK_MIDDLE;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			state = States.IDLE;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			state = getPosition(e);
			switch(state){
			case CLICK_LEFT_SIDE:
				self.setSliderGauche(e.getX());
				break;
			case CLICK_RIGHT_SIDE:
				self.setSliderDroite(e.getX());
				break;
			case CLICK_MIDDLE :
				// on cherche le bord le plus proche, et on le déplace à la position voulue
//				if((e.getX()-gauche.x)<((droite.x-gauche.x)/2)) {
//					self.setSliderGauche(e.getX());
//				}else {
//					self.setSliderDroite(e.getX());
//				}
				oldValue = e.getX();
				break;
			default:
				break;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			switch(state) {
			case CLICK_MIDDLE:
				// on cherche le bord le plus proche, et on ajuste le rect voulu
//				if((e.getX()-gauche.x)<((droite.x-gauche.x)/2)) {
//					self.setSliderGauche(e.getX());
//				}else {
//					self.setSliderDroite(e.getX());
//				}
				int newValue = e.getX();
				int offset = newValue - oldValue;
				self.moveRange(offset);
				oldValue = newValue;
				break;
			case CLICK_RECT_LEFT:
				self.setSliderGauche(e.getX());
				break;
			case CLICK_RECT_RIGHT:
				self.setSliderDroite(e.getX());
				break;
			default:
				break;
			}
		}

	}
}