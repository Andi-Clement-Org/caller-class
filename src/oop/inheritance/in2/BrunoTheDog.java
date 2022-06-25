package oop.inheritance.in2;

import java.util.Arrays;

public class BrunoTheDog extends Dog {

    private StringBuffer stringBuffer;

    public BrunoTheDog() {
        stringBuffer = new StringBuffer();
    }

    public void showMe() {
        stringBuffer = new StringBuffer(8);
    }

    public void manageInterval() {
        int[] sizes = new int[100];
        int[] colors = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i / 2 == 0) {
                sizes[i] = i;
            }
            else {
                colors[i] = i;
            }
        }

        System.out.printf("Sizes: %d", Arrays.stream(sizes).count());
        System.out.printf("Colors: %d", Arrays.stream(colors).count());

    }

}