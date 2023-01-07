import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server start!");
        try (ServerSocket serverSocket = new ServerSocket(5688)) {
            while (true) {
                new Echoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }

        System.out.println("Server shutdown!");
    }
}
