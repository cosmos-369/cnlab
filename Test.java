import java.util.*;
import java.io.*;
import java.math.*;
import java.net.*;

public class Test {
    public static void main(String[] args) {
        String host = "www.google.com";
        try {
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress i : addresses) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
