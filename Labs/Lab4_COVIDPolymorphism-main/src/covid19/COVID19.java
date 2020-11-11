/**
 * Purpose: To create a simple Monte Carlo simulation of a
 * spreading epidemic, A bunch of people are placed uniformly at random 
 * on a square grid, and a single one of them starts off infected.  
 */
package covid19;

import org.knowm.xchart.*;
import java.util.Random;
import java.util.ArrayList; 

public class COVID19 {
    private Person[] people;
    private int hour;
    private final int frameInterval;
    private final double drawSize;
    private final int numMoving;
    private int numHours;
    private final int numMask;
    double[] infectedCount;
    double[] uninfectedCount;
    double[] recoveredCount;
    
    
    /**
     * Initialize a pandemic scenario
     * @param numPeople The total number of people in the simulation
     * @param numMoving The total number of people in the simulation who are moving
     * @param moveDist The distance a person moves at each timestep
     * @param infectDist The distance a person has to be to infect another person
     * @param numHours The total number of hours in the simulation
     * @param recoveryTime The number of hours it takes to recover from being infected
     * @param frameInterval Target interval between frames of the animation in milliseconds
     * @param drawSize Size of the dot
     */
    public COVID19(int numPeople, int numMoving, double moveDist, 
                    double infectDist, int numHours, int recoveryTime,
                    int frameInterval, double drawSize, int numMask) {
        this.frameInterval = frameInterval;
        this.drawSize = drawSize;
        this.numMoving = numMoving;
        this.numHours = numHours;
        this.numMask = numMask;
        initializePandemic(numPeople, numMoving, numMask);
        runPandemic(moveDist, infectDist, numHours, recoveryTime);
    }
    
    /**
     * Initialize the pandemic
     * @param numPeople The total number of people in the simulation
     * @param numMoving The total number of people in the simulation who are moving
     * @param dist The distance a person moves at each timestep
     */
    private void initializePandemic(int numPeople, int numMoving, int numMask) {
        people = new Person[numPeople];
        for (int i = 0; i < numPeople; i++) {
            if (i < numMoving) {
                people[i] = new Person(true);
            }
            else if(i < numMoving + 20){
                people[i] = new Covidiot(false);
            }
            else if(i < numMoving + 40){
                people[i] = new EssentialWorker(false);
            }
            else if(i < numMoving + 50){
                people[i] = new Nurse(true);
                people[i].putOnMask();
            }
            else {
                people[i] = new Person(false);
            }
        }
        for(int j = 1; j < numMask; j++){
            people[j].putOnMask();
        }
        people[0].makeSick();
        this.hour = 0;
    }

    
    /**
     * Run the pandemic
     * @param moveDist The distance a person moves at each timestep
     * @param infectDist The distance a person has to be to infect another person
     * @param numHours The total number of hours in the simulation
     * @param recoveryTime The number of hours it takes to recover from being infected
     */
    private void runPandemic(double moveDist, double infectDist, 
                            int numHours, int recoveryTime) {
        infectedCount = new double[numHours];
        uninfectedCount = new double[numHours];
        recoveredCount = new double[numHours];
        for (hour = 0; hour < numHours; hour++) {
            for (int i = 0; i < people.length; i++) {
                people[i].updateStatus(recoveryTime);
                if(people[i] instanceof EssentialWorker){
                    people[i].move(moveDist);
                }
                else{
                    people[i].move(moveDist);
                }
                // Check contact with all other people
                for (int j = 0; j < people.length; j++) {
                    people[i].contactWith(people[j], infectDist);
                }
            }
            // Count the totals after this iteration
            int numInfected = 0;
            int numUninfected = 0;
            int numRecovered = 0;
            for (int i = 0; i < people.length; i++) {
                switch(people[i].getState()) {
                    case Person.INFECTED:
                        numInfected++;
                        break;
                    case Person.UNINFECTED:
                        numUninfected++;
                        break;
                    case Person.RECOVERED:
                        numRecovered++;
                        break;
                }
            }
            infectedCount[hour] = numInfected;
            uninfectedCount[hour] = numUninfected;
            recoveredCount[hour] = numRecovered;
            this.drawState();
        }
        this.plotResults();
    }
    
    /**
     * Draw points representing each person in the simulation
     */
    private void drawState() {
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLUE);
        for (Person p : people) {
            p.draw(drawSize);
        }
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(0.07, 0.97, "Day " + hour/24);
        StdDraw.show();
        StdDraw.pause(frameInterval);
    }
    
    /**
     * Plot the results of the simulation
     * @param title Title of the plot
     */
    public void plotResults() {
        int N = infectedCount.length;
        XYChart chart = new XYChart(500, 400);
        String title = "Epidemic Simulation: " + people.length + " People, ";
        title += "Moving = " + (100.0*numMoving/(double)people.length) + "%, ";
        title += "Mask Wearers =" + (100.0*numMask/(double)people.length) +"%, ";
        chart.setTitle(title);
        chart.setXAxisTitle("Day");
        chart.setYAxisTitle("Counts");
        double[] days = new double[N];
        for (int i = 0; i < N; i++) {
            days[i] = i/24.0;
        }
        chart.addSeries("Uninfected", days, uninfectedCount);
        chart.addSeries("Infected", days, infectedCount);
        chart.addSeries("Recovered", days, recoveredCount);
        //series.setMarker(SeriesMarkers.CIRCLE);
        ArrayList<XYChart> charts = new ArrayList<>();
        charts.add(chart);
        new SwingWrapper<>(charts).displayChartMatrix();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numPeople = 1000;
        int numMoving = 200;
        double moveDist = 0.005;
        double infectDist = 0.01;
        int numHours = 24*120;
        int recoveryTime = 24*14;
        int frameInterval = 1;
        double drawSize = 0.005;
        int numMask = 200;
        COVID19 sim = new COVID19(numPeople, numMoving, moveDist, 
                    infectDist, numHours, recoveryTime,
                    frameInterval, drawSize, numMask);
    }
    
}
