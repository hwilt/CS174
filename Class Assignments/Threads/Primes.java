import java.util.Arrays;

public class Primes implements Runnable {
    public static boolean isPrime(int x) {
        boolean prime = true;
        if (x > 2) {
            for (int i = 2; i <= 1+(int)Math.sqrt(x) && prime; i++) {
                if (x % i == 0) {
                    prime = false;
                }
            }
        }
        return prime;
    }

    private int start;
    private int end;

    public Primes(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        int count = 0;
        for (int x = start; x <= end; x++) {
            if (isPrime(x)) {
                count++;
            }
        }
        System.out.println(count + " primes between " + start + " and " + end);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Need and end and number of threads");
        }
        int end = Integer.parseInt(args[0]);
        int NThreads = Integer.parseInt(args[1]);
        int NumsPerThread = end/NThreads;
        
        for (int i = 0; i < NThreads; i++) {
            System.out.println(i*NumsPerThread + ", " + ((i+1)*NumsPerThread-1));
            Primes p = new Primes(i*NumsPerThread, (i+1)*NumsPerThread-1);
            new Thread(p).start();
        }
    }
}