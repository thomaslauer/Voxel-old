package com.base.game.blocks;

import com.base.game.Block;
import com.base.game.Utils;

public class BlockStone extends Block{

	public BlockStone(long x, long y, long z) {
		super(x, y, z);
		this.texture = Utils.loadTexture("PNG", "stone.png");
	}

}
