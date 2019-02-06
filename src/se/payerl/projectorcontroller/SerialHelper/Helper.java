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

package se.payerl.projectorcontroller.SerialHelper;

import java.nio.charset.Charset;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import se.payerl.projectorcontroller.SerialHelper.Enums.DataBits;
import se.payerl.projectorcontroller.SerialHelper.Enums.Parity;
import se.payerl.projectorcontroller.SerialHelper.Enums.StopBits;

public class Helper {
	//private Queue<SendQueueElement> sendQueue;
	private MessageQueue<SendQueueElement> sendQueue;
	private SerialManager sm;
	
	@SuppressWarnings("unused")
	private Helper() {}
	
	public Helper(String portName, int baudRate, DataBits dataBits, StopBits stopBits, Parity parity, Charset charset) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
		this.sendQueue = new MessageQueue<>();
		this.sm = new SerialManager(portName, baudRate, dataBits, stopBits, parity, sendQueue, charset);
	}

	public void queueMessage(SendQueueElement sqe) {
		this.sendQueue.push(sqe);
	}
	
	public static String stringToHex(String message) {
	    char[] ch = message.toCharArray();
	    StringBuilder builder = new StringBuilder();
	    for (char c : ch) {
	    	// Step-2 Use %H to format character to Hex
	    	String hexCode=String.format("%H", c);
	    	builder.append(hexCode);
	    }
	    return builder.toString();
	}
	
	public void close() {
		this.sm.disconnect();
	}
}