package Shapes;
import java.awt.Color;

public class Shape {
    protected double thickness;
    protected Color color;
    
    /**
     * Constructor for a shape
     * @param thickness Thickness of pen drawing
     * @param color Color to draw
     */
    public Shape(double thickness, Color color) {
        this.thickness = thickness;
        this.color = color;
    }
    
    /**
     * Setter method for a color
     * @param color An AWT color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Setter method for thickness
     * @param thickness The thickness
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
    
    /**
     * This method simply prepares the pen color and thickness.
     * Subclasses should override this method to actually draw things
     */
    public void draw() {
        StdDraw.setPenRadius(thickness);
        StdDraw.setPenColor(color);
    }
    
    public double getArea() {
        System.out.println("Warning: Calling getArea on base class");
        return 0;
    }
    
    
    @Override
    public String toString() {
        return "Shape";
    }
}
