import java.util.ArrayList;
/**
 * Hand.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Hand of the player that will determine the value of his/her hand.
 *
 */
public class Hand
{
    private ArrayList<Card> Hand;
    int x = 2;
    /**
     * Constructs a hand of an Array lists of cards.
     */
    public Hand()
    {
        Hand = new ArrayList<Card>();
    }
    
    /**
     * Adds a card to the Hand from a shoe. 
     * 
     * @pararm  c   Card from a shoe 
     */
    public void addCard(Card c)
    {
        if(c.isAce() && getValue() + 11 > 21)
        {
            c.changeAce(true);
            Hand.add(c);
        }
        else if (c.isAce() && getValue() + 11 <= 21)
        {
            c.changeAce(false);
            Hand.add(c);
        }
        else
        {
            Hand.add(c);
        }
    }
    
    /**
     * checks to see if the starting hand of 2 cards is a blackJack.
     * 
     * @return  true     if the hand is a blackJack
     * @retrun  false   if the hand is no a blackJack
     */
    public boolean blackJack()
    {
        if(getValue() == 21 && getSize() == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * checks to see if the hand has busted, if there is an Ace in the hand it will
     * change the value of the ace to 1. Returns true if the value is greater than 21
     * returns false if value is less than 21.
     * 
     */
    public boolean busted()
    {
        if(getValue() > 21)
        {
            for(int i = 0; i < Hand.size(); i++)
            {
                if(Hand.get(i).isAce() && Hand.get(i).getValue() == 11)
                {
                    Hand.get(i).changeAce(true);
                    busted();
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Clears the hand in order to start a new game
     */
    public void clear()
    {
        for(int i = Hand.size() - 1; i >= 0; i--)
        {
            Hand.remove(i);
        }
    }
    
    /**
     * Accessor of the Hand
     * 
     * @return  Hand    the hand that is in play
     */
    public ArrayList<Card> getCards()
    {
        return Hand;
    }
    
    /**
     * Accessor of the size of the Card (how many cards are actaully in the hand)
     * 
     * @return  count   the size of the hand
     */
    public int getSize()
    {
        int count = 0;
        count += Hand.size();
        return count;
    }
    
    /**
     * returns the value of the Hand based on the Cards in the hand
     * 
     * @return  count   actual value of the total of the hand
     */
    public int getValue()
    {
        int count = 0;
        for(int i = 0; i < Hand.size(); i++)
        {
            count += Hand.get(i).getValue();
        }
        return count;
    }
    
    /**
     * Prints out the Hand
     */
    public String toString()
    {
        return getCards() + "";
    }
    
    
}
