package com.base.game.render;

public class FaceRender {
	public boolean xup = false;
	public boolean zup = false;
	public boolean yup = false;
	public boolean xdown = false;
	public boolean zdown = false;
	public boolean ydown = false;
	
	public void setAll(boolean condition){
		xup = condition;
		yup = condition;
		zup = condition;
		xdown = condition;
		ydown = condition;
		zdown = condition;
	}
}
