package com.n9mtq4.tetris.render;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Will on 11/5/14.
 */
public class Display extends Canvas implements Runnable {
	
	private int fps;
	private int WIDTH;
	private int HEIGHT;
	private int SCALE;
	private boolean running;
	private Screen screen;
	private Thread thread;
	public int[] pixels;
	private BufferedImage img;
	
	public Display(int width, int height, int scale) {
		
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		this.setSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		screen = new Screen(this);
		
		img = new BufferedImage(WIDTH * SCALE, HEIGHT * SCALE, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
	}
	
	public void start() {
		
		if (running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void stop() {
		
		if (!running) return;
		running = false;
		System.out.println("closing");
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	@Override
	public void run() {
		
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		
		while (running) {
			
//			game loop
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > secondsPerTick) {
				
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					
					System.out.println(frames + " fps");
					previousTime += 1000;
					fps = frames;
					frames = 0;
					
				}
				
			}
			
			if (ticked) {
				
			}
			render();
			frames++;
			ticked = false;
			
		}
		
		render();
		frames++;
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			
			createBufferStrategy(3);
			return;
			
		}
		
		for (int i = 0; i < getWIDTH() * getHEIGHT(); i++) {
			
			pixels[i] = getScreen().pixels[i];
			
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(getImg(), 0, 0, getHEIGHT() * SCALE, getHEIGHT() * SCALE, null);
		g.setColor(new Color(255, 255, 0));
		g.setFont(new Font("Verdana", Font.BOLD, 24));
		g.drawString(String.valueOf(getFps()), 0, 30);
		getScreen().render();
		g.dispose();
		bs.show();
		
	}
	
	public int getFps() {
		return fps;
	}
	
	public void setFps(int fps) {
		this.fps = fps;
	}
	
	public int getWIDTH() {
		return WIDTH;
	}
	
	public void setWIDTH(int WIDTH) {
		this.WIDTH = WIDTH;
	}
	
	public int getHEIGHT() {
		return HEIGHT;
	}
	
	public void setHEIGHT(int HEIGHT) {
		this.HEIGHT = HEIGHT;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public Screen getScreen() {
		return screen;
	}
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
}
