package com.base.game.render.meshes;

import org.lwjgl.util.vector.Vector3f;

import com.base.game.render.Mesh;
import com.base.game.render.Vertex;

public class MeshBlock extends Mesh{
	public MeshBlock(){
		super();
		Vertex[] data = new Vertex[] {new Vertex(new Vector3f(1, 0, 0)),
				  new Vertex(new Vector3f(0, 0, 0)), //front face A
				  new Vertex(new Vector3f(0, 1, 0)),
				  
				  new Vertex(new Vector3f(1, 0, 0)),
				  new Vertex(new Vector3f(0, 1, 0)), //front face B
				  new Vertex(new Vector3f(1, 1, 0)),
				  
				  new Vertex(new Vector3f(1, 0, 1)),
				  new Vertex(new Vector3f(0, 1, 1)), //back face A
				  new Vertex(new Vector3f(0, 0, 1)),
				  
				  new Vertex(new Vector3f(1, 0, 1)),
				  new Vertex(new Vector3f(1, 1, 1)), //back face B
				  new Vertex(new Vector3f(0, 1, 1)),
				  
				  new Vertex(new Vector3f(0, 0, 1)),
				  new Vertex(new Vector3f(0, 1, 1)), //left face A
				  new Vertex(new Vector3f(0, 0, 0)),
				  
				  new Vertex(new Vector3f(0, 0, 0)),
				  new Vertex(new Vector3f(0, 1, 1)), //left face B
				  new Vertex(new Vector3f(0, 1, 0)),
				  
				  new Vertex(new Vector3f(1, 0, 1)),
				  new Vertex(new Vector3f(1, 0, 0)), //right face A
				  new Vertex(new Vector3f(1, 1, 1)),
				  
				  new Vertex(new Vector3f(1, 0, 0)),
				  new Vertex(new Vector3f(1, 1, 0)), //right face B
				  new Vertex(new Vector3f(1, 1, 1)),
				  
				  new Vertex(new Vector3f(0, 0, 0)),
				  new Vertex(new Vector3f(1, 0, 0)), //bottom face A
				  new Vertex(new Vector3f(0, 0, 1)),
				  
				  new Vertex(new Vector3f(1, 0, 0)),
				  new Vertex(new Vector3f(1, 0, 1)), //bottom face B
				  new Vertex(new Vector3f(0, 0, 1)),
				  
				  new Vertex(new Vector3f(0, 1, 0)),
				  new Vertex(new Vector3f(0, 1, 1)), //top face A
				  new Vertex(new Vector3f(1, 1, 0)),
				  
				  new Vertex(new Vector3f(1, 1, 0)),
				  new Vertex(new Vector3f(0, 1, 1)), //top face B
				  new Vertex(new Vector3f(1, 1, 1)),};
		this.addVertices(data);
	}
}
