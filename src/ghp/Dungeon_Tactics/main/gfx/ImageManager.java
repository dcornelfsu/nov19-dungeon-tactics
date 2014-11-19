package ghp.Dungeon_Tactics.main.gfx;

import ghp.Dungeon_Tactics.main.Game;

import java.awt.image.BufferedImage;

public class ImageManager {
	
	public BufferedImage player, grassTile, dirtTile, stoneTile,rockTile,wallTile,treeTile,wallDoorTile;
	
	public ImageManager (SpriteSheet sheet){
		// crop(column, row, pixel width, pixel height)
		player = sheet.crop(15,0 , Game.TILESIZE, Game.TILESIZE);
		grassTile = sheet.crop(1,1,Game.TILESIZE,Game.TILESIZE);
		dirtTile = sheet.crop(0,19,Game.TILESIZE,Game.TILESIZE);
		stoneTile = sheet.crop(7,17,Game.TILESIZE,Game.TILESIZE);
		rockTile = sheet.crop(6,17,Game.TILESIZE,Game.TILESIZE);
		wallTile = sheet.crop(3,3,Game.TILESIZE,Game.TILESIZE);
		treeTile = sheet.crop(4,18,Game.TILESIZE,Game.TILESIZE);
		wallDoorTile = sheet.crop(5,0,Game.TILESIZE,Game.TILESIZE);
	}

}
