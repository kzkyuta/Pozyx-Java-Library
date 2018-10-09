# Pozyx-Java-Libraly
The Java library to work with the pozyx accurate indoor positioning system

## Requisities

* This library works on Java, an you need to Download and install JDK. Please Download [pozyx_lib.jar](https://github.com/kzkyuta/Pozyx-Java-Library/blob/master/pozyx_lib/build/libs/pozyx_lib.jar), and Import this to your project.
* Windows only install [ST's virtual COM driver](https://www.st.com/content/st_com/en/products/development-tools/software-development-tools/stm32-software-development-tools/stm32-utilities/stsw-stm32102.html). After running this installer, please run the correct driver package for your system, located in "C:\Program Files (x86)\STMicroelectronics\Software\Virtual comport driver". Choose Win7 if you run Windows 7 or older. Choose Win8 for Windows 8 or newer. Run "dpinst_amd64.exe" on a 64-bit system, "dpinst_x86.exe"on a 32-bit system.

## How to use this library

Download [pozyx_lib.jar](https://github.com/kzkyuta/Pozyx-Java-Library/blob/master/pozyx_lib/build/libs/pozyx_lib.jar), and Import this to your project. 

After [pozyx_lib.jar](https://github.com/kzkyuta/Pozyx-Java-Library/blob/master/pozyx_lib/build/libs/pozyx_lib.jar), was imported on your project, you can confirm if you import the lib correctly, and know which port your Pozyx is on. 
First, write the sentence below and import the lib on your main class.

``` java
import com.kzk.libs.PozyxSerial;
```
After this, make the instance. If there is no error, you could import the lib, and your pozyx was recognized correctly.

```java
PozyxSerial port = new PozyxSerial(PozyxSerial.getFirstPozyxSerialPort());
```

### How do I know what port my Pozyx is on 

* You can see Ports on your system easily with running `port.listSerialPort ` with your instance.
* You can quickly find whether there's a recognized Pozyx device using `PozyxSerial.getFirstPozyxSerialPort()`

## Examples 

There is an [example java application](https://github.com/kzkyuta/Pozyx-Java-Library/blob/master/pozyx_app/src/main/java/com/kzk/apps/Main.java). you can download it, and run to see how this library works. 

Also the below, there are some explanation how it works. 

* To check the Farmware Version run below

```java 
DeviceDetailes device = new DeviceDetailes();
port.getDeviceDetails(device);   // port is instance from SerialPort, device is instance from DeviceDetailes
```

* To control LEDs you can use the codes below. First argument is number of led, and it is 1-4. There are 4 LEDs of the Pozyx Tag. Second argument is boolean and it is true, the LED is turn on, and the opposite is turning off.

```java 
port.setLed(1, true);
port.setLed(2, false);
```

* To get the acceleration sensor datas, you can type below.

```java 
Data ACCdata = new Data();  // build a container for ACC data.
port.getACCData(ACCdata);  // receive the data from pozyx
System.out.println(ACCdata.getData());   // out put the data, and the data type is Integer.
```

## References

This library was made following [pypozyx](https://github.com/pozyxLabs/Pozyx-Python-library)
