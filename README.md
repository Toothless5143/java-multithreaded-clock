# Java Multithreaded Clock

A simple, command-line digital clock application written in Java. This project demonstrates the fundamentals of multithreading by using separate threads for updating and displaying the current time concurrently.

## Features

- Displays the current time and date, updated every second.
- Utilizes a separate thread for background time updates and another for console display.
- Implements thread priorities to ensure the display thread is responsive.
- Uses the `volatile` keyword for thread-safe communication between threads.
- Provides a clean, single-line output that overwrites itself, creating a dynamic display.

## Technologies Used

- Java
- Java Time API (`java.time`)

## How to Run

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/Toothless5143/java-multithreaded-clock/
    cd java-multithreaded-clock
    ```

2.  **Navigate to the source directory:**
    ```sh
    cd src
    ```

3.  **Compile the Java files:**
    ```sh
    javac SimpleClockApplication.java Clock.java
    ```

4.  **Run the application:**
    ```sh
    java SimpleClockApplication
    ```

The current time will be displayed in your console, updating every second. Press `Ctrl + C` to stop the application.
