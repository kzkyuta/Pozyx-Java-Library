package com.kzk.libs.structures.generic;

/*
 * pypozyx.structures.generic - introduces generic data structures derived from ByteStructure

Generic Structures

As the name implies, contains generic structures whose specific use is up to the
user. You should use SingleRegister where applicable when reading/writing
a single register, and use Data for larger data structures.

Structures contained:
Data
    THE generic data structure, a powerful way of constructing arbitrarily
    formed packed data structures
XYZ
    A generic XYZ data structure that is used in much 3D sensor data
SingleRegister
    Data resembling a single register. Can choose size and whether signed.
UniformData
    A variation on Data with all data being a uniform format. Questionably useful.

The use of Data:
Data creates a packed data structure with size and format that is entirely the user's choice.
The format follows the one used in struct, where b is a byte, h is a 2-byte int, and
i is a default-sized integer, and f is a float. In capitals, these are signed.
So, to create a custom construct consisting of 4 uint16 and a single int, the
following code can be used.

  >>> d = Data([0] * 5, 'HHHHi')

or

  >>> data_format = 'HHHHi'
  >>> d = Data([0] * len(data_format), data_format)
 */

public class Generic {
	
	public static boolean isRegReadable(byte reg) {
	    if ((0x00 <= reg && reg < 0x07) 
	    		|| (0x10 <= reg && reg < 0x12) 
	    		|| (0x14 <= reg && reg < 0x22) 
	    		|| (0x22 <= reg && reg < 0x24) 
	    		|| (0x27 <= reg && reg < 0x2B) 
	    		|| (0x30 <= reg && reg < 0x48) 
	    		|| (0x4E <= reg && reg < 0x89)) {
	        return true;
	    } else {
	    	return false;
	    }
	}
	
	public static byte[] hexStringToByteArray(String s) {
	   int len = s.length();
	   byte[] data = new byte[len / 2];
	   for (int i = 0; i < len; i += 2) {
	       data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                            + Character.digit(s.charAt(i+1), 16));
	   }
	   return data;
	}
	public static boolean dataCheck(Data data) {
		
		return true;
	}

}
