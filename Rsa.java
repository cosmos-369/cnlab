import java.util.*;
import java.io.*;
import java.math.*;

public class Rsa {
    private BigInteger p, q, n, phi, e, d;
    int bitlen = 1024;

    public Rsa() {
        Random r = new Random();
        p = BigInteger.probablePrime(bitlen, r);
        q = BigInteger.probablePrime(bitlen, r);

        System.out.println("p:" + p);
        System.out.println("q:" + q);

        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(bitlen / 2, r);
        while (!e.gcd(phi).equals(BigInteger.ONE)) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(phi);
    }

    public String bytesToString(byte[] data) {
        String str = "";
        for (byte b : data) {
            str += Byte.toString(b);
        }
        return str;
    }

    public byte[] encrypt(byte[] data) {
        return (new BigInteger(data).modPow(e, n).toByteArray());
    }

    public byte[] dencrypt(byte[] data) {
        return (new BigInteger(data).modPow(d, n).toByteArray());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg;
        Rsa r = new Rsa();
        System.out.println("enter message:");
        msg = sc.nextLine();
        System.out.println("encryping message: " + msg);
        System.out.println("message in bytes: " + r.bytesToString(msg.getBytes()));

        byte[] encypedmsg = r.encrypt(msg.getBytes());
        byte[] decryptedmsg = r.dencrypt(encypedmsg);

        System.out.println("decrypted message: " + new String(decryptedmsg));
    }
}
