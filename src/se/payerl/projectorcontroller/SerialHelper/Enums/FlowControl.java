package se.payerl.projectorcontroller.SerialHelper.Enums;

public enum FlowControl {
	FLOWCONTROL_NONE(0),
 	FLOWCONTROL_RTSCTS_IN(1),
 	FLOWCONTROL_RTSCTS_OUT(2),
 	FLOWCONTROL_XONXOFF_IN(4),
 	FLOWCONTROL_XONXOFF_OUT(8);
	
	private final int value;
	FlowControl(final int newValue) {
        value = newValue;
    }
	public int getValue() { return value; }
}