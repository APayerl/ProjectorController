package se.payerl.projectorcontroller.SerialHelper;

import se.payerl.projectorcontroller.SerialHelper.Interfaces.Message;

public class SendQueueElement {
	public SendQueueElement(byte[] message, int linesToReturn, Message callback) {
		this.message = message;
		this.numberOfReplys = linesToReturn;
		this.callback = callback;
	}
	
	@SuppressWarnings("unused")
	private SendQueueElement() {}
	
	public byte[] message;
	public int numberOfReplys;
	public Message callback;
}