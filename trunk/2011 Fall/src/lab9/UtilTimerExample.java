package lab9;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a tasks: 
 * two that are periodic and one that executes once after a
 * delay
 */

public class UtilTimerExample {
    private Timer timer;

    public UtilTimerExample() {
        timer = new Timer();
        timer.schedule(new MessageTask1(), 1000, 1000);
        timer.schedule(new MessageTask2(), 200, 1500);   
        timer.schedule(new MessageTask3(), 20000);
	}

    class MessageTask1 extends TimerTask {
        public void run() {
        	// format is the same as printf but does not look like C
            System.out.format("That's one second%n");
        }
    }
    
    class MessageTask2 extends TimerTask {
        public void run() {
        	// format is the same as printf but does not look like C
            System.out.format("That's 1.5 seconds%n" );
        }
    }
    
    class MessageTask3 extends TimerTask {
        public void run() {
        	// format is the same as printf but does not look like C
            System.out.format("Time's up%n");
            timer.cancel();
        }
    }

    public static void main(String args[]) {
        new UtilTimerExample();
        System.out.format("Tasks scheduled.%n");
    }
}