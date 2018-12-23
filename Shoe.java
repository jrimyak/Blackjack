import java.util.ArrayList;
import java.util.Random;
/**
 * SHoe.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * A shoe of decks of cards for the use in the game of BlackJack
 *
 */
public class Shoe
{
    private ArrayList<Card> shoe;
    /**
     * Creates a Shoe of n decks of cards.
     * 
     * @param   n   the number of decks that will be made. 
     */
    public Shoe(int n)
    {
        shoe = new ArrayList<Card>();
        for(int i = 0; i < n; i++)
        {
            Deck decks = new Deck();
            for(int j = 0; j < decks.getDeck().size(); j++)
            {
                shoe.add(decks.getDeck().get(j));
            }
        }
    }
    
    /**
     * shuffles the entire shoe with all decks so that every card is touched and 
     * moved to a different location in the shoe.
     */
    public void shuffle()
    {
        Random random = new Random();
        int x;
        Card temp;
        for(int i = shoe.size() -1; i >=0; i--)
        {
            temp = shoe.get(i);
            x = random.nextInt(shoe.size());
            shoe.set(i, shoe.get(x));
            shoe.set(x,temp);
        }
    }
    
    /**
     * returns the shoe. 
     */
    public ArrayList<Card> shoe()
    {
        return shoe;
    }
    
    /**
     * returns the top (first) card of the deck
     */
    public Card getTopCard()
    {
        Card card;
        card = shoe.get(0);
        shoe.remove(0);
        return card;
    }
    
    /**
     * PRECONDITION: must get (n-1) to get the card that is wanted
     * 
     * returns any card in the shoe with the given int n.
     * 
     * @param   n   location of the card that we want to return
     */
    public Card getCard(int n)
    {
        Card card;
        card = shoe.get(n-1);
        shoe.remove(n-1);
        return card;
    }
    
    /**
     * prints out the shoe with all the decks.
     */
    public String toString()
    {
        return shoe + "";
    }
}
