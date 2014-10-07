package com.base.game;

import com.base.game.render.Camera;
import com.base.game.util.Time;

public class Player extends Entity{
	
	private Camera camera;
	
	public Player(float x, float z, float y) {
		super(x, z, y);
		camera = new Camera(this);
	}
	
	public void update(){
		if(Input.getKey(Input.KEY_W))
			moveZ((float) (0.005 * Time.getDeltaTime()));
		if(Input.getKey(Input.KEY_S))
			moveZ((float) (-0.005 * Time.getDeltaTime()));
		if(Input.getKey(Input.KEY_A))
			moveX((float) (0.005 * Time.getDeltaTime()));
		if(Input.getKey(Input.KEY_D))
			moveX((float) (-0.005 * Time.getDeltaTime()));
		if(Input.getKey(Input.KEY_SPACE))
			moveY((float) (-0.005 * Time.getDeltaTime()));
		if(Input.getKey(Input.KEY_LSHIFT))
			moveY((float) (0.005 * Time.getDeltaTime()));
		camera.update();
	}
	
	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
}
