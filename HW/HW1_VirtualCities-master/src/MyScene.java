/**
 * A class that holds methods to draw different 3D objects and piece
 * together scenes
 */
public class MyScene {
    
    /**
     * Draw a city block repeated several times
     */
    public static void drawScene() {
        Scene3D scene = new Scene3D();
        scene.addCamera(-50, 63, 111, 0);
        scene.addCamera(90, 63, 100, 0);
        scene.addLight(0, 100, 0, 1, 1, 1);
        scene.addLight(0, -100, 0, 1, 1, 1);
        scene.addLight(-100, 100, 0, 1, 1, 1);
        scene.addLight(100, -100, 0, 1, 1, 1);
        
        // Add a large gray box for the ground
        scene.addBox(0, -25, 0, 1000, 50, 1000, 127, 127, 127);
        
        drawCityBlock(scene,0,0);
        drawCityBlock(scene,30,0);
        drawCityBlock(scene,-30,0);
        drawCityBlock(scene,60,0);
        drawCityBlock(scene,-60,0);
        drawCityBlock(scene,0,20);
        drawCityBlock(scene,30,20);
        drawCityBlock(scene,-30,20);
        drawCityBlock(scene,60,20);
        drawCityBlock(scene,-60,20);
        drawCityBlock(scene,0,40);
        drawCityBlock(scene,30,40);
        drawCityBlock(scene,-30,40);
        drawCityBlock(scene,60,40);
        drawCityBlock(scene,-60,40);
        drawCityBlock(scene,0,60);
        drawCityBlock(scene,30,60);
        drawCityBlock(scene,-30,60);
        drawCityBlock(scene,60,60);
        drawCityBlock(scene,-60,60);
        
        scene.saveScene("myscene.json", "Scene Title");
    }
    
