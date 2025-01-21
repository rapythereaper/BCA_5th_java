import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args){
        try {
            Socket conn=new Socket("127.0.0.1",5050);
            InputStream in=conn.getInputStream();
            OutputStream out=conn.getOutputStream();
            out.write("hello i am ram bahadur".getBytes());
            out.write('\0');
            while (true){
                int res=in.read();
                if((char)res=='\0')break;
                System.out.print((char)res);
            }
            System.out.println();
            conn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
