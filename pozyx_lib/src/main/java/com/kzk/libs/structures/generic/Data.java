package com.kzk.libs.structures.generic;

import java.util.ArrayList;

// this class can handle only a byte or two bytes data
public class Data extends ByteStructure {
	
	protected static int dataSize = 0;
//	protected String id = "None";

	public Data() {
		this.data.add("");
		this.dataFormat = "B";
		this.setPackedSize();
	}
	
	public Data(String format) {
		this.data.add("");
		this.dataFormat = format;
		this.setPackedSize();
	}
	
	// Stringのアレイデータを入力とするのは使えないんじゃない？
	protected Data(ArrayList<String> data, String format) {
		this.data = data;
		this.dataFormat = format;
		this.setPackedSize();
	}
	
	public ArrayList<String> exportData(){
		return this.data;
	}

	public String getValue(int index) {
		return data.get(index);
	}
	
	public void setValue(int index, String s) {
		this.data.set(index, s);
	}
	
	@Override
	public void load(ArrayList<String> receivedData) {
		loadData(receivedData);  // received data tp this.data
	}
	
	public String getFormat() {
		return this.dataFormat;
	}
	
	/////////

//	public int getDataSize() {
//		return dataSize;
//	}
//
//	public void setDataSize(int dataSize) {
//		this.dataSize = dataSize;
//	}
	
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
