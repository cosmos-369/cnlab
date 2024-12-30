import java.util.*;
import java.io.*;
import java.math.*;
import java.net.*;

public class Local {
    public static void main(String[] args) throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("local host address: " + addr.getHostAddress());
        System.out.println("local host names: " + addr.getHostName());
    }
}
