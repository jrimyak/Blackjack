
/**
 * ShoeRunner.java 
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Tests all methods of the Shoe class to show that 
 * they all function correctly.
 *
 */

public class ShoeRunner 
{
   public static void main(String[] args)
   {
       Shoe shoe = new Shoe(4);
       System.out.println("Unshuffled Shoe: " + shoe);
       System.out.println();
       shoe.shuffle();
       System.out.println("After Shuffle: " + shoe);
       System.out.println();
       shoe.getCard(15);
       System.out.println("Getting the 15th Card: " + shoe);
       System.out.println();
       shoe.getTopCard();
       System.out.println("Getting the Top Card: " + shoe);
       System.out.println();
   }
}
