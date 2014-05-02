package com.base.game;

import org.lwjgl.util.vector.Vector3f;

public abstract class Entity {
	public Vector3f position;
	public Vector3f rotation;
	
	public Entity(float x, float z, float y){
		this(new Vector3f(x, y, z));
	}
	
	public Entity(float x, float z, float y, float rx, float rz, float ry){
		this(new Vector3f(x, y, z), new Vector3f(rx, ry, rz));
	}
	
	public Entity(Vector3f position){
		this(position, new Vector3f(0, 0, 0));
	}
	
	public Entity(Vector3f position, Vector3f rotation){
		this.position = position;
		this.rotation = rotation;
	}
	
	public void input(){}
	public void update(){}
	public void render(){}
	
	public void moveZ(float amt){
		position.z += amt * Math.sin(Math.toRadians(rotation.y + 90));
		position.x += amt * Math.cos(Math.toRadians(rotation.y + 90));
	}
	
	public void moveX(float amt){
		position.z += amt * Math.sin(Math.toRadians(rotation.y));
		position.x += amt * Math.cos(Math.toRadians(rotation.y));
	}
	public void moveY(float amt){
		position.y += amt;
	}
}
