package com.base.game.util;

import java.util.HashMap;
import com.base.game.blocks.Block;

public class BlockDoubleHashMap {
	// HashMaps to hold all the information
	private HashMap<Integer, Block> dataValueMap;
	private HashMap<String, Block> nameMap;
	
	public BlockDoubleHashMap()
	{
		dataValueMap = new HashMap<Integer, Block>();
		nameMap = new HashMap<String, Block>();
	}
	
	// puts a block into both of the HashMaps
	public synchronized void addBlock(int dataValue, String name, Block block)
	{
		dataValueMap.put(dataValue, block);
		nameMap.put(name, block);
		block.dataValue = dataValue;
		block.name = name;
	}
	
	// gets a block from the dataValueMap
	public Block getBlock(int dataValue)
	{
		return dataValueMap.get(dataValue);
	}
	
	// gets a block from the name
	public Block getBlock(String name)
	{
		return nameMap.get(name);
	}
}
