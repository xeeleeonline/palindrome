import java.util.Scanner;

public class Palindrome {

   public static void main (String [] args) {
      
      System.out.println("Product Palindrome");
      System.out.println("==================");
      System.out.println("This program finds the highest product palindrome of any two n-digit numbers.");
      System.out.println();
      
      finalPalindrome(checkInput());
   }
   
   public static void finalPalindrome (int finalDigits) {
      int maxNumber = (int)Math.pow(10, finalDigits) - 1;
      int minNumber = (int)Math.pow(10, finalDigits - 1);
      long minCap = 9 * (long)(Math.pow(10, 2 * finalDigits - 1));
      
      long multiplicand = 0;
      long multiplier = 0;
      
      long palindrome = 0;
      boolean palindromeFirstFound = false;
      
      for (long i = maxNumber; i >= minNumber; i--) {
         if (i * i < minCap) break;
         
         for (long j = i; j >= minNumber; j--) {
            long product = i * j;
            //System.out.println("product = " + product);
            
            if (product < palindrome || product < minCap) break;
            
            String productAsString = String.valueOf(product);
            StringBuilder productAsStringBuilder = new StringBuilder();
            productAsStringBuilder.append(productAsString);
            productAsStringBuilder = productAsStringBuilder.reverse();
            productAsString = productAsStringBuilder.toString();
            long reversedProduct = Long.parseLong(productAsString);
            
            //System.out.println("product = " + product + ", reversed product = " + reversedProduct);
            
            if (product == reversedProduct) {
               if (product > palindrome) { 
                  palindrome = product;
                  multiplicand = i;
                  multiplier = j;
               }
            }
         }
      }
      System.out.println("The highest product palindrome of two " + finalDigits + "-digit numbers is: ");
      System.out.println(palindrome + " (" + multiplicand + " x " + multiplier + ")");
   }
   
   public static int checkInput () {
      boolean correctInput = false;
      Scanner input = new Scanner (System.in);
      int numDigits = 0;
      
      while (!correctInput) {
         System.out.print("Number of digits (range 2 -> 9): ");
         
         boolean passedTryCatch = true;
         try { numDigits = input.nextInt(); }
         catch (Exception e) {
            passedTryCatch = false;
            System.out.println();
            System.out.println("Invalid input!!");
            System.out.println("- - - - - - - -");
            input.nextLine();
         }
         
         if (passedTryCatch) {
            if (numDigits > 1 && numDigits < 10) correctInput = true;
            else
            {
               System.out.println();
               System.out.println("Invalid input!!");
               System.out.println("- - - - - - - -");
            }
         }
      }
      System.out.println();
      return numDigits;
   }
}