package gameobjectLists;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import gamestates.GameState;
import gamestates.Star;
import main.MainWindow;

public class Stars {
	
	private ArrayList<Star> starList;
	private Random r = new Random();
	private MainWindow game;
	
	public Stars(MainWindow game){
		this.game=game;
		starList = new ArrayList<Star>();
		for(int x=0 ; x<game.getWidth() ; x++){
			for(int y=0 ; y<game.getHeight() ; y++){
				if(r.nextInt(7001)==7000)addStar(new Star(game,x,y));
			}
		}
	}
	
	public void updateVariables(){
		
		if(GameState.getCurrentGameState()!=game.pauseState())addStar(new Star(game,(int)r.nextInt(game.getWidth()),(int)-10));
		
		for( int i=0 ; i<starList.size() ; i++ ){
			if(starList.get(i)!=null){
				if(starList.get(i).getY()>(game.getHeight()+10))
					removeStar(starList.get(i));
				else
					starList.get(i).updateVariables();
			}
		}
	}
	
	public void draw(Graphics g){
		for( int i=0 ; i<starList.size() ; i++ ){
			starList.get(i).draw(g);
		}
	}
	
	public void addStar(Star star){
		starList.add(star);
	}
	
	public void removeStar(Star star){
		starList.remove(star);
	}
}
