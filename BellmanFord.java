import java.util.Scanner;

public class BellmanFord {
    private int D[]; // distance
    private int num_ver; // number of vertexex
    public static final int MAX_VAL = 999; // max value

    public BellmanFord(int num_ver) {
        this.num_ver = num_ver;
        this.D = new int[num_ver + 1];
    }

    public void BellmanFordEval(int source, int A[][]) {
        for (int i = 1; i <= num_ver; i++)
            D[i] = MAX_VAL;

        D[source] = 0;

        for (int node = 1; node <= num_ver; node++) {
            for (int sn = 1; sn <= num_ver; sn++) {
                for (int dn = 1; dn <= num_ver; dn++) {
                    if (A[sn][dn] != MAX_VAL) {
                        if (D[dn] > D[sn] + A[sn][dn]) {
                            D[dn] = D[sn] + A[sn][dn];
                        }
                    }
                }
            }

            // checking for negative cycles
            for (int sn = 1; sn <= num_ver; sn++) {
                for (int dn = 1; dn <= num_ver; dn++) {
                    if (A[sn][dn] != MAX_VAL) {
                        if (D[dn] > D[sn] + A[sn][dn]) {
                            System.out.println("graph contains negative edge cycles");
                        }
                    }
                }
            }
        }

        // print result of Bellman Ford
        for (int vertex = 1; vertex <= num_ver; vertex++) {
            System.out.println("distance of source " + source + " to " + vertex + " is " + D[vertex]);
        }
    }

    public static void main(String[] args) {
        int num_ver = 0;
        int source;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices: ");
        num_ver = sc.nextInt();
        int A[][] = new int[num_ver + 1][num_ver + 1];
        System.out.println("enter adjacnecy matrix:");
        for (int i = 1; i <= num_ver; i++) {
            for (int j = 1; j <= num_ver; j++) {
                A[i][j] = sc.nextInt();
                if (i == j) {
                    A[i][j] = 0;
                    continue;
                }
                if (A[i][j] == 0) {
                    A[i][j] = MAX_VAL;
                }
            }
        }
        System.out.println("enter the source vertex:");
        source = sc.nextInt();
        BellmanFord b = new BellmanFord(num_ver);
        b.BellmanFordEval(source, A);
        sc.close();
    }
}
