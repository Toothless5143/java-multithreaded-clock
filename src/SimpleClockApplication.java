/**
 * The main class to start the Simple Clock Application.
 * This class contains the main entry point of the program.
 * 
 * @author Safwan Luban
 */
public class SimpleClockApplication {

    /**
     * The main method which creates an instance of the Clock
     * and starts its execution.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a new Clock object.
        Clock clock = new Clock();
        
        // Start the clock's threads.
        clock.start();
    }
}
