package Shapes;

import java.awt.Color;

/**
 *
 * @author wilth
 */
public class Triangle extends Shape{
    private LineSegment a;
    private LineSegment b;
    private LineSegment c;
    

    /**
     * Triangle Constructor 
     * 
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     * @param ax X coordinate of first point
     * @param bx Y coordinate of first point
     * @param cx X coordinate of second point
     * @param ay Y coordinate of second point
     * @param by X coordinate of third point
     * @param cy Y coordinate of third point
     */
    public Triangle(double thickness, Color color, double ax, double ay, double bx, double by, double cx, double cy){
        super(thickness, color);
        this.a = new LineSegment(thickness, color, ax, ay, bx, by);
        this.b = new LineSegment(thickness, color, bx, by, cx, cy);
        this.c = new LineSegment(thickness, color, cx, cy, ax, ay);
    }
    
    /**
     * Use heron's formula to find the semi-perimeter then use the area of 
     * a triangle formula.
     * 
     * @return area; 
     */
    public double getArea(){
        double semiPerimeter = (a.getLength() + b.getLength() + c.getLength());
        semiPerimeter /= 2;
        double area = Math.sqrt(semiPerimeter*(semiPerimeter-a.getLength())*(semiPerimeter-b.getLength())*(semiPerimeter-c.getLength()));
        return area;
    }
    
    
    
    public void draw() {
        // Set pen color and thickness
        super.draw();
        // draws the lines to make a triangle
        a.draw();
        b.draw();
        c.draw();
    }
    
    
    
    public String toString() {
        return "Triangle from " + a.getPoint() + " to " + b.getPoint() + " to " + c.getPoint();
    }
    
}
