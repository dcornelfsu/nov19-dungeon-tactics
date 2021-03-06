package ghp.Dungeon_Tactics.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		// This area is where key press events are handled
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Game.getPlayer().up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Game.getPlayer().down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Game.getPlayer().leftTurn = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Game.getPlayer().rightTurn = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// This area is where key release events are handled
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Game.getPlayer().up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Game.getPlayer().down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Game.getPlayer().leftTurn = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Game.getPlayer().rightTurn = false;
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
