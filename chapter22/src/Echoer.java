import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    Socket socket;

    public Echoer(Socket socket) {
        this.socket = new Socket();
        System.out.println("Sever was connected by client -> " + socket.getInetAddress() + ":" + socket.getPort());
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echo = input.readLine();
                if (echo.equals("exit")) {
                    System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " close connection.");
                    break;
                }
                output.println("Server receive your message: " + echo);
                System.out.println("Message from client: " + echo);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
    }
}
