package com.kzk.libs;

import com.kzk.libs.structures.generic.Data;
import com.kzk.libs.structures.generic.SingleRegister;


public abstract class Core {

	abstract int regRead(byte address, Data data);
	
	abstract int regWrite(byte address, Data data);
	
	abstract int remoteRegWrite(String remoteId, byte address, Data data);
	
	abstract int regFunction(byte address, Data params, Data data);
	
	abstract int remoteRegRead(String Destination, byte address, Data data);
	
	abstract void waitForFlag(boolean interruptFlag, float timeoutS, boolean interrupt);
	
	abstract int useFunction(byte function, Data params, Data data, String remoteId);
	
	abstract int clearInterruptStatus();
	
	abstract int getInterruptStatus(Data interrupt, String remoteId);
	
//	abstract int getRead(byte address, Data data, String remoteId);
}
