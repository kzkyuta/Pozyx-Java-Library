package com.kzk.libs.structures.generic;

public class NetworkId extends Data {
	// this class will be used as container for NetworkId
	// data format shold be "H"
	
	public NetworkId() {
		this("");
	}
	
	public NetworkId(String id) {
		this.data.add(id);
		this.dataFormat = "H";
		this.setPackedSize();
	}
	
	public void setNetWorkId(String id) {
		this.data.set(0, id);
	}
	
	public String getNetWorkId() {
		return this.data.get(0);
	}
	
}
