package com.kzk.libs.structures.device;

import com.kzk.libs.structures.generic.Data;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;

public class NetworkId extends Data {
	// this class will be used as container for NetworkId
	// data format shold be "H"
	
	private static final Logger LOGGER = Logger.getLogger(NetworkId.class.getName());
	
	public NetworkId() {
		this("");
	}
	
	public NetworkId(String id) {
		this.data.add("");
		this.setNetworkId(id);
		this.dataFormat = "h";
		this.setPackedSize();
	}
	
	public void setNetworkId(String id) {
		// try to change the id to byte array for checking if id is in range of byte.
		byte[] bytes = DatatypeConverter.parseHexBinary(id); 
		if(bytes.length != 2) {
			LOGGER.warning("This value is not a ID style");
			return;
		}
		ArrayList<String> tempData = new ArrayList<String>();
		tempData.add(id);
 		this.data = tempData;
	}
	
	public String getNetWorkId() {
		return this.data.get(0);
	}
	
}
