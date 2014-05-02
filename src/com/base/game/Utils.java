package com.base.game;

import java.io.IOException;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Utils {
	public static Texture loadTexture(String fileType, String fileName){
		try {
			return TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream("res/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Vector2f subtractVectors(Vector2f a, Vector2f b){
		float x = a.x - b.x;
		float y = a.y - b.y;
		return new Vector2f(x, y);
	}
}
