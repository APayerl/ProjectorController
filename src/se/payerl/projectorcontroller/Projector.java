package se.payerl.projectorcontroller;

import se.payerl.projectorcontroller.SerialHelper.Helper;
import se.payerl.projectorcontroller.SerialHelper.SendQueueElement;
import se.payerl.projectorcontroller.SerialHelper.Interfaces.Message;

public abstract class Projector {
	protected String projectorName;
	protected Helper helper;
	
//	public String getProjectorName() {
//		return this.projectorName;
//	}
//	
//	public Helper getProjectorHelper() {
//		return this.helper;
//	}
//	
//	protected void setProjectorName(String name) {
//		this.projectorName = name;
//	}
//	
//	protected void setProjectorHelper(Helper h) {
//		this.helper = h;
//	}
	
	public void queueMessage(byte[] message, int replys, Message callback) {
		this.queueMessage(new SendQueueElement(message, replys, callback));
	}
	
	public void queueMessage(SendQueueElement sqe) {
		this.helper.queueMessage(sqe);
	}
	
	public void closePorts() {
		this.helper.close();
	}
}