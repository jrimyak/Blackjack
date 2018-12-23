import java.util.Scanner;
/**
 * Player.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * Representation of a Player in BlackJack
 *
 */
public class Player
{
    private Scanner scan;
    private Hand playerHand;
    private String name;
    private int bankroll;
    private int bet;
    private int action;
    private int insurance;
    private Card upCard;
    public Player(String n, int bank)
    {
        name = n;
        bankroll = bank;
        scan = new Scanner(System.in);
    }
    
    public void Bet()
    {
        int choice;
        if(bankroll <= 0)
        {
            System.out.println("You have no money left to bet, press 1 to continue playing," 
                                + "or any other number to exit.");
            choice = scan.nextInt();
            if(choice == 1)
            {
                bankrupt();
            }
            else
            {
                System.out.println("You chose to leave. Thanks for playing at J Dog's Casino.");
                System.exit(0);
            }
        }
        int betAmount;
        System.out.println("How much would you like to bet? ");
        betAmount = scan.nextInt();
        if(betAmount > bankroll)
        {
            System.out.println("You don't have enough money for that bet, press 1 to change your bet" 
                                + " or press any other number to add money to the bank.");
            choice = scan.nextInt();
            if(choice == 1)
            {
                Bet();
            }
            else
            {
                changeBankRoll();
            }
        }
        else
        {
            bankroll -= betAmount;
            bet = betAmount;
        }
        
    }
    
    public void changeBankRoll()
    {
        System.out.println("How much money would you like to add to the bank?");
        bankroll += scan.nextInt();
        System.out.println("Your new balance is: " + bankroll);
        Bet();
    }
    
    public void bankrupt()
    {
        System.out.println("How much money would you like to add to the bank?");
        bankroll = scan.nextInt();
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getBet()
    {
        return bet;
    }
    
    public int getBankroll()
    {
        return bankroll;
    }    
    
    public void changeDoubleDown()
    {
        bankroll -= getBet();
        bet = bet*2;
    }
    
    public void setUpHand(Hand myHand, Card dealerUpCard)
    {
        playerHand = myHand;
        upCard = dealerUpCard;
    }
    
    public Hand getPlayerHand()
    {
        return playerHand;
    }
    
    public Card getUpCard()
    {
        return upCard;
    }
    
    public boolean wantInsurance()
    {
        if(getUpCard().isAce())
        {
            System.out.println("The dealer shows an Ace, would you like to place an Insurance Bet?"
                                + "\nYes: 1 \t No: 0");
            insurance = scan.nextInt();
            if(insurance == 1)
            {
                bankroll -= bet/2;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    public int nextAction()
    {
        if(playerHand.getSize() == 2)
        {
            System.out.println("What would you like to do?" + "\nStand : 0 \t Hit: 1 "
                                + "\t DoubleDown: 2");
        }
        else
        {
            System.out.println("What would you like to do?" + "\nStand : 0 \t Hit: 1");
        }
        action = scan.nextInt();
        if(playerHand.getSize() > 2 && action == 2)
        {
            System.out.println("Don't you know the rules? " +
                               "You can't double down after hitting. " +
                               "Please either Hit or Stand.");
            nextAction();
        }
        if(action < 0 || action > 2)
        {
            System.out.println("You entered an invalid input, please restart");
            nextAction();
        }
        return action;
    }
    
    public int getAction()
    {
        return action;
    }
    
    public void win()
    {
        bankroll += bet*2;
        System.out.println("Your bet amount was: " + getBet());
        System.out.println("New balance: " + bankroll);
    }

    public void lose()
    {
        System.out.println("You lost your bet of " + getBet());
        System.out.println("New balance: " + bankroll);
    }
    
    public void push()
    {
        bankroll += bet;
        System.out.println("You win your bet back with a value of " + getBet());
        System.out.println("New balance: " + bankroll);
    }
    
    public void winBlackJack()
    {
        bankroll += bet*3 + bet/2;
        System.out.println("You have a blackJack and win 3:2 of your bet!");
        System.out.println("New balance: " + bankroll);
    }
        
    public String toString()
    {
        return "New player name: " + name + "\nMoney in the bank: " + bankroll;
    }
}

