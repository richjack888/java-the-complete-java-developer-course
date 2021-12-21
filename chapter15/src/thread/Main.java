package thread;

import static thread.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        System.out.println(ANSI_CYAN + "Hello again from the main thread.");



    }
}
