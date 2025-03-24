
package Midterm;


public class HALAD_multidimentional_Array {
    public static void main(String[] args){
            int numbers [][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("The elements in Row " + (i -(-1)) + ": ");
            for (int num : numbers[i]) {
                System.out.print(num + " ");
            }
            System.out.println();

        }
    }
}


    
