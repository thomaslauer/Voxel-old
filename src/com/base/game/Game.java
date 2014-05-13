package com.base.game;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import com.base.game.blocks.Block;
import com.base.game.render.Mesh;
import com.base.game.render.Shader;
import com.base.game.render.TextureMap;
import com.base.game.render.Window;
import com.base.game.render.meshes.MeshBlock;
import com.base.game.update.UpdateJob;
import com.base.game.util.ResourceLoader;

public class Game {
	public boolean isRunning = true;
	
	public static World world;
	
	public static Shader shader;
	private static Mesh mesh;
	private Block tempBlock;
	
	
	public Game(int width, int height, String title){
		world = new World();
		Window.initWindow(width, height, title);
		Window.initProjection(70, (float)Window.getWidth()/(float)Window.getHeight(), 0.1f, 1000);
		
		//start mesh testing
		mesh = new MeshBlock();
		shader = new Shader();
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vert"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.frag"));
		shader.compileShader();
		
		TextureMap.init("TextureMap.png");
	}
	
	public void start(){
		world.addChunk(0, 0);
		world.getPlayer().position.z = -5;
		
		UpdateJob updateJob = new UpdateJob(this);
		Thread updateThread = new Thread(updateJob);
		updateThread.start();
		
		gameLoop();
	}
	
	public void gameLoop(){
		isRunning = true;
		
		long fps = 0;
		long lastFPS = Time.getTime();
		
		while(isRunning){
			render();
			
			Display.setVSyncEnabled(true);
			
			if(Time.getTime() - lastFPS > 1000){
				System.out.println("FPS: " + fps);
				fps = 0;
				lastFPS += 1000;
			}
			fps++;
			
			if(Window.isCloseRequested())
				isRunning = false;
		}
	}
	
	public void input(){
		Input.update();
	}
	
	public void update(){
		world.update();
		world.player.update();
	}
	
	public void tick(){
		world.tick();
	}
	
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		world.getPlayer().getCamera().useView();
		shader.bind();
		world.render();
		
//		mesh.draw(); //draw the mesh
		Window.update();
	}
}
