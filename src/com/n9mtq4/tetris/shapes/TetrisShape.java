package com.n9mtq4.tetris.shapes;

import java.awt.*;

/**
 * Created by Will on 11/5/14.
 */
public class TetrisShape {
	
	public boolean[] boxArray;
	public int x;
	public int y;
	public int width;
	public int height;
	public int scale;
	public Color color;
	
	public TetrisShape(Color c, int width, int height) {
		
		this.boxArray = new boolean[width * height];
		this.color = c;
		initBox();
		
	}
	
	public void initBox() {
		
	}
	
}
