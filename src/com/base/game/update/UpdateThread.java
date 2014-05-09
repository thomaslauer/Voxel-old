package com.base.game.update;

import com.base.game.Game;
import com.base.game.Time;

public class UpdateThread implements Runnable{
	
	public Game game;
	
	public int ticksPerSecond = 20;
	public float tickTime = (float)1/ticksPerSecond;
	
	public UpdateThread(Game game) {
		this.game = game;
	}

	public void run(){
		startUpdateLoop();
	}
	
	public void startUpdateLoop(){
		long fps = 0;
		long lastFPS = Time.getTime();
		while(isRunning){
			game.update();
			
			

			if(Time.getTime() - lastFPS > 1000){
				System.out.println("TPS: " + fps);
				fps = 0;
				lastFPS += 1000;
			}
			fps++;
			
		}
	}
	
	public boolean isRunning;
	public void setIsRunning(boolean arg1){
		isRunning = arg1;
	}
	public boolean getIsRunning(){
		return isRunning;
	}
}
