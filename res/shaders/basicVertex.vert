#version 330

layout (location = 0) in vec3 position;

varying vec4 color;

void main()
{
	color = vec4(0.5, 0.0, 1.0, 1.0);
	gl_Position = gl_ModelViewProjectionMatrix*gl_Vertex;
}