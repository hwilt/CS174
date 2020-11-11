public class Tree {
    // States of a tree
    public static final int HEALTHY = 0;
    public static final int ON_FIRE = 1;
    public static final int BURNT = 2;
    private int state;
    private int i, j;
    /**
     * Initialize a tree with grid coordinates
     * @param i Row of tree
     * @param j Column of tree
     */
    public Tree(int i, int j) {
        state = HEALTHY;
        this.i = i;
        this.j = j;
    }
    /**
     * Return the state of the tree
     * @return state
     */
    public int getState() {
        return this.state;
    }
    /**
     * Set the state of the tree
     * @param state 
     */
    public void setState(int state) {
        this.state = state;
    }
    /**
     * Get the row of the tree
     * @return row
     */
    public int geti() {
        return i;
    }
    /**
     * Get the column of the tree
     * @return column
     */
    public int getj() {
        return j;
    }
    /**
     * Draw the tree with its appropriate color and at an appropriate
     * size, given how big the grid is
     * @param gridSize Number of trees along a row/column
     */
    public void draw(int gridSize) {
        switch(state) {
            case HEALTHY:
                StdDraw.setPenColor(StdDraw.GREEN);
                break;
            case ON_FIRE:
                StdDraw.setPenColor(StdDraw.RED);
                break;
            case BURNT:
                StdDraw.setPenColor(StdDraw.BLACK);
        }
        StdDraw.setPenRadius(0.5/gridSize);
        double fuzz = 0.5/gridSize;
        StdDraw.point(j/(double)gridSize + fuzz, i/(double)gridSize + fuzz);
    }
    
    public String toString() {
        String[] types = {"Healthy", "Fire", "Burnt"};
        return types[state] + " at (" + i + ", " + j + ")";
    }
}