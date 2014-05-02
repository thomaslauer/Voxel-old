package com.base.game;

import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;

import com.base.game.render.Render;

public abstract class Block {
	public Vector3f position;
	
	public Texture texture;
	
	public Block(long x, long y, long z){
		this.texture = Utils.loadTexture("PNG", "stone.png");
		position = new Vector3f(x, y, z);
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void setTexture(Texture texture){
		this.texture = texture;
	}
	
	public Texture getTexture(){
		return texture;
	}

	public void render() {
		Render.block(this);
	}
}
