package input;

import java.io.*;
import java.net.MalformedURLException;

import javax.sound.sampled.*;

public class Sound {
	
	private Clip clip;
	
    public Sound(String fileName) {
        // specify the sound to play
        // (assuming the sound can be played by the audio system)
        // from a wave File
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
             // load the sound into memory (a Clip)
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else {
                throw new RuntimeException("Sound: file not found: " + fileName);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }

    // play, stop, loop the sound clip
    }
    
    public void play(){
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }
    
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(){
            clip.stop();
        }
    
    public static void playSound(String fileName){
	    File url = new File(fileName);
	    Clip clip = null;
	    AudioInputStream ais = null;
	    
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		try {
			ais = AudioSystem.getAudioInputStream( url );
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		
	    try {
			clip.open(ais);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	    clip.start();
	}
}