package Midterm;

import java.util.Scanner;

public class Activity_1_Palindrome {

    public static void main(String[] args) {       
        Scanner a = new Scanner(System.in);

        System.out.println("Enter your text");
        String string = a.next();

        String org_str = string;
        int length = string.length();

        String reverse = "";

        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }
        if (org_str.equals(reverse)) {
            System.out.println(" ITS A PALINDROME ");
        } else {
            System.out.println(" ITS NOT A PALINDROME ");
        }
    }
}
