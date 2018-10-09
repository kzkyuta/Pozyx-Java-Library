package com.kzk.libs.structures.generic;

//public abstract class Data extends ByteStructure {
public class Data extends ByteStructure {
	
	protected static String data = "";
	protected static int dataSize = 0;
	public String id = "None";

	public Data() {
		this(data, dataSize);
	}
	public Data(String data) {
		this(data, dataSize);
	}
	public Data(String data, int dataSize) {
		this.data = data;
		this.dataSize = dataSize;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	
	public int getACCData(int a) {
		if(this.getData().length() != 12) {
			System.out.println("This data is not for ACC");
			return 0;
		}
		int outData = 0;
		switch(a) {
			case 0:
				outData = Integer.parseInt(this.getData().substring(0, 4), 16);
				break;
			case 1:
				outData = Integer.parseInt(this.getData().substring(4, 8), 16);
				break;
			case 2:
				outData = Integer.parseInt(this.getData().substring(8, 12), 16);
				break;
		}
		return outData;
	}

}
