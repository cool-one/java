/***********************************************************************************************************
FILE:       gcdEuclid.java
UPDATED:    8-16-19
AUTHOR:     RC
TOPIC:      Use Euclid's Algorithm to return the gcd of 2 (+) integers. - Discrete Math
USAGE:      $ javac gcdEuclid.java     
            $ java gcdEuclid
***********************************************************************************************************/

/* Formula:
 * A / B
 * Check if rem = 0
 * If rem 0 then return B as gcd
 * Else set A = B, B = rem
 * Repeat.
 */
 
import java.util.Scanner;
class gcdEuclid {
  public static void main(String args[]) {
    play();
  }
  
/*************************************************************************************************************
[1] Get Integer from User, return Int.  range: 1-1000
*************************************************************************************************************/
    static int getInteger() {
    Scanner sc = new Scanner(System.in);
    int uDigit = 0;
    while(true) {
      System.out.println("Enter an integer from 1 to 1000: ");
      try {       
        uDigit = sc.nextInt();
      } catch(NumberFormatException e) {
        System.out.println("not an int, try again");
        sc.next();
        continue;
      } catch(Exception e) {
        System.out.println("Exception caught!");
        sc.next();
        continue;
      }
      if(uDigit < 1) {
        System.out.println("You can't use that number...");
        continue;
      }
      if(uDigit > 1000) {
        System.out.println("You're getting carried away, think smaller");
        continue;
      }
      else break;
    }
    return uDigit;
  }
  
/*************************************************************************************************************
[2] Calculate GCD, returns int.
*************************************************************************************************************/
  static int gcd(int a, int b) {
    int remainder = -1;
    while(remainder != 0) {
      remainder = a % b;
      if(remainder == 0) {
        return b;     //return GCD.
      } else  {
      a = b;
      b = remainder;
      }
    }
    return -1;      //dummy to satisfy compiler.
  }
  
/*************************************************************************************************************
[3] User Control Loop
*************************************************************************************************************/
  static void play() {
    Scanner sc = new Scanner(System.in);
    while(true) {
      System.out.println("Do you want to find a GCD? Y / N: ");
      char choice;
      choice = sc.next().charAt(0);
      if(choice == 'Y'|| choice == 'y') {
        int n1, n2, answer;
        System.out.println("Please select your 1st number");
        n1 = getInteger();
        System.out.println("Please select your 2nd number");
        n2 = getInteger();
        answer = gcd(n1, n2);
        System.out.println("Your GCD today is: " + answer);
      }
      else if (choice == 'N'|| choice == 'n') {
        System.out.println("Have a nice day! ");
        break;  //exit loop
      }
      else {
        System.out.println("Not a valid option, try again..");
      }
    }
  }
}
