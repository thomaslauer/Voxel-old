package com.base.game.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector2f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;


public class Window {
	
	public static void initWindow(int width, int height, String title){
		Display.setTitle(title);
		
		try{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			Keyboard.create();
			Mouse.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
	}
	
	public static void initProjection(float fov, float aspectRatio, float nearClipping, float farClipping){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, aspectRatio, nearClipping, farClipping);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.2f, 0.2f, 0.9f, 1f);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void update(){
		Display.update();
	}
	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	public static int getWidth(){
		return Display.getDisplayMode().getWidth();
	}
	public static int getHeight(){
		return Display.getDisplayMode().getHeight();
	}
	public static String getTitle(){
		return Display.getTitle();
	}
	public static Vector2f getCenter(){
		return new Vector2f(getWidth()/2, getHeight()/2);
	}
}
