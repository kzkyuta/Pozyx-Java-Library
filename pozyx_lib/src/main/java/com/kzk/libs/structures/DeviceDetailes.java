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
}
