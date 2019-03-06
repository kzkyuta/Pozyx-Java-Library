package com.kzk.libs.structures.device;

import com.kzk.libs.structures.ByteStructure;
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
	public int byte_size = 10;
    public String data_format = "IIh";
    public int timestamp;
    public int distance;
    public int rss;
    public int[] data = new int[3];
    
    public DeviceRange() {	
    	this.timestamp = 0;
    	this.distance = 0;
    	this.rss = 0;
    }
    
    public DeviceRange(int timestamp, int distance, int rss) {
    	this.timestamp = timestamp;
    	this.distance = distance;
    	this.rss = rss;
    	data = new int [] {this.timestamp, this.distance, this.rss};
    }
    public void load(int[] data) {
    	this.data = data;
    	this.timestamp = data[0];
    	this.distance = data[1];
    	this.rss = data[2];
	}
    public void update_data(int[] data) {
    	// TODO:try catch
		if(Arrays.equals(this.data, data)) {
			this.data[0] = this.timestamp;
			this.data[1] = this.distance;
			this.data[2] = this.rss;
		}
    }
    public void showDeviceRange() {
		System.out.println(this.timestamp + "ms, " + this.distance + "mm, " + this.rss + "dBm");
    }
}
