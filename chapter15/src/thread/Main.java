package thread;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class thread.");
            }
        }.start();

        System.out.println("Hello again from the main thread.");



    }
}
