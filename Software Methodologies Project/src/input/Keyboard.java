package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Keyboard implements KeyListener{
	
	private boolean moveUp =false;
	private boolean moveDown =false;
	private boolean moveLeft =false;
	private boolean moveRight =false;
	private boolean shoot = false;
	private boolean esc = false;
	private boolean alt = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up (Moves the ship in the positive direction)
	        	moveUp=true;
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down
	        	moveDown=true;
	        	break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	moveLeft=true;
	            break;
	        case KeyEvent.VK_RIGHT:
	            // handle right
	        	moveRight=true;
	            break;
	        case KeyEvent.VK_W:
	            // handle up (Moves the ship in the positive direction)
	        	moveUp=true;
	            break;
	        case KeyEvent.VK_S:
	            // handle down
	        	moveDown=true;
	            break;
	        case KeyEvent.VK_A:
	            // handle left
	        	moveLeft=true;
	            break;
	        case KeyEvent.VK_D:
	            // handle right
	        	moveRight=true;
	            break;
	        case KeyEvent.VK_SPACE:
	        	//handle space (shooting)
	        	shoot = true;
	        	try {
					playSound("shot.wav");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	break;
	        case KeyEvent.VK_M:
	        	alt = true;
	        	break;
	        case KeyEvent.VK_ESCAPE:
	        	esc=true;
	        	break;
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up (Moves the ship in the positive direction)
	        	moveUp=false;
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down
	        	moveDown=false;
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	moveLeft=false;
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	moveRight=false;
	            break;
	        case KeyEvent.VK_W:
	            // handle up (Moves the ship in the positive direction)
	        	moveUp=false;
	            break;
	        case KeyEvent.VK_S:
	            // handle down
	        	moveDown=false;
	            break;
	        case KeyEvent.VK_A:
	            // handle left
	        	moveLeft=false;
	            break;
	        case KeyEvent.VK_D:
	            // handle right
	        	moveRight=false;
	            break;
	        case KeyEvent.VK_SPACE :
	        	// handle space (shooting)
	        	shoot=false;
	        	break;
	        case KeyEvent.VK_M:
	        	alt = false;
	        	break;
	        case KeyEvent.VK_ESCAPE:
	        	esc=false;
	    }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public static void playSound(String fileName) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException{
	    File url = new File(fileName);
	    Clip clip = AudioSystem.getClip();

	    AudioInputStream ais = AudioSystem.
	        getAudioInputStream( url );
	    clip.open(ais);
	    clip.start();
	}
	
	public boolean up(){
		return moveUp;
	}
	
	public boolean down(){
		return moveDown;
	}
	
	public boolean left(){
		return moveLeft;
	}
	
	public boolean right(){
		return moveRight;
	}
	
	public boolean space(){
		return shoot;
	}
	
	public boolean esc(){
		return esc;
	}
	
	public boolean alt(){
		return alt;
	}
}