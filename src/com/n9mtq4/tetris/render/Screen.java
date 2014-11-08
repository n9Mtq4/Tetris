package com.n9mtq4.tetris.render;

import com.n9mtq4.tetris.game.TetrisBlock;
import com.n9mtq4.tetris.game.TetrisGame;

import java.awt.*;

/**
 * Created by Will on 11/5/14.
 */
public class Screen extends Render {
	
	private Display display;
	
	public Screen(Display d) {
		super(d.getWIDTH(), d.getHEIGHT());
		this.display = d;
	}
	
	public void render(Graphics g) {
		
		TetrisGame t = display.getGame();
		
		for (int i = 0; i < t.blocks.length; i++) {
			
			int x = i % display.getWIDTH();
			int y = i / display.getHEIGHT();
/*			if (t.getIndex(x, y) != i) {
				System.out.println("Error in code");
			}*/
			TetrisBlock b = t.blocks[i];
			g.fillRect(x * display.getSCALE(), y * display.getSCALE(), (x + 1) * display.getSCALE(), (y + 1) * display.getSCALE());
			
		}
		
		draw(this, 0, 0);
		
	}
	
	public int convert(Color color) {
		
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		
		return r << 16 | g << 8 | b;
		
	}
	
}
