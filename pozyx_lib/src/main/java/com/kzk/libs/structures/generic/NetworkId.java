package com.kzk.libs.structures.generic;

public class NetworkId extends Data {
	
	
	public NetworkId() {
		this("0");
	}
	
	public NetworkId(String id) {
		super(id, 2);  // first input can be none.
		this.id = id;
	}
	
}
