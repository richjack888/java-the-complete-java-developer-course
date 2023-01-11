package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(54088);

            while (true) {
                byte[] data = new byte[20];
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
                socket.receive(datagramPacket);
                System.out.println("Text received: " + new String(data, 0, datagramPacket.getLength()));

                String returnString = "echo: " + new String(data, 0, datagramPacket.getLength());
                byte[] data2 = returnString.getBytes("UTF-8");
                InetAddress inetAddress = datagramPacket.getAddress();
                int port = datagramPacket.getPort();
                datagramPacket = new DatagramPacket(data2, data2.length, inetAddress, port);
                socket.send(datagramPacket);

            }

        } catch (SocketException e) {
            System.out.println("Server SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Server IOException: " + e.getMessage());
        }

    }
}
