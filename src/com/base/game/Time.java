package com.base.game;

public class Time {
	public static final long SECOND = 1000000000L;

	private static double delta;

	public static long getTime(){
		return System.nanoTime() / 1000000;
	}

	public static double getDelta(){
		return delta;
	}

	public static void setDelta(double delta){
		Time.delta = delta;
	}
}
