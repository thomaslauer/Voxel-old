package com.base.game;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.base.game.render.Mesh;
import com.base.game.render.Vertex;


public class Chunk {
	public int[][][] blocks;
	
	public Vector2f position;
	
	public Mesh chunkMesh;
	
	public Chunk(Vector2f position)
	{
		blocks = new int[16][16][16];
		this.position = position;
		
		chunkMesh = new Mesh();
		
		for(int x = 0; x < 16; x++)
		{
			for(int y = 0; y < 16; y++)
			{
				for(int z = 0; z < 16; z++)
				{
					blocks[x][y][z] = 1;
				}
			}
		}
		buildMesh();
	}
	
	public void buildMesh() 
	{
		//TODO: add way to calculate mesh on the fly
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 1)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 1))); // front face A
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 1)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 1))); // front face B
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 0))); // back face A
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 0)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 0))); // back face B
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 0)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 1))); // left face A
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 0))); // left face B
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 1)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 0))); // right face A
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 0))); // right face B
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 1))); // top face A
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 0)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 1, 1))); // top face B
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 1, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 0))); // bottom face A
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 1)));
		
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 0)));
		chunkMesh.addVertex(new Vertex(new Vector3f(1, 0, 1))); // bottom face B
		chunkMesh.addVertex(new Vertex(new Vector3f(0, 0, 1)));
		
		chunkMesh.updateMesh();
	}
	
	public void tick()
	{
		
	}
	
	public void render()
	{
		chunkMesh.draw();
	}

	
	public int[][][] getBlocks()
	{
		return blocks;
	}
}
