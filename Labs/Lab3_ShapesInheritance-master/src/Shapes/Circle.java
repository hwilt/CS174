package Shapes;

import java.awt.Color;

/**
 *
 * @author wilth
 */
public class Circle extends Shape{
    private double centerX;
    private double centerY;
    private double radius;
    private int numOfLines;
    
    
    
    /**
     * Circle Constructor
     * 
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     * @param cx X center of circle
     * @param cy Y center of circle
     * @param r radius of circle
     * @param lines number of lines in the circle
     */
    public Circle(double thickness, Color color, double cx, double cy, double r, int lines) {
        super(thickness, color);
        centerX = cx;
        centerY = cy;
        radius = r;
        numOfLines = lines;
    }
    
    /**
     * area = pi*radius^2
     * 
     * @return area
     */
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    
    public void draw(){
        // Set pen color and thickness
        super.draw();
        // loop for making the line segments of the circle
        LineSegment a;
        double x1;
        double y1;
        double x2;
        double y2;
        for(int i = 0; i < numOfLines; i++){
            x1 = centerX + radius*Math.cos((2*Math.PI*i)/numOfLines);
            y1 = centerY + radius*Math.sin((2*Math.PI*i)/numOfLines);
            x2 = centerX + radius*Math.cos((2*Math.PI*(i+1))/numOfLines);
            y2 = centerY + radius*Math.sin((2*Math.PI*(i+1))/numOfLines);
            a = new LineSegment(thickness, color, x1,y1,x2,y2);
            a.draw();
        }
    }
    
    public String toString(){
        return "Circle centered at (" + centerX + ", " + centerY + ")";
    }
}
