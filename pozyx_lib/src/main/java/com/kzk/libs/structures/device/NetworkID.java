package com.kzk.libs.structures.device;

import com.kzk.libs.structures.generic.Data;

public class NetworkID extends Data{
	public NetworkID() {
		this("0");
	}
	
	public NetworkID(String id) {
		super(id, 2);  // first input can be none.
		this.id = id;
	}
	
	public NetworkID(Data data) {
		super(data.id, 2);  // first input can be none.
		this.id = data.id;
	}
	
	public String showNetWorkId() {
		return this.id;
	}
}
