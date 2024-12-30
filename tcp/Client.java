import java.io.*;
import java.math.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        // connect to server
        Socket clienSocket = new Socket("127.0.0.1", 4000);
        System.out.println("connection sucessful");

        // get file name
        System.out.println("enter the filename:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();

        // get socket output stream
        // create printwriter to print data to output stream
        OutputStream ostream = clienSocket.getOutputStream();
        PrintWriter pwriter = new PrintWriter(ostream, true);
        pwriter.println(fname);

        // get the input stream from the socket to read the file
        InputStream istream = clienSocket.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        String str;
        while ((str = socketRead.readLine()) != null) {
            System.out.println(str);
        }
    }
}
