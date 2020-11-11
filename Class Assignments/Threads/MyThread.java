public class MyThread implements Runnable {
    private Counter counter;
    private int N;
    /**
     * 
     * @param counter Counter object
     * @param N Number of times I want to increment and decrement
     *          one right after the other
     */
    public MyThread(Counter counter, int N) {
        this.counter = counter;
        this.N = N;
    }

    public void run() {
        for (int i = 0; i < N; i++) {
            synchronized(counter) {
                counter.increment();
            }
            
            // c = 1000
            // RACE CONDITION
            // Thread 1 reads c, and adds 1 to it, getting 1001
            // Thread 1 writes 1001
            // Thread 2 reads c, which is 1001, adds 1 to it, getting 1002
            // Thread 2 writes 1002

            // Thread 1 reads c, and adds 1 to it, getting 1001
            // Thread 2 reads c, reads 1000, add 1 to it, getting 1001
            // Thread 1 writes 1001
            // Thread 2 writes 1001
            synchronized(counter) {
                counter.decrement();
            }
            
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 4; i++) {
            MyThread thread = new MyThread(counter, 10000);
            new Thread(thread).start();
        }
        try {
            // Wait a second for the threads to finish
            Thread.sleep(1000);
            System.out.println(counter);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}