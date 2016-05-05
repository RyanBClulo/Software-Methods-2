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
	public static final Font titleFont = new Font("Lucida Console",Font.ITALIC, 64);
	
	//Font used for heading of Submenus like the pause screen and Continue screen.
	public static final Font subMenuTitle = new Font("Lucida Console",Font.ITALIC, 40);
	
	public static final Font subMenuTitle2 = new Font("Lucida Console",Font.ITALIC, 32);
	
	//Font used for menuText
	public static final Font menuFont = new Font("Helvetica", Font.BOLD, 36);
	
	public static final Font subMenuFont = new Font("Helvetica", Font.BOLD, 26);
	
	public static final Font subMenuFont2 = new Font("Helvetica", Font.PLAIN, 26);
	
	//Font used for in-game HUD
	public static final Font gameFont = new Font("Helvetica", Font.BOLD, 20);
	
	//Font used for game timer.
	public static final Font timerFont = new Font("Helveticai",Font.BOLD,80);
}