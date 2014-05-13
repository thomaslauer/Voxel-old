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
					
					if(x != 15){
						if(blocks[x + 1][z][y].isSolid){
							blocks[x][z][y].faceRender.xup = false;
						}else{
							blocks[x][z][y].faceRender.xup = true;
						}
					}else{
						blocks[x][z][y].faceRender.xup = true;
					}
					
					if(z != 15){
						if(blocks[x][z + 1][y].isSolid){
							blocks[x][z][y].faceRender.yup = false;
						}else{
							blocks[x][z][y].faceRender.yup = true;
						}
					}else{
						blocks[x][z][y].faceRender.yup = true;
					}
					
					if(y != 15){	
						if(blocks[x][z][y + 1].isSolid){
							blocks[x][z][y].faceRender.zdown = false;
						}else{
							blocks[x][z][y].faceRender.zdown = true;
						}
					}else{
						blocks[x][z][y].faceRender.zdown = true;
					}
					
					if(x != 0){
						if(blocks[x - 1][z][y].isSolid){
							blocks[x][z][y].faceRender.xdown = false;
						}else{
							blocks[x][z][y].faceRender.xdown = true;
						}
					}else{
						blocks[x][z][y].faceRender.xdown = true;
					}
					
					if(z != 0){
						if(blocks[x][z - 1][y].isSolid){
							blocks[x][z][y].faceRender.ydown = false;
						}else{
							blocks[x][z][y].faceRender.ydown = true;
						}
					}else{
						blocks[x][z][y].faceRender.ydown = true;
					}
					
					if(y != 0){
						if(blocks[x][z][y - 1].isSolid){
							blocks[x][z][y].faceRender.zup = false;
						}else{
							blocks[x][z][y].faceRender.zup = true;
						}
					}else{
						blocks[x][z][y].faceRender.zup = true;
					}
				}
			}
		}
	}
	
	public Block[][][] getBlocks(){
		return blocks;
	}
}
