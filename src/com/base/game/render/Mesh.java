package com.base.game.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import java.util.ArrayList;

import com.base.game.util.Utils;

public class Mesh {
	private int vbo;
	private int size;
	
	private ArrayList<Vertex> vertexList;
	//TODO: add indices for saving vertices and stuff
	
	public Mesh(){
		vbo = glGenBuffers();
		size = 0;
		vertexList = new ArrayList<Vertex>();
	}
	
	public void addVertex(Vertex vertex)
	{
		vertexList.add(vertex);
	}
	
	public void updateMesh()
	{
		Vertex[] tempArray = vertexList.toArray(new Vertex[vertexList.size()]);
		addVertices(tempArray);
	}
	
	public void addVertices(Vertex[] vertices){
		size = vertices.length;
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Utils.createFlippedBuffer(vertices), GL_STATIC_DRAW);
	}
	
	//TODO: add method for adding triangles
	
	public void draw()
	{
		//TODO: add indices for performance
		glEnableVertexAttribArray(0);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
		
		glDrawArrays(GL_TRIANGLES, 0, size);
		
		glDisableVertexAttribArray(0);
	}
}
