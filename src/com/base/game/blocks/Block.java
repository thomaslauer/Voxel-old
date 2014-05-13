package com.base.game.blocks;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.base.game.render.Mesh;
import com.base.game.render.Render;
import com.base.game.render.meshes.MeshBlock;

public abstract class Block {
	public Vector3f position;
	
	public Vector2f texture = new Vector2f(0, 0);
	public boolean isSolid = true;
	
	public boolean doRender = true;
	
	public Mesh mesh;
	
	
	public static int dataValue;
	
	
	public Block(long x, long y, long z){
		position = new Vector3f(x, y, z);
		mesh = new MeshBlock();
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void render() {
		Render.block(this);
	}
	
	public Block setTexture(Vector2f textureCoords){
		texture = textureCoords;
		return this;
	}
	public Vector2f getTexture(){
		return texture;
	}
}
