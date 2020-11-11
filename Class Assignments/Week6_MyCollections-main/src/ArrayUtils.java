/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ctralie
 */
public class ArrayUtils {
    public static int[] addElement(int[] arr, int element) {
        int[] toReturn = new int[arr.length+1];
        // Step 1: Copy everything over to this new array
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = arr[i];
        }
        // Add new element at the end
        toReturn[arr.length] = element;
        return toReturn;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5};
        arr = addElement(arr, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
