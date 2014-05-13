package com.base.game.blocks;

import org.lwjgl.util.vector.Vector2f;

public class BlockStone extends Block{
	
	static {
		dataValue = 1;
	}
	
	public BlockStone(long x, long y, long z) {
		super(x, y, z);
		setTexture(new Vector2f(0, 1));
	}
}
