package com.base.game.blocks;

import org.lwjgl.util.vector.Vector2f;

public abstract class Block {
	public static Vector2f texture = new Vector2f(0, 0);
	
	public static boolean isSolid = true;
	
	public static int dataValue;
}
