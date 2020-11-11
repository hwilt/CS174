/**
 *
 * @author wilth
 */
public class Location {
    private String locationName;
    private String description;
    private String[] placesToGo;
    
    /**
     * Constructor for each location which will set the name, description and 
     * the places you can go for each location
     * 
     * @param name the location name
     * @param descp the description of the location
     * @param arr the array that holds the places you can go.
     */
    public Location(String name, String descp, String[] arr){
        locationName = name;
        description = descp;
        placesToGo = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            placesToGo[i] = arr[i];
        }
    }
    
    /**
     * Returns the location name of the location
     * 
     * @return the location name
     */
    public String getLocationName(){
        return locationName;
    }
    
    /**
     * Returns the description of the location
     * 
     * @return the description
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Returns the array of places that location can then go to, 
     * 
     * @return placesTo string
     */
    public String getPlacesTo(){
        String placesTo = "[";
        for(int i = 0; i < placesToGo.length; i++){
            if(placesToGo.length - 1 != i){
                placesTo += placesToGo[i] + "], [";
            }
            else{
                placesTo += placesToGo[i] + "]";
            }
        }
        return placesTo;
    }
    
    
    /**
     * toString method for the location object which returns the name, 
     * description and locations you can go next
     * 
     * @return 
     */
    public String toString(){
        return "Location: " + locationName + "; " + description;
    }
    
}
