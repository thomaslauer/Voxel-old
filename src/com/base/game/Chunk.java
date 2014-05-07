package com.base.game;

import org.lwjgl.util.vector.Vector2f;

import com.base.game.blocks.BlockStone;


public class Chunk {
	public Block[][][] blocks;
	
	public Chunk(){
		blocks = new Block[16][16][16]; //not like normal, it is x, z, y

		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					blocks[x][z][y] = new BlockStone(x, z, y).setTexture(new Vector2f(1, 0));
				}
			}
		}
	}
	
	public void update(){
		
	}
	
	public void render(){
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					blocks[x][z][y].render();
				}
			}
		}
	}
	
	public Block[][][] getBlocks(){
		return blocks;
	}
}
