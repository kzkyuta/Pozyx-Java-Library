package com.kzk.apps;

import java.util.ArrayList;

import com.kzk.libs.PozyxSerial;
import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;
import com.kzk.libs.structures.Data;
import com.kzk.libs.structures.DeviceDetailes;
import com.kzk.libs.structures.Generic;

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
		port.setLed(1, true);  // ?
		port.setLed(2, false);  // control for left LED, indicating with gree LED
		port.setLed(3, false);  // control for middle LED
		port.setLed(4, true);  // ?
		
		// Acceleration data 
		Data ACCdata = new Data();  // build a container for ACC data.
		port.getACCData(ACCdata);  // collect the device data from pozyx via Serial comunication
		
		System.out.println(ACCdata.getData());		// x, y, z
		System.out.println(ACCdata.getACCData(0));  // x
		System.out.println(ACCdata.getACCData(1));  // y
		System.out.println(ACCdata.getACCData(2));  // z
		
	}
}
