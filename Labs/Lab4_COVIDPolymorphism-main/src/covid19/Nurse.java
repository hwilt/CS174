/*
 * Made by Henry Wilt || Ursinus College Computer Science Student
 * It works on my machine, maybe not on yours.
 */
package covid19;

import static covid19.Person.INFECTED;
import static covid19.Person.OFF;
import static covid19.Person.ON;
import static covid19.Person.UNINFECTED;
import java.util.Random;


public class Nurse extends Person{
    
    public Nurse(boolean moving) {
        super(moving);
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
        Random r = new Random();
        double dx = Math.abs(other.x - x); 
        double dy = Math.abs(other.y - y);
        double dist = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        if (other.state == INFECTED && state == UNINFECTED) {
            if(dist <= infectDist){ 
                int percent = r.nextInt(100);
                int heal = r.nextInt(100);
                if(heal < 50){
                    other.heal();
                }
                else if (percent < 10){
                    makeSick();
                }
            }
        }
    }
    
    
    
    
    
    /**
     * Draws the nurse half the size of regular people
     * @param size The size to draw the point
     */
    public void draw(double size) {
        setupPenColor();
        StdDraw.filledCircle(x, y, size/2);
    }
}
