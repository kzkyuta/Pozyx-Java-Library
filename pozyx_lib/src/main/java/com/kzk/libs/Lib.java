package com.kzk.libs;

import javax.print.attribute.ResolutionSyntax;
import javax.swing.SpringLayout.Constraints;

import java.util.logging.Logger;

import com.kzk.libs.definitions.Constants;
import com.kzk.libs.definitions.Registers;
import com.kzk.libs.structures.Data;
import com.kzk.libs.structures.generic.Generic;
import com.kzk.libs.structures.device.NetworkID;
import com.kzk.libs.structures.generic.SingleRegister;
import com.kzk.libs.structures.device.UWBSettings;

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
		SingleRegister firmware = new SingleRegister();
		int status = getFirmwareVersion(firmware, remoteId);
		NetworkID networkId; 
		if(remoteId == "None") {
			networkId = new NetworkID();
			this.getNetworkId(networkId);
		} else {
			networkId = new NetworkID(remoteId);
		}
		System.out.println("Device Information for device " + networkId.id);
		if(status != Constants.POZYX_SUCCESS) {
			System.out.println("\t- Error: Couldn't retrieve device information");  // TODO: change to worning
			return;
		}
		byte[] ver = Generic.hexStringToByteArray(firmware.getData());
		System.out.println("\t- Firmware version v" + (ver[0] >> 4) + "." + (ver[0] % 0x10));
	}
	
	public int getNetworkId(NetworkID networkId) {  // 
		return regRead(Registers.NETWORK_ID, networkId);
	}
	
	public int getDeviceDetails(Data dDetails) {
		return getDeviceDetails(dDetails, "None");
	}
	public int getDeviceDetails(Data dDetails, String remoteId) {
		int status = this.getWhoAmI(dDetails, remoteId);
		if(dDetails.id.equals("None")) {  // TODO: Baptistに聞く
//			if(remoteId.equals("None")) {
//				NetworkId networkId = new NetworkId();
//				status &= this.getNetworkId(networkId);
//				dDetails.id = networkId.id;
//			}else {
//				dDetails.id = remoteId;
//			}
		}
		System.out.println(dDetails.id);
		return status;
	}
	
	public int setLed(int ledNum, boolean state){
		return setLed(ledNum, state, "None");
	}
	public int setLed(int ledNum, boolean state, String remoteId){
		if(!(1<= ledNum) || !(ledNum <= 4)) {  // for Anchor
			LOGGER.severe("setLed: LED number " + ledNum + "not in range");
		}
		Data params = new SingleRegister();
		Data data = new SingleRegister();
		
		byte byteData;
		if(state) {
			byteData = (byte) ((0x01 << (byte) (4-1+ledNum)) | (((0x1 << (byte) (ledNum -1)) & (byte)0xFF)));
		}else {
			byteData = (byte) ((0x01 << (byte) (4-1+ledNum)) | (((0x0 << (byte) (ledNum -1)) & (byte)0xFF)));
		}
		params.setData(String.format("%02x", byteData).toUpperCase());
		return this.useFunction(Registers.LED_CONTROL, params, data, remoteId);
	}
	
	public abstract int setWrite(byte address, Data data, String remoteId, double localDelay, double remoteDelay);
	
	public void setUWBSetting(UWBSettings uwbSetting, String remoteId, boolean saveToFlash) {
		
		Data gainRegister = new Data(String.valueOf(uwbSetting.gain_db));
		Data uwbRegisters = new Data(String.valueOf(uwbSetting.channnel) + String.valueOf(uwbSetting.bitrate + (uwbSetting.prf << 6)));
		this.setWrite(Registers.UWB_CHANNEL, uwbRegisters, remoteId, 2 * Constants.DELAY_LOCAL_WRITE, 2 * Constants.DELAY_REMOTE_WRITE);
	}
	
	public int getACCData(Data data) {
		return getACCData(data, "None");
	}
	public int getACCData(Data data, String remoteId) {
		data.setDataSize(6);
		return this.getRead(Registers.ACCELERATION_X, data, remoteId);
	}
}
