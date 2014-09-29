package com.base.game.blocks;

import org.lwjgl.util.vector.Vector2f;

import com.base.game.util.BlockDoubleHashMap;
import com.base.game.blocks.material.Material;

public class Block {
	
	public static BlockDoubleHashMap blockMap = new BlockDoubleHashMap();
	
	public int dataValue;
	public String name;
	
	public Material material;
	
	// texture for the particular block
	private static Vector2f texture = new Vector2f(0, 0);
	
	public Block(Material material)
	{
		this.material = material;
	}
	
	public static void registerBlocks()
	{
		blockMap.addBlock(0, "air", new BlockAir());
		blockMap.addBlock(1, "stone", new Block(Material.stone));
	}
	
	public static Vector2f getTexture() {
		return texture;
	}

	public static void setTexture(Vector2f texture) {
		Block.texture = texture;
	}
}
