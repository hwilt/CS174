package drills;

/**
 *
 * @author wilth
 */

/** Modify the countZeroes method in ArrayZeroes.java file 
 * to count the number of zeroes in an array 
 * (this is based on exercise 13 on page 266 of the Horstmann 
 * book Java for Everyone).
 */

public class ArrayZeroes {
    public static int countZeroes(int[] arr) {
        /** TODO: Fill this in.  You should return
        * an int representing the number of zeroes in the
        * array arr
        */
        int numOfZeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                numOfZeroes++;
            }
        }   
        return numOfZeroes;
    }
}