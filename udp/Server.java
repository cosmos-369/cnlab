import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket srvsck = new DatagramSocket(4000);

        byte[] sendbuffer = new byte[1024];
        byte[] receivebuffer = new byte[1024];

        while (true) {
            DatagramPacket rPacket = new DatagramPacket(receivebuffer, receivebuffer.length);
            srvsck.receive(rPacket);

            InetAddress ip = rPacket.getAddress();
            int port = rPacket.getPort();

            String clientData = new String(rPacket.getData());
            System.out.println("client:" + clientData);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("server:");

            String srvmsg = br.readLine();
            sendbuffer = srvmsg.getBytes();
            DatagramPacket sendpacket = new DatagramPacket(sendbuffer, sendbuffer.length, ip, port);
            srvsck.send(sendpacket);

        }
    }
}
