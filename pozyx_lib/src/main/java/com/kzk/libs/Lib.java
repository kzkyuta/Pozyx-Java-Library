package com.kzk.libs;

import javax.print.attribute.ResolutionSyntax;
import javax.swing.SpringLayout.Constraints;

import java.util.logging.Logger;
import java.util.Date;

import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;
import com.kzk.libs.definitions.Bitmasks;
import com.kzk.libs.structures.generic.Data;
import com.kzk.libs.structures.DeviceDetailes;
import com.kzk.libs.structures.device.NetworkId;
import com.kzk.libs.structures.device.UWBSettings;
import com.kzk.libs.structures.device.DeviceRange;
import com.kzk.libs.structures.generic.Generic;
import com.kzk.libs.structures.generic.SingleRegister;
import com.kzk.libs.structures.generic.XYZ;

public abstract class Lib extends Core {
	public static final Logger LOGGER = Logger.getLogger(PozyxSerial.class.getName()); // TODO: confirm

	public void setSensorMode() {
		
	}
	
	public int getWhoAmI(Data whoAmI){
		return this.getWhoAmI(whoAmI, "None");
	}
	
	public int getWhoAmI(Data whoAmI, String remoteId){
		return getRead(Registers.WHO_AM_I, whoAmI, remoteId);
	}
	
	public int getRead(byte address, Data data, String remoteId) {
		if(!Generic.isRegReadable(address)) {
			System.out.println("Register no readable");
		}
		
		if(remoteId.equals("None")) {
			return regRead(address, data);
		} else {
			return remoteRegRead(remoteId, address, data);
		}
	}
	
	public int getFirmwareVersion(Data firmware) { // TODO: remote ID can be input
		return getFirmwareVersion(firmware, "None");
	}
	
	public int getFirmwareVersion(Data firmware, String remoteId) { // TODO: remote ID can be input
		return this.getRead(Registers.FIRMWARE_VERSION, firmware, remoteId);
	}
	
	public void printDeviceInfo(String remoteId) {
		DeviceDetailes firmware = new DeviceDetailes();
		int status = this.getWhoAmI(firmware, remoteId);
		if(status != 1) {
			LOGGER.severe("Faled to get data from Pozyx");
			return;
		}
		System.out.println(firmware.firmware_version_string() + "\n"
				+ firmware.hardware_version_string() + "\n"
				+ firmware.self_test_result() + "\n"
				+ firmware.error_code() + "\n"
				);
	}
	
	public int getNetworkId(NetworkId networkId) {  // 
		return regRead(Registers.NETWORK_ID, networkId);
	}
	
	public int getDeviceDetails(Data dDetails) {
		return getDeviceDetails(dDetails, "None");
	}
	public int getDeviceDetails(Data dDetails, String remoteId) {
		int status = this.getWhoAmI(dDetails, remoteId);
//		if(dDetails.id.equals("None")) {  // TODO: Baptistに聞く
//			if(remoteId.equals("None")) {
//				NetworkId networkId = new NetworkId();
//				status &= this.getNetworkId(networkId);
//				dDetails.id = networkId.id;
//			}else {
//				dDetails.id = remoteId;
//			}
//		}
//		System.out.println(dDetails.id);
		return status;
	}
	
	public int setLed(int ledNum, boolean state){
		return setLed(ledNum, state, "None");
	}
	public int setLed(int ledNum, boolean state, String remoteId){
		if(!(1<= ledNum) || !(ledNum <= 4)) {  // for Anchor
			LOGGER.severe("setLed: LED number " + ledNum + "not in range");
		}
		Data inputParams = new Data();  // 1 byte info
		Data receiveData = new Data();  // 1 byte info: for receive return value from pozyx
		
		byte byteData;
		if(state) {
			byteData = (byte) ((0x01 << (byte) (4-1+ledNum)) | (((0x1 << (byte) (ledNum -1)) & (byte)0xFF)));
		}else {
			byteData = (byte) ((0x01 << (byte) (4-1+ledNum)) | (((0x0 << (byte) (ledNum -1)) & (byte)0xFF)));
		}
		inputParams.setValue(0, String.format("%02x", byteData).toUpperCase());
		return this.useFunction(Registers.LED_CONTROL, inputParams, receiveData, remoteId);
	}
	
	public abstract int setWrite(byte address, Data data, String remoteId, double localDelay, double remoteDelay);
	
	public void setUWBSetting(UWBSettings uwbSetting, String remoteId, boolean saveToFlash) {
		
		Data gainRegister = new Data(String.valueOf(uwbSetting.gain_db));
		Data uwbRegisters = new Data(String.valueOf(uwbSetting.channnel) + String.valueOf(uwbSetting.bitrate + (uwbSetting.prf << 6)));
		this.setWrite(Registers.UWB_CHANNEL, uwbRegisters, remoteId, 2 * Constants.DELAY_LOCAL_WRITE, 2 * Constants.DELAY_REMOTE_WRITE);
	}
	
	public int getXYZData(XYZ data, int index) {
		return getXYZData(data, index, "None");
	}
	public int getXYZData(XYZ data, int index, String remoteId) {
		Data xyzData = new Data(data.getFormat());
		int result;
		switch (index) {
		case 0:
			result = this.getRead(Registers.ACCELERATION_X, xyzData, remoteId);
			break;
		case 1:
			result = this.getRead(Registers.MAGNETIC_X, xyzData, remoteId);
			break;
		case 2:
			result = this.getRead(Registers.GYRO_X, xyzData, remoteId);
			break;
		case 3:
			result = this.getRead(Registers.LINEAR_ACCELERATION_X, xyzData, remoteId);
			break;
		case 4:
			result = this.getRead(Registers.GRAVITY_VECTOR_X, xyzData, remoteId);
			break;
		default:
			result = 0;
			break;
		}
		data.importData(xyzData.exportData());
		return result;
	}
	
//	public void doRanging(Data destinationId, Data deviceRange, String remoteId) {
//		int intFlag;
//		NetworkID netWorkId = new NetworkID(destinationId);
//		this.clearInterruptStatus();
//		
//		
//		if(remoteId.equals("None")) {
//			intFlag = Bitmasks.INT_STATUS_FUNC;
//		}else {
//			intFlag = Bitmasks.INT_STATUS_RX_DATA;
//		}
//		int status = this.useFunction(Registers.DO_RANGING, netWorkId, deviceRange, remoteId);
//		if(status == Constants.POZYX_SUCCESS) {
//			status = this.checkForFlag(intFlag, Constants.DELAY_INTERRUPT, null);
//		}
//		
//	}

//	protected int checkForFlag(int interruptFlag, double timeout_s, Data interrupt) {
//		if(interrupt == null) {
//			interrupt = new SingleRegister();
//		}
//		int errorInterruptMask = Bitmasks.INT_MASK_ERR;
//		if(waitForFlagState(interruptFlag | errorInterruptMask, timeout_s, interrupt)) {
//			
//		}
//		return 0;
//	}

//	private boolean waitForFlagState(int interruptFlag, double timeout_s, Data interrupt) {
//		// TODO 自動生成されたメソッド・スタブ
//		if(interrupt == null) {
//			interrupt = new SingleRegister(); 
//		}
//		long start = System.currentTimeMillis();
//		while(start - System.currentTimeMillis() < timeout_s) {
//			int status = getInterruptStatus(interrupt, "None");
//			if(interrupt.getData(0) &) {
//				
//			}
//		}
//		return false;
//	}
}
