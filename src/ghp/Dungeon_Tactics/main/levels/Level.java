package ghp.Dungeon_Tactics.main.levels;

import ghp.Dungeon_Tactics.main.Game;
import ghp.Dungeon_Tactics.main.tiles.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Level {
	
	// We will load in images as map files. We will assign tiles by the RGB numbers converted to hex of our tiles
	// Grass is 0,255,0 for example hex 00FF00
	// Stone is 128,128,128      hex 808080
	// Dirt 127,116, 63    hex 7F743F
	
	private int[][] tiles;
	private int w, h;
	
	
	public Level(BufferedImage levelImage){
		w = levelImage.getWidth();
		h = levelImage.getHeight();
		loadLevel(levelImage);
	}
	
	public void loadLevel(BufferedImage levelImage){
		// Initialize the array to the pixel width height of our level
		tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
		
		// Now we write the RGB values 
		for(int y = 0 ; y < h; y++){
			for(int x = 0 ; x < w; x++){
				Color color = new Color(levelImage.getRGB(x, y));
				//Converts RGB to hex
				String hex = String.format("%02x%02x%02x",color.getRed(),color.getGreen(),color.getBlue());
				
				// All letters must be lower case in Switch Statements.
				// Switch statements are like huge if statements.
				// Rock is   000000
				// Grass is  004400
				// Dirt is   829121
				// Wall is   123548
				// Tree is   751369
				// Wall Door 323548
				switch(hex){
				
				case "004400": // Grass Tile - id : 1 // Working
					tiles[x][y]=1;
					break;
				case "808080": // Stone tile - id : 2 Working
					tiles[x][y]=2;
					break;
				case "829121": // Dirt Tile id :  // Working
					tiles[x][y]=3;
					break;
				case "000000": // rock Tile id : 4 Working
					tiles[x][y]=4;
					break;
				case "123548": // wall Tile id : 5 // Working
					tiles[x][y]=5;
					break;
				case "751369": // tree Tile id : 6 // Working
					tiles[x][y]=6;
					break;
				case "323548": // Wall Door id :7 
					tiles[x][y]=7;
				default:
					tiles[x][y]=1;
					break;
				
				}
			}
		}
	}
	
	public void render(Graphics brush){
		int xo = Game.getPlayer().getX(); //nov 19
		int yo = Game.getPlayer().getY(); //nov 19
		
		// This will allow for dynamic allocation of memory instead of cramming it all into memory at once.
		// Don't ask me how - Wes.
		int x0 =Math.max(xo / (Game.TILESIZE * Game.SCALE),0);
		int y0 =Math.max(yo / (Game.TILESIZE * Game.SCALE),0);
		int x1 =Math.min((xo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE)+1 , w);
		int y1 =Math.min((yo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE)+1 , w);
		
		for(int y = y0; y <y1; y++){
			for(int x = x0; x<x1; x++){
				getTile(x,y).render(brush, x * Game.TILESIZE * Game.SCALE - xo, y * Game.TILESIZE * Game.SCALE - yo);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x >= w || y >= h)
			return Tile.wall;
		switch(tiles[x][y]){
		case 1:
			return Tile.grass;
		case 2:
			return Tile.stone;
		case 3:
			return Tile.dirt;
		case 4:
			return Tile.rock;
		case 5:
			return Tile.wall;
		case 6:
			return Tile.tree;
		case 7:
			return Tile.wallDoor;
		default:
			return Tile.grass;
		}
		
	}
}
