package com.base.game;

import org.lwjgl.util.vector.*;

import com.base.game.render.Window;

import static org.lwjgl.opengl.GL11.*;

public class Camera {
	
	public float sensitivity;
	public boolean cursor;
	public int captureKey;
	public int releaseKey;
	
	private Player player;
	
	public Camera(Player player){
		sensitivity = 0.05f;
		cursor = false;
		captureKey = Input.KEY_TAB;
		releaseKey = Input.KEY_ESCAPE;
		this.player = player;
	}
	
	public void update(){
		
		if(Input.getKey(releaseKey)){
			cursor = true;
		}
		if(Input.getKey(captureKey)){
			cursor = false;
		}
		
		Input.setCursor(cursor);
		
		if(!cursor){
			Vector2f deltaPos = Utils.subtractVectors(Input.getMousePosition(), Window.getCenter());
			player.rotation.y += deltaPos.x * sensitivity;
			player.rotation.x += deltaPos.y * sensitivity;
			Input.setMousePosition(Window.getCenter());
		}
	}
	
	public void useView(){
		glRotatef(player.rotation.x, 1, 0, 0);
		glRotatef(player.rotation.y, 0, 1, 0);
		glRotatef(player.rotation.z, 0, 0, 1);
		
		glTranslatef(player.position.x, player.position.y, player.position.z);
	}
}
