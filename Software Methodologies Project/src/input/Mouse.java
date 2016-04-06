package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener,MouseMotionListener{
	
	public boolean rightPressed=false;
	
	public int mouseX,mouseY;
	
	@Override
	public void mousePressed(MouseEvent e) {
		rightPressed=true;
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		rightPressed=false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
}