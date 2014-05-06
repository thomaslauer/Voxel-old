package com.base.game;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.util.vector.Vector2f;

public class World {
	private Player player;
	private HashMap<Vector2f, Chunk> worldChunks;
	
	public World(){
		player = new Player(0, 0, 0);
		worldChunks = new HashMap<Vector2f, Chunk>();
	}
	
	public void update(){
		for(Map.Entry<Vector2f, Chunk> entry : worldChunks.entrySet()){
			entry.getValue().update();
		}
		
		player.update();
	}
	
	public void render(){
		for(Map.Entry<Vector2f, Chunk> entry : worldChunks.entrySet()){
			entry.getValue().render();
		}
	}
	
	public void addChunk(long x, long z){
		worldChunks.put(new Vector2f(x, z), new Chunk(x, z));
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public HashMap<Vector2f, Chunk> getWorldChunks() {
		return worldChunks;
	}

	public void setWorldChunks(HashMap<Vector2f, Chunk> worldChunks) {
		this.worldChunks = worldChunks;
	}
}
