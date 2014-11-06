package com.n9mtq4.tetris.game;

import com.n9mtq4.tetris.render.Display;

import java.awt.*;

/**
 * Created by Will on 11/6/14.
 */
public class TetrisGame {
	
	private Display display;
	public TetrisBlock[] blocks;
	
	public TetrisGame(Display display) {
		
		this.display = display;
		populateBlocks();
		
	}
	
	public void populateBlocks() {
		
		blocks = new TetrisBlock[(display.getHEIGHT() * display.getBlocksperblocks()) * (display.getWIDTH() * display.getBlocksperblocks())];
		for (TetrisBlock b : blocks) {
			b = new TetrisBlock();
			b.color = Color.GREEN;
		}
		
	}
	
	public int getIndex(int x, int y) {
		
		return x + y;
		
	}
	
}
