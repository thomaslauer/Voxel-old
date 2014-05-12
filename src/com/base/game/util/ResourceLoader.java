package com.base.game.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class ResourceLoader {
	public static String loadShader(String fileName){
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader = null;
		
		try {
			shaderReader = new BufferedReader(new FileReader("res/shaders/" + fileName));
			String line;
			while((line = shaderReader.readLine()) != null){
				shaderSource.append(line).append("\n");
			}
			
			shaderReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shaderSource.toString();
	}
}
