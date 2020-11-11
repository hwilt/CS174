package drills;

/**
 *
 * @author wilth
 */

/** 
 * This is the tester class for the method ArrayZeroes()
 * public class Tester {
    public static void main(String[] args) {
        int[] arr0 = {};
        System.out.print(ArrayZeroes.countZeroes(arr0));
        int[] arr1 = {0, 5, 10, 0, 3, 4};
        System.out.print(ArrayZeroes.countZeroes(arr1));
        int[] arr2 = {0, 0, 1, 2, 4, 3, 4, 4, 0, 1, 2, 0, 3, 0, 0, 0, 2, 2, 4, 0};
        System.out.print(ArrayZeroes.countZeroes(arr2));
        int[] arr3 = {3, 13, 12,  3, 20, 17, 10, 17,  6,  1, 19, 10, 15,  9,  9, 13, 11, 8, 17,  0,  2,  1,  4, 10, 20,  5, 14,  5, 20, 17, 14, 17, 16,  5, 17, 14,  1, 17, 10, 14, 20, 20,  8, 10,  9,  9, 20,  8, 14,  4, 13, 9,  3, 11,  2,  8, 12,  1, 13,  9, 13,  1,  9, 14, 16, 15,  0,  9, 3,  5, 17,  2,  0, 12,  8,  7, 13, 15, 14,  7, 10, 11, 18, 19, 14, 20, 10,  2,  3, 10, 20,  3, 19,  8, 14, 11, 11,  5,  5,  0};
        System.out.print(ArrayZeroes.countZeroes(arr3));
    }
   }
 * 
 */

/** 
 * This is the tester class for the method ArrayPrinter()
 * public class Tester {
    public static void main(String[] args) {
        int[] arr0 = {0, 5, 10, 0, 3, 4};
        ArrayPrinter.printArray(arr0);
        System.out.print(".");
        int[] arr1 = {0, 0, 1, 2, 4, 3, 4};
        ArrayPrinter.printArray(arr1);
        System.out.print(".");
    }
   }
 * 
 */

/** 
 * This is the tester class for the method GetMean()
 * public class Tester {
    public static void main(String[] args) {
        int[] arr0 = {0, 5, 10, 0, 3, 4, 0, 1};
        System.out.print((double)ArrayUtils.getMean(arr0));
        System.out.print(",");
        int[] arr1 = {0, 0, 1, 1, 1, 1, 3};
        System.out.print((double)ArrayUtils.getMean(arr1));
        System.out.print(",");
        int[] arr2 = {};
        System.out.print((double)ArrayUtils.getMean(arr2));
    }
   }
 * 
 */

/** 
 * This is the tester class for the method GetMean()
 * public class Tester {
    public static void main(String[] args) {
        int[] arr0 = {0, 5, 10, 0, 3, 4, 0, 1};
        System.out.print((double)ArrayUtils.getMean(arr0));
        System.out.print(",");
        int[] arr1 = {0, 0, 1, 1, 1, 1, 3};
        System.out.print((double)ArrayUtils.getMean(arr1));
        System.out.print(",");
        int[] arr2 = {};
        System.out.print((double)ArrayUtils.getMean(arr2));
    }
   }
 * 
 */
/** 
 * This is the tester class for the method getReverseArray()
 * public class Tester {
    public static void main(String[] args) {
        int[] arr0 = {0, 5, 10, 0, 3, 4, 0, 1};
        ArrayUtils.printArray(ArrayUtils.getReverseArray(arr0));
        System.out.print(".");
        int[] arr1 = {0, 0, 1, 1, 1, 1, 3};
        ArrayUtils.printArray(ArrayUtils.getReverseArray(arr1));
    }
   }
 * 
 */

/**
 * This is the tester class for the method insertElement()
    public class Tester {
        public static void main(String[] args) {
            int[] arr0 = {0, 5, 4, 8, 2};
            int[] result;
            result = ArrayUtils.insertElement(arr0, 2, 1);
            ArrayUtils.printArray(result);
            System.out.print(".");
            result = ArrayUtils.insertElement(arr0, 4, 10);
            ArrayUtils.printArray(result);
            System.out.print(".");
            result = ArrayUtils.insertElement(arr0, 0, 50);
            ArrayUtils.printArray(result);
        }
    }
*/

/**
 * this is the tester class for the method sort3elements()
 * public class Tester {
    public static void main(String[] args) {
      ArrayUtils.printArray(ArrayUtils.sort3Elements(7, 3, 1));
      System.out.println(".");
      ArrayUtils.printArray(ArrayUtils.sort3Elements(9, 1, 8));
      System.out.println(".");
    }
   }
 * 
 */

/**
 * This is the tester class for getMinIndex()
    public class Tester {
       public static void main(String[] args) {
           int[] arr0 = {3, 5, 0, 8, 0, 2};
           int min0 = ArrayUtils.getMinIndex(arr0);
           int[] arr1 = {9, -3, 4, -3, 2, 5, 3, 2};
           int min1 = ArrayUtils.getMinIndex(arr1);
           int[] arr2 = {};
           int min2 = ArrayUtils.getMinIndex(arr2);
           System.out.print(min0);
           System.out.print(".");
           System.out.print(min1);
           System.out.print(".");
           System.out.print(min2);
       }
    }
 */

/**
 * This is the tester class for the countVowels() method
 * public class Tester {
       public static void main(String[] args){
            String s1 = "I love CS";
            int vowels1 = StringUtils.countVowels(s1);
            String s2 = "The quick brown fox jumped over the lAzy dOg";
            int vowels2 = StringUtils.countVowels(s2);
            String s3 = "aEIOu  AeioU";
            int vowels3 = StringUtils.countVowels(s3);
            System.out.print(vowels1 + "." + vowels2 + "." + vowels3);
       }
   }
 */
