//TicketManager.java for Assignment 7
import java.text.DecimalFormat;

public class TicketManager
{
   final int NUM_ROWS = 15, ROW_SIZE = 10; //declaring constants
   final double SEAT_PRICE = 15.0;
   DecimalFormat fmt = new DecimalFormat("$#0.00");
   
   private int seatsSold;  //declaring variables
   private double totalRevenue = 0.0;
   private String[][] seatArray = new String[NUM_ROWS][ROW_SIZE]; //declaring seatArray
   
   public TicketManager()
   {  //constructor fills in array with empty seats to start
      for (int i = 0; i < NUM_ROWS; i++)
			for (int j = 0; j < ROW_SIZE; j++)
				seatArray[i][j] = "O ";
   }  //end of TicketManager() constructor
   
   public void displaySeats()
   {
		//display chart of seats
		System.out.println("\n              Seats ");
		System.out.println("       1  2  3  4  5  6  7  8  9  10");
		for (int i = 0; i < (NUM_ROWS); i++)
      {
			if(i<=8)
				System.out.print("Row  " + (i+1) + " ");
			else
				System.out.print("Row " + (i+1) + " ");
			for (int j = 0; j < ROW_SIZE; j++)
				System.out.print(seatArray[i][j]+" ");
			System.out.println();
		}
		System.out.println("\nLegend:     #  =  Sold");
		System.out.println("            O  =  Available");
	}  //end of displaySeats()
   
   public boolean checkAvailability(int seats, int row, int initial)
   {  //checks if there are too many wanted seats
		int lastWantedSeat = seats + (initial - 1);
		if (lastWantedSeat > ROW_SIZE)
      {
			System.out.print("\nOne or more of the seats you have requested do not exist, re-book please.");
			return false;
		}
		//if array value is filled, return false
		for (int i = initial; i < lastWantedSeat; i++)
      {
			if (seatArray[row - 1][i] == "# ")
         {
				System.out.print("\nOne or more of the seats you have requested are already sold.");
				return false;
			}
		}
		System.out.print("\nThe seats you have requested are available for purchase.");
		System.out.print("\nThe total purchase price will be: " + seats + " seats X $15.0 = " + fmt.format(seats * 15));
		return true;
   }  //end of checkAvailability()
   
   public void purchaseTickets(int seats, int row, int initial)
   {
		//check seat availability
		if(checkAvailability(seats, row, initial) == false)
      {
			System.out.print("\nWrong, you can book up to 10 seats only");
			System.out.print("\nRe-enter number of seats desired (1-10):");
		}
		
      //display ticket purchase information
      System.out.print("\nPlease input amount paid: ");
		double amount = Assignment7.myScan.nextDouble();
		if (amount >= (seats * 15))
      {
			printTickets(row, initial, (initial + seats));
			System.out.print("\nTickets purchased : " + seats);
			System.out.print("\nPayment\t\t   : "+ fmt.format(amount));
			System.out.print("\nTotal ticket price: "+ fmt.format((seats*15)));
			System.out.print("\nChange due        : "+ fmt.format((amount - (seats * 15)))+"\n\n");
			
         seatsSold += seats;
			totalRevenue = totalRevenue + (amount - (amount - (seats * 15)));
			
			for (int i = 0; i < seats; i++)
				seatArray[row - 1][initial + (i - 1)] = "# ";	
		} 
      else
      {
			System.out.print("\nInsufficient payment. ");
			System.out.print("\nThe sale has been cancelled and your money is being returned.\n");
		}
   }  //end of purchaseTickets()
   
   public void printTickets(int row, int first, int lastseat)
   {
		System.out.print("\n********************************");
		System.out.print("\n\tPhoenix Children Theater\t");
		System.out.println();
		for (int i = 0; i < (lastseat - first); i++)
			System.out.print("\n\tRow " + row + " ~ " + "Seat " + (first + i));
		System.out.print("\n********************************\n");
   }  //end of printTickets()
   
   public void displaySalesReport()
   {
		System.out.print("\nPhoenix Children Theater Sales Report\n" + "===================================");
		System.out.print("\nSeats sold:\t\t    " + seatsSold);
		System.out.print("\nSeats available:       " + (150 - seatsSold));
		System.out.print("\nTotal revenue to date: " + fmt.format(totalRevenue));
   }  //end of displaySalesReport()
}  //end of TicketManager class