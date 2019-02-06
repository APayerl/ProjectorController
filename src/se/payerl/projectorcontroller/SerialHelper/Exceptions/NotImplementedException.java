package se.payerl.projectorcontroller.SerialHelper.Exceptions;

@SuppressWarnings("serial")
public class NotImplementedException extends UnsupportedOperationException {
	public NotImplementedException() {
		super();
	}
	
	public NotImplementedException(String string) {
		super(string + " is not yet implemented!");
	}
}