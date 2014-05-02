package com.base.game;

import com.base.game.blocks.BlockStone;


public class Chunk {
	public Block[][][] blocks;
	
	public Chunk(){
		blocks = new Block[16][16][16]; //not like normal, it is x, z, y
//		int x = 0, z = 0, y = 0;
		
		
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					blocks[x][z][y] = new BlockStone(x, z, y);
					System.out.println("x: " + x + " z: " + z + " y: " + y);
				}
			}
		}
		
		
//		while(x < 16){
//			while(z < 16){
//				while(y < 16){
//					blocks[x][z][y] = new BlockStone(x, z, y);
//					y++;
//					System.out.println(y);
//				}
//				z++;
//				
//			}
//			x++;
//		}
	}
	
	public void update(){
		
	}
	
	public void render(){
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					blocks[x][z][y].render();
					//System.out.println("x: " + x + " z: " + z + " y: " + y);
				}
			}
		}
	}
	
	public Block[][][] getBlocks(){
		return blocks;
	}
}
