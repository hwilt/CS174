package Shapes;

import java.awt.Color;

/**
 *
 * @author wilth
 */
public class Square extends Shape{
    private double centerX;
    private double centerY;
    private double sideLength;
    private LineSegment a;
    private LineSegment b;
    private LineSegment c;
    private LineSegment d;
    
    /**
     * Square Constructor
     * 
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     * @param x X coordinate of center
     * @param y Y coordinate of center
     * @param side side length
     */
    public Square(double thickness, Color color, double x, double y, double side) {
        super(thickness, color);
        centerX = x;
        centerY = y;
        sideLength = side;
        this.a = new LineSegment(thickness, color, x+(side/2), y+(side/2), x+(side/2), y-(side/2));
        this.b = new LineSegment(thickness, color, x-(side/2), y+(side/2), x+(side/2), y+(side/2));
        this.c = new LineSegment(thickness, color, x-(side/2), y-(side/2), x-(side/2), y+(side/2));
        this.d = new LineSegment(thickness, color, x-(side/2), y-(side/2), x+(side/2), y-(side/2));
        
    }
    
    /**
     * (side length)^2 = area
     * 
     * @return area
     */
    public double getArea(){
        return Math.pow(sideLength, 2);
    }
    
    public void draw(){
        // Set pen color and thickness
        super.draw();
        // draws the lines to make a square
        a.draw();
        b.draw();
        c.draw();
        d.draw();
    }
    
    public String toString(){
        return "Square centered at (" + centerX + ", " + centerY + ")";
    }
    
}
