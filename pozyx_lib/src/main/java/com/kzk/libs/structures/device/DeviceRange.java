package com.kzk.libs.structures.device;

import com.kzk.libs.structures.ByteStructure;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Container for the device range data, resulting from a range measurement.

    The keyword arguments are at once its properties.

    Kwargs:
        timestamp: Timestamp of the range measurement
        distance: Distance measured by the device.
        RSS: Signal strength during the ranging measurement.
 */

public class DeviceRange extends ByteStructure{
    public int timestamp;
    public int distance;
    public int rss;
    
    public DeviceRange() {
    	this.dataFormat = "bIIh";
    	this.timestamp = 0;
    	this.distance = 0;
    	this.rss = 0;
    }
    
    public DeviceRange(int timestamp, int distance, int rss) {
    	this.timestamp = timestamp;
    	this.distance = distance;
    	this.rss = rss;
    	updateData(); 
    }
    
    public void load(ArrayList<String> receivedData) {
    	loadData(receivedData);
    	this.timestamp = convertByteDataToInt(1);
    	this.distance = convertByteDataToInt(2);
    	this.rss = convertByteDataToInt(3);
	}
    public void updateData() {
    	
    }
    public void showDeviceRange() {
		System.out.println(this.timestamp + "ms, " + this.distance + "mm, " + this.rss + "dBm");
    }
}
