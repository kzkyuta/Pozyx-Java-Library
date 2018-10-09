package com.kzk.libs.structures.generic;

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

}