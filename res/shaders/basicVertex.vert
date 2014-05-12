#version 330

out vec4 color;

void main()
{
	color = gl_Vertex;
	gl_Position = gl_ModelViewProjectionMatrix*gl_Vertex;
}