package drills;

/**
 *
 * @author wilth
 */

/**
 * Declare a void method printArray in the ArrayPrinter class. 
 * This method should take an array of ints, and it should then print out the
 * elements of the array separated by commas (this is useful, since printing 
 * out an array by default in Java just gives its memory address). 
 * For example, the array {0,5,2,4} should be printed out as 0, 5, 2, 4. 
 * Note how there is no comma or space at the end of the output string.
 */

public class ArrayPrinter {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr.length-1 == i){
                System.out.print(arr[i]);
            }
            else{
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
