package com.base.game;

import org.lwjgl.util.vector.Vector2f;


import org.lwjgl.util.vector.Vector3f;

import com.base.game.blocks.BlockStone;
import com.base.game.render.Render;


public class Chunk {
	public Block[][][] blocks;
	
	public Vector2f position;
	
	
	public Chunk(long x, long z){
		
		this.position = new Vector2f(x, z);
		
		blocks = new Block[16][16][16]; //not like normal, it is x, z, y
		
		
		for(int bx = 0; bx < 16; bx++){
			for(int bz = 0; bz < 16; bz++){
				for(int by = 0; by < 16; by++){
					blocks[bx][bz][by] = new BlockStone(bx, bz, by);
					System.out.println("x: " + bx + " z: " + bz + " y: " + by);
				}
			}
		}
	}
	
	public void update(){
	}
	
	public void render(){
		Render.chunk(this);
	}
	
	public Block getLocalBlock(Vector3f localPosition){
		return blocks[(int) localPosition.x][(int) localPosition.z][(int) localPosition.y];
	}
	
	public Block[][][] getBlocks(){
		return blocks;
	}
}
