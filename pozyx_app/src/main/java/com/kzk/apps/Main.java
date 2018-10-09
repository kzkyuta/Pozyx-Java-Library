package com.kzk.apps;

import java.util.ArrayList;

import com.kzk.libs.PozyxSerial;
import com.kzk.libs.structures.generic.Data;
import com.kzk.libs.structures.generic.DeviceDetailes;
import com.kzk.libs.structures.generic.Generic;
import com.kzk.libs.structures.generic.SingleRegister;

import definitions.Registers;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("hello world");
		
		PozyxSerial lib = new PozyxSerial(PozyxSerial.getFirstPozyxSerialPort());
		DeviceDetailes device = new DeviceDetailes();
		lib.getDeviceDetails(device);
		lib.deviceCheck(device);
		lib.setLed(1, true);  // ?
		lib.setLed(2, false);  // control for left LED, indicating with gree LED
		lib.setLed(3, false);  // control for middle LED
		lib.setLed(4, true);  // ?
		
		Data ACCdata = new Data();  // build a container for ACC data.
		lib.getACCData(ACCdata);
		System.out.println(ACCdata.getData());		
		System.out.println(ACCdata.getACCData(0));
		System.out.println(ACCdata.getACCData(1));
		System.out.println(ACCdata.getACCData(2));
		
		String byteStr = "0A12BA";
		byte[] test = {0x0A, 0x12, (byte) 0xBA};
		
		 int len = byteStr.length();
	   byte[] data = new byte[len / 2];
	   for (int i = 0; i < len; i += 2) {
	       data[i / 2] = (byte) ((Character.digit(byteStr.charAt(i), 16) << 4)
	                            + Character.digit(byteStr.charAt(i+1), 16));
	   }
		
//		byte byteTest = 0x12;
//		byte byteT = (0x01 << 6) | (((0x1 << 2) & (byte)0xFF));
//	   byte byteData = (byte) ((0x01 << bShift1) | (((0x1 << bShift2) & (byte)0xFF)));
//		System.out.println(String.format("%02x", byteT).toUpperCase());
		String byteT = "D,F1";
		System.out.println(Integer.parseInt(byteT.substring(2, 4), 16));
		
		
//		System.out.println(byteStr.getBytes()[0]);
//		System.out.println(test[2]);
//		System.out.println(data[2]);
//		PozyxSerial.listSerialPort();
		
//		ArrayList<String> test = PozyxSerial.getPozyxPorts();
//		System.out.println(test.size());
//		System.out.println(System.getProperty("os.name").toLowerCase()); // out the os name on this pc
		
		
		byte verByte = 0x11;
		String verString = "1A";
		byte[] ver = Generic.hexStringToByteArray(verString);
		
		System.out.println("Byte: " + (verByte >> 4) + "   " + (verByte % 0x10));
		
		System.out.println("Byte: " + (ver[0] >> 4) + "   " + (ver[0] % 0x10));
		
	}
}
