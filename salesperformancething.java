//Analyzes sales performance for individuals

import java.util.Scanner;   //importing Scanner & DecimalFormat classes
import java.text.DecimalFormat;

public class Assignment6
{ 
   static DecimalFormat fmt = new DecimalFormat("$##,###.00"); //creates global DecimalFormat mask
   
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in); //creates Scanner
      
      final int NUMREPS = 30; //declaring variables
      int counter = 0;
      double revenue;
      String yes = "Y";
      
      String[] salesperson = new String[NUMREPS];  //creates array for name and ind. revenue
      double[] revenues = new double[NUMREPS];
      
      do {
         if (counter < NUMREPS)
         {  //grabs user input for salesperson name, revenue & continuing
            yes = scan.nextLine();
            salesperson[counter] = yes;
         
            revenue = scan.nextDouble();
            revenues[counter] = revenue;
         
            counter++;
            yes = scan.nextLine();
            yes = scan.nextLine();
         }
         else
            yes = "N";
      }  while(yes.toUpperCase().charAt(0) != 'N');
      
      int highest = getHighestIndex(revenues, counter);  //computing the index of highest/lowest #
      int lowest = getLowestIndex(revenues, counter);
      
      //prints report
      System.out.println("=== PPG Industries Sales Report ===");
      System.out.println("Number of sales person: " + counter);
      System.out.println("Total sales revenue: " + fmt.format(getTotal(revenues, revenues.length)));
      System.out.println("Average sales revenue: " + fmt.format(getAverage(revenues, counter)));
      System.out.println(countAboveAverage(revenues, getAverage(revenues, counter), counter)
                           + " salesperson's revenue are above average");
      System.out.println(salesperson[highest] + " has the highest sales revenue of " + 
                                                fmt.format(revenues[highest]));
      System.out.println(salesperson[lowest] + " has the lowest sales revenue of " +
                                                fmt.format(revenues[lowest]));                                         
      printPerformance(revenues, salesperson, getAverage(revenues, counter), counter);                                          
   }  //end of main()
   
   public static double getTotal(double[] salesArray, int size)
   {  //computes the total revenue
      double total = 0;
      for(int i = 0; i < size; i++)
      {
         total += salesArray[i];
      }
      return total;
   }  //end of getTotal()
   
   public static double getAverage(double[] salesArray, int size)
   {  //computes average revenue
      double avg = 0;
      for(int i = 0; i < size; i++)
      {
         avg += salesArray[i];
      }
      return avg/size;
   }  //end of getAverage()
   
   public static int getHighestIndex(double[] salesArray, int size)
   {  //computes the index of the highest value
      double highest = 0;
      int index = 0;
      for (int i = 0; i < size; i++)
      {
         if(salesArray[i] > highest)
         {
            highest = salesArray[i];
            index = i;
         }
      }
      return index;
   }  //end of getHighestIndex()
   
   public static int getLowestIndex(double[] salesArray, int size)
   {  //computes the index of the lowest value
      double lowest = salesArray[0];
      int index = 0;
      for(int i = 0; i < size; i++)
      {
         if(salesArray[i] < lowest)
         {
            lowest = salesArray[i];
            index = i;
         }
      }
      return index;
   }  //end of getLowestIndex()
   
   public static int countAboveAverage(double[] salesArray, double avg, int size)
   {
      int counter = 0;
      for(int i = 0; i < size; i++)
      {
         if(salesArray[i] >= avg)
            counter++;
      }
      return counter;
   }  //end of countAboveAverage()
   
   public static void printPerformance(double[] revenueArray, String[] personArray, double avg, int size)
   {
      System.out.println("\n=== Individual Sales Performance Report ===");
      System.out.println("Name\t\tSales Revenue\tAbove Avg");
      for(int i = 0; i < size; i++)
      {
         System.out.print(personArray[i] + "\t" + fmt.format(revenueArray[i]));
         if(revenueArray[i] >= avg)
            System.out.print("\tYes\n");
         else
            System.out.print("\tNo\n");
      }
      System.out.println();
   }  //end of printPerformance()                                                           
}  //end of class Assignment6