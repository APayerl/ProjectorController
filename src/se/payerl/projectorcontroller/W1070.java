//ProjectorController is a program used to control a projector using a serial connection.
//Copyright (C) <2019>  <Anders Payerl>
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program. If not, see <https://www.gnu.org/licenses/>.

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