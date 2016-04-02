package display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
	
	private JFrame frame=null;
	private Canvas canvas;
	
	public Display(){
		
	}
	
	public void createDisplay(){
		if(frame==null){
			frame = new JFrame("SM - X");								// set the title of the screen;
			frame.setSize(800,950);							// set the width and height of the screen;
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// set the window to close and the close button is pressed;
			frame.setResizable(false);								// set the window to not resizable so the size of the screen can be changed during the game;
			frame.setLocationRelativeTo(null);						// set the screen to open right in the middle of the computer screen;
			frame.setVisible(true);									// makes the window visible;
			
			canvas = new Canvas();									//Create a new canvas object;
			canvas.setPreferredSize(new Dimension(800,950));	//
			canvas.setMaximumSize(new Dimension(800,950));		//Set the size of the canvas to the window width and height and fix it to that size;
			canvas.setMinimumSize(new Dimension(800,950));		//
			canvas.setFocusable(false);
			
			frame.add(canvas);										// add the canvas to the window frame;
			frame.pack();											// makes the frame pack all the information together
		}
	}
	
	public void close(){
		frame.dispose();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
}