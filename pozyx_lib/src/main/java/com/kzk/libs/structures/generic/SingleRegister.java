package com.kzk.libs.structures.generic;

import com.kzk.libs.structures.generic.Data;

public class SingleRegister extends Data {
	// this class has only one element at this.data.
	
	public SingleRegister(String value, int size, boolean signed) {
		if(size == 1)  this.dataFormat = "b";
		else if(size == 2)    this.dataFormat = "h";
		else if(size == 4)    this.dataFormat = "i";
		else {
			System.out.println("the input size is wrong, it need to be 1, 2 and 4");
		}
        if(signed) {
        	dataFormat = dataFormat.toUpperCase();
        }
        this.data.add(value);
        this.setPackedSize();
	}
	
	public SingleRegister() {
		this("", 1, true);
	}

	public SingleRegister(String value, int size) {
		this(value, size, true);
	}
	
	@Override
	public void setValue(int index, String s) {
		this.data.set(0, s);
	}
	
	public String getValue() {
		return data.get(0);
	}
}
