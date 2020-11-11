public class Counter {
    private int c;
    public Counter() {
        c = 0;
    }
    public void increment() {
        c = c + 1;
    }
    public void decrement() {
        c = c - 1;
    }
    public String toString() {
        return "" + c;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 10000; i++) {
            counter.increment();
            counter.decrement();
        }
        System.out.println(counter);
    }
}