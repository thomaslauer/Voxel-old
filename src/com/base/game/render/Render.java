package com.base.game.render;

import static org.lwjgl.opengl.GL11.*;

import com.base.game.Block;

public class Render {
	
	public static void block(Block block){
		
		float x = block.getTexture().getX();
		float y = block.getTexture().getY();
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
