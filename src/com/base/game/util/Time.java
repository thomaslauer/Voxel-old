package com.base.game.util;

public class Time {
	public static final long SECOND = 1000000000L;
	
	public static long deltaTime = 0;
	
	public static long getDeltaTime() {
		return deltaTime;
	}

	public static void setDeltaTime(long deltaTime) {
		Time.deltaTime = deltaTime;
	}

	public static long getTime(){
		return System.nanoTime() / 1000000;
	}
}
