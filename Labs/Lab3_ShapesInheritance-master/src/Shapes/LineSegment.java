package Shapes;

import java.awt.Color;

public class LineSegment extends Shape {
    private Point a;
    private Point b;
    
    /**
     * Line segment constructor
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     * @param ax X coordinate of first point
     * @param ay Y coordinate of first point
     * @param bx X coordinate of second point
     * @param by Y coordinate of second point
     */
    public LineSegment(double thickness, Color color,
                       double ax, double ay, double bx, double by) {
        super(thickness, color);
        this.a = new Point(thickness, color, ax, ay);
        this.b = new Point(thickness, color, bx, by);
    }
    
    /**
     * An alternative line segment constructor that accepts point objects
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     * @param a The first point
     * @param b The second point
     */
    public LineSegment(double thickness, Color color, Point a, Point b) {
        super(thickness, color);
        this.a = a;
        this.b = b;
    }
    
    /**
     * Update the coordinates of the first point
     * @param ax X coordinate of first point
     * @param ay Y coordinate of first point
     */
    public void setA(double ax, double ay) {
        this.a = new Point(thickness, color, ax, ay);
    }
    
    
    /**
     * Update the coordinates of the second point
     * @param bx X coordinate of second point
     * @param by Y coordinate of second point
     */
    public void setB(double bx, double by) {
        this.b = new Point(thickness, color, bx, by);
    }
    
    /**
     * Get the length of this line segment by using the 
     * Pythagorean theorem
     * @return The length of the line segment
     */
    public double getLength() {
        double diffx = a.getX() - b.getX();
        double diffy = a.getY() - b.getY();
        return Math.sqrt(diffx*diffx + diffy*diffy);
    }
    
    /**
     * Get the area of a line segment
     * @return 0; A line segment has zero area
     */
    @Override
    public double getArea() {
        return 0.0;
    }
    
    @Override
    public void draw() {
        // Set pen color and thickness
        super.draw(); 
        // Draw the line segment
        StdDraw.line(a.getX(), a.getY(), b.getX(), b.getY());
    }
    
    public String getPoint(){
        return "Point(" + a.getX() + ", " + a.getY() + ")";
    }
   
    
    @Override
    public String toString() {
        return "Line Segment from " + a.toString() + " to " + b.toString();
    }
}
