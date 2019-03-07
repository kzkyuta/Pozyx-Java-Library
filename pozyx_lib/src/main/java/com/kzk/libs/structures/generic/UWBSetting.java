package com.kzk.libs.structures.generic;

import java.util.ArrayList;

public class UWBSetting extends ByteStructure {
	
	public static final byte DEFAULT_CHANNNEL = 0x05;
	public static final byte DEFAULT_BITRATE = 0x01; // 0: 110kbits/s, 1: 850kbits/s(Default), 2: 6.8Mbits/s
	public static final byte DEFAULT_PRF = 0x02; // 1: 16MHz;, 2: 64MHz(default)
	public static final byte DEFAULT_PLEN = 0x08; // 1024 symbols
	public static final double DEFAULT_GAIN_DB = 25.0;
	
	protected String data = "";
	protected int dataSize = 7;
	public String id = "None";
	
	public byte channnel;
	public byte bitrate;
	public byte prf;
	public byte plen;
	public double gain_db;
//	protected ArrayList<byte> datas = new ArrayList<byte>();
	public byte[] datas;

	@Override
	public void load(ArrayList<String> data) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