    /**
    * Draw a simple sign that consists of a 2 meter tall cylinder for the
    * poll and a 0.5x0.5x0.02 meter box for the sign itself
    * 
    * @param scene The scene to which to add the sign
    * @param cx Center of the sign in x
    * @param cz Center of the sign in z
    * @param isEastWest If true, the sign is oriented from east to west.  Otherwise,
    *                   the sign is oriented from north to south
    * @param r Red component of the sign
    * @param g Green component of the sign
    * @param b Blue component of the sign
    */
    public static void drawSign(Scene3D scene, double cx, double cz, boolean isEastWest, double r, double g, double b) {
        // Draw the main pole
        scene.addCylinder(cx, 1, cz, 0.05, 2, 127, 127, 127); 
        if (isEastWest) {
           // Draw a 0.5 x 0.5 box in the X/Y plane, with a thin dimension in Z
           scene.addBox(cx, 2, cz, 0.5, 0.5, 0.1, r, g, b);
        }
        else {
           // Draw a 0.5 x 0.5 box in the Y/Z plane, with a thin dimension in X
           scene.addBox(cx, 2, cz, 0.1, 0.5, 0.5, r, g, b);
        }
    }
    /**
     * Draws a tree that consists of any height cylinder for the trunk and a
     * Ellipsoid that is 1x1.25x1 meters for the leaves on top. The Elliposoid
     * is rgb(0,255,0) and the cylinder is rgb(102,51,0).
     * 
     * @param scene The scene to which to add the tree to.
     * @param cx center of the tree in x
     * @param cz center of the tree in z
     * @param height height for the tree trunk.
     */
    public static void drawTree(Scene3D scene, double cx, double cz, double height){
        scene.addCylinder(cx, 0, cz, 0.30, height, 102, 51, 0);
        scene.addEllipsoid(cx, height * 0.60, cz, 1, 1.25, 1, 0, 255, 0);
    }
    /**
     * Draws a FireHydrant that consists of two Cylinders one for the base of
     * Hydrant and one for the stem of the Hydrant, a sphere at the top of the
     * Hydrant to cap it off, and two boxes one that is positioned east to west
     * and one that is north to south. The rgb(255,0,0) is on everything.
     * 
     * @param scene The scene to which to add the fire hydrant to
     * @param cx center of the fire hydrant in x
     * @param cz center of the fire hydrant in z
     */
    public static void drawFireHydrant(Scene3D scene, double cx, double cz){
        scene.addCylinder(cx, 0, cz, 0.20, 0.15, 255, 0, 0);
        scene.addCylinder(cx, 0, cz, 0.13, 1, 255, 0, 0);
        scene.addSphere(cx, 0.5, cz, 0.13, 255, 0, 0);
        scene.addBox(cx, .37, cz, .18, .18, .4, 255, 0, 0);
        scene.addBox(cx, .37, cz, .18, .18, .4, 255, 0, 0, 0, 90, 0);
    }
    /**
     * Draws a Stop post that consists of a cylinder, two boxes, and three spheres
     * The cylinder is the stem of the stop post, the first box is for the arm to
     * the light box, and the last box is for the stoplight. The three spheres are
     * for each of red, yellow, and green lights.
     * 
     * @param scene The scene to which to add the stop post to
     * @param cx center of the stop post in x
     * @param cz center of the stop post in z
     */
    public static void drawStopPost(Scene3D scene, double cx, double cz){
        scene.addCylinder(cx, 0, cz, .30, 8, 169, 169, 169);
        scene.addBox(cx + 2, 3.8, cz, 0.25, 6, 0.5, 169, 169, 169, 0, 0, 90);
        scene.addBox(cx + 4, 3.4, cz, .45, .85, .45, 169, 169, 169);
        scene.addSphere(cx + 4, 3.55, cz+.23, .1, 255, 0, 0);
        scene.addSphere(cx + 4, 3.35, cz+.23, .1, 255, 255, 0);
        scene.addSphere(cx + 4, 3.15, cz+.23, .1, 0, 255, 0);
    }
    /**
     * Draws a car that can either be facing north/south or east/west. Consists 
     * of two boxes and two cylinders, the two cylinders are for the wheels and
     * can only be grey, and the two boxes are for the very boxy car which those
     * boxes can be any color the coder wants.
     * 
     * @param scene The scene to which to add the car to
     * @param cx center of the car in x
     * @param cz center of the car in z
     * @param r red value in rgb of the car
     * @param g green value in rgb of the car
     * @param b blue value in rgb of the car
     * @param isFacingNorth if true, the car is oriented from east to west. Otherwise,
     *                     the car is oriented from north to south
     */
    public static void drawCar(Scene3D scene, double cx, double cz, double r, double g, double b, boolean isFacingNorth){
        if (isFacingNorth) {
            scene.addBox(cx, .5, cz, 1.7, 0.7, 4.5, r, g, b);
            scene.addBox(cx, 1.2, cz-0.4, 1.5, 0.8, 3.5, r, g, b);
            scene.addCylinder(cx, .30, cz-1.7, .32, 1.72, 169, 169, 169, 90, 90, 0, 1, 1, 1);
            scene.addCylinder(cx, .30, cz+1.7, .32, 1.72, 169, 169, 169, 90, 90, 0, 1, 1, 1);
        }
        else {            
            scene.addBox(cx, .5, cz, 4.5, 0.7, 1.7, r, g, b);
            scene.addBox(cx-0.4, 1.2, cz, 3.5, 0.8, 1.5, r, g, b);
            scene.addCylinder(cx-1.7, .30, cz, .32, 1.72, 169, 169, 169, 90, 0, 0, 1, 1, 1);
            scene.addCylinder(cx+1.7, .30, cz, .32, 1.72, 169, 169, 169, 90, 0, 0, 1, 1, 1);
        }
    }
    
