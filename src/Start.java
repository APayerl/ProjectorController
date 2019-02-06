import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import se.payerl.projectorcontroller.W1070;
import se.payerl.projectorcontroller.benq.Generic;

public class Start {
    public static void main(String[] args) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, InterruptedException {
    	W1070 projector = new W1070();
    	projector.runCommand(Generic.Power.CHECK, (command, reply) -> {
			System.out.println("Sent: '" + command + "' received reply: '" + reply + "'");
			return true;
		});
    	projector.runCommand(Generic.Power.ON, (command, reply) -> {
			System.out.println("Sent: '" + command + "' received reply: '" + reply + "'");
			return true;
		});
    	projector.runCommand(Generic.Power.CHECK, (command, reply) -> {
			System.out.println("Sent: '" + command + "' received reply: '" + reply + "'");
			return true;
		});
    	projector.closePorts();
    }  
}