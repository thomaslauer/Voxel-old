package com.base.game.render;

import org.newdawn.slick.opengl.Texture;

import com.base.game.Utils;

public class TextureMap {
	
	public static Texture texture;
	
	public static int textureMapDimensions;
	public static float textureMapScale;
	
	public static void init(String textureMap){
		textureMapDimensions = 16;
		textureMapScale = (float)1/textureMapDimensions;
		
		System.out.print("Loading texture");
		texture = Utils.loadTexture("PNG", textureMap);
	}
	
	public static void bind(){
		texture.bind();
	}
	
	public static void release(){
		texture.release();
	}
}