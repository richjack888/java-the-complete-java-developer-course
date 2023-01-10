package UDP;

import java.io.IOException;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echo: ");
                echoString = scanner.nextLine();

                byte[] data = echoString.getBytes();

                DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, 54088);
                datagramSocket.send(datagramPacket);

            } while (!echoString.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("Client SocketTimeoutException:  " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Client IOException: " + e.getMessage());
        }
    }
}
