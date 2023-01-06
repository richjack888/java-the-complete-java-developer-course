import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server start!");
        try (ServerSocket serverSocket = new ServerSocket(5688)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Sever was connected by client -> " + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String echo = input.readLine();
                if (echo.equals("exit")) {

                    break;
                }
                output.println("Server receive your message: " + echo);
                System.out.println("Message from client: " + echo);

//                // todo no reaction
//                if(socket.isClosed()){
//                    System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " close connection.");
//                }


            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }

        System.out.println("Server shutdown!");
    }
}
