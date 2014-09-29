package com.base.game.blocks.material;

public class Material {
	public static Material air = new Material().setTransparent(true).setDoRender(false);
	public static Material stone = new Material();
	
	public boolean isTransparent = false;
	public boolean doRender = true;
	
	
	public Material setTransparent(boolean isTransparent) {
		this.isTransparent = isTransparent;
		return this;
	}
	public Material setDoRender(boolean doRender) {
		this.doRender = doRender;
		return this;
	}
}
