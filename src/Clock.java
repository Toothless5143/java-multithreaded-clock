import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Clock class is responsible for managing and displaying the current time and date.
 * It utilizes two separate threads: one for updating the time value and another for
 * displaying it. This demonstrates the use of multithreading and thread priorities.
 */
public class Clock {

    /**
     * A volatile string to hold the current formatted time. The 'volatile' keyword
     * ensures that changes made by one thread are immediately visible to others, which
     * is crucial for thread safety between the update and display threads.
     */
    private volatile String currentTime;

    /**
     * The formatter for the date and time, using the "HH:mm:ss dd-MM-yyyy" pattern.
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    /**
     * Constructor for the Clock class.
     * It initializes the currentTime with a starting value to avoid a null
     * display upon startup.
     */
    public Clock() {
        this.currentTime = formatter.format(LocalDateTime.now());
    }

    /**
     * Creates, configures, and starts the two threads for updating and displaying the time.
     * This method also sets different priorities for the threads to manage their execution.
     */
    public void start() {
        // Create the thread responsible for updating the time value every second.
        Thread updateThread = new Thread(this::updateTime);
        updateThread.setName("Time-Updater-Thread");
        
        // The update thread is given a lower priority, as its background task is not
        // as time-critical as the user-facing display.
        updateThread.setPriority(Thread.MIN_PRIORITY);

        // Create the thread responsible for displaying the time on the console.
        Thread displayThread = new Thread(this::displayTime);
        displayThread.setName("Time-Displayer-Thread");
        
        // The display thread is given a higher priority to ensure that the console
        // output remains responsive and updates promptly.
        displayThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Starting the Simple Clock Application...");
        
        // Start both threads to run concurrently.
        updateThread.start();
        displayThread.start();
    }

    /**
     * This method runs in a continuous loop within the 'updateThread'.
     * It fetches the current system time, formats it, and stores it in the
     * shared 'currentTime' variable. It then sleeps for one second.
     */
    private void updateTime() {
        try {
            while (true) {
                currentTime = formatter.format(LocalDateTime.now());
                // Pause the thread for 1 second before the next update.
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Restore the interrupted status of the thread.
            Thread.currentThread().interrupt();
            System.err.println("The time update thread was interrupted.");
        }
    }

    /**
     * This method runs in a continuous loop within the 'displayThread'.
     * It reads the value from the shared 'currentTime' variable and prints it to the console.
     * The carriage return character '\r' moves the cursor to the beginning
     * of the line, creating the effect of an updating clock on a single line.
     */
    private void displayTime() {
        try {
            while (true) {
                // Print the current time. '\r' allows overwriting the same line.
                System.out.print("\rCurrent Time: " + currentTime);
                // Pause the thread to sync with the update cycle.
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("\nThe time display thread was interrupted.");
        }
    }
}
