import java.util.ArrayList;
import java.util.Random;
/**
 * Deck.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Creates a Deck of cards to be used in the game of 
 * BlackJack
 *
 */
public class Deck
{
    private ArrayList<Card> Deck;
    private int value;
    private String suit;
    private String rank;
    private int count = 0;
    private String reveal = new String("");
    
    /**
     * Creates the standard 52 card deck used in a game of BlackJack
     */
    public Deck()
    {
        Deck = new ArrayList<Card>();
        for(int i = 1; i <14; i++)
        {
            if (i == 1) 
            {
                rank = "Ace"; 
                value = 1;
            }
            else if (i == 2) 
            {
                rank = "Two"; 
                value = 2;
            }
            else if (i == 3) 
            {
                rank = "Three";
                value = 3;
            }
            else if (i == 4) 
            {
                rank = "Four"; 
                value = 4;
            }
            else if (i == 5) 
            {
                rank = "Five";
                value = 5;
            }
            else if (i == 6) 
            {
                rank = "Six";
                value = 6;
            }
            else if (i == 7) 
            {
                rank = "Seven";
                value = 7;
            }
            else if (i == 8)
            {
                rank = "Eight";
                value = 8;
            }
            else if (i == 9) 
            {
                rank = "Nine";
                value = 9;
            }
            else if (i == 10) 
            {
                rank = "Ten";
                value = 10;
            }
            else if (i == 11) 
            {
                rank = "Jack";
                value = 10;
            }
            else if (i == 12) 
            {
                rank = "Queen";
                value = 10;
            }
            else if (i == 13) 
            {
                rank = "King"; 
                value = 10;
            }
            for(int j = 0; j < 4; j++)
            {
                if(j==0)
                {
                    suit = "Hearts";
                }
                else if(j==1)
                {
                    suit = "Spades";
                }
                else if (j==2)
                {
                    suit = "Clubs";
                }
                else
                {
                    suit = "Diamonds";
                }
                Card card = new Card(suit,rank,value);
                Deck.add(card);
                count++;
            }
        }
    }

    /**
     * returns the entire deck of cards that was created
     * in the Deck() constructor
     */
    public ArrayList<Card> getDeck()
    {
        return Deck;
    }

    /**
     * Returns the top card of the deck, or the "first/next"
     * card in the deck.
     */
    public Card getTopCard()
    {
        Card topCard;
        topCard = Deck.get(0);
        Deck.remove(0);
        return topCard;
    }

    /**
     * PRECONDITION: 1 < n < 52 (must fit in the paramater of deck cards).
     * PRECONDITION: remove 1 to n to get that card.
     * 
     * Returns any card at a given number in the deck, 
     * say the 17th card, it will return that card.
     * 
     * @param   n   the card in a deck of 52
     */
    public Card getCard(int n)
    {
        Card card;
        card = Deck.get(n-1);
        Deck.remove(n-1);
        return card;
    }

    /**
     * shuffles the deck so that every single card in the deck
     * is "touched" and therefore moved to a random position in the deck.
     */
    public void shuffle()
    {
        Random random = new Random();
        int x;
        Card temporary;
        for(int i = Deck.size() - 1; i >=0; i--)
        {
            temporary = Deck.get(i);
            x = random.nextInt(52);
            Deck.set(i, Deck.get(x));
            Deck.set(x, temporary);
        }
    }

    /**
     * Prints out the cards in the deck.
     */
    public String toString()
    {
        return getDeck() + "";
    }
}
