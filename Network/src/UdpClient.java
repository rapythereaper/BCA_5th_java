import java.net.*;

public class UdpClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(); // Create a socket
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Server address
            String message = "Hello from client";

            // Send message to the server
            DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, 5050);
            socket.send(sendPacket);

            // Receive response from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
