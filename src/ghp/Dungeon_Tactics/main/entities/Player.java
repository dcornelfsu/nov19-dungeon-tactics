package ghp.Dungeon_Tactics.main.entities;
//Written By Wesley Leach on 9-16
import java.awt.Graphics;


import ghp.Dungeon_Tactics.main.Game;
import ghp.Dungeon_Tactics.main.gfx.ImageManager;


public class Player  {
	
	private int x,y ,xo,yo,xs,ys;
	private ImageManager imgMan;
	public static int HITPOINTS = 10;
	public static int BaseDamge = 10;
	public boolean up = false, down = false, leftTurn = false, rightTurn = false;
	
	// Players movement allotment.
	private final int SPEED = Game.TILESIZE;
	
	public Player (int x, int y, ImageManager imgMan){
		this.x=x;
		this.y=y;
		xo=0;
		yo=0;
		xs=0;
		ys=0;
		this.imgMan=imgMan;
	}
	
	public void tick(){
		xs=0;
		ys=0;
		// Player movement is located here.
		if(up){
			ys -=SPEED;
		}else if(down){
			ys +=SPEED;
		}
		if(leftTurn){
			xs -= SPEED;
		}else if(rightTurn){
			xs += SPEED;
		}
		move (xs,ys);
	}
	
	public void move( int xs, int ys){
		if(!collision(xs,0)){
			xo += xs;
		}
		if(!collision (0,ys)){
			yo +=ys;
		}
	}
	
	// checks if a move is valid
	private boolean collision (int xs, int ys){
		// Checks top left corner for collision
		if(Game.getLevel().getTile((xo +xs +x ) / (Game.TILESIZE * Game.SCALE) , (yo+ys + y) / (Game.TILESIZE * Game.SCALE)).isSolid())
			return true;
		// Checks  top right corner for collision
		if(Game.getLevel().getTile((xo +xs +x + Game.TILESIZE * Game.SCALE -1 ) / (Game.TILESIZE * Game.SCALE) , (yo + ys + y) / (Game.TILESIZE * Game.SCALE)).isSolid())
			return true;
		// Checks bottom right
		if(Game.getLevel().getTile((xo +xs +x + Game.TILESIZE * Game.SCALE -1 ) / (Game.TILESIZE * Game.SCALE) , (yo + ys + y + Game.TILESIZE * Game.SCALE -1) / (Game.TILESIZE * Game.SCALE)).isSolid())
			return true;
		// Checks bottom left
		if(Game.getLevel().getTile((xo +xs +x ) / (Game.TILESIZE * Game.SCALE) , (yo+ys + y + Game.TILESIZE * Game.SCALE -1) / (Game.TILESIZE * Game.SCALE)).isSolid())
			return true;
		return false;
	}

	public void render(Graphics brush){
		/* 
		 * This draws an image to the screen. The first parameter is the actual image that will be drawn
		 * So we crop out a piece of our sprite sheet to be displayed. The x and y coordinate of the image
		 * are the next parameters that we pass in (0,0) is at the top left. The next two parameters have to
		 * do with scaling. They help to ensure that the games scale is maintained. The last parameter is set to
		 * null because that is something called an observer...I have no idea what that is so I set it to null.
		 */
		brush.drawImage(imgMan.player, x , y , Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE,null);
	}
	
	// Get Methods
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	

}
