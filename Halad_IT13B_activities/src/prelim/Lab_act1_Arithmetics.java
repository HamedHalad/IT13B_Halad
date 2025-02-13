package prelim;

import java.util.Scanner;

public class Lab_act1_Arithmetics {

    public static void main(String[] args) {
        int x = 10;
        int y = 4;
        int z = 6;
        System.out.println(x + "*" + y + "+" + z + "=" + (x*y+z));
        System.out.println(x + "-" + y + "%" + z + "=" + ((x-y)%z));
        System.out.println(x + "+" + y + "+" + z + "3" + "=" + ((x+y+z)/3));
        System.out.println(x + "*" + z + "-" + y + "*" + y + "=" + (x*z-(y*y)));
    }

}
