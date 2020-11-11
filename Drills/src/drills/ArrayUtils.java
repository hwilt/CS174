package drills;

/**
 *
 * @author wilth
 */
public class ArrayUtils {
    
    /**
     * Fill in a method to compute the mean of an array of ints. 
     * Note that even though the inputs are integers, 
     * their mean may be a decimal number! 
     * For example, the mean of {0, 5, 2, 4} is 2.75. 
     * Finally, if an empty array is passed to your method, 
     * you should return 0.0. Recall that this is referred to as a 
     * boundary case or edge case in testing.
     */
    public static double getMean(int[] arr) {
      /** TODO: Fill in your code here to compute the mean **/
      double mean = 0.0;
      if(arr.length != 0){
          for(int i = 0; i < arr.length; i++){
                mean += arr[i];
          }
          mean /= arr.length;
      }
      return mean;
    }
    
    /**
     * Fill in the method getReverseArray in ArrayUtils.java to return a 
     * new array which is the reverse of a given array. 
     * For example, the array {0, 5, 2, 3} would turn into the array {3, 2, 5, 0}.
     */
    public static int[] getReverseArray(int[] arr) {
      /** TODO: Fill in your code here to create the reverse array **/
      int[] reversed = new int[arr.length];
      int UP = reversed.length - 1;
      for (int DOWN = 0; DOWN < arr.length; DOWN++){
          reversed[DOWN] = arr[UP];
          UP--;
      }
      return reversed;
    }
    /**
    * Creates and returns a new array with "element" at the index "index," and
    * everything after the original index shifted over to the right by one
    *
    * @param arr The original array
    * @param index The index at which to place the new element.  Should be a value less
    *              than the length of the array
    * @param element The value of the new element
    * 
    * @return An array with the new element inserted
    */
    public static int[] insertElement(int[] arr, int index, int element) {
        /** TODO: Fill this in.  You should return
        * an int representing the number of zeroes in the
        * array arr
        */
        int[] newArray = new int[arr.length + 1];
        for (int i = 0; i < newArray.length; i++){
            if (i < index){
                newArray[i] = arr[i];
            }
            else if(i == index){
                newArray[i] = element;
            }
            else{
                newArray[i] = arr[i - 1];
            }
        }
        newArray[index] = element;
        return newArray;
    }
    
    
    /**
     * Creates and returns an array that takes three integers and sorts them in 
     * lowest to highest order.
     * @param int1 integer #1
     * @param int2 integer #2
     * @param int3 integer #3
     * @return An array with the elements sorted
    */
    public static int[] sort3Elements(int int1, int int2, int int3){
        int[] newArray = new int[3];
        newArray[0] = int1;
        newArray[1] = int2;
        newArray[2] = int3;
        int temp;
        for(int i = newArray.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(newArray[j] > newArray[j+1]){
                    temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }
        return newArray;
    }
    /**
     * Takes in an array of ints and returns the minimum index in the array.
     * @param arr
     * @return the lowest element in the array
     */
    public static int getMinIndex(int[] arr){
        int min = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }
    
    
    

    public static void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]);
        if (i < arr.length-1) {
          System.out.print(",");
        }
      }
    }
}
