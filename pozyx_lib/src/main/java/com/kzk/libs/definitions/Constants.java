package com.kzk.libs.definitions;

public class Constants {
	// Pozyx status returns
	public static final int POZYX_FAILURE = 0x0;
	public static final int POZYX_SUCCESS = 0x1;
	public static final int POZYX_TIMEOUT = 0x8;

	public static final double DELAY_LOCAL_WRITE = 0.001;
	public static final double DELAY_REMOTE_WRITE = 0.005;
	
	public static final double DELAY_INTERRUPT = 0.1;
	public static final double DELAY_POLLING_FAST = 0.0005;
	public static final long DELAY_POLLING_MIDDLE = 1;  // ms

	
	/*
	# Pozyx serial buffer sizes
    MAX_BUF_SIZE = 100
    MAX_SERIAL_SIZE = 28

    # Remote operations
    REMOTE_READ = 0x02
    REMOTE_WRITE = 0x04
    REMOTE_DATA = 0x06
    REMOTE_FUNCTION = 0x08

    # Pozyx delay constants
    DELAY_POLLING = 0.002
    DELAY_POLLING_FAST = 0.0005
    DELAY_LOCAL_WRITE = 0.001
    DELAY_LOCAL_FUNCTION = 0.005
    DELAY_REMOTE_WRITE = 0.005
    DELAY_REMOTE_FUNCTION = 0.01
    DELAY_INTERRUPT = 0.1
    DELAY_RANGING = 0.2
    DELAY_MODE_CHANGE = 0.02
    DELAY_FLASH = 0.5

    # Pozyx timeout constants
    TIMEOUT_RANGING = 0.025
    TIMEOUT_REMOTE_RANGING = 0.1
    TIMEOUT_POSITIONING = 0.2
    TIMEOUT_REMOTE_POSITIONING = 0.4
    TIMEOUT_POSITIONING_DATA = 1.0
    TIMEOUT_REMOTE_POSITIONING_DATA = 1.0
    TIMEOUT_OPTIMAL_DISCOVERY = 0.1

    # Pozyx status returns
    STATUS_FAILURE = 0x0
    STATUS_SUCCESS = 0x1
    STATUS_TIMEOUT = 0x8

    # Pozyx interrupt pin
    INT_PIN0 = 0x0
    INT_PIN1 = 0x1

    # Pozyx led control indexes
    LED_CTRL_LED_RX = 0x10
    LED_CTRL_LED_TX = 0x20
    LED_ON = True
    LED_OFF = False

    # Pozyx device modes
    TAG_MODE = 0
    ANCHOR_MODE = 1

    # The GPIO modes
    GPIO_DIGITAL_INPUT = 0
    GPIO_PUSH_PULL = 1
    GPIO_OPEN_DRAIN = 1

    ALL_GPIO_MODES = [GPIO_DIGITAL_INPUT, GPIO_PUSH_PULL, GPIO_OPEN_DRAIN]

    # The GPIO pull resistor configuration
    GPIO_NO_PULL = 0
    GPIO_PULL_UP = 1
    GPIO_PULL_DOWN = 2

    ALL_GPIO_PULLS = [GPIO_NO_PULL, GPIO_PULL_UP, GPIO_PULL_DOWN]

    # anchor selection modes
    ANCHOR_SELECT_MANUAL = 0
    ANCHOR_SELECT_AUTO = 1

    # discovery options
    DISCOVERY_ANCHORS_ONLY = 0
    DISCOVERY_TAGS_ONLY = 1
    DISCOVERY_ALL_DEVICES = 2

    DISCOVERY_TYPES = [DISCOVERY_ALL_DEVICES, DISCOVERY_ANCHORS_ONLY, DISCOVERY_TAGS_ONLY]

    # Pozyx positioning dimensions
    DIMENSION_3D = 3
    DIMENSION_2D = 2
    DIMENSION_2_5D = 1

    DIMENSIONS = [DIMENSION_3D, DIMENSION_2D, DIMENSION_2_5D]

    # positioning algorithm options
    POSITIONING_ALGORITHM_UWB_ONLY = 0
    POSITIONING_ALGORITHM_TRACKING = 4
    POSITIONING_ALGORITHM_NONE = 3

    POSITIONING_ALGORITHMS = [POSITIONING_ALGORITHM_UWB_ONLY, POSITIONING_ALGORITHM_TRACKING, POSITIONING_ALGORITHM_NONE]

    # ranging protocol options
    RANGE_PROTOCOL_PRECISION = 0x00
    RANGE_PROTOCOL_FAST = 0x01
    RANGE_PROTOCOL_TEST = 0x02

    RANGING_PROTOCOLS = [RANGE_PROTOCOL_PRECISION, RANGE_PROTOCOL_FAST]

    # positioning filters
    FILTER_TYPE_NONE = 0
    FILTER_TYPE_FIR = 1
    FILTER_TYPE_MOVING_AVERAGE = 3
    FILTER_TYPE_MOVING_MEDIAN = 4

    FILTER_TYPES = [FILTER_TYPE_NONE, FILTER_TYPE_FIR, FILTER_TYPE_MOVING_AVERAGE, FILTER_TYPE_MOVING_MEDIAN]

    # how to intercept pozyx events: by polling or by interrupts
    MODE_POLLING = 0
    MODE_INTERRUPT = 1

    # Division factors for converting the raw register values to meaningful
    # physical quantities
    POSITION_DIV_MM = 1.0
    PRESSURE_DIV_PA = 1000.0
    MAX_LINEAR_ACCELERATION_DIV_MG = 1.0
    ACCELERATION_DIV_MG = 1.0
    GYRO_DIV_DPS = 16.0
    MAGNETOMETER_DIV_UT = 16.0
    EULER_ANGLES_DIV_DEG = 16.0
    QUATERNION_DIV = 16384.0
    TEMPERATURE_DIV_CELSIUS = 1.0

    # flash configuration types
    FLASH_SAVE_REGISTERS = 1
    FLASH_SAVE_ANCHOR_IDS = 2
    FLASH_SAVE_NETWORK = 3
    FLASH_SAVE_ALL = 4

    ALL_FLASH_SAVE_TYPES = [FLASH_SAVE_REGISTERS, FLASH_SAVE_ANCHOR_IDS, FLASH_SAVE_NETWORK, FLASH_SAVE_ALL]

    # possible pin configuration settings
    INTERRUPT_CONFIG = 0x24
    PIN_MODE_PUSH_PULL = 0
    PIN_MODE_OPEN_DRAIN = 1

    # Possible pin activity states
    PIN_ACTIVE_LOW = 0
    PIN_ACTIVE_HIGH = 1

    # Possible UWB settings

    UWB_BITRATE_110_KBPS = 0
    UWB_BITRATE_850_KBPS = 1
    UWB_BITRATE_6810_KBPS = 2

    UWB_PRF_16_MHZ = 1
    UWB_PRF_64_MHZ = 2

    UWB_PLEN_64 = 0x04
    UWB_PLEN_128 = 0x14
    UWB_PLEN_256 = 0x24
    UWB_PLEN_512 = 0x34
    UWB_PLEN_1024 = 0x08
    UWB_PLEN_1536 = 0x18
    UWB_PLEN_2048 = 0x28
    UWB_PLEN_4096 = 0x0C

    ALL_UWB_CHANNELS = [1, 2, 3, 4, 5, 7]

    ALL_UWB_BITRATES = [
        UWB_BITRATE_110_KBPS,
        UWB_BITRATE_850_KBPS,
        UWB_BITRATE_6810_KBPS,
    ]

    ALL_UWB_PRFS = [
        UWB_PRF_16_MHZ,
        UWB_PRF_64_MHZ,
    ]

    ALL_UWB_PLENS = [
        UWB_PLEN_64,
        UWB_PLEN_128,
        UWB_PLEN_256,
        UWB_PLEN_512,
        UWB_PLEN_1024,
        UWB_PLEN_1536,
        UWB_PLEN_2048,
        UWB_PLEN_4096,
    ]
    */
}
