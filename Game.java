import java.util.Scanner;
/**
 * Game.java 
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Essentially the start up of the game. Gets the ball rolling to let the game play.
 *
 */

public class Game 
{
   public static void main(String[] args)
   {
       Scanner scan = new Scanner(System.in);
       System.out.println("Welcome to Jake's Casino" + "\nWho are you? ");
       String name = scan.nextLine();
       System.out.println("How much money are you gambling today? ");
       int moneyInDaBank = scan.nextInt();
       Player player = new Player(name, moneyInDaBank);
       Dealer dealer = new Dealer(player);
       dealer.play();
   }
}
