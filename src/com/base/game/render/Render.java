package com.base.game.render;

import static org.lwjgl.opengl.GL11.*;

import com.base.game.Block;
import com.base.game.Chunk;

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
		
		TextureMap.bind();
		
		float x = block.getTexture().getX() * TextureMap.textureMapScale;
		float y = block.getTexture().getY() * TextureMap.textureMapScale;
		float a = x + TextureMap.textureMapScale;
		float b = y + TextureMap.textureMapScale;
		
		
		glPushMatrix();
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTranslatef(block.position.x, block.position.y, block.position.z);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(x,b); glVertex3f(0,0,1);
			glTexCoord2f(a,b); glVertex3f(1,0,1);
			glTexCoord2f(a,y); glVertex3f(1,1,1);
			glTexCoord2f(x,y); glVertex3f(0,1,1);
			
			glTexCoord2f(a,b); glVertex3f(0,0,0);
			glTexCoord2f(a,y); glVertex3f(0,1,0);
			glTexCoord2f(x,y); glVertex3f(1,1,0);
			glTexCoord2f(x,b); glVertex3f(1,0,0);
			
			glTexCoord2f(x,b); glVertex3f(0,0,0);
			glTexCoord2f(a,b); glVertex3f(0,0,1);
			glTexCoord2f(a,y); glVertex3f(0,1,1);
			glTexCoord2f(x,y); glVertex3f(0,1,0);
			
			glTexCoord2f(a,b); glVertex3f(1,0,0);
			glTexCoord2f(x,b); glVertex3f(1,0,1);
			glTexCoord2f(x,y); glVertex3f(1,1,1);
			glTexCoord2f(a,y); glVertex3f(1,1,0);
			
			glTexCoord2f(x,y); glVertex3f(0,0,0);
			glTexCoord2f(a,y); glVertex3f(1,0,0);
			glTexCoord2f(a,b); glVertex3f(1,0,1);
			glTexCoord2f(x,b); glVertex3f(0,0,1);
			
			glTexCoord2f(x,y); glVertex3f(0,1,0);
			glTexCoord2f(a,y); glVertex3f(1,1,0);
			glTexCoord2f(a,b); glVertex3f(1,1,1);
			glTexCoord2f(x,b); glVertex3f(0,1,1);
		}
		glEnd();
		//block.texture.release(); //is this needed?
		glPopMatrix();
	}
}
