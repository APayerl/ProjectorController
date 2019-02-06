package se.payerl.projectorcontroller.SerialHelper.Interfaces;

import se.payerl.projectorcontroller.SerialHelper.SendQueueElement;

public interface Message {
	public void newMessage(String message);
	public void newReply(String originalMessage, String reply);
}