package se.payerl.projectorcontroller.SerialHelper;

import java.nio.charset.Charset;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import se.payerl.projectorcontroller.SerialHelper.Enums.DataBits;
import se.payerl.projectorcontroller.SerialHelper.Enums.Parity;
import se.payerl.projectorcontroller.SerialHelper.Enums.StopBits;

public class SerialManager {
	@SuppressWarnings("unused")
	private SerialManager() {}
	private SerialPort serialPort;
	private MessageQueue<SendQueueElement> myQueue;
	private SerialWriter serialWriter;
	private ControlObject controlObject;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	
//	public SerialManager(String portName, int baudRate, DataBits dataBits, StopBits stopBits, Parity parity, MessageQueue<SendQueueElement> queue) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
//		this.myQueue = queue;
//		serialPort = connect(portName, baudRate, dataBits, stopBits, parity);
//	}
	
	public SerialManager(String portName, int baudRate, DataBits dataBits, StopBits stopBits, Parity parity, MessageQueue<SendQueueElement> queue, Charset charset) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
		this.myQueue = queue;
		serialPort = connect(portName, baudRate, dataBits, stopBits, parity, charset);
	}

	public void disconnect() {
		controlObject.keepGoing = false;
//		commPort.close();
	}
	
	public SerialPort connect(String portName, int baudRate, DataBits dataBits, StopBits stopBits, Parity parity, Charset charset) throws NoSuchPortException, gnu.io.PortInUseException, UnsupportedCommOperationException
    {
        portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        commPort = portIdentifier.open(this.toString(),2000);
        serialPort = null;
        
        if ( commPort instanceof SerialPort )
        {
            serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(baudRate, dataBits.getValue(), stopBits.getValue(), parity.getValue());
            this.controlObject = new ControlObject();
			this.serialWriter = new SerialWriter(serialPort, this.myQueue, this.controlObject, charset);
			serialWriter.start();
        }
        else
        {
        	//TODO Throw exception for port not being a serial port?
            System.out.println("Error: Only serial ports are handled by this example.");
        }
        return serialPort;
    }
	
//	public class NewSendRecieve implements Runnable {
//		private ControlObject controlObjectReader;
//		private ControlObject controlObjectWriter;
//		private Queue<SendQueueElement> queue;
//		private OutputStream out;
//		
//		public NewSendRecieve(OutputStream out, Queue<SendQueueElement> queue, ControlObject controlObjectWriter, ControlObject controlObjectReader) {
//			this.out = out;
//			this.queue = queue;
//			this.controlObjectReader = controlObjectReader;
//			this.controlObjectWriter = controlObjectWriter;
//			throw new NotImplementedException("SerialWriter.SerialWriter(InputStream)");
//		}
//
//		@Override
//		public void run() {
//			SendQueueElement lastSent;
//			while(controlObjectWriter.keepGoing || !queue.isEmpty()) {
//				//TODO Fix logic
//				try {
//					if(!this.queue.isEmpty()) {
//						lastSent = this.queue.peek();
//						this.out.write(lastSent.message);
//					}
//				} catch (NoSuchElementException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
