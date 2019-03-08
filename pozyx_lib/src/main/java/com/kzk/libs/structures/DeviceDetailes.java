package com.kzk.libs.structures;

import com.kzk.libs.structures.generic.Data;

/*
 * Container for system information, such as firmware, hardware...

    Read-only, so all values are implemented as properties.
 */

public class DeviceDetailes extends Data{
	// this class is used to get device information 
	// like Pozyx identification ID 0x43, firmware version, hardware version
	// internal self test result and error code.
	
	public DeviceDetailes() {
		super("BBBBB");  // make data whose contents are none and the size is 1 byte
	}
	
	public String firmware_version_string() {
		return "\t- Farmware Version is v" + this.convetHalfByteToInt(1, 0)
		+ "." + this.convetHalfByteToInt(1, 1);
	}
	
	public String hardware_version_string() {
		return "\t- Hardware Version is v1." + this.convetHalfByteToInt(2, 1);
	}
	
	public String self_test_result() {
		if(!this.getValue(3).equals("3F")) {
			return "\t- Self tests: something wrong. returned data is " + this.getValue(3) + ". Check \"https://www.pozyx.io/product-info/developer-tag/datasheet-register-overview\" " ;
		}
		return "\t- Self tests: ALL green!";
	}
	
	public String error_code() {
		if(!this.getValue(4).equals("00")) {
			return "\t- Check Error Code:Returned value is " + this.getValue(3) + ". Check \"https://www.pozyx.io/product-info/developer-tag/datasheet-register-overview\" " ;
		}
		return "\t- Check Error Code: No error!";
	}
}
