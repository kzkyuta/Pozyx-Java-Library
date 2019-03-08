package com.kzk.apps;

import java.util.ArrayList;

import com.kzk.libs.PozyxSerial;
import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;
import com.kzk.libs.structures.generic.Data;
import com.kzk.libs.structures.DeviceDetailes;
import com.kzk.libs.structures.generic.Generic;
import com.kzk.libs.structures.generic.SingleRegister;
import com.kzk.libs.structures.generic.XYZ;
import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world");
		
		// make an instance for serial communication.
		PozyxSerial port = new PozyxSerial(PozyxSerial.getFirstPozyxSerialPort());
		
		// make an instance for the container of device data.
		DeviceDetailes device = new DeviceDetailes();
		
		// to collect the device data from pozyx via Serial comunication
		port.getDeviceDetails(device);
		port.deviceCheck(device);  // print out the data.
		
		// LED control
		// on 1 and 4 do not work on Pozyx Anchor.
		port.setLed(1, false);  // ?
		port.setLed(2, false);  // control for left LED, indicating with gree LED
		port.setLed(3, false);  // control for middle LED
		port.setLed(4, false);  // ?
		
		// Acceleration data 
		XYZ ACCdata = new XYZ();  // build a container for ACC data.
		XYZ MAGdata = new XYZ();  // build a container for ACC data.
		XYZ GRAVdata = new XYZ();  // build a container for ACC data.
		port.getXYZData(ACCdata, 0);  // collect the device data from pozyx via Serial comunication
		port.getXYZData(MAGdata, 1);  // collect the device data from pozyx via Serial comunication
		port.getXYZData(GRAVdata, 4);  // collect the device data from pozyx via Serial comunication
		
		System.out.println("x:" + ACCdata.getData(0) + " y:" + ACCdata.getData(1) + " z:" + ACCdata.getData(2));
		System.out.println("x:" + GRAVdata.getData(0) + " y:" + GRAVdata.getData(1) + " z:" + GRAVdata.getData(2));
		System.out.println("x:" + MAGdata.getData(0) + " y:" + MAGdata.getData(1) + " z:" + MAGdata.getData(2));
		
	}
}
