import java.util.Scanner;
/**
 * PlayerRunner.java 
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Runs and tests the methods in the Player class.
 *
 */

public class PlayerRunner 
{
   public static void main(String[] args)
   {
       int action;
       Scanner scan = new Scanner(System.in);
       Player player = new Player("Jesse", 200);
       System.out.println(player);
       player.Bet();
       System.out.println("Your bet amount: " + player.getBet());
       System.out.println("Your current Bankroll: " + player.getBankroll());
       
       System.out.println(player.getName() + " wants insurance: " +player.wantInsurance());
       System.out.println("Current bankroll after Insurance choice: " + player.getBankroll());
       
       System.out.println(player.getName() + " wants insurance: " +player.wantInsurance());
       System.out.println("Current bankroll after Insurance choice : " + player.getBankroll());
       
       System.out.println(player.nextAction());
       
       player.win();
       player.lose();
       player.push();
       player.winBlackJack();
   }
}
