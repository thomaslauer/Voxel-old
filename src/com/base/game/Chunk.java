package com.base.game;

import org.lwjgl.util.vector.Vector2f;

import com.base.game.blocks.Block;
import com.base.game.blocks.BlockStone;


public class Chunk {
	public Block[][][] blocks;
	
	public Vector2f position;
	
	public Chunk(Vector2f position){
		
		this.position = position;
		
		blocks = new Block[16][16][16]; //not like normal, it is x, z, y
		
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					blocks[x][z][y] = new BlockStone(x, z, y).setTexture(new Vector2f(1, 0));
				}
			}
		}
		updateVisibility();
	}
	
	public void tick(){
		
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
	
	public void updateVisibility(){
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					
//					System.out.println("x: " + x + " z: " + z + " y: " + y);
					
					try{
					if(blocks[x+1][z][y].isSolid && blocks[x-1][z][y].isSolid && blocks[x][z+1][y].isSolid && blocks[x][z-1][y].isSolid && blocks[x][z][y+1].isSolid && blocks[x-1][z][y-1].isSolid){
						blocks[x][z][y].doRender = false;
					}else{
						blocks[x][z][y].doRender = true;
					}
					}catch(ArrayIndexOutOfBoundsException ex){
						blocks[x][z][y].doRender = true;
					}
				}
			}
		}
	}
	
	public Block[][][] getBlocks(){
		return blocks;
	}
}
