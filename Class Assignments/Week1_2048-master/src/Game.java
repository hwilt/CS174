import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int[][] board;
    
    public Game() {
        board = new int[4][4];
    }
    
    /**
     * Print out the board in text, making enough space to 
     * accommodate 4 digit numbers like 2048
     */
    public void printBoard() {
        for (int i = 0; i < 4; i++) {
            System.out.println("=========================");
            for (int j = 0; j < 4; j++) {
                if (board[i][j] > 0) {
                    System.out.printf("|%4d ", board[i][j]);
                }
                else {
                    System.out.printf("|     ");
                }
            }
            System.out.println("|");
        }
        System.out.println("=========================\n");
    }
    
    /**
     * Clear the board by putting all zeroes into it
     */
    public void clearBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }   
    }
    
    /**
     * Add a single random number that's either a 2 or a 4
     */
    public void addRandom() {
        // TODO: Group 1 fills this in
    }
    
    /**
     * Initialize a grid with some amount of random numbers that
     * are either 2s or 4s
     * @param numInitial How many numbers to place
     */
    public void makeRandomGrid(int numInitial) {
        // TODO: Group 1 fills this in
    }
    
    /**
     * Move all of the nonzero entries over to the right so there
     * are no gaps and everything is touching the right
     */
    public void moveRight() {
        // TODO: Group 2 fills this in
    }
    
    /**
     * Move all of the nonzero entries down so there
     * are no gaps and everything is touching the bottom
     */
    public void moveDown2() {
        for(int row = 3; row >= 0; row--){
            for (int col = 3; col >= 0; col--){
                if(board[row][col] > 0){
                    switch(row){
                        case 0:
                            if(board[1][col]  == 0){
                                if(board[2][col] == 0){
                                    if(board[3][col] == 0){
                                    board[3][col] = board[row][col];
                                    board[row][col]  = 0;
                                    }
                                    else{
                                        board[2][col] = board[row][col];
                                        board[row][col] = 0;
                                    }
                                }
                                else{
                                    board[1][col] = board[row][col];
                                    board[row][col] = 0;
                                }
                            }
                            break;
                        case 1:
                            if(board[2][col] == 0){
                                if(board[3][col] == 0){
                                    board[3][col] = board[row][col];
                                    board[row][col] = 0;
                                }
                                else{
                                    board[2][col] = board[row][col];
                                    board[row][col] = 0;
                                }
                            }
                            break;
                        case 2:
                            if(board[3][col] == 0){
                                board[3][col] = board[row][col];
                                board[row][col] = 0;
                            }
                            break;
                        case 3:
                            break;
                    }
                }
            }
        }
    }
    public static void moveDown(){
        for(int col = 0; col < 4; col++){
            for(int row = 2; row >= 0; row--){
                if(board[row][col] != 0){
                    for(int i = 3; i >= 0; i--){
                        if(board[i][col] == 0){
                            board[i][col] = board[row][col];
                            board[row][col] = 0;
                        }
                    }
                }
            }
        }
    } 
    
    /**
     * Combine all adjacent numbers that are the same in a particular row
     * There are three cases
     * 1) There are two in a row.  In this case, put a zero in the place
     *    of the first one, and replace the second one with twice its value
     * 2) There are three in a row.  In this case, put a zero in the first place,
     *    keep the original value in the second place, and put twice the original
     *    value in the third place
     * 3) There are 4 in a row.  Put zeros in the first two, and put twice
     *    the value in the second two
     */
    public void combineRight() {
        // TODO: Group 4 fills this in
    }
    
    
    /**
     * Combine all adjacent numbers that are the same in a particular column
     * There are three cases
     * 1) There are two in a row.  In this case, put a zero in the place
     *    of the first one, and replace the second one with twice its value
     * 2) There are three in a row.  In this case, put a zero in the first place,
     *    keep the original value in the second place, and put twice the original
     *    value in the third place
     * 3) There are 4 in a row.  Put zeros in the first two, and put twice
     *    the value in the second two
     */
    public void combineDown() {
        // TODO: Group 5 fills this in
    }
    
    /**
     * Reflect the board vertically
     */
    public void flipVertically() {
        // TODO: Group 6 fills this in
    }
    
    /**
     * Reflect the board horizontally
     */
    public void flipHorizontally() {
        // TODO: Group 6 fills this in
    }
    
    /**
     * Return whether the board is full
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        // TODO: Group 7 fills this in
        return false; // TODO: This is a dummy value
    }
    
    /**
     * Check that the board is full *and* it is not possible
     *            to combine any adjacent elements
     * @return true if the game is over, false otherwise
     */
    public boolean isOver() {
        // TODO: Group 7 fills this in
        return false; // TODO: This is a dummy value
    }
    
    /**
     * Repeat the following until the board is full
     * 1) Print the board
     * 2) Have the user choose a direction: 
     *        a Left, d right, w up, s down
     * 3) Move the board in that direction and combine things as necessary
     * 4) Print the resulting board
     * 5) If the board is not full, put a new random 2 or 4 on the board
     */
    public void playGame() {
        
    }
    
    /**
     * You can use this for debugging; put any numbers you like in
     * the board
     */
    public void makeMyOwnGrid() {
        clearBoard();
        // TODO: Fill this in with your own custom board
        board[0][0] = 2;
        board[2][0] = 2;
        board[0][1] = 4;
        board[2][1] = 4;
        board[0][2] = 32;
        board[2][2] = 64;
        board[1][3] = 8;
        board[2][3] = 8;
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        // TODO: Debugging/test code here
        game.makeMyOwnGrid();
        game.printBoard();
        game.moveDown();
        game.printBoard();
    }
}
