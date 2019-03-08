package com.kzk.libs.definitions;

public class Bitmasks {
	// Pozyx firmware identifiers
	public static final int intFIRMWARE_MAJOR = 0xF0;
	public static final int intFIRMWARE_MINOR = 0xF;

	// Pozyx device identifier for hardware
	public static final int ANCHOR = 0x00;
	public static final int TAG = 0x20;

    // Bit mask for POZYX_ST_RESULT
	public static final int SELFTEST_RESULT_ACCELEROMETER = 0x01;
	public static final int SELFTEST_RESULT_MAGNETOMETER = 0x02;
	public static final int SELFTEST_RESULT_GYRO = 0x04;
	public static final int SELFTEST_RESULT_MCU = 0x08;
	public static final int SELFTEST_RESULT_PRESSURE = 0x10;
	public static final int SELFTEST_RESULT_UWB = 0x20;

    // Bit mask for POZYX_INT_STATUS
	public static final int INT_STATUS_ERR = 0x01;
	public static final int INT_STATUS_POS = 0x02;
	public static final int INT_STATUS_IMU = 0x04;
	public static final int INT_STATUS_RX_DATA = 0x08;
	public static final int INT_STATUS_FUNC = 0x10;

    // Bit mask for POZYX_INT_MASK
	public static final int INT_MASK_ERR = 0x01;
	public static final int INT_MASK_POS = 0x02;
	public static final int INT_MASK_IMU = 0x04;
	public static final int INT_MASK_RX_DATA = 0x08;
	public static final int INT_MASK_FUNC = 0x10;
	public static final int INT_MASK_TDMA = 0x40;
	public static final int INT_MASK_PIN = 0x80;
	public static final int INT_MASK_ALL = 0x1F;

    // Bit mask for POZYX_LED_CTRL
	public static final int LED_CTRL_LED1 = 0x01;
	public static final int LED_CTRL_LED2 = 0x02;
	public static final int LED_CTRL_LED3 = 0x04;
	public static final int LED_CTRL_LED4 = 0x08;

    // Bit mask for device type
	public static final int DEVICE_TYPE = 0xE0;

	// Bit mask for POZYX_ST_RESULT
	public static final int POZYX_ST_RESULT_ACC = 0x01;
	public static final int POZYX_ST_RESULT_MAGN = 0x02;
	public static final int POZYX_ST_RESULT_GYR = 0x04;
	public static final int POZYX_ST_RESULT_MCU = 0x08;
	public static final int POZYX_ST_RESULT_PRES = 0x10;
	public static final int POZYX_ST_RESULT_UWB = 0x20;

	// Bit mask for POZYX_INT_STATUS
	public static final int POZYX_INT_STATUS_ERR = 0x01;
	public static final int POZYX_INT_STATUS_POS = 0x02;
	public static final int POZYX_INT_STATUS_IMU = 0x04;
	public static final int POZYX_INT_STATUS_RX_DATA = 0x08;
	public static final int POZYX_INT_STATUS_FUNC = 0x10;

	// Bit mask for POZYX_INT_MASK
	public static final int POZYX_INT_MASK_ERR = 0x01;
	public static final int POZYX_INT_MASK_POS = 0x02;
	public static final int POZYX_INT_MASK_IMU = 0x04;
	public static final int POZYX_INT_MASK_RX_DATA = 0x08;
	public static final int POZYX_INT_MASK_FUNC = 0x10;
	public static final int POZYX_INT_MASK_TDMA = 0x40;
	public static final int POZYX_INT_MASK_PIN = 0x80;
	public static final int POZYX_INT_MASK_ALL = 0x1F;

	// Bit mask for POZYX_LED_CTRL
	public static final int POZYX_LED_CTRL_LED1 = 0x01;
	public static final int POZYX_LED_CTRL_LED2 = 0x02;
	public static final int POZYX_LED_CTRL_LED3 = 0x04;
	public static final int POZYX_LED_CTRL_LED4 = 0x08;

	// Remote operations
	public static final int POZYX_REMOTE_READ = 0x02;
	public static final int POZYX_REMOTE_WRITE = 0x04;
	public static final int POZYX_REMOTE_DATA = 0x06;
	public static final int POZYX_REMOTE_FUNCTION = 0x08;

	// Bit mask for device type
	public static final int POZYX_TYPE = 0xE0;
}
