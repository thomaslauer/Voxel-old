package com.base.game.blocks;

import org.lwjgl.util.vector.Vector2f;

import com.base.game.Block;

public class BlockStone extends Block{

	public BlockStone(long x, long y, long z) {
		super(x, y, z);
		setTexture(new Vector2f(0, 1));
	}
}
