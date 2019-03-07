package com.kzk.libs.structures.generic;

import java.util.ArrayList;

public abstract class ByteStructure {

	protected int byteSize = 4;
	protected String dataFormat = "BBBB";
	protected String byteData = "00";
	protected ArrayList<String> data = new ArrayList<String>();  // unit is one byte
	
	protected void setPackedSize() {
		String newFormat = "";
		for(int i =0; i < data.size(); i ++) {
			if(dataFormat.charAt(i) == 'f') {
				newFormat += "BBBB"; // float is 4 bytes;
			}
		}
	}
	
}
