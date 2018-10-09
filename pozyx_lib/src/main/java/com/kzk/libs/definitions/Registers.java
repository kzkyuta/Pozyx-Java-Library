package com.kzk.libs.definitions;

public class Registers {
	public static final byte WHO_AM_I = 0x0; // Returns the constant value 0x43.
	public static final byte FIRMWARE_VERSION = 0x1; // Returns the POZYX firmware version.
	public static final byte HARDWARE_VERSION = 0x2; // Returns the POZYX hardware version.
	public static final byte SELFTEST_RESULT = 0x3; // Returns the self-test result
	public static final byte ERROR_CODE = 0x4; // Describes a possibly system error.
	public static final byte INTERRUPT_STATUS = 0x5; // Indicates the source of the interrupt.
	public static final byte CALIBRATION_STATUS = 0x6; // Returns the calibration status.

	// Configuration registers
	public static final byte INTERRUPT_MASK = 0x10; // Indicates which interrupts are enabled.
	public static final byte INTERRUPT_PIN = 0x11; // Configure the interrupt pin
	public static final byte LED_CONFIGURATION = 0x15; // Configure the LEDs
	public static final byte POSITIONING_FILTER = 0x14; // Filter used for positioning
	public static final byte POSITIONING_ALGORITHM = 0x16; // Algorithm used for positioning
	// Configure the number of anchors and selection procedure
	public static final byte POSITIONING_NUMBER_OF_ANCHORS = 0x17;
	public static final byte[] ALL_POSITIONING_REGISTERS = { 0x14, 0x16, 0x21, 0x38 };
	// Defines the update interval in ms in continuous positioning.
	public static final byte POSITIONING_INTERVAL = 0x18;
	public static final byte NETWORK_ID = 0x1A;// The network id.
	public static final byte UWB_CHANNEL = 0x1C; // UWB channel number.
	// Configure the UWB datarate and pulse repetition frequency (PRF)
	public static final byte UWB_RATES = 0x1D;
	public static final byte UWB_PLEN = 0x1E; // Configure the UWB preamble length.
	public static final byte UWB_GAIN = 0x1F; // Configure the power gain for the UWB transmitter
	public static final byte[] ALL_UWB_REGISTERS = { 0x1C, 0x1D, 0x1E, 0x1F };
	public static final byte UWB_CRYSTAL_TRIM = 0x20; // Trimming value for the uwb crystal.
	public static final byte RANGING_PROTOCOL = 0x21; // The ranging protocol
	// Configure the mode of operation of the pozyx device
	public static final byte OPERATION_MODE = 0x22;
	public static final byte SENSORS_MODE = 0x23; // Configure the mode of operation of the sensors
	public static final byte CONFIG_GPIO_1 = 0x27; // Configure GPIO pin 1.
	public static final byte CONFIG_GPIO_2 = 0x28; // Configure GPIO pin 2.
	public static final byte CONFIG_GPIO_3 = 0x29; // Configure GPIO pin 3.
	public static final byte CONFIG_GPIO_4 = 0x2A; // Configure GPIO pin 4.

	// Positioning data
	public static final byte POSITION_X = 0x30; // x-coordinate of the device in mm.
	public static final byte POSITION_Y = 0x34; // y-coordinate of the device in mm.
	public static final byte POSITION_Z = 0x38; // z-coordinate of the device in mm.
	public static final byte HEIGHT = 0x38; // z-coordinate of the device in mm.
	public static final byte POSITIONING_ERROR_X = 0x3C; // estimated error covariance of x
	public static final byte POSITIONING_ERROR_Y = 0x3E; // estimated error covariance of y
	public static final byte POSITIONING_ERROR_Z = 0x40; // estimated error covariance of z
	public static final byte POSITIONING_ERROR_XY = 0x42; // estimated covariance of xy
	public static final byte POSITIONING_ERROR_XZ = 0x44; // estimated covariance of xz
	public static final byte POSITIONING_ERROR_YZ = 0x46; // estimated covariance of yz

