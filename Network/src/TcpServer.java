import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args){
        final int port=5050;
        try{
            ServerSocket server=new ServerSocket(port);
            System.out.println("TCP server running at:"+ InetAddress.getLocalHost() +":"+port);
            Socket clientSocket=server.accept();
            System.out.println("\t->"+clientSocket.getInetAddress()+" connected");
            InputStream clinetIn=clientSocket.getInputStream();
            OutputStream clientOut=clientSocket.getOutputStream();
            System.out.print("\t->");
            while(true){
                int read= clinetIn.read();

                if((char)read=='\0'){
                    System.out.println();
                    break;
                }
                System.out.print((char)read);
            }
            clientOut.write("Thank you for connecting".getBytes());
            clientOut.write('\0');
            clientSocket.close();
            server.close();
        }catch (Exception _){}
    }
}
