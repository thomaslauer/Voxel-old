package com.base.game;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import com.base.game.render.TextureMap;
import com.base.game.render.Window;
import com.base.game.update.UpdateThread;

public class Game {
	public boolean isRunning;
	
	public static World world;
	
	public UpdateThread updateThread;
	
	public Game(int width, int height, String title){
		world = new World();
		Window.initWindow(width, height, title);
		Window.initProjection(70, (float)Window.getWidth()/(float)Window.getHeight(), 0.1f, 1000);
		TextureMap.init("TextureMap.png");
	}
	
	public void start(){
		world.addChunk(0, 0);
		world.getPlayer().position.z = -1;
		
		Runnable updateThreadJob = new UpdateThread(this);
		updateThread = new UpdateThread(updateThreadJob);
		updateThread.start();
		gameLoop();
	}
	
	public void gameLoop(){
		isRunning = true;
		
		long fps = 0;
		long lastFPS = Time.getTime();
		
		while(isRunning){
			input();
			render();
			Display.sync(60);
			
			if(Time.getTime() - lastFPS > 1000){
				System.out.println("FPS: " + fps);
				fps = 0;
				lastFPS += 1000;
			}
			fps++;
			
			if(Window.isCloseRequested())
				isRunning = false;
		}
		updateThread
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
