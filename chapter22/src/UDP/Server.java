package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(54088);

            while (true) {
                byte[] data = new byte[50];
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
                socket.receive(datagramPacket);
                System.out.println("Text received: " + new String(data));
            }

        } catch (SocketException e) {
            System.out.println("Server SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Server IOException: " + e.getMessage());
        }

    }
}
