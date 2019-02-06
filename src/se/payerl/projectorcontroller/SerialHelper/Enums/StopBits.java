package se.payerl.projectorcontroller.SerialHelper.Enums;

public enum StopBits {
 	STOPBITS_1(1),
 	STOPBITS_1_5(3),
 	STOPBITS_2(2);
	
	private final int value;
	StopBits(final int newValue) {
        value = newValue;
    }
	public int getValue() { return value; }
}