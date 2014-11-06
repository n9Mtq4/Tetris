package com.n9mtq4.tetris;

import com.n9mtq4.tetris.render.Display;

import javax.swing.*;

/**
 * Created by Will on 11/5/14.
 */
public class TetrisWindow {
	
	private Display display;
	private JFrame frame;
	
	public TetrisWindow(Display display) {
		this.display = display;
		gui();
	}
	
	public void gui() {
		
		frame = new JFrame("Tetris");
		
		frame.add(display);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
