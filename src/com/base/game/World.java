package com.base.game;

import java.util.ArrayList;

public class World {
	private Player player;
	private ArrayList<Chunk> worldChunks;
	
	public World(){
		player = new Player(0, 0, 0);
		worldChunks = new ArrayList<Chunk>();
	}
	
	public void update(){
		for(Chunk ch : worldChunks)
			ch.update();
		
		player.update();
	}
	
	public void render(){
		for(Chunk ch : worldChunks)
			ch.render();
	}
	
	public void addChunk(){
		worldChunks.add(new Chunk());
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Chunk> getWorldChunks() {
		return worldChunks;
	}

	public void setWorldChunks(ArrayList<Chunk> worldChunks) {
		this.worldChunks = worldChunks;
	}
}
