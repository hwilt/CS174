import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Random;

public class Tester {
    /**
     * Compare a student deque to an array implementation of deque
     * @param deque A ground truth deque
     * @param mydeque Student deque
     * @return 
     */
    public static boolean dequesEqual(ArrayDeque<Integer> deque, Deque<Integer> mydeque) {
        boolean equal = true;
        Object[] arr1 = deque.toArray();
        Object[] arr2 = mydeque.toArray();
        for (int i = 0; i < arr1.length && equal; i++) {
            if (!(arr1[i].equals(arr2[i]))) {
                equal = false;
            }
        }
        return equal;
    }
    
    public static void main(String[] args) {
        int numOps = 10000; // Number of operations to do
        int seed = 0; // Seed for random ops
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> mydeque = new Deque<>();
        Random rand = new Random(seed);
        for (int i = 0; i < numOps; i++) {
            double num = rand.nextDouble();
            String operation = "no operation";
            try {
                if (num < 0.4) {
                    int x = rand.nextInt();
                    operation = "addFirst(" + x + ")";
                    deque.addFirst(x);
                    mydeque.addFirst(x);
                }
                else if (num < 0.8) {
                    int x = rand.nextInt();
                    operation = "addLast(" + x + ")";
                    deque.addLast(x);
                    mydeque.addLast(x);
                }
                else if (num < 0.85 && deque.size() > 0) {
                    operation = "removeFirst()";
                    deque.removeFirst();
                    mydeque.removeFirst();
                }
                else if (num < 0.85 && deque.size() > 0) {
                    operation = "removeFirst()";
                    deque.removeFirst();
                    mydeque.removeFirst();
                }
                else if (num < 0.95 && deque.size() > 0) {
                    operation = "removeLast()";
                    deque.removeLast();
                    mydeque.removeLast();
                }
                else {
                    Object[] arr = deque.toArray();
                    Integer elem = (Integer)arr[rand.nextInt(arr.length)];
                    operation = "remove(" + elem + ")";
                    deque.remove(elem);
                    mydeque.remove(elem);
                }
            }
            catch(Exception e) {
                System.out.println("Error during " + operation);
                throw e;
            }
            try {
                if (deque.size() != mydeque.size()) {
                    String str = "Deques do not have the same reported size after a " + operation + 
                                           "\n Ground truth size " + deque.size() +  ", my size " + mydeque.size();
                    System.out.println(str);
                    System.out.println(Arrays.toString(deque.toArray()));
                    System.out.println(Arrays.toString(mydeque.toArray()));
                    throw new RuntimeException(str);
                }
                if (!dequesEqual(deque, mydeque)) {
                    System.out.println(Arrays.toString(deque.toArray()));
                    System.out.println(Arrays.toString(mydeque.toArray()));
                    throw new RuntimeException("Deques not equal after a " + operation);
                }
            }
            catch(Exception e) {
                System.out.println("Error after " + operation);
                throw e;
            }
        }
    }
}
