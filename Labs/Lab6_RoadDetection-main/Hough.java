/**
 * Programmer: Chris Tralie (modified by CS 174 student)
 * Purpose: To use the hough transform to find lines in an edge image.  Students
 * will convert this into thread-safe parallel code by making this implement the
 * runnable interface and having it compute different ranges of angles in parallel
*/
import java.awt.Color;
import java.util.Arrays;

public class Hough implements Runnable {
    private EdgeImage image;
    private int NAngles; //not usefull anymore
    private int NRad;
    private float thresh;
    private int start; //start of the angles
    private int end; //end of the angles 

    /**
     * Initialize a hough transform for lines
     * @param image The edge image to do this on
     * @param NAngles Number of angles to sweep from 0 to 2PI at each offset
     * @param NRad number of offsets
     * @param thresh Threshold over which to consider an edge to have enough 
     *               energy to draw
     */
    public Hough(EdgeImage image, int start, int end, int NRad, float thresh) {
        this.image = image;
        this.end = end;
        this.start = start;
        this.NRad = NRad;
        this.thresh = thresh;
    }

    /**
     * Draw a line at a particular angle at a particular distance
     * from the center
     * @param angle Angle between 0 and 2PI
     * @param r Distance from center
     */
    public void drawLine(double angle, double r) {
        int M = image.grad.length;
        int N = image.grad[0].length;
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        double di = -s;
        double dj = c;
        for (int k = 0; k < 2; k++) {
            double i = r*c + image.grad.length/2;
            double j = r*s + image.grad[0].length/2;
            while (i >= 0 && j >= 0 && i < M && j < N) {
                int ii = (int)i;
                int jj = (int)j;
                synchronized(image) {   
                    image.picture.set(jj, ii, Color.RED); //put a lock
                }
                i += di;
                j += dj;
            }
            di *= -1;
            dj *= -1;
        }
    }

    /**
     * Draw the edges using the parameters specified in the constructor
     */
    //change this to run()
    public void run() {
        int M = image.grad.length;
        int N = image.grad[0].length;
        for (int a = start; a < end; a++) {
            double angle = 2*Math.PI*a/end;
            double c = Math.cos(angle);
            double s = Math.sin(angle);
            for (int r = 0; r < NRad; r++) {
                double di = -s;
                double dj = c;
                float total = 0.0f;
                for (int k = 0; k < 2; k++) {
                    double i = r*c + image.grad.length/2;
                    double j = r*s + image.grad[0].length/2;
                    while (i >= 0 && j >= 0 && i < M && j < N) {
                        int ii = (int)i;
                        int jj = (int)j;
                        total += image.grad[ii][jj];
                        i += di;
                        j += dj;
                    }
                    di *= -1;
                    dj *= -1;
                }
                if (total > thresh) {
                    drawLine(angle, r);
                }
            }
        }
        synchronized(image){
            image.picture.save("edges.png");
        }
        
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Error: Need to specify image path, threshold, and Threads");
        }
        String imagepath = args[0];
        float thresh = Float.parseFloat(args[1]);
        EdgeImage im = new EdgeImage(imagepath);
        int sigma = 3;
        // Step 1: Compute gradient
        im.computeGradient(sigma, 3);
        //ImageUtils.saveImage(im.grad, "grad.png", true, 0);
        // Step 2: Nonmax suppression
        im.nonmaxSuppression();
        // Step 3: Get edges
        int numAngles = 4000;
        int NThreads = Integer.parseInt(args[2]);
        int NumsPerThread = numAngles/NThreads;
        for(int i = 0; i < NThreads; i++){
            System.out.println("Thread " + i + ", Angles:" + i*NumsPerThread + ", " + ((i+1)*NumsPerThread-1));
            Hough h = new Hough(im, i*NumsPerThread, (i+1)*NumsPerThread-1, 1000, thresh);
            new Thread(h).start();
        }
    }
}
