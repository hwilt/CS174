package drills;

/**
 *
 * @author wilth
 */
public class StringUtils {
    /**
    * Count the number of vowels in a string, regardless
    * of case
    * 
    * @param s The string to examine
    * @return The number of vowels in the string
    */
    public static int countVowels(String s) {
      int numVowels = 0;
      String s1 = s.toLowerCase();
      for(int i = 0; i < s1.length(); i++){
          if(s1.charAt(i) == 'a' || s1.charAt(i) == 'e' ||s1.charAt(i) == 'i' ||s1.charAt(i) == 'o' || s1.charAt(i) =='u'){
              numVowels++;
          }
      }
      return numVowels;
    }


}