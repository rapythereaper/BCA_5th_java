import java.net.*;

public class UdpServer {
    public static void main(String[] args) {
        final int port=5050;

        try {
            DatagramSocket socket = new DatagramSocket(port); // Create a socket to listen on port 9876
            byte[] receiveData = new byte[1024]; // Buffer to store incoming data

            System.out.println("Udp server running at:"+ InetAddress.getLocalHost() +":"+port);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket); // Receive incoming packet

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received message: " + message);

                // Respond back to the client
                String response = "Hello from server";
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.length(), clientAddress, clientPort);
                socket.send(sendPacket); // Send response

        } catch (Exception e) {
            e.printStackTrace();
        };
    }
}
