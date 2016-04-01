package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import window.MainWindow;

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
		MainWindow.getPlayerShip().setShipLocation(e.getX(),e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}