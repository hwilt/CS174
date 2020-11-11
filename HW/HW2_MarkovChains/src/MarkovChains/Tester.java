package MarkovChains;


/**
 *
 * @author wilth
 */
public class Tester {
    public static void main(String[] args){
        MarkovChains model = new MarkovChains(5);
        model.addTextFromFile("spongebobquotes.txt");
        model.addTextFromFile("simpsonsquotes.txt");
        //model.addTextFromFile("ursinustweets.txt");
        model.synthesizeText("", 100);
        //System.out.println(model.gram.size());
        //System.out.println(model.gram.get(" you "));
    }
}
