package Shapes;

import java.awt.Color;


public class Point extends Shape {
    private double ax;
    private double ay;
    
    /**
     * Constructor for a point
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     * @param ax X coordinate of the point
     * @param ay Y coordinate of the point
     */
    public Point(double thickness, Color color, double ax, double ay) {
        super(thickness, color);
        this.ax = ax;
        this.ay = ay;
    }
    
    public double getX() {
        return ax;
    }
    
    public double getY() {
        return ay;
    }
    
    /**
     * Get the area of a point
     * @return 0; A point has zero area
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
        StdDraw.point(ax, ay);
    }
    
    @Override
    public String toString() {
        return "Point(" + ax + ", " + ay + ")";
    }
}
