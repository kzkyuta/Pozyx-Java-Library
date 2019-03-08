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
}
