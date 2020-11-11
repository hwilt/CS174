import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author wilth
 */
public class Adventure {
    //holds all the locations that the locations can go to
    public static HashMap<String, String[]> LocationToLocation = new HashMap();
    
    //holds the location data for all locations in the palace
    public static HashMap<String, Location> palace = new HashMap<>();
    
    /**
     * Displays the starting texts 
     */
    public static void startOfAdventure(){
        String start = "Welcome, agent. \nYou are now in front of the Palace. Get out of the car and go into the party. \nYour Goal: Find the King's Room and use the key to open the vault and steal his treasure.";
        System.out.println(start);
    }
    
    
    /**
     * Displays the ending texts 
     */
    public static void endOfAdventure(){
        String end = "You made it, congrats. You stuff your pockets and bag with the gold coins. \nYou start to leave the vault as you notice something else in the corner of your eye.";
        System.out.println(end);
    }
    
    /**
     * Adds where each location can go to in a hash-map.
     */
    public static void addLocationstoLocations(){
        LocationToLocation.put("Courtyard", new String[] {"Grand Hall"});
        LocationToLocation.put("Grand Hall", new String[] {"Main Dinning Room", "Ballroom", "Courtyard"});
        LocationToLocation.put("Ballroom", new String[] {"Grand Hall"});
        LocationToLocation.put("Main Dinning Room", new String[] {"Hallway", "Grand Hall"});
        LocationToLocation.put("Hallway", new String[] {"Guest Room", "King's Room", "Main Dinning Room"});
        LocationToLocation.put("Guest Room", new String[] {"Hallway"});
        LocationToLocation.put("King's Room", new String[] {"Walkway", "Hallway"});
        LocationToLocation.put("Walkway", new String[] {"Vault", "King's Room"});
        LocationToLocation.put("Vault", new String[] {"Walkway"});
    }
    
    /**
     * Adds all the locations to the hash-map with each location's name, description,
     * and locations it can go to.
     */
    public static void addLocations(){
        palace.put("Courtyard", new Location("Courtyard", "\nGet into the party, toward the Main Hall", LocationToLocation.get("Courtyard")));
        palace.put("Grand Hall", new Location("Grand Hall", "\nYou walk into the palace and the first thing that catches your eye is the massive marble starcase.\nAs, you look around more, you look for where the vault could be.\nThere are two rooms, the Ballroom and Main Dinning Hall.", LocationToLocation.get("Grand Hall")));
        palace.put("Main Dinning Room", new Location("Main Dinning Room", "\nYou sit down next to a table of fine noble men and women.\nThey are talking about the king and his riches.\nYou question \"Do you know where he stores them?\"\nThey do not respond, but one of women passes you a paper to meet her in the Hallway.", LocationToLocation.get("Main Dinning Room")));
        palace.put("Hallway", new Location("Hallway", "\nWalking out of the Dinning room you spot the women who told you to meet her in the Hall.\nShe wispers to you \"The king keeps his treature in his vault but you need the key. Look for it in his room.\"\nShe leaves and you start walking down the hall and come across two bedrooms.", LocationToLocation.get("Hallway")));
        palace.put("Ballroom", new Location("Ballroom", "\nAs you walk in there is an expansive room, with 20ft high ceiling.\nThere are many people dancing around you and as you come to notice. \nThere is no other way out than the way you came.", LocationToLocation.get("Ballroom")));
        palace.put("Guest Room", new Location("Guest Room", "\nYou look around and see a sign, it says that you went into the wrong room.", LocationToLocation.get("Guest Room")));
        palace.put("King's Room", new Location("King's Room", "\nYou walk straight into the King's room and start searching for the key.\nYou see his bed, his desk and a bookshelf.\nOn his desk, there is his notebook and a drawer, you open the drawer and you find the key.\nNow to find the vault, as you thought that the door handle starts to jiggle.\nYou have to think quicky, the bookshelf maybe a hidden door and luck finds you as the bookshelf opens.\nYou quickly close it as the king walks in.", LocationToLocation.get("King's Room")));
        palace.put("Walkway", new Location("Walkway", "\nYou escaped from the King finding, you contiune walking down the walkway and find a locked steel door.\nYou painked for a bit but, remember the key that you swiped and use it.\nThe key turns.", LocationToLocation.get("Walkway")));
        palace.put("Vault", new Location("Vault", "", LocationToLocation.get("Vault")));
    }
    
    
    /**
     * calls to add the locations, to start the adventure, end the adventure, and
     * have a loop until you get to the end.
     */
    public static void play(){
        Scanner in = new Scanner(System.in);
        boolean gameOver = false;
        String locationNext = "Courtyard";
        addLocationstoLocations();
        addLocations();
        startOfAdventure();
        System.out.println("\n" + palace.get("Courtyard"));
        while(!gameOver){
            System.out.println("\nWhere would you like to go next:" + palace.get(locationNext).getPlacesTo());
            locationNext = in.nextLine();
            if(locationNext.compareTo("Vault") == 0){
                gameOver = true;
            }
            System.out.println("\n" + palace.get(locationNext));
        }
        endOfAdventure();
    }
    
    
    public static void main(String[] args){
        play();
    }
}
