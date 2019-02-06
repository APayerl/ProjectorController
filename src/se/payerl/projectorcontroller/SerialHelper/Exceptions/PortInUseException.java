package se.payerl.projectorcontroller.SerialHelper.Exceptions;

@SuppressWarnings("serial")
public class PortInUseException extends UnsupportedOperationException {
	@SuppressWarnings("unused")
	private PortInUseException(){}
	public PortInUseException(String s) {
		super("Port: " + s + " is already in use!");
	}
}
