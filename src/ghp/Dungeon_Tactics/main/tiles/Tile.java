package ghp.Dungeon_Tactics.main.tiles;

import java.awt.Graphics;

import ghp.Dungeon_Tactics.main.Game;
import ghp.Dungeon_Tactics.main.gfx.ImageManager;

/*
 * An abstract class can not be instantiated. That means you can't create new instances of these types of classes.
 * 
 * The purpose of this type class is to serve as a base for making subclasses.
 * 
 * This class in particular will be the basis for all of our other tiles.
 */

public abstract class Tile {
	
	// Protected means only routines in this class can access these variables.
	protected ImageManager imgMan;
	
	public static Tile grass = new GrassTile(Game.getImageManager());
	public static Tile dirt = new DirtTile(Game.getImageManager());
	public static Tile rock = new RockTile(Game.getImageManager());
	public static Tile stone = new StoneTile(Game.getImageManager());
	public static Tile wallDoor = new WallDoorTile(Game.getImageManager());
	public static Tile wall = new WallTile(Game.getImageManager());
	public static Tile tree = new TreeTile(Game.getImageManager());
	
	public Tile (ImageManager imgMan){
		this.imgMan = imgMan;
	}
	
	public abstract void tick();
	public abstract void render(Graphics brush, int x , int y);
	public boolean isSolid(){
		return false;
	}
}
