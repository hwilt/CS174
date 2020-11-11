package MarkovChains;
import java.io.*;
import java.util.*;

/**
 *
 * @author wilth
 */
public class MarkovChains {
    private int gramLen;
    public HashMap<String, HashMap<Character, Integer>> gram = new HashMap<>();
    
    public MarkovChains(int gramlength){
        gramLen = gramlength;
    }
    
    
    /**
     * Takes the line or string you input and puts the gram into a hashmap that
     * value is a hashmap of the character after the gram and how many times it
     * shows put in the text file.
     * 
     * @param a which is the string you input or string it gets from the file
     */
    public void addText(String a){
        String longa = a + a.substring(0,gramLen);
        for(int i = 0; i < a.length(); i++){
            int gramLength = i + gramLen;
            String gram1 = longa.substring(i, gramLength);
            if(!gram.containsKey(gram1)){
                HashMap<Character, Integer> gramcounts = new HashMap<>();
                if(gramLength <= a.length()){
                    char gramchar = longa.charAt(gramLength);
                    if(gramcounts.containsKey(gramchar)){
                        gramcounts.put(gramchar, gramcounts.get(gramchar) + 1);
                    }
                    else{
                        gramcounts.put(gramchar, 1);
                    }
                }
                gram.put(gram1, gramcounts);
            }
            else{
                if(gramLength <= a.length()){
                    char gramchar = longa.charAt(gramLength);
                    if(gram.get(gram1).containsKey(gramchar)){
                        gram.get(gram1).put(gramchar, gram.get(gram1).get(gramchar) +1);
                    }
                    else{
                        gram.get(gram1).put(gramchar, 1);
                    }
                }
            }
        }
    }
    
    
    /**
     * takes the name of the file and takes the line and sees if it is empty or 
     * not, if it isn't then it is pushed to the addText() method
     * 
     * @param filename name of the file
     */
    public void addTextFromFile(String filename){
        File fin = new File(filename);
        try {
            Scanner in = new Scanner(fin);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if(!line.isEmpty() && line.length() >= gramLen){
                    addText(line);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    
    /**
     * 
     * 
     * @param startGram how you want to start the line
     * @param numOfCharacters how long you want the line to be
     */
    public void synthesizeText(String startGram, int numOfCharacters){
        Random r = new Random();
        String end = "";
        String randChar = "";
        int rand;
        int currentSum;
        List<String> valueGram = new ArrayList<>(gram.keySet());
        for(int randGram = 0; randGram < valueGram.size(); randGram++){
            end += valueGram.get(randGram);
            for(int i = 0; i < numOfCharacters; i++){
                String nextGram = end.substring(end.length()-gramLen,end.length());
                if(gram.containsKey(nextGram)){
                    int total = 0;
                    for(Character ck: gram.get(nextGram).keySet()){
                        total += gram.get(nextGram).get(ck);
                    }
                    if(total > 0){
                        rand = r.nextInt(total);
                        currentSum = 0;
                        for(Character newChar: gram.get(nextGram).keySet()){
                            currentSum += gram.get(nextGram).get(newChar);
                            
                            if(rand < currentSum){
                                end += newChar;
                            }
                        }
                    }
                }
            }
            System.out.println(end);
            end = "";
        }
    }
}
