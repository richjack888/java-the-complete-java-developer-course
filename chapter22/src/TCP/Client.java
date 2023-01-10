package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("TCP.Client start!");
        try (Socket socket = new Socket("localhost", 5688)) {
            socket.setSoTimeout(5000);
            System.out.println("TCP.Client open connect to server -> " + socket.getInetAddress() + ":" +socket.getPort());
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String clientSentString;
            String ServerResponseString;

            do {
                System.out.println("Enter something to server (if you want to leave type 'exit') : ");
                clientSentString = scanner.nextLine();
                stringToEcho.println(clientSentString);

                if (!clientSentString.equals("exit")) {
                    ServerResponseString = echoes.readLine();
                    System.out.println((ServerResponseString));
                }
            } while (!clientSentString.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("TCP.Client Error: The socket timeout!");
        }

        catch (IOException e) {
            System.out.println("TCP.Client error: " + e.getMessage());
        }

        System.out.println("TCP.Client close!");

    }
}
