import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import se.payerl.projectorcontroller.W1070;

public class Start {
    public static void main(String[] args) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, InterruptedException {
    	W1070 projector = new W1070();
    	projector.turnOff();
    	projector.closePorts();
    }  
}