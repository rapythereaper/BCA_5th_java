import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class IpAdress {
    public static void main(String[]args){
        try {
            InetAddress ip=InetAddress.getLocalHost();
            System.out.println(ip);
            InetAddress ip2=InetAddress.getByName("google.com");
            System.out.println(ip2);
            String ip3=new URL("https://www.facebook.com").getHost();
            System.out.println(ip3);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
