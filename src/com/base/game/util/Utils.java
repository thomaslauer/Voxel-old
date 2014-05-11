package com.base.game.util;

import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.base.game.render.Vertex;

public class Utils {
	public static Texture loadTexture(String fileType, String fileName){
		try {
			return TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream("res/textures" + fileName));
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
	
	public static FloatBuffer createFloatBuffer(int size)
	{
		return BufferUtils.createFloatBuffer(size);
	}

	public static FloatBuffer createFlippedBuffer(Vertex[] vertices)
	{
		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);

		for(int i = 0; i < vertices.length; i++)
		{
			buffer.put(vertices[i].getPos().getX());
			buffer.put(vertices[i].getPos().getY());
			buffer.put(vertices[i].getPos().getZ());
		}

		buffer.flip();

		return buffer;
	}
}
