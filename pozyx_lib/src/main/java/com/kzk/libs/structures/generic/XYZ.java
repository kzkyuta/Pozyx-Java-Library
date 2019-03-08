package com.kzk.libs.structures.generic;

import java.util.ArrayList;
import com.kzk.libs.structures.ByteStructure;

public class XYZ extends ByteStructure{
	int[] xyzData = new int[3];
	
	public XYZ() {
		this.dataFormat = "hhh";
		setPackedSize();
	}
	
	@Override
	public void load(ArrayList<String> data) {
		// TODO 自動生成されたメソッド・スタブ
		loadData(data);
		xyzData[0] = convertByteDataToInt(0);
		xyzData[1] = convertByteDataToInt(1);
		xyzData[2] = convertByteDataToInt(2);
	}
	
	public int getData(int a) {
		if(a < 0 || a > 3) {
			// TODO: implement through
			System.out.println("input value need to be 0 to 2");
		}
		return xyzData[a];
	}
	
	public String getFormat() {
		return dataFormat;
	}
	
	public void importData(ArrayList<String> input) {
		this.data = input;
		xyzData[0] = convertByteDataToShort(0);
		xyzData[1] = convertByteDataToShort(1);
		xyzData[2] = convertByteDataToShort(2);
	}
}
