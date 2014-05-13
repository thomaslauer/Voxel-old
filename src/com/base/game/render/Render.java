package com.base.game.render;

import static org.lwjgl.opengl.GL11.*;

import com.base.game.Chunk;
import com.base.game.blocks.Block;

public class Render {
	
	public static void chunk(Chunk chunk){
		glPushMatrix();
		glTranslatef(chunk.position.x, 0, chunk.position.y);
		for(int x = 0; x < 16; x++){
			for(int z = 0; z < 16; z++){
				for(int y = 0; y < 16; y++){
					chunk.blocks[x][z][y].render();
				}
			}
		}
		glPopMatrix();
	}
	
	public static void block(Block block){
		glPushMatrix();
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTranslatef(block.position.getX(), block.position.getZ(), block.position.getY());
		block.mesh.draw();
		glPopMatrix();
	}
}
