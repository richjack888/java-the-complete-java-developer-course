package thread;

import static thread.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        final Thread anotherThread = new AnotherThread();
        anotherThread.setName(" == Another Thread == ");
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_BLACK + "Hello from anonymous MyRunnable class.");
                try {
                    anotherThread.join(1000);
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so I'm running again." );
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        System.out.println(ANSI_CYAN + "Hello again from the main thread.");


    }
}