	// Sensor data
	public static final byte MAX_LINEAR_ACCELERATION = 0x4E; // Return the max linear acceleration and reset it to 0
	public static final byte PRESSURE = 0x50; // Pressure data in mPa
	public static final byte ACCELERATION_X = 0x54; // Accelerometer data (in mg)
	public static final byte ACCELERATION_Y = 0x56;
	public static final byte ACCELERATION_Z = 0x58;
	public static final byte MAGNETIC_X = 0x5A; // Magnemtometer data
	public static final byte MAGNETIC_Y = 0x5C;
	public static final byte MAGNETIC_Z = 0x5E;
	public static final byte GYRO_X = 0x60; // Gyroscope data
	public static final byte GYRO_Y = 0x62;
	public static final byte GYRO_Z = 0x64;
	// Euler angles heading (or yaw) (1 degree = 16 LSB )
	public static final byte EULER_ANGLE_HEADING = 0x66;
	public static final byte EULER_ANGLE_YAW = 0x66;
	public static final byte EULER_ANGLE_ROLL = 0x68; // Euler angles roll ( 1 degree = 16 LSB )
	public static final byte EULER_ANGLE_PITCH = 0x6A; // Euler angles pitch ( 1 degree = 16 LSB )
	public static final byte QUATERNION_W = 0x6C; // Weight of quaternion.
	public static final byte QUATERNION_X = 0x6E; // x of quaternion
	public static final byte QUATERNION_Y = 0x70; // y of quaternion
	public static final byte QUATERNION_Z = 0x72; // z of quaternion
	public static final byte LINEAR_ACCELERATION_X = 0x74; // Linear acceleration in x-direction
	public static final byte LINEAR_ACCELERATION_Y = 0x76; // Linear acceleration in y-direction
	public static final byte LINEAR_ACCELERATION_Z = 0x78; // Linear acceleration in z-direction
	public static final byte GRAVITY_VECTOR_X = 0x7A; // x-component of gravity vector
	public static final byte GRAVITY_VECTOR_Y = 0x7C; // y-component of gravity vector
	public static final byte GRAVITY_VECTOR_Z = 0x7E; // z-component of gravity vector
	public static final int TEMPERATURE = 0x80; // Temperature

	// General data
	// Returns the number of devices stored internally
	public static final byte DEVICE_LIST_SIZE = (byte)0x81;
	public static final byte RX_NETWORK_ID = (byte)0x82; // The network id of the latest received message
	public static final byte RX_DATA_LENGTH = (byte)0x84; // The length of the latest received message
	public static final byte GPIO_1 = (byte)0x85; // Value of the GPIO pin 1
	public static final byte GPIO_2 = (byte)0x86; // Value of the GPIO pin 2
	public static final byte GPIO_3 = (byte)0x87; // Value of the GPIO pin 3
	public static final byte GPIO_4 = (byte)0x88; // Value of the GPIO pin 4

	// Functions
	public static final byte RESET_SYSTEM = (byte)0xB0; // Reset the Pozyx device
	public static final byte LED_CONTROL = (byte)0xB1; // Control LEDS 1 to 4 on the board
	public static final byte WRITE_TX_DATA = (byte)0xB2; // Write data in the UWB transmit (TX) buffer
	public static final byte SEND_TX_DATA = (byte)0xB3; // Transmit the TX buffer to some other pozyx device
	public static final byte READ_RX_DATA = (byte)0xB4; // Read data from the UWB receive (RX) buffer
	public static final byte DO_RANGING = (byte)0xB5; // Initiate ranging measurement
	public static final byte DO_POSITIONING = (byte)0xB6; // Initiate the positioning process.
	// Set the list of anchor ID's used for positioning.
	public static final byte SET_POSITIONING_ANCHOR_IDS = (byte)0xB7;
	// Read the list of anchor ID's used for positioning.
	public static final byte GET_POSITIONING_ANCHOR_IDS = (byte)0xB8;
	public static final byte RESET_FLASH_MEMORY = (byte)0xB9; // Reset a portion of the configuration in flash memory
	public static final byte SAVE_FLASH_MEMORY = (byte)0xBA; // Store a portion of the configuration in flash memory
	public static final byte GET_FLASH_DETAILS = (byte)0xBB; // Return information on what is stored in flash

	// Device list functions
	// Get all the network IDs's of devices in the device list.
	public static final byte GET_DEVICE_LIST_IDS = (byte)0xC0;
	// Obtain the network ID's of all pozyx devices within range.
	public static final byte DO_DISCOVERY = (byte)0xC1;

	public static final byte CLEAR_DEVICES = (byte)0xC3; // Clear the list of all pozyx devices.
	public static final byte ADD_DEVICE = (byte)0xC4; // Add a pozyx device to the devices list
	// Get the stored device information for a given pozyx device
	public static final byte GET_DEVICE_INFO = (byte)0xC5;
	// Get the stored coordinates of a given pozyx device
	public static final byte GET_DEVICE_COORDINATES = (byte)0xC6;
	// Get the stored range information of a given pozyx device
	public static final byte GET_DEVICE_RANGE_INFO = (byte)0xC7;
	public static final byte CIR_DATA = (byte)0xC8; // Get the channel impulse response (CIR) coefficients

	public static final byte DO_POSITIONING_WITH_DATA = (byte)0xCC;
}
