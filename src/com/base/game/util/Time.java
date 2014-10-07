package com.base.game.util;

public class Time {
	public static final long SECOND = 1000000000L;
	
	public static double deltaTime = 0;
	
	public static double getDeltaTime() {
		return deltaTime;
	}

	public static void setDeltaTime(long deltaTime) {
		Time.deltaTime = deltaTime;
	}

	public static double getTime(){
		return System.nanoTime() / 1000000;
	}
}
