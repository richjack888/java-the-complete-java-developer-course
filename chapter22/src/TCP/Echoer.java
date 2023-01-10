package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private final Socket socket;
    private final String clientAddress;

    public Echoer(Socket socket) {
        this.socket = socket;
        this.clientAddress = socket.getInetAddress() + ":" + socket.getPort();
        System.out.println("Sever was connected by client -> " + clientAddress);
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echo = input.readLine();
                if (echo.equals("exit")) {
                    break;
                }

////                 test client timeout for socket.setSoTimeout(5000);
//                try {
//                    Thread.sleep(15000);
//                }catch (InterruptedException e) {
//                    System.out.println("Thread interrupted");
//                }


                output.println("TCP.Server receive your message: " + echo);
                System.out.println("Message from " + clientAddress + ": " + echo);
            }
        } catch (Exception e) {
            System.out.println("TCP.Echoer Error:" + e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " close connection.");
            } catch (Exception e) {
                System.out.println("TCP.Echoer Error:" + e.getMessage());
            }
        }
    }
}
