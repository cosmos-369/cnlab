import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket srvsocket = new ServerSocket(4000);
        System.out.println("server ready for connection");

        // accept client connection
        Socket conn = srvsocket.accept();

        InputStream istream = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(istream));
        String fname = br.readLine();

        OutputStream ostream = conn.getOutputStream();
        PrintWriter pwriter = new PrintWriter(ostream, true);
        String str;
        try {
            BufferedReader b = new BufferedReader(new FileReader(fname));
            while ((str = b.readLine()) != null) {
                pwriter.println(str);
            }
            System.out.println("file contents sent sucessfully");
        } catch (Exception e) {
            pwriter.println("file not found at the server");
            System.out.println("file not found");
        }
    }
}
