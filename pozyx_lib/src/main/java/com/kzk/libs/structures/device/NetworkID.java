package com.kzk.libs.structures.device;

import com.kzk.libs.structures.Data;

public class NetworkID extends Data{
	public NetworkID() {
		this("0");
	}
	
	public NetworkID(String id) {
		super(id, 2);  // first input can be none.
		this.id = id;
	}
}
