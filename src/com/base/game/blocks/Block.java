package com.base.game.blocks;

import java.util.HashMap;

import org.lwjgl.util.vector.Vector2f;

public class Block {
	
	// HashMap to hold the blocks in their dataValues
	public static final HashMap<Integer, Block> blockMap = new HashMap<Integer, Block>();

	public int dataValue = 0;
	
	// texture for the particular block
	private static Vector2f texture = new Vector2f(0, 0);
	
	// render the block as a solid (not transparent)
	private boolean isSolid = true;
	
	// uses a mesh TODO: add meshes for different types of blocks
	private boolean renderMesh = true;
	
	public static Vector2f getTexture() {
		return texture;
	}

	public static void setTexture(Vector2f texture) {
		Block.texture = texture;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public boolean isRenderMesh() {
		return renderMesh;
	}

	public void setRenderMesh(boolean renderMesh) {
		this.renderMesh = renderMesh;
	}
}
