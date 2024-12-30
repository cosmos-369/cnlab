import java.util.*;
import java.io.*;

public class LeakyBucket {
    public static void main(String[] args) {
        int rate = 3, bucketSize = 4, packetCount, sent = 0, rem = 0;

        int packets[];

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of packets:");
        packetCount = sc.nextInt();
        packets = new int[packetCount];
        System.out.println("enter packet size: ");
        for (int i = 0; i < packetCount; i++) {
            packets[i] = sc.nextInt();
        }

        System.out.println("clock" + "\t" + "sent" + "\t" + "received" + "\t" + "rem");
        for (int i = 0; i < packetCount; i++) {
            int rece = 0;
            Boolean dropped = false;
            if (packets[i] > bucketSize - rem) {
                dropped = true;
            } else {
                rem += packets[i];
                rece = packets[i];
            }

            if (rem > rate) {
                sent = rate;
                rem -= rate;
            } else {
                sent = rem;
                rem = 0;
            }

            if (dropped) {
                System.out.println(i + 1 + "\t" + sent + "\t" + "dropped" + "\t\t" + rem);
            } else {
                System.out.println(i + 1 + "\t" + sent + "\t" + rece + "\t\t" + rem);
            }
        }
    }
}
