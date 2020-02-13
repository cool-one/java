/***********************************************************************************************************
FILE:       nFact.java
UPDATED:    8-16-19
AUTHOR:     RC
TOPIC:      Calculate n! w/ Input Restriction & User Controls - Discrete Math
USAGE:      $ javac nFact.java     
            $ java nFact
***********************************************************************************************************/
import java.util.Scanner;
class nFact {
  
  public static void main(String args[]) {
    play();
  }
/*************************************************************************************************************
[1] Acquire integer from user.  range: 0-13
*************************************************************************************************************/
    static int getInteger() {
    Scanner sc = new Scanner(System.in);
    int a = 0;
    while(true) {
      System.out.println("Enter an integer to find a factorial of: ");
      //int a = 0;
      try {       //may be better to use if(sc.nextInt())
        a = sc.nextInt();
      } catch(NumberFormatException e) {
        System.out.println("not an int, try again");
        sc.next();
        continue;
      } catch(Exception e) {
        System.out.println("Exception caught!");
        sc.next();
        continue;
      }
      if(a < 0) {
        System.out.println("You can't use negative numbers...");
        continue;
      }
      if(a > 13) {
        System.out.println("You're getting carried away, think smaller");
        continue;
      }
      else break;
    }
    return a;
  }

/*************************************************************************************************************
[2] Calculates n!, takes int, returns int. Recursive function
*************************************************************************************************************/
  static int nFactorial(int n) {
    int answer;
    if(n==1 || n==0) {
      //CK System.out.println("current n is " + n + ", factorial of " + n + " is 1");
      return 1;
    }
    answer = nFactorial(n-1)*n;
    //CK System.out.print("current n is " + n + ", factorial of " + n + " is " + answer + "\n");
    return answer;
  }
  
/*************************************************************************************************************
[3] User Control Loop
*************************************************************************************************************/
  static void play() {
    Scanner sc = new Scanner(System.in);
    while(true) {
      System.out.println("Do you want to find a factorial? Y / N: ");
      char choice;
      choice = sc.next().charAt(0);
      if(choice == 'Y'|| choice == 'y') {
        int digit, answer = 0;
        digit = getInteger();               //ACTION functions
        answer = nFactorial(digit);     
        System.out.println("The factorial of " + digit + " is " + answer);
      }
      else if (choice == 'N'|| choice == 'n') {
        System.out.println("Have a nice day! ");
        break;
      }
      else {
        System.out.println("Not a valid option, try again..");
      }
    }
  }
}
