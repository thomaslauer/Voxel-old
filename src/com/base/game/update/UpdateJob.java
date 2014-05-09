package com.base.game.update;

import com.base.game.*;

public class UpdateJob implements Runnable{
	
	public Game game;
	
	public UpdateJob(Game game){
		this.game = game;
	}
	public void run(){
		startUpdateLoop();
	}
	
	private void startUpdateLoop(){
		while(game.isRunning){
			game.update();
		}
	}
}
