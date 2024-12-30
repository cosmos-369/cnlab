import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("client:");
        String clientmsg = br.readLine();

        byte[] receivebuff = new byte[1024];
        byte[] sendbuff = new byte[1024];

        sendbuff = clientmsg.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket sPacket = new DatagramPacket(sendbuff, sendbuff.length, ip, 4000);
        socket.send(sPacket);

        // read message from server
        DatagramPacket rPacket = new DatagramPacket(receivebuff, receivebuff.length);
        socket.receive(rPacket);

        String srvmsg = new String(rPacket.getData());
        System.out.println("server: " + srvmsg);
        socket.close();
    }
}
