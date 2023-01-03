import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client start!");
        try (Socket socket = new Socket("localhost", 5688)) {
            System.out.println("Client open connect to server -> " + socket.getInetAddress() + ":" +socket.getPort());
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

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }

        System.out.println("Client close!");

    }
}
