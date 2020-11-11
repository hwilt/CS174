/**
 * The superclass for a person
 */
package covid19;

import java.awt.Color;
import java.util.Random;


public class Person {
    // The three states a person can be in
    public static final int INFECTED = 0;
    public static final int UNINFECTED = 1;
    public static final int RECOVERED = 2;
    public static final int OFF = 0;
    public static final int ON = 1;
    
    protected double x, y; // The 2D location of the person
    protected boolean moving; // Whether a person is moving
    protected int mask; // Whether a person has a mask or not
    protected int state; // What health state a person is in
    protected int timeSick; // Number of hours a person has been sick
    
    public Person(boolean moving) {
        state = UNINFECTED;
        timeSick = 0;
        this.moving = moving;
        this.mask = mask;
        this.moveToRandom();
    }
    
    /**
     * Move to a random position on the 1x1 grid
     * of the simulation
     */
    private void moveToRandom() {
        x = Math.random();
        y = Math.random();
    }
    
    /**
     * Manually move this person to a particular position
     * 
     * @param x Position to set x
     * @param y Position to set y
     */
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Perform one step of the random walk
     * @param dist Distance to move
     */
    public void move(double dist) {
        Random rand = new Random();
        if (moving) {
            int choice = rand.nextInt(4);
            if (choice == 0 && x > 0) {
                x -= dist;
            }
            else if (choice == 1 && x < 1) {
                x += dist;
            }
            else if (choice == 2 && y < 1) {
                y += dist;
            }
            else if (choice == 3 && y > 0) {
                y -= dist;
            }
        }
    }
    
    /**
     * See if a sick other person is coming into contact with
     * this person, and make this person sick if they are
     * uninfected
     * @param other The other person
     * @param infectDist The distance a person has to be to transmit
     *                   the disease
     */
    public void contactWith(Person other, double infectDist) {
        if (other.state == INFECTED && state == UNINFECTED) {
            // Distance in x between me and an other
            double dx = Math.abs(other.x - x); 
            // TODO: FILL THIS IN
            // If an infected person gets close enough to an 
            // uninfected person by the equation
            // Math.sfqrt(dx^2 + dy^2), then infect the uninfected person
            //Distance in y between me and an other
            double dy = Math.abs(other.y - y);
            double dist = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            if(dist <= infectDist){
                Random r = new Random();
                int percent = r.nextInt(100);
                if(other.mask == ON && mask == ON){
                    if(percent < 5){
                       makeSick(); 
                    }
                }
                else if(other.mask == ON && mask == OFF){
                    if(percent < 20){
                        makeSick();
                    }
                }
                else if(other.mask == OFF && mask == ON){
                    if(percent < 60){
                        makeSick();
                    }
                }
                else{
                    if(percent < 95){
                        makeSick();
                    }
                }
            }
        }
    }
    
    /**
     * Update the status of a person
     * @param recoveryTime How many hours it takes a person to recover
     */
    public void updateStatus(int recoveryTime) {
        // TODO: Fill this in.  If a person is infected
        // and they have been infected for longer than
        // recoveryTime, then switch them to being recovered
        if(getState() == INFECTED){
            if(recoveryTime <= timeSick){
                heal();   
            }
            else{
                timeSick += 1;
            }
        }
    }
    
    /**
     * Setup the color to draw based on the state
     */
    protected void setupPenColor() {
        switch(state) {
            case INFECTED:
                StdDraw.setPenColor(new Color(255, 173, 0));
                break;
            case RECOVERED:
                StdDraw.setPenColor(new Color(129, 0, 255));
                break;
            case UNINFECTED:
                StdDraw.setPenColor(new Color(0, 55, 255));
                break;
        }
    }
    
    /**
     * 
     * @param size The size to draw the point
     */
    public void draw(double size) {
        setupPenColor();
        StdDraw.filledCircle(x, y, size);
    }
    
    /**
     * @return Whether this person is moving
     */
    public boolean isMoving() {
        return (moving == true);
    }
    
    
    /**
     * Return the state of this person
     * @return 
     */
    public int getState() {
        return state;
    }
    
    /**
     * Change a person's state to be INFECTED
     */
    public void makeSick() {
        state = INFECTED;
    }
    
    /**
     * Puts a mask on a person
     */
    public void putOnMask(){
        mask = ON;
    }
    
    /**
     * Change a person's state to be RECOVERED
     */
    public void heal() {
        state = RECOVERED;
    }
    
    @Override
    public String toString() {
        String ret = "healthy";
        if (state == INFECTED) {
            ret = "sick";
        }
        return ret;
    }
}
