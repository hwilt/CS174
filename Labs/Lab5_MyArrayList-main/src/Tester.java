import java.util.ArrayList;
import java.util.Random;

public class Tester {
    public static boolean listsEqual(ArrayList<Integer> arr, MyArrayList<Integer> myarr) {
        boolean equal = true;
        for (int i = 0; i < arr.size() && equal; i++) {
            Integer i1 = (Integer)arr.get(i);
            Integer i2 = (Integer)myarr.get(i);
            if (i1.intValue() != i2.intValue()) {
                equal = false;
            }
        }
        return equal;
    }
    
    public static void printArrayList(ArrayList arr) {
        System.out.print("[");
        for (int k = 0; k < arr.size(); k++) {
            System.out.print(arr.get(k));
            if (k < arr.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int numOps = 10000; // Number of operations to do
        int seed = 0; // Seed for random ops
        ArrayList<Integer> arr = new ArrayList<>();
        MyArrayList<Integer> myarr = new MyArrayList<>();
        Random rand = new Random(seed);
        for (int i = 0; i < numOps; i++) {
            double num = rand.nextDouble();
            String operation = "no operation";
            if (num < 0.5) {
                int x = rand.nextInt();
                arr.add(x);
                myarr.add(x);
                operation = "add(" + x + ")";
            }
            else if (num < 0.8 && arr.size() > 0) {
                int x = rand.nextInt();
                int index = rand.nextInt(arr.size());
                arr.add(index, x);
                myarr.add(index, x);
                operation = "add(" + index + ", " + x + ")";
            }
            else if (num < 0.9 && arr.size() > 0) {
                int x = rand.nextInt();
                int index = rand.nextInt(arr.size());
                arr.set(index, x);
                myarr.set(index, x);
                operation = "set(" + index + ", " + x + ")";
            }
            else if (num < 0.95 && arr.size() > 0) {
                int index = rand.nextInt(arr.size());
                arr.remove(index);
                myarr.remove(index);
                operation = "remove(" + index + ")";
            }
            else if (num < 0.98 && arr.size() > 0) {
                Integer value = arr.get(rand.nextInt(arr.size()));
                arr.remove(value);
                myarr.remove(value);
                operation = "remove("+value+")";
            }
            
            if (arr.size() != myarr.size()) {
                printArrayList(arr);
                System.out.println(myarr);
                throw new RuntimeException("Arrays do not have the same size after a " + operation + 
                                       "\n Ground truth size " + arr.size() +  ", my size " + myarr.size());
            }
            
            if (!listsEqual(arr, myarr)) {
                printArrayList(arr);
                System.out.println(myarr);
                throw new RuntimeException("Arrays not equal after a " + operation);
            }
        }
    }
}
