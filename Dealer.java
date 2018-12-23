import java.util.ArrayList;
import java.util.Scanner;
/**
 * Dealer.java  
 *
 * @author: Jake Imyak
 * BlackJack Project
 * 
 * Brief Program Description:
 * A representaion of the dealer in BlackJack
 *
 */
public class Dealer
{
    private Scanner scan;
    private Shoe dealerShoe;
    private Player player;
    private Hand dealerHand;
    private Hand playerHand;
    private Card upCard;
    private boolean insureResult = false;
    
    public Dealer(Player p1)
    {
        player = p1;
        dealerShoe = new Shoe(4);
        dealerHand = new Hand();
        playerHand = new Hand();
        scan = new Scanner(System.in);
    }
    
    public void setUp()
    {
        dealerShoe.shuffle();
        playerHand.addCard(dealerShoe.getTopCard());
        dealerHand.addCard(dealerShoe.getTopCard());
        playerHand.addCard(dealerShoe.getTopCard());
        dealerHand.addCard(dealerShoe.getTopCard());
        player.setUpHand(playerHand, dealerHand.getCards().get(0));
        if(dealerHand.getCards().get(0).isAce())
        {
            controlInsurance();
        }
    }    
    
    public Hand getPlayerHand()
    {
        return playerHand;
    }
    
    public Hand getDealerHand()
    {
        return dealerHand;
    }
    
    public Card getupCard()
    {
        upCard = dealerHand.getCards().get(0);
        return upCard;
    }
    
    public boolean controlInsurance()
    {
        if(player.wantInsurance() == true)
        {
            insureResult = true;
        }
        return insureResult;
    }
    
    public void controlPlayerHand()
    {
        if(playerHand.blackJack() == false && dealerHand.blackJack() == false)
        {
            player.nextAction();
            while(playerHand.busted() == false && player.getAction()!= 0 && player.getAction()!=2 && playerHand.getSize()!= 5)
            {
                 if(player.getAction() == 1)
                 {
                     playerHand.addCard(dealerShoe.getTopCard());
                     playerHand.busted();
                     if(playerHand.busted())
                     {
                         System.out.println("You Busted: " + getPlayerHand());
                         gameResult();
                     }
                     else if(playerHand.getSize() == 5 && playerHand.busted() == false)
                     {
                         System.out.println("Your Hand: " + getPlayerHand());
                         System.out.println("5 - Card Charlie Baby!!");
                         gameResult();
                     }
                     else
                     {
                         if(playerHand.getSize() != 5)
                         {
                             System.out.println("Your Hand: " + getPlayerHand());
                             player.nextAction();
                         }
                     }
                 }
            }
            if(player.getAction() == 2)
            {
                playerHand.addCard(dealerShoe.getTopCard());
                System.out.println("Your Hand: " + getPlayerHand());
                if(playerHand.busted() == true)
                {
                    gameResult();
                }
            }
            if(playerHand.busted() == false && playerHand.getSize()!= 5)
            {
                controlDealerHand();
            }
        }
        else if(playerHand.blackJack() == true && dealerHand.blackJack() == false)
        {
            gameResult();
        }
        else
        {
            controlDealerHand();
        }
    }
    
    public void controlDealerHand()
    {
        System.out.println("Dealer's Hand: " + getDealerHand());
        if(dealerHand.blackJack() == false)
        {
            while(dealerHand.getValue() < 17)
            {
                dealerHand.addCard(dealerShoe.getTopCard());
                dealerHand.busted();
                System.out.println("Dealer's Hand: " + getDealerHand());
            }
        }
        gameResult();
    }
    
    public void gameResult()
    {
        if(player.getAction() == 2)
        {
            player.changeDoubleDown();
        }
        if(playerHand.getValue() > dealerHand.getValue() && playerHand.busted() == false
            &&playerHand.blackJack() == false)
        {
            System.out.println("You Win!");
            player.win();
        }
        else if(playerHand.getValue() < dealerHand.getValue() && dealerHand.busted() == false)
        {
            System.out.println("Dealer Wins :(");
            player.lose();
        }
        else if(dealerHand.blackJack() == true && playerHand.blackJack() == false)
        {
            System.out.println("Dealer Has a blackJack: " + getDealerHand());
            player.lose();
        }
        else if(playerHand.getValue() == dealerHand.getValue() && playerHand.busted() == false
                && dealerHand.busted() == false)
        {
            System.out.println("You Push.");
            player.push();
        }
        else if(playerHand.blackJack() == true && dealerHand.blackJack() == false)
        {
            System.out.println("BlackJack!!!");
            player.winBlackJack();
        }
        else if(playerHand.blackJack() == true && dealerHand.blackJack() == true)
        {
            System.out.println("You Push.");
            player.push();
        }
        else if(playerHand.busted() == false && dealerHand.busted() == true)
        {
            System.out.println("Dealer Busts! You win!");
            player.win();                           
        }
        else if(playerHand.busted() == true && dealerHand.busted() == false)
        {
            System.out.println("You busted!");
            player.lose();
        }
        else if(playerHand.busted() == true && dealerHand.busted() == true)
        {
            System.out.println("You busted!");
            player.lose();
        }
        if(playerHand.busted() == false && dealerHand.blackJack() == true && insureResult == true)
        {
            System.out.println("You Won your insurance bet!");
        }
    }
    
    public void clean()
    {
        playerHand.clear();
        dealerHand.clear();
    }
    
    public void play()
    {
        clean();
        System.out.println("Press 1 to play, or any other number to exit ");
        int act = scan.nextInt();
        if(act == 1)
        {
            player.Bet();            
            setUp();
            System.out.println(player.getName() + "'s hand: " + getPlayerHand());
            System.out.println("Dealer's hand: " + getupCard());
            controlPlayerHand();
            play();
        }
        else
        {
            System.out.println("You chose to leave. Thanks for playing at J Dog's Casino.");
            System.exit(0);
        }
    }
    
}
