package com.kzk.apps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.kzk.libs.PozyxSerial;
import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;
import com.kzk.libs.structures.generic.Data;
import com.kzk.libs.structures.DeviceDetailes;
import com.kzk.libs.structures.device.DeviceRange;
import com.kzk.libs.structures.device.NetworkId;
import com.kzk.libs.structures.generic.Generic;
import com.kzk.libs.structures.generic.SingleRegister;
import com.kzk.libs.structures.generic.XYZ;
import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world");
		
		// make an instance for serial communication.
		PozyxSerial port = new PozyxSerial(PozyxSerial.getFirstPozyxSerialPort());
		
		// to collect the device data from pozyx via Serial comunication
		port.printDeviceInfo("None");
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// LED control
		// on 1 and 4 do not work on Pozyx Anchor.
		port.setLed(1, false);  // ?
		port.setLed(2, false);  // control for left LED, indicating with gree LED
		port.setLed(3, false);  // control for middle LED
		port.setLed(4, false);  // ?
		
		DeviceRange deviceRange = new DeviceRange();
		SingleRegister protocol = new SingleRegister();
		protocol.setValue(0, "00");
		port.setRangingProtocol(protocol, "None");
		System.out.println(deviceRange.getByteSize());
		System.out.println("----------------------");
		int status;
		while(true) {
			status = port.doRanging("6113", deviceRange, "None");
			if(status == Constants.POZYX_SUCCESS) {
				deviceRange.showDeviceRange();
			}
		}
//		System.out.println("----------------------");
		
		// Acceleration data 
//		XYZ ACCdata = new XYZ();  // build a container for ACC data.
//		XYZ MAGdata = new XYZ();  // build a container for ACC data.
//		XYZ GRAVdata = new XYZ();  // build a container for ACC data.
//		port.getXYZData(ACCdata, 0);  // collect the device data from pozyx via Serial comunication
//		port.getXYZData(MAGdata, 1);  // collect the device data from pozyx via Serial comunication
//		port.getXYZData(GRAVdata, 4);  // collect the device data from pozyx via Serial comunication
//		
//		System.out.println("x:" + ACCdata.getData(0) + " y:" + ACCdata.getData(1) + " z:" + ACCdata.getData(2));
//		System.out.println("x:" + GRAVdata.getData(0) + " y:" + GRAVdata.getData(1) + " z:" + GRAVdata.getData(2));
//		System.out.println("x:" + MAGdata.getData(0) + " y:" + MAGdata.getData(1) + " z:" + MAGdata.getData(2));
		
	}
}
