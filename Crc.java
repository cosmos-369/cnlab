import java.util.*;
import java.math.*;
import java.io.*;

public class Crc {
    // get data
    // generate crc
    // perform error checking
    public static void main(String args[]) throws Exception {
        int data_bits, divisor_bits, tot_bits;
        int[] data, divisor, div, rem, crc;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // get data bits
        System.out.println("enter number of data bits: ");
        data_bits = Integer.parseInt(br.readLine());

        System.out.println("enter data bits: ");
        data = new int[data_bits];
        for (int i = 0; i < data_bits; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        // get divisor bits
        System.out.println("enter number of divisor bits: ");
        divisor_bits = Integer.parseInt(br.readLine());

        System.out.println("enter divisor bits: ");
        divisor = new int[divisor_bits];
        for (int i = 0; i < divisor_bits; i++) {
            divisor[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("data bits: ");
        for (int i = 0; i < data_bits; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("divisor bits: ");
        for (int i = 0; i < divisor_bits; i++) {
            System.out.print(divisor[i] + " ");
        }

        // compute reminder
        tot_bits = data_bits + divisor_bits - 1;
        div = new int[tot_bits];
        rem = new int[tot_bits];
        crc = new int[tot_bits];
        for (int i = 0; i < data_bits; i++) {
            div[i] = data[i];
            rem[i] = data[i];
        }
        rem = divide(divisor, rem);
        for (int i = 0; i < tot_bits; i++) {
            crc[i] = div[i] ^ rem[i];
        }

        System.out.println("\ncrc bits are: ");
        for (int i = 0; i < crc.length; i++) {
            System.out.print(crc[i] + " ");
        }

        // error detection
        System.out.println("enter " + tot_bits + " number of bits:");
        for (int i = 0; i < div.length; i++) {
            div[i] = Integer.parseInt(br.readLine());
        }

        rem = divide(divisor, div);
        for (int i = 0; i < rem.length; i++) {
            if (i == 1) {
                System.out.println("error");
                break;
            }
            if (i == rem.length - 1) {
                System.out.println("no error");
            }
        }
        System.out.println("thank you");
    }

    static int[] divide(int[] divisor, int[] rem) {
        int ptr = 0;
        while (true) {
            for (int i = 0; i < divisor.length; i++) {
                rem[ptr + i] = rem[ptr + i] ^ divisor[i];
            }

            while (ptr < rem.length && rem[ptr] == 0)
                ptr++;

            if (ptr >= rem.length || rem.length - ptr < divisor.length) {
                break;
            }
        }
        return rem;
    }
}