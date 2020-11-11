package Test;
import Shapes.*;
import java.awt.Color;
/**
 *
 * @author wilth
 */
public class test {
    public static void main(String[] args){
        //LineSegment L1 = new LineSegment(0.01, new Color(0, 255, 255), 0.2, 0.2, 0.5, 0.5);
        //System.out.println(L1);
       // System.out.println("length = " + L1.getLength());
        //L1.draw();
        //Triangle T = new Triangle(0.01, new Color(255, 0, 0), 0.1, 0.1, 0.5, 0.9, 0.8, 0.2);
        //System.out.println(T);
        //System.out.println("Area = " + T.getArea());
        //T.draw();
        //Square S = new Square(0.01, new Color(255, 0, 0), 0.6, 0.6, 0.3);
        //System.out.println(S);
        //System.out.println("Area = " + S.getArea());
        //S.draw();
        //Square S1 = new Square(0.005, new Color(0, 255, 0), 0.4, 0.4, 0.2);
        //S1.draw();
        Circle C = new Circle(0.01, new Color(0,0,255), 0.3, 0.7, 0.2, 15);
        System.out.println(C);
        System.out.println(C.getArea());
        C.draw();
        Circle C1 = new Circle(0.005, new Color(0,255,0), 0.8, 0.3, 0.1, 100);
        C1.draw();
    }
}
