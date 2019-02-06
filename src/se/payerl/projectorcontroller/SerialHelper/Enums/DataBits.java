package se.payerl.projectorcontroller.SerialHelper.Enums;

public enum DataBits {
	DATABITS_5(5),
	DATABITS_6(6),
	DATABITS_7(7),
	DATABITS_8(8);
	
	private final int value;
	DataBits(final int newValue) {
        value = newValue;
    }
	public int getValue() { return value; }
}