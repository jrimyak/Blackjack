
/**
 * CardRunner.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Runs to make sure the Card class is functional.
 *
 */
public class CardRunner
{
    public static void main(String[] args)
    {
        Card silly = new Card();
        Card Ace = new Card("Spades","Ace", 11);
        Card Eight = new Card("Diamonds","Eight", 8);
        Card King = new Card("Hearts","King", 10);

        System.out.println(King);
        System.out.println(Eight);
        System.out.println(Ace);
        Ace.changeAce(true);
        System.out.println(Ace);
        System.out.println(Ace.isAce());
        System.out.println(King.isAce());
        System.out.println(Eight.getSuit());
        System.out.println(King.getRank());
        System.out.println(Ace.getValue());
    }
}
/**
 * OUTPUT
 * The card is a King of Hearts (value =  10)
The card is a Eight of Diamonds (value =  8)
The card is a Ace of Spades (value =  11)
The card is a Ace of Spades (value =  1)
true
false
Diamonds
King
1

 */