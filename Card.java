
/**
 * Card.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * A class that provides all methods/characteristics of a card. 
 *
 */
public class Card
{
    private final String suit;
    private final String rank;
    private int value;  //not final b/c ace could be a one or eleven.
    
    /**
     * Default Constructor - create a card with goofy values so that they stand out
     */
    public Card()
    {
        value = -1;
        suit = "horses?";
        rank = "joker";
    }
    /**
     * Constructs the card giving it an apporiate
     * suit, rank, and value.
     * 
     * @param   s   String representing the suit of a given card
     * @param   r   String representing the rank of a given card
     * @param   v   int representing the value of a Card object
     */
    public Card(String s, String r, int v)
    {
        suit = s;
        rank = r;
        value = v;
    }
    
    /**
     * returns the suit of the card
     * 
     * @return  suit    suit of the card
     */
    public String getSuit()
    {
        return suit;
    }
    
    /**
     * returns the rank of the card
     * 
     * @return  rank    rank of the card
     */
    public String getRank()
    {
        return rank;
    }
    
    /**
     * returns the actual value of the card
     * 
     * @return  value   value of the card
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Tests if the card is an ace.
     * 
     * PRECONDITION: the rank of a Card is in the form of "Ace", "Two", etc.
     */
    public boolean isAce()
    {
        return getRank().equalsIgnoreCase("Ace");
    }
    
    /**
     *  This changes the value of the ace to either one or eleven.
     *  
     *  @param  toOne   tells us whether to set the ace to one or eleven.
     */
    public void changeAce(boolean toOne)
    {
        if (isAce())
        {
            if (toOne == true)
            {
                value = 1;
            }
            else
            {
                value = 11;
            }
        }
    }
    
    /**
     * Prints out the characteristics of a card.
     */
    public String toString()
    {
        return  getRank() + " of " + getSuit()  + "(" + 
                getValue() + ")";
    }
}

