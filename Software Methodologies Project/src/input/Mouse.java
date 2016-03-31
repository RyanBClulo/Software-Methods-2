package input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import phisicsObjects.PlayerShip;

public class Mouse implements MouseListener{
	
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
	public void mousePressed(MouseEvent e) {
		PlayerShip.setShipLocation(new Point(e.getX(),e.getY()));
		PlayerShip.updateXY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}