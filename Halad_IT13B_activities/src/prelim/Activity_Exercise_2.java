
package prelim;

import java.util.Scanner;


public class Activity_Exercise_2 {
     public static void main(String[] args){
        
        int num1, num2, num3;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Input the first number: ");
        num1 = in.nextInt();

        System.out.println("Input the Second number: ");
        num2 = in.nextInt();

        System.out.println("Input the third number: ");
        num3 = in.nextInt();

        if (num1 >= num2 && num1 > num3 ) {
            System.out.println("The Greatest number is: " + num1);
            
        } else if (num2 >= num1 && num2 > num3) {
          System.out.println("The Greatest number is: " + num2);
          
        } else if (num3 >= num1 && num3 > num2){
            System.out.println("The Greatest number is: " + num3);
            
        } else {
            System.out.println("error");
            
        } 
    }
}
