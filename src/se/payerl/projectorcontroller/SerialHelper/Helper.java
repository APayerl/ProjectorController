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
	
	public String stringToHex(String message) {
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