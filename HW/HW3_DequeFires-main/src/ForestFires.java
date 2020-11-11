public class ForestFires {
    private Tree[][] trees; // 2D array holding trees
    private Deque<Tree> treeDeque; // Deque holding trees that are on fire
    
    /**
     * Initialize a new forest fire simulation on a grid
     * @param N Number of points on the grid
     * @param fireCoords Locations of the starting coordinates of fires
     */
    public ForestFires(int N, int[][] fireCoords) {
        trees = new Tree[N][N];
        for (int i = 0; i < N; i++) {
            trees[i] = new Tree[N];
            for (int j = 0; j < N; j++) {
                trees[i][j] = new Tree(i, j);
            }
        }
        treeDeque = new Deque<>();
        for (int k = 0; k < fireCoords.length; k++) {
            int i = fireCoords[k][0];
            int j = fireCoords[k][1];
            trees[i][j].setState(Tree.ON_FIRE);
            treeDeque.addFirst(trees[i][j]);
        }
    }
    
    /**
     * Draw the entire forest with all of the trees their appropriate
     * colors
     * @param frameInterval Number of milliseconds to pause after draw
     */
    private void draw(int frameInterval) {
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < trees.length; i++) {
            for (int j = 0; j < trees[i].length; j++) {
                trees[i][j].draw(trees.length);
            }
        }
        StdDraw.show();
        StdDraw.pause(frameInterval);
    }
    
    /**
     * Perform a simulation of trees setting each other on fire
     * until the entire forest has burned down
     * @param frameInterval Number of milliseconds to pause after draw
     */
    private void doSimulation(int frameInterval) {
        System.out.println("Starting with " + treeDeque.size() + " fires");
        while(treeDeque.size() > 0) {
            // TODO: Constant time
            Tree fire =treeDeque.removeFirst();
            int i = fire.geti();
            int j = fire.getj();
            if(i-1 >= 0 && j-1 >= 0){
                Tree topLeft = trees[i-1][j-1];
                if(topLeft.getState() == Tree.HEALTHY){
                    topLeft.setState(Tree.ON_FIRE);
                    treeDeque.addLast(topLeft);
                }
            }
            if(i-1 >= 0 && j < trees.length){
                Tree topMiddle = trees[i-1][j];
                if(topMiddle.getState() == Tree.HEALTHY){
                    topMiddle.setState(Tree.ON_FIRE);
                    treeDeque.addLast(topMiddle);
                }
            }
            if(i-1 >= 0 && j+1 < trees.length){
                Tree topRight = trees[i-1][j+1];
                if(topRight.getState() == Tree.HEALTHY){
                    topRight.setState(Tree.ON_FIRE);
                    treeDeque.addLast(topRight);
                }
            }
            if(i < trees.length && j-1 >= 0){
                Tree middleLeft = trees[i][j-1];
                if(middleLeft.getState() == Tree.HEALTHY){
                    middleLeft.setState(Tree.ON_FIRE);
                    treeDeque.addLast(middleLeft);
                }
            }
            if(i < trees.length && j+1 < trees.length ){
                Tree middleRight = trees[i][j+1];
                if(middleRight.getState() == Tree.HEALTHY){
                    middleRight.setState(Tree.ON_FIRE);
                    treeDeque.addLast(middleRight);
                }
            }
            if(i+1 < trees.length && j-1 >= 0){
                Tree bottomLeft = trees[i+1][j-1];
                if(bottomLeft.getState() == Tree.HEALTHY){
                    bottomLeft.setState(Tree.ON_FIRE);
                    treeDeque.addLast(bottomLeft);
                }
            }
            if(i+1 < trees.length && j < trees.length){
                Tree bottomMiddle = trees[i+1][j];
                if(bottomMiddle.getState() == Tree.HEALTHY){
                    bottomMiddle.setState(Tree.ON_FIRE);
                    treeDeque.addLast(bottomMiddle);
                }
            }
            if(i+1 < trees.length && j+1 < trees.length){
                Tree bottomRight = trees[i+1][j+1];
                if(bottomRight.getState() == Tree.HEALTHY){
                    bottomRight.setState(Tree.ON_FIRE);
                    treeDeque.addLast(bottomRight);
                }
            }
            fire.setState(Tree.BURNT);
            draw(frameInterval);
        }
        System.out.println("Finished");
    }
    
    public static void main(String[] args) {
        int[][] onFire = {{10, 10}, {25, 25}};
        ForestFires fires = new ForestFires(50, onFire);
        fires.doSimulation(5);
    }
}
