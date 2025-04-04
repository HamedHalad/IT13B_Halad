/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midterm;

/**
 *
 * @author Doofenshmirtz
 */
public class Fibonacci {
    
    public static void main(String[] args) {
        int fibonacci = 10;

        for (int x = 0; x < fibonacci; x++) {
            System.out.print(fibonacci(x) + ", ");
        }
    }

    public static int fibonacci(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }
}
    

