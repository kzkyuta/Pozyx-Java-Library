package com.kzk.libs.structures;

import java.util.ArrayList;
import java.nio.ByteBuffer;
import javax.xml.bind.DatatypeConverter;

public abstract class ByteStructure {

	protected int byteSize;
	protected String dataFormat;
//	protected String byteData = "00";  // temp container for received data from pozyx. 
	protected ArrayList<String> data; // any type of data with 
	
	public ByteStructure() {
		this.byteSize = 4;
		this.dataFormat = "BBBB";
		this.data = new ArrayList<String>();
	}
	/*
	 * The use of Data:
    byteStructure creates a packed data structure with size and format that is entirely the user's choice.
    The format follows the one used in struct, where b is a byte, h is a 2-byte int, and
    i is a default-sized integer, and f is a float. In capitals, these are unsigned.
    So, to create a custom construct consisting of 4 uint16 and a single int, the
    following code can be used.
    >>> d = Data([0] * 5, 'HHHHi') // python code
	 */
	
//	protected ByteStructure() {
//		
//	}
	
	protected void setPackedSize() {
		String newFormat = "";
		for(int i =0; i < dataFormat.length(); i ++) {
			if(dataFormat.charAt(i) == 'f' | dataFormat.charAt(i) == 'F' |
				dataFormat.charAt(i) == 'i' | dataFormat.charAt(i) == 'I') {
				newFormat += "BBBB"; // float and int is 4 bytes;
			}else if(dataFormat.charAt(i) == 'b' | dataFormat.charAt(i) == 'B') {
				newFormat += "B"; // byte is 1 bytes;
			}else if(dataFormat.charAt(i) == 'h' | dataFormat.charAt(i) == 'H') {
				newFormat += "BB"; // 2-byte is 1 bytes;
			}
		}
		this.byteSize = newFormat.length(); 
	}
	
	public int getByteSize() {  // return size of byte scale 
		return this.byteSize;
	}
	
	public int getDataSize() {  // return the number of data information. 
		return this.data.size();
	}
	
	public String getFormat() {
		return this.dataFormat;
	}
	
	public abstract void load(ArrayList<String> data);  // the way to process data is depend on the class.
	
	// received row byte data to structured data based on dataFormat
	protected void loadData(ArrayList<String> inData) {
		int k = 0; // number of inData
		ArrayList<String> tempArray = new ArrayList<String>();
		for(int i = 0; i < dataFormat.length(); i++) {
			if(dataFormat.charAt(i) == 'f' | dataFormat.charAt(i) == 'F' |
					dataFormat.charAt(i) == 'i' | dataFormat.charAt(i) == 'I') {
				String fourByte = "";
				for(int ii = 0; ii < 4; ii++) {
					fourByte += inData.get(k);
					k++;
				}
				tempArray.add(fourByte);
			}else if(dataFormat.charAt(i) == 'h' | dataFormat.charAt(i) == 'H') {
				String twoByte = "";
				for(int ii = 0; ii < 2; ii++) {
					twoByte += inData.get(k);
					k++;
				}
				tempArray.add(twoByte);
			}else if(dataFormat.charAt(i) == 'b' | dataFormat.charAt(i) == 'B') {
				tempArray.add(inData.get(k));
				k++;
			}
		}		
		this.data = tempArray;
	}
	
	protected int convetHalfByteToInt(int index, int a){
		String s = this.data.get(index);
		int results[] = new int[2];
		int result = 0;
		
		if(s.length() == 2) {  // argument needs to be one byte code
			results[0] = (byte) (Character.digit(s.charAt(0), 16));
			results[1] = (byte) (Character.digit(s.charAt(1), 16));
			if(a == 0) result = results[0];
			if(a == 1) result = results[1];
		}else{
			System.out.println("this data is too big data to convert to int");  // TODO: implement through
			return result;
		}
		return result;
	}
	
	protected int convertByteDataToInt(int index) {
		String s = this.data.get(index);
		return Integer.parseInt(s, 16);
	}
	
	protected short convertByteDataToShort(int index) {
		String s = this.data.get(index);
		byte[] bytes = DatatypeConverter.parseHexBinary(s);
		short result = ByteBuffer.wrap(bytes).getShort();
//		System.out.println(s);
		return result;
//		return Short.parseShort(s, 16);
	}
	
	public byte[] getByteArrayData(int index) {
		String s = this.data.get(index);
		byte[] bytes = DatatypeConverter.parseHexBinary(s);
		
		return bytes;
	}
}
