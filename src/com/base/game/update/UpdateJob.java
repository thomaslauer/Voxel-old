package com.base.game.update;

import com.base.game.Game;
import com.base.game.Time;

public class UpdateJob {

	public Game game;
	
	public int ticksPerSecond = 20;
	public float tickTime = (float)1/ticksPerSecond;
	
	public UpdateJob(Game game) {
		this.game = game;
	}

	public void run(){
		startUpdateLoop();
	}
	
	public void startUpdateLoop(){
		
	}
}
