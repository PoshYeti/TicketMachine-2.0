public class TicketMachineUppgraded
{
    private int priceShort;
    private int priceLong;
    private int balance;
    private int total;
    private int ticketAmount;
    
    private boolean shortTrip;
    private boolean longTrip;

    public TicketMachineUppgraded(int ticketShort, int ticketLong)
    {
        priceShort = ticketShort;
        priceLong = ticketLong;
        shortTrip = false;
        longTrip = false;
        ticketAmount = 1;
        balance = 0;
        total = 0;
    }

    public void numberOfTickets(int numberOfTickets)
    {
        if (numberOfTickets > 0)
        {
            System.out.println("You will no order: " + numberOfTickets + " tickets");
            System.out.println();
            ticketAmount = numberOfTickets;
        }
        else
        {
            System.out.println("That is not a valid amount of tickets");
            System.out.println();
        }
    }
    
    public void updatePriceShort(int newPriceShort)
    {
        if (newPriceShort <= 0)
        {
            System.out.println("That is not a valid price for a ticket");
            System.out.println();
        }
        else
        {
            priceShort = newPriceShort;
            System.out.println("The new price for a short journey is: " + priceShort);
            System.out.println();
        }
    }
    
    public int getPriceShort()
    {
        System.out.println("The price for a short journey is: " + priceShort);
        System.out.println();
        return priceShort;
    }
    
    public void updatePriceLong(int newPriceLong)
    {
        if (newPriceLong <= 0)
        {
            System.out.println("That is not a valid price for a ticket");
            System.out.println();
        }
        else
        {
            priceLong = newPriceLong;
            System.out.println("The new price for a short journey is: " + priceLong);
        }
    }
    
    public int getPriceLong()
    {
        System.out.println("The price for a long journey is: " + priceLong);
        return priceLong;
    }

    public void insertMoney(int amount)
    {
        if (amount <= 0)
        {
            System.out.println("The amount inserted is not correct");
            System.out.println("Insert a positive amount, you idiot");
            System.out.println();
        }
        else
        {
            balance = balance + amount;
        }
    }
    
    public int returnMoney()
    {
        printFrame();
        
        System.out.println("Amount of money returned to your account: " + balance);
        System.out.println();
        
        balance -= balance;
        
        System.out.println("The amount remaining is now: " + balance);
        System.out.println("You really don't want to tip me?");
        
        printFrame();
        
        return balance;
    }
    
    public void shortTrainTrip()
    {
        System.out.println("We're going on a short trip? How fun!");
        System.out.println();
        longTrip = false;
        shortTrip= true;
    }
    
    public void longTrainTrip()
    {  
        System.out.println("We're going on a long trip? Better pack my bags!");
        System.out.println();
        shortTrip = false;
        longTrip = true;
    }

    public void buyTicket()
    {
        if (shortTrip == true && longTrip == false)
        {
            if(balance >= priceShort * ticketAmount)
            {
                printTicket(priceShort);
            }
            else
            {
                printTicketFailed(priceShort);
            }
        }
        else if (longTrip == true && shortTrip == false)
        {
            if (balance >= priceLong * ticketAmount)
            {
                printTicket(priceLong);
            }
            else
            {
                printTicketFailed(priceLong);
            }
        }
        else
        {
            printFrame();
            System.out.println("You have not specified if you want the short, or long train trip");
            printFrame();
        }
    }
    
    public void balanceNow()
    {
        printFrame();
        System.out.println("Balance now: " + balance);
        printFrame();
    }
    
    private void printTicket(int priceType)
    {
        printFrame();
        System.out.println("# Zachorian Express");
        System.out.println("# Ticket");
        System.out.println("# Pris per person: " + priceType + " dollars.");
        System.out.println("# Number of tickets: " + ticketAmount);
        System.out.println("# Total price for all tickets: " + priceType * ticketAmount + " dollars.");
        printFrame();

        total = total + balance;
        balance -= priceType * ticketAmount;
        balanceNow();
    }
    
    private void printTicketFailed(int priceType)
    {
        printFrame();
        System.out.println("You have not deposited enough money");
        System.out.println("Amount deposited: " + balance);
        System.out.println("Amount needed: " + priceType * ticketAmount);
        System.out.println("Deposit more money to ride the short Zachorian Express");
        printFrame();
    }
    
    private void printFrame()
    {
        System.out.println();
        System.out.println("################################################################");
        System.out.println();
    }
}
