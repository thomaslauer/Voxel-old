package com.base.game;

public class Main {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Voxel 0.1";
	
	
	public static void main(String args[]){
		Game g = new Game(WIDTH, HEIGHT, TITLE);
		g.start(new World());
	}
}
