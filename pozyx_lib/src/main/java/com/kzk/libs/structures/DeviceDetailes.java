package com.kzk.libs.structures;

public class DeviceDetailes extends Data{
	public String id;
	public DeviceDetailes() {
		super("", 5);  // make data whose contents are none and the size is 1 byte
	}
	
	public String firmware_version_string() {
		byte[] firmware = Generic.hexStringToByteArray(this.getData().substring(2, 4));
//		System.out.println("\t- Firmware version v" + (ver[0] >> 4) + "." + (ver[0] % 0x10));
		return "\t- Farmware Version is v" + (firmware[0] >> 4) + "." + (firmware[0] % 0x10);
	}
	
	public String hardware_version_string() {
		byte[] hardware = Generic.hexStringToByteArray(this.getData().substring(4, 6));
		return "\t- Hardware Version is v1." + (hardware[0] % 0x10);
	}
	
}
