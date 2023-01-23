//does stuff with movie tickets

import java.util.*;
import java.text.DecimalFormat;

class Assignment5
{	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
   {
      DecimalFormat fmt1 = new DecimalFormat("$0.00");   //currency and percentage formatting masks
      DecimalFormat fmt2 = new DecimalFormat("0.00%");
      char choice;
      MovieTicket oneMovieTicket = getMovieTicketInfo(); //get info. for oneMovieTicket object

      displayMenu(); //call displayMenu() method to show the menu to user

      do {
         //System.out.print("\nPlease enter a command: ");
         choice = (scan.next().toUpperCase()).charAt(0); //scan user input

         if (choice != 'Q' )
         {
            switch (choice)   //switch user input
            {
               case 'T':
			         {	//change oneMovieTicket's title
                     String oldTitle = oneMovieTicket.getTitle();
                     scan.nextLine();
                     String newTitle = scan.nextLine();
                     oneMovieTicket.setTitle(newTitle);
			             //System.out.print("\nEnter the new title: ");

			            System.out.println("\nThe ticket title has been changed"
			       				      + " from " + oldTitle + " to "
			       				      + newTitle +"\n");
			         }
			      break;

               case 'R':
                  { //change oneMovieTicket's row number
                     String oldRow = oneMovieTicket.getRow();
                     //System.out.print("\nEnter the new row: ");
					      scan.nextLine();
                     String newRow = scan.nextLine();
			            oneMovieTicket.setRow(newRow);

                     System.out.print("\nThe ticket row has been changed"
                            				+ " from " + oldRow + " to "
                            				+ newRow + "\n");
                  }
                  break;

               case 'N':
                  { //change oneMovieTicket's seat number
                     int oldSeatNum = oneMovieTicket.getSeatNum();
                     //System.out.print("\nEnter the new seat number: ");
                     int newSeatNum = scan.nextInt();
                     oneMovieTicket.setSeatNum(newSeatNum);

                     System.out.print("\nThe ticket seat number has been changed"
                            				+ " from " + oldSeatNum + " to "
                            				+ newSeatNum + "\n");
                  }
                  break;

               case 'I':
                  { //Adjust or increase the ticket price
                     double oldPrice = oneMovieTicket.getPrice();
                     //System.out.print("\nEnter the new adjusted price: ");
                     double newPrice = scan.nextDouble();
                     oneMovieTicket.adjustPrice(newPrice);
                     
                     System.out.print("\nPrice was adjusted from " + fmt1.format(oldPrice)
                            				+ " to new price of " + fmt1.format(newPrice) + "\n");
                  }
                  break;

               case 'D':
                  {  //discount the ticket price
                     //System.out.print("\nEnter the discount (e.g. 0.05 for 5%): ");
                     double discountRate = scan.nextDouble();
                     oneMovieTicket.discount(discountRate); 
                     System.out.print("\nPrice was reduced by " + fmt2.format(discountRate)
                            				+ ", the new price is " + fmt1.format(oneMovieTicket.getPrice()) + "\n");
                  }
                  break;

               case 'S':  //call toString() to show the MovieTicket's info.
                  System.out.print(oneMovieTicket.toString());
                  break;
               
               case '?':  //display menu again
                  displayMenu();
                  break;
               
               default:
                  System.out.print("\nUnknown command\n");
                  break;
            } //end switch
         } //end if
      } while(choice != 'Q');
   } //end of main()

//***************************************************************
// getMovieTicketInfo() has user enter a ticket's info. from keyboard,
// then create and return a MovieTicket object accordingly
   public static MovieTicket getMovieTicketInfo()
   {
      //Local variables used to store a MovieTicket's title, row
      //& seat number, price info.
      String title, row;
      int seatNum;
      double price;
      System.out.print("\nWelcome to Harkins Theatre");
      System.out.print("\n==========================");

      //System.out.print("\nEnter movie title: ");
      //get user's input and store it inside variable title
      title = scan.nextLine();

   	//System.out.print("\nEnter ticket row: ");
      //get user's input and store it inside variable row
      row = scan.nextLine();

      //System.out.print("\nEnter ticket number: ");
      //get user's input and store it inside variable seatNum
      seatNum = scan.nextInt();

      //System.out.print("\nEnter ticket price: ");
      //get user's input and store it inside variable price
      price = scan.nextDouble();

	  //create a MovieTicket object by using above information
      MovieTicket aMovieTicket = new MovieTicket(title, row, seatNum, price);

      return aMovieTicket;
   } //end of getMovieTicketInfo()

//****************************************************
// DisplayMenu() on screen
   public static void displayMenu()
   {
      System.out.print("\nChoose an Action\n");
      System.out.print("-------------------\n");
      System.out.print("T\t Change Movie Ticket Title\n");
      System.out.print("R\t Change Movie Ticket Row\n");
      System.out.print("N\t Change Movie Ticket Number\n");
      System.out.print("I\t Adjust Movie Ticket Price\n");
      System.out.print("D\t Discount the Price\n");
      System.out.print("S\t Show Movie Ticket Info.\n");
      System.out.print("?\t Display the Menu\n");
      System.out.print("Q\t Exit Program\n\n");
   } //end of displayMenu()
} //end of class