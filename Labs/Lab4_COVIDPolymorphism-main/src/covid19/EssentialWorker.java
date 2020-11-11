/*
 * Made by Henry Wilt || Ursinus College Computer Science Student
 * It works on my machine, maybe not on yours.
 */
package covid19;

import java.util.Random;

public class EssentialWorker extends Person{

    private double vx, vy;//random numbers between 0 and 1
    private int hours = 0;

    public EssentialWorker(boolean moving){
        super(moving);
        Random r = new Random();
        vx = r.nextDouble();
        vy = r.nextDouble();
    }
    
    
    /**
     * Has the worker move to its work and back home
     * @param dist Distance to move
     */
    public void move(double dist){
        if(hours > 8 && hours < 13){
            x += vx * dist;
            y += vy * dist;
        }
        else if(hours > 20 && hours <= 24){
            if(hours  == 24){
                hours = 0;
                x += -vx * dist;
                y += -vy * dist;
            }
            else{
                x += -vx * dist;
                y += -vy * dist;
            }
        }
        hours++;
    }
    
    /**
     * Draws the EssentialWorkers as a box instead of a Circle
     * @param size The size to draw the point
     */
    public void draw(double size) {
        setupPenColor();
        StdDraw.filledSquare(x, y, size * 2);
    }
}
