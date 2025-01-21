import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlClass {
    public static void main(String []args){
        try {
            URL url=new URL("http://127.0.0.1:8080");
            URLConnection connection= url.openConnection();
            System.out.println(connection.getContentType());
            int len=connection.getContentLength();
            if(len!=-1) {
                System.out.println(len);
                InputStream in = connection.getInputStream();
                byte[] b = new byte[len];
                in.read(b);
                String responce = new String(b);
                System.out.println(responce);
            }else{
                System.out.println("Unable to get content");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
