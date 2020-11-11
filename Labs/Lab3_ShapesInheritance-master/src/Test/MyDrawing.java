package Test;
import Shapes.*;
import java.awt.Color;
/**
 *
 * @author wilth
 */
public class MyDrawing {
    public static void main(String[] args){
        Circle C = new Circle(0.01, new Color(0,0,255), 0.3, 0.7, 0.2, 100);
        Square S = new Square(0.005, new Color(0, 255, 0), 0.4, 0.4, 0.2);
        Triangle T = new Triangle(0.01, new Color(255, 0, 0), 0.1, 0.1, 0.5, 0.9, 0.8, 0.2);
        C.draw();
        S.draw();
        T.draw();
    }
}
