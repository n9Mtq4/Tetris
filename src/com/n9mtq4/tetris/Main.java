package com.n9mtq4.tetris;

import com.n9mtq4.tetris.render.Display;

/**
 * Created by Will on 11/5/14.
 */
public class Main {
	
	public static Display display;
	public static TetrisWindow window;
	
	public static void main(String[] args) {
		
		display = new Display(20, 40, 10);
		window = new TetrisWindow(display);
		display.start();
		
	}
	
}
