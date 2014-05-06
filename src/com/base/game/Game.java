package com.base.game;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import com.base.game.render.Window;

public class Game {
	public boolean isRunning;
	
	public World world;
	
	public Game(int width, int height, String title){
		Window.initWindow(width, height, title);
		Window.initProjection(70, (float)Window.getWidth()/(float)Window.getHeight(), 0.1f, 1000);
	}
	
	public void start(World world){
		this.world = world;
		world.addChunk(0, 0);
		world.getPlayer().position.z = -10;
		gameLoop();
	}
	
	public void gameLoop(){
		isRunning = true;
		
		while(isRunning){
			input();
			update();
			render();
			Display.sync(60);
			
			if(Window.isCloseRequested())
				isRunning = false;
		}
	}
	
	public void input(){
		Input.update();
	}
	
	public void update(){
		world.update();
	}
	
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		world.getPlayer().getCamera().useView();
		world.render();
		Window.update();
	}
}
