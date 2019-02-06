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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import gnu.io.SerialPort;

public class SerialWriter extends Thread {
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
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String line = null;
		OutputStream os = null;
		SendQueueElement tmp = null;
		List<String> responses = null;
		
		try {
			is = this.port.getInputStream();
			isr = new InputStreamReader(is, this.charset);
			br = new BufferedReader(isr);
			os = this.port.getOutputStream();
			responses = new ArrayList<>();
			
			while(controlObject.keepGoing || !queue.isEmpty()) {
				if(!this.queue.isEmpty()) {
					tmp = this.queue.peek();
					os.write(tmp.message.getBytes(this.charset));
					
					int counter = 0;
					while((line = br.readLine()) != null) {
						if(!line.contentEquals("")) {
							counter += 1;
							responses.add(line);
						}
						if(counter > tmp.numberOfReplys) {
							break;
						}
					}
					if(tmp.replyCallback.newReply(responses.get(0).substring(1), responses.get(1))) {
						this.queue.pop();
					}
				}
			}
		} catch (IOException e1) {
			//TODO Implement good solution!
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				os.close();
				port.close();
			} catch (IOException e) {
				//TODO Implement good solution!
			}
		}
	}
}