    /**
     * Draw at least two cars, two tress at different  heights, one fireHydrant,
     * one stop light, one sign, and at least one building(simple box)
     * 
     * @param scene the scene to which you will add the city block to
     * @param cx the center of the scene in x
     * @param cz the center of the scene in z
     */
    public static void drawCityBlock(Scene3D scene, int cx, int cz){
        scene.addBox(cx, 0, cz, 10, 50, 10, 169, 169, 169);
        drawTree(scene, cx + 8, cz - 2, 6);
        drawTree(scene, cx + 8, cz, 4);
        drawTree(scene, cx + 8, cz + 4 , 7);
        drawFireHydrant(scene, cx + 9, cz - 3);
        drawStopPost(scene, cx + 9, cz - 4);
        drawSign(scene,cx + 15, cz - 4, true, 255, 0, 0);
        drawCar(scene, cx + 11, cz - 4, 255, 0, 0, true);
        drawCar(scene, cx + 11, cz + 2, 0, 255, 0, true);
    }
    
    /**
     * Draws a pretty blocky person that consists of five boxes and one sphere,
     * the sphere for the head and two boxes for the arms, two boxes for the legs
     * one box for the chest.
     * 
     * @param scene the scene to which you will add the couple to
     * @param cx center position that the couple will be in x
     * @param cz center position that the couple will be in y
     */
    public static void drawPerson(Scene3D scene, double cx, double cz){
        //legs
        scene.addBox(cx - .2, 0, cz, .3, 2, .3, 0, 0, 255);
        scene.addBox(cx + .2, 0, cz, .3, 2, .3, 0, 0, 255);
        //arms
        scene.addBox(cx - .4, 1.75, cz, .2, 1, .3, 255, 0, 0);
        scene.addBox(cx + .4, 1.75, cz, .2, 1, .3, 255, 0, 0);
        //chest
        scene.addBox(cx, 1.63, cz, .7, 1.25, .3, 255, 0, 0);
        //head
        scene.addSphere(cx, 2.55, cz, .35, 207, 185, 151);
    }
    
    /**
     * Draws a pretty blocky couple that consists of two blocky people
     * 
     * @param scene the scene to which you will add the couple to
     * @param cx center position that the couple will be in x
     * @param cz center position that the couple will be in y
     */
    public static void drawCouple(Scene3D scene, int cx, int cz){
        drawPerson(scene, cx, cz);
        drawPerson(scene, cx + 1, cz + 0.1);
    }
    
    
    /**
     * Draw your art contest submission
     */
    public static void drawArtContest() {
        Scene3D scene = new Scene3D();
        scene.addCamera(-50, 63, 111, 0);
        scene.addCamera(90, 63, 100, 0);
        scene.addCamera(47, 2, 5, 0);
        scene.addLight(0, 100, 0, 1, 1, 1);
        scene.addLight(0, -100, 0, 1, 1, 1);
        scene.addLight(-100, 100, 0, 1, 1, 1);
        scene.addLight(100, -100, 0, 1, 1, 1);
        scene.addBox(0, -25, 0, 1000, 50, 1000, 127, 127, 127);
        
        drawCityBlock(scene,0,0);
        drawCityBlock(scene,30,0);
        drawCityBlock(scene,-30,0);
        drawCityBlock(scene,60,0);
        drawCityBlock(scene,-60,0);
        drawCityBlock(scene,0,20);
        drawCityBlock(scene,30,20);
        drawCityBlock(scene,-30,20);
        drawCityBlock(scene,60,20);
        drawCityBlock(scene,-60,20);
        drawCityBlock(scene,0,40);
        drawCityBlock(scene,30,40);
        drawCityBlock(scene,-30,40);
        drawCityBlock(scene,60,40);
        drawCityBlock(scene,-60,40);
        drawCityBlock(scene,0,60);
        drawCityBlock(scene,30,60);
        drawCityBlock(scene,-30,60);
        drawCityBlock(scene,60,60);
        drawCityBlock(scene,-60,60);
        drawCouple(scene, 47, 0);
        scene.saveScene("artcontest.json", "Couple Walking");
    }
    
    public static void main(String[] args) {
        drawScene();
        drawArtContest();
    }
}
