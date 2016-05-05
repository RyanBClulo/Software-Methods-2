package graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 
 * @author Franco Reda
 *
 */
public class TextSettings 
{	
	
	//Font used for Game Heading
	public static final Font titleFont = new Font("Lucida Console",Font.BOLD, 50);
	
	//Font used for heading of Submenus like the pause screen and Continue screen.
	public static final Font subMenuTitle = new Font("Tahoma",Font.BOLD, 30);
	
	//Font used for menuText
	public static final Font menuFont = new Font("MonoType", Font.PLAIN, 26);
	
	//Font used for in-game HUD
	public static final Font gameFont = new Font("Orator Std", Font.BOLD, 20);
	
	//Font used for game timer.
	public static final Font timerFont = new Font("Orator Std",Font.BOLD,80);
}