package se.payerl.projectorcontroller.SerialHelper;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialWriter extends Thread implements SerialPortEventListener {
	private ControlObject controlObject;
	private MessageQueue<SendQueueElement> queue;
	private SerialPort port;
	private Charset charset;

	public SerialWriter(SerialPort port, MessageQueue<SendQueueElement> queue, ControlObject cob, Charset charset) {
		this.port = port;
		this.queue = queue;
		this.controlObject = cob;
		this.charset = charset;
	}

	@Override
	public void run() {
//		InputStream is = null;
//		InputStreamReader isr = null;
//		BufferedReader br = null;
		OutputStream os = null;
//		String line = null;
		
		try {
			this.port.addEventListener(this);
//			is = this.port.getInputStream();
//			isr = new InputStreamReader(is, this.charset);
//			br = new BufferedReader(isr);
			os = this.port.getOutputStream();
			
			while(controlObject.keepGoing || !queue.isEmpty()) {
				if(!this.queue.isEmpty()) {
					try {
						os.write(this.queue.pop().message);
//						System.out.println("Time to read");
//						while((line = br.readLine()) != null) {
//							//System.out.println("|" + line + "|");
//							System.out.println("Reading..");
//							line = null;
//						}
//						System.out.println("Done reading");
////						os.flush();
					} catch (IOException e) {}
				}
			}
		} catch (IOException e1) {
			System.out.println("io exception row 54");
		} catch (TooManyListenersException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			this.port.removeEventListener();
			try {
//				br.close();
//				isr.close();
//				is.close();
				os.close();
				port.close();
			} catch (IOException e) {
				System.out.println("io exception row 63");
			}
		}
	}
	
	@Override
	public void serialEvent(SerialPortEvent ev) {
		switch(ev.getEventType()) {
			case SerialPortEvent.BI:
		    case SerialPortEvent.OE:
		    case SerialPortEvent.FE:
		    case SerialPortEvent.PE:
		    case SerialPortEvent.CD:
		    case SerialPortEvent.CTS:
		    case SerialPortEvent.DSR:
		    	System.out.println("data set ready");
		    case SerialPortEvent.RI:
		    case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
		    	System.out.println("empty");
		        break;
			case SerialPortEvent.DATA_AVAILABLE:
				try {
					System.out.println("Data available!");
					byte[] readBuffer = new byte[port.getInputStream().available()];
					port.getInputStream().read(readBuffer, 0, port.getInputStream().available());
//					Thread.sleep(1000);
					System.out.print(new String(readBuffer, this.charset));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		}
		System.out.println("end of event");
	}
}