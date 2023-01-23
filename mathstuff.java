//This program performs 3 different arithmetic
//operations depending on a user's input,
//then prints out the answer

import java.util.Scanner;  //import Scanner class

class Lab5
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);   //creates Scanner object
      int choice; //initializing variable
      do{   //initializes do-while loop
         System.out.println();   //prints the menu
         System.out.println("1) Calculate the sum of integers 1 to m");
         System.out.println("2) Calculate the factorial of a given number");
         System.out.println("3) Find the first digit of a given number");
         System.out.println("4) Quit");
         System.out.println();
         
         choice = in.nextInt();  //requests user choice
         
         switch (choice)
         {
            case 1:     int m, sum = 0;   //calculates the sum of integers 1 to n
                        m = in.nextInt();
                        int i = 1;
                        while (i <= m)
                        {
                           sum = sum + i;
                           i++;
                        }
                        System.out.println("The sum of 1 to " + m + " is " + sum);
                        break;
            case 2:     int n, fact = 1;  //calculates the factorial of n
                        n = in.nextInt();
                        for (int j = 1; j <= n; j++)
                        {
                           fact = fact * j;
                        }
                        System.out.println("The factorial of " + n + " is " + fact);
                        break;            
            case 3:     int num, rem = 0; //finds the first digit of n
                        num = in.nextInt();
                        while (num != 0)
                        {
                           rem = num % 10;
                           num = num / 10;
                        }
                        System.out.println("The leftmost digit is " + rem);
                        break;
            default:
                        break;            
         }
        } while (choice != 4);
   }
}