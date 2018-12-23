
/**
 * HandRunner.java 
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * A tester method for the Hand Class, which tests all methods in the class accordingly.
 *
 */

public class HandRunner 
{
   public static void main(String[] args)
   {
       Shoe shoe = new Shoe(4);
       Hand hand = new Hand();
       System.out.println("New Hand");
       hand.addCard(shoe.getTopCard());
       hand.addCard(shoe.getTopCard());
       hand.addCard(shoe.getTopCard());
       System.out.println(hand);
       shoe.shuffle();
       hand.addCard(shoe.getTopCard());
       System.out.println(hand);
       System.out.println("Busted?: " + hand.busted());
       System.out.println(hand);
       System.out.println("Busted?: " + hand.busted());
       hand.clear();
       System.out.println(hand);
       System.out.println("\nNew Hand");
       hand.addCard(shoe.getTopCard());
       hand.addCard(shoe.getCard(51));
       System.out.println(hand);
       System.out.println("BlackJack? : " + hand.blackJack());
       System.out.println("Busted? : " + hand.busted());
       System.out.println("Value of hand: " + hand.getValue());
       System.out.println("\nNew Hand");
       hand.clear();
       Shoe shoe1 = new Shoe(1);
       hand.addCard(shoe1.getCard(13));
       hand.addCard(shoe1.getCard(44));
       hand.addCard(shoe1.getCard(46));
       System.out.println(hand);
       System.out.println("Value of hand: " + hand.getValue());
       System.out.println("Busted? : " + hand.busted());
       System.out.println(hand);
       System.out.println("\nNew Hand");
       hand.clear();
       Shoe shoe2 = new Shoe(3);
       shoe2.shuffle();
       hand.addCard(shoe2.getTopCard());
       hand.addCard(shoe2.getTopCard());
       System.out.println(hand);
       System.out.println("BlackJack? : " + hand.blackJack());
       hand.addCard(shoe2.getTopCard());
       System.out.println(hand);
       System.out.println("Busted? : " + hand.busted());
       hand.busted();
       System.out.println(hand);
       System.out.println(hand.getValue());
   }
}
/**
 * OUTPUT 1
 * 
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1)]
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Nine of Diamonds(9)]
 * busted?: true
 * [Ace of Hearts(1), Ace of Spades(1), Ace of Clubs(1), Nine of Diamonds(9)]
 * busted?: false
 * []
 * New Hand
 * [King of Diamonds(10), Ace of Spades(11)]
 * BlackJack? : true
 * Busted? : false
 * Value of hand: 21
 * 
 * OUTPUT 2
 * 
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1)]
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Four of Clubs(4)]
 * busted?: false
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Four of Clubs(4)]
 * []
 * New Hand
 * [King of Hearts(10), Nine of Spades(9)]
 * BlackJack? : false
 * Busted? : false
 * Value of hand: 19
 * 
 * OUTPUT 3
 * 
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1)]
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), King of Hearts(10)]
 * busted?: true
 * [Ace of Hearts(1), Ace of Spades(1), Ace of Clubs(1), King of Hearts(10)]
 * []
 * New Hand
 * [Two of Clubs(2), Four of Clubs(4)]
 * BlackJack? : false
 * Busted? : false
 * Value of hand: 6
 * 
 * OUTPUT 4
 * 
 * New Hand
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1)]
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Queen of Spades(10)]
 * Busted?: true
 * [Ace of Hearts(1), Ace of Spades(1), Ace of Clubs(1), Queen of Spades(10)]
 * []
 * 
 * New Hand
 * [Four of Diamonds(4), Ace of Spades(11)]
 * BlackJack? : false
 * Busted? : false
 * Value of hand: 15
 * 
 * New Hand
 * [Four of Hearts(4), Queen of Hearts(10), Queen of Diamonds(10)]
 * Value of hand: 24
 * Busted? : true
 * [Four of Hearts(4), Queen of Hearts(10), Queen of Diamonds(10)]
 * 
 * OUTPUT 5
 * 
 * New Hand
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1)]
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Seven of Hearts(7)]
 * Busted?: false
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Seven of Hearts(7)]
 * []
 * 
 * New Hand
 * [Jack of Hearts(10), Two of Clubs(2)]
 * BlackJack? : false
 * Busted? : false
 * Value of hand: 12
 * 
 * New Hand
 * [Four of Hearts(4), Queen of Hearts(10), Queen of Diamonds(10)]
 * Value of hand: 24
 * Busted? : true
 * [Four of Hearts(4), Queen of Hearts(10), Queen of Diamonds(10)]
 * 
 * NewHand
 * [Jack of Diamonds(10), King of Diamonds(10)]
 * BlackJack? : false
 * [Jack of Diamonds(10), King of Diamonds(10), Seven of Diamonds(7)]
 * Busted? : true
 * [Jack of Diamonds(10), King of Diamonds(10), Seven of Diamonds(7)]
 * 27
 * 
 * OUTPUT 6
 * 
 * New Hand
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1)]
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Five of Hearts(5)]
 * Busted?: false
 * [Ace of Hearts(11), Ace of Spades(1), Ace of Clubs(1), Five of Hearts(5)]
 * []
 * 
 * New Hand
 * [Seven of Diamonds(7), Seven of Spades(7)]
 * BlackJack? : false
 * Busted? : false
 * Value of hand: 14
 * 
 * New Hand
 * [Four of Hearts(4), Queen of Hearts(10), Queen of Diamonds(10)]
 * Value of hand: 24
 * Busted? : true
 * [Four of Hearts(4), Queen of Hearts(10), Queen of Diamonds(10)]
 * 
 * New Hand
 * [Nine of Hearts(9), Ace of Diamonds(11)]
 * BlackJack? : false
 * [Nine of Hearts(9), Ace of Diamonds(11), Eight of Spades(8)]
 * Busted? : true
 * [Nine of Hearts(9), Ace of Diamonds(1), Eight of Spades(8)]
 * 18
 * 
 */