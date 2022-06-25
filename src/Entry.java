import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Entry {

    /**
     *
     */

    public static void main(String[] args) {
        try {
            phony(2, 3);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void phoneTest(int n, int m) throws Exception {

        Scanner input = new Scanner(System.in);

        int[] fArray = new int[n * 4 + m * 2];
        int[] sArray = new int[n * 4];
        int[] tArray = new int[m * 2];

        int count = 0;
        while (n != 0 && m != 0) {
            int z = input.nextInt();
            for ( int i = 0; i < n * 4 + m * 2; i++ ) {
                if (i < n * 4) {
                    sArray[i] = z;
                    if (i % 3 == 0 || i % 4 == 0) {
                        System.out.println(i);
                    }
                }
                else {
                    tArray[i] = z;
                }
            }
        }

    }

    public static void phony(int n, int m) throws Exception {
        if (n == 0 || m == 0) {
            throw new Exception("Cannot have Zero Values");
        }

        int rn1 = n * 4;
        int rn2 = m * 2;

        int start = Math.max(rn1, rn2);
        int end = Math.min(rn1, rn2);

        List<Integer> inRange = IntStream.rangeClosed(end, start).boxed().toList();
        int[] ranging = inRange.stream().mapToInt(i->i).toArray();

        for (int i = 0; i < ranging.length; i++) {
//            phony(i-1, );
        }

    }

}