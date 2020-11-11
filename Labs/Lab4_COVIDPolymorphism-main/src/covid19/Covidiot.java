/*
 * Made by Henry Wilt || Ursinus College Computer Science Student
 * It works on my machine, maybe not on yours.
 */
package covid19;

import java.util.Random;


public class Covidiot extends Person{
    
    private double vx, vy; //random numbers between 0 and 1
    
    public Covidiot(boolean moving) {
        super(moving);
        Random r = new Random();
        vx = r.nextDouble();
        vy = r.nextDouble();
    }
    
    /**
     * Goes in straight line then bounces back if it goes out of bounds
     * @param dist Distance to move
     */
    public void move(double dist) {
        x += vx * dist;
        y += vy * dist;
        if(x > 1){
            vx = -vx;
            x = 1;
        }
        else if(x < 0){
            vx = -vx;
            x = 0;
        }
        else if(y > 1){
            vy = -vy;
            y = 1;
        }
        else if(y < 0){
            vy = -vy;
            y = 0;
        }
    }
    
    
    /**
     * Draws the Covidiots twice the size of regular people
     * @param size The size to draw the point
     */
    public void draw(double size) {
        setupPenColor();
        StdDraw.filledCircle(x, y, size * 2);
    }
}
