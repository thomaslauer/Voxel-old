package com.base.game.update;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.base.game.*;
import com.base.game.render.Window;

public class UpdateJob implements Runnable{
	
	public Game game;
	
	
	
	public UpdateJob(Game game){
		this.game = game;
	}
	public void run(){
		try {
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Input.setMousePosition(Window.getCenter());
		System.out.println("starting update loop...");
		startUpdateLoop();
	}
	
	private long lastLoopTime = Time.getTime();
	private final int TARGET_FPS = 60;
	private final long OPTIMAL_TIME = Time.SECOND / TARGET_FPS;
	
	private void startUpdateLoop(){
		
		@SuppressWarnings("unused")
		long fps = 0;
		long lastFPS = Time.getTime();
		
		int tickCount = 0;
		
		while(game.isRunning){
			game.input();
			game.update();
			
			tickCount++;
			if(tickCount >= 3){
				game.tick();
				tickCount = 0;
			}
			
			
			long now = Time.getTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double)OPTIMAL_TIME);
			
			Time.setDeltaTime((long) delta);
			
			game.tick();
			
			if(Time.getTime() - lastFPS > 1000){
				System.out.println("TPS: " + fps);
				fps = 0;
				lastFPS += 1000;
			}
			fps++;
			
			try {
				Thread.sleep((lastLoopTime-Time.getTime() + OPTIMAL_TIME)/1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
