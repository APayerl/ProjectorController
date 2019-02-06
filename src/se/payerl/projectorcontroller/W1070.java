package se.payerl.projectorcontroller;

import java.nio.charset.StandardCharsets;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import se.payerl.projectorcontroller.SerialHelper.Helper;
import se.payerl.projectorcontroller.SerialHelper.Enums.DataBits;
import se.payerl.projectorcontroller.SerialHelper.Enums.Parity;
import se.payerl.projectorcontroller.SerialHelper.Enums.StopBits;
import se.payerl.projectorcontroller.benq.Generic;

public class W1070 extends Projector {
	public W1070() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
		super.projectorName = "W1070";
		super.helper = new Helper("/dev/ttyUSB0", 115200, DataBits.DATABITS_8, StopBits.STOPBITS_1, Parity.PARITY_NONE, StandardCharsets.US_ASCII);
	}
	
	public void turnOn() {
		super.queueMessage(Generic.Power.ON.getBytes(StandardCharsets.US_ASCII), 1, reply -> {
			System.out.println("Yay we turned on the projector!");
		});
	}

	public void turnOff() {
		super.queueMessage(Generic.Power.OFF.getBytes(StandardCharsets.US_ASCII), 1, reply -> {
			System.out.println("Yay we turned off the projector!");
		});
	}
}