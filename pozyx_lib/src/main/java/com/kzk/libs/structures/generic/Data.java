package com.kzk.libs.structures.generic;

import java.util.ArrayList;

//public abstract class Data extends ByteStructure {
public class Data extends ByteStructure {
	
//	protected static String data = "";
	protected static int dataSize = 0;
	public String id = "None";

	public Data() {
		
	}
	public Data(ArrayList<String> data) {
		this(data, super.dataFormat);  // ここから
	}
	
	public Data(ArrayList<String> data, String format) {
		this.data = data;
		this.dataFormat = format;
		this.setPackedSize();
		String newByteData = "";
		for(int i = 0; i < dataFormat.length(); i++) {
			newByteData += "00";
		}
		this.byteData = newByteData;
		this.dataSize = dataFormat.length();
	}

	public String getData(int index) {
		return data.get(index);
	}
	
	public void load(ArrayList<String> data) {
		this.data = data;
	}

	public void setData(String data) {
		if(data.length() == 2) {
			this.data.add(data);
		}
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	
	public int getACCData(int a) {
		if(this.data.size() != 6) {
			System.out.println("This data is not for ACC");
			return 0;
		}
		int outData = 0;
		switch(a) {
			case 0:
//				outData = Integer.parseInt(this.getData().substring(0, 4), 16);
				outData = Integer.parseInt((this.getData(0) + this.getData(1)), 16);
				break;
			case 1:
//				outData = Integer.parseInt(this.getData().substring(4, 8), 16);
				outData = Integer.parseInt((this.getData(2) + this.getData(3)), 16);
				break;
			case 2:
//				outData = Integer.parseInt(this.getData().substring(8, 12), 16);
				outData = Integer.parseInt((this.getData(4) + this.getData(5)), 16);
				break;
		}
		return outData;
	}

}
