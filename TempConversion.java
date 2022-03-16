/* 
This program prompts the user to choose one of the following options:
  
  1. Convert Fahrenheit to Celsius (Centigrade)
  2. Convert Fahrenheit to Kelvin
  3. Display data
  4. Quit the program

It a provides a response based on the user's selection. It allows the 
user to convert temperatures up to 10 times. If an option that is not
1, 2, 3, or 4 is chosen, the program tells the user the option is invalid
and to select a valid option. If the user attempts to exceed 10 conversions
program will tell the user that too many temperatures are entered.
*/

import java.util.Scanner;

public class TempConversion {

// Variables and array
static final int maxCounter = 10;
static int tempCounter = 0;
static float[][] tempArray = new float[maxCounter][3];
static float fahrenheit = 0F;
static float celsius = 0F;
static float kelvin = 0F;

   // Main method
   public static void main(String[] args) {
      showMenu();
   }
   
   // Display menu  
      public static void showMenu() {
         Scanner input = new Scanner(System.in);
         displayMenuSelections();
         int userSelection = input.nextInt();
         
         while(userSelection !=4)
         {
            switch(userSelection)
            {
               case 1:
                  showCelsius();
                  break;
               case 2:
                  showKelvin();
                  break;
               case 3:
                  showData();
                  break;
               default:
                  System.out.println("You chose an invalid option. Select 1, 2, 3, or 4.");
                  System.out.println();
                  break;
              }
              displayMenuSelections();
              userSelection = input.nextInt();
           }
           
           System.out.println("Bye");
           quitProgram();
           }
           
   // Display menu selections
   public static void displayMenuSelections()
   {
      // Output using System.out.println()
      System.out.println("Limit: " + maxCounter + " Temps: " + tempCounter);
      
      System.out.println("Select one of the following options:");
      System.out.println("1. Convert Fahrenheit to Celsius (Centigrade)");
      System.out.println("2. Convert Fahrenheit to Kelvin");
      System.out.println("3. Display data"); 
      System.out.println("4. Quit the program");
      System.out.println("Enter your choice: ");
    }
      
   // Method showCelsius
   public static void calculateTemp()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a Fahrenheit temperature:");
      
      fahrenheit = input.nextFloat();
      celsius = (fahrenheit - (float)(32.0))*(float)(5.0/9.0);
      kelvin = celsius + 273.15F;
      
      while(kelvin < 0)
      {
         System.out.println("You have entered an invalid temperature.");
         System.out.println("Enter a Fahrenheit temperature: ");
         
         fahrenheit = input.nextFloat();
         celsius = (fahrenheit - (float)(32.0)) * (float)(5.0 / 9.0);
         kelvin = celsius + 273.15F;
       }
       
       if(tempCounter >= maxCounter)
       {
         System.out.println("Too many temperatures entered! Max is :" + maxCounter);
         showData();
         System.exit(0);
        }
        
         tempArray[tempCounter][0] = fahrenheit;
         tempArray[tempCounter][1] = celsius;
         tempArray[tempCounter][2] = kelvin;
         
         tempCounter++;
   } 
   
   // method showCelsius
   public static void showCelsius()
   {
      calculateTemp();
      System.out.println(String.format("%.1f", fahrenheit) + " Fahrenheit = " +
      String.format("%.1f", celsius) + " Celsius");
    }
    
    // method showKelvin
    public static void showKelvin()
    {
      calculateTemp();
      System.out.println(String.format("%.1f", fahrenheit) + " Fahrenheit = " +
      String.format("%.1f", kelvin) + " Kelvin");
    }
    
    // method to display data
    public static void showData()
    {
      System.out.print("Fahrenheit: ");
      
      for(int i = 0; i < tempArray.length; i++)
      {
         float fahrenheit = tempArray[i][0];
         System.out.printf("%7.1f ", fahrenheit); 
      }
      
      System.out.println();
      System.out.print("Celsius: ");
      
      for(int i = 0; i < tempArray.length; i++)
      {
         float celsius = tempArray[i][1];
         System.out.printf("%7.1f ", celsius);  
      }
      
      System.out.println();
      System.out.print("Kelvin: ");
      
      for(int i = 0; i < tempArray.length; i++)
      {
         float kelvin = tempArray[i][2];
         System.out.printf("%7.1f ", kelvin);
      }
      System.out.println();
   }
   
   // method to quit
   public static void quitProgram()
   {
      System.exit(0);
   }
}
