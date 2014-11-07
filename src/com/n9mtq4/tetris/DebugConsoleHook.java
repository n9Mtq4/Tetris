package com.n9mtq4.tetris;

import com.n9mtq4.console.lib.ConsoleListener;
import com.n9mtq4.console.lib.events.*;
import com.n9mtq4.tetris.render.Display;

/**
 * Created by Will on 11/6/14.
 */
public class DebugConsoleHook extends ConsoleListener {
	
	private Display d;
	
	public DebugConsoleHook(Display d) {
		this.d = d;
	}
	
	@Override
	public void onAddition(AdditionActionEvent additionActionEvent) {
		
	}
	
	@Override
	public void onEnable(EnableActionEvent enableActionEvent) {
		
	}
	
	@Override
	public void actionTab(TabActionEvent tabActionEvent) {
		
	}
	
	@Override
	public void actionPreformed(ConsoleActionEvent e) {
		
		if (e.getCommand().getArg(0).equalsIgnoreCase("tetris")) {
			
			
			
		}
		
	}
	
	@Override
	public void onDisable(DisableActionEvent disableActionEvent) {
		
	}
	
	@Override
	public void onRemoval(RemovalActionEvent removalActionEvent) {
		
	}
	
}
