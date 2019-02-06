package se.payerl.projectorcontroller.SerialHelper.Enums;

public enum Parity {
	PARITY_EVEN(2),
 	PARITY_MARK(3),
 	PARITY_NONE(0),
 	PARITY_ODD(1),
 	PARITY_SPACE(4);
	
	private final int value;
	Parity(final int newValue) {
        value = newValue;
    }
	public int getValue() { return value; }
}