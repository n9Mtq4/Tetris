package com.n9mtq4.tetris.shapes;

import java.awt.*;

/**
 * Created by Will on 11/5/14.
 */
public class Line4 extends TetrisShape {
	
	public Line4() {
		
		super(new Color(0, 0, 255), 1, 4);
		
	}
	
	@Override
	public void initBox() {
		
		for (boolean b : boxArray) {
			b = true;
		}
		
	}
	
}
