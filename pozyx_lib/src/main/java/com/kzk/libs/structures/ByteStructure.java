package com.kzk.libs.structures;

/*
 * The ByteStructure class is the base class that all custom structs inherit
their basic functionality from. It implements the low-level functionality
that makes it easy to make use arbitrary struct formats in the interface
with Pozyx.
 */

public abstract class ByteStructure {

	protected int byteSize = 4;
	protected String dataFormat = "BBBB";
	
	protected String byteData = "00";
//	protected static String data = "";
	
	public ByteStructure() {
		
	}
	
//	public load_bytes() {
//		
//	}
}
