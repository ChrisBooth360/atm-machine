import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class OptionMenu {

  public void login() {
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.0");

    Map<Integer, Integer> validAccounts = new HashMap<>();
    validAccounts.put(1, 2);
    validAccounts.put(987654321, 4321);

    Scanner inputLogin = new Scanner(System.in);
    int x = 0;

    do {
      try {
        System.out.println("Welcome to Chris's ATM! Input your account number " 
                            + " and pin to access your account. (Type 'exit' to quit).");
        System.out.println("Enter account number");
        int userAccountNum = inputLogin.nextInt();
        System.out.println("Enter pin:");
        int userPin = inputLogin.nextInt();

        boolean accountFound = false;

        for (Entry<Integer, Integer> entry : validAccounts.entrySet()) {
          if (entry.getKey() == userAccountNum && entry.getValue() == userPin) {
            accountFound = true;
            Account currentAccount = new Account(userAccountNum, userPin);
            accountSelection(currentAccount);
            x = 1;
          }
        }

        if(!accountFound){
          System.out.println("Your account does not exist. Try again.");
        }

      } catch (InputMismatchException e) {
        System.out.println("Invalid action. Input only numbers.");
        inputLogin.nextLine();
      }
    } while (x == 0);

  }

  public void accountSelection(Account currentAccount){

    Scanner input2 = new Scanner(System.in);
    String userChoice = "0";

    do{

      System.out.println("Which account would you like to access? Input number as choice.");
      System.out.println("1 - Savings Account");
      System.out.println("2 - Chequing Account");
      System.out.println("3 - exit");

      userChoice = input2.nextLine();

      switch(userChoice){
        case "1":
          actionSelection(currentAccount, currentAccount.getSavingsTotal(), currentAccount.getTypeSavings());
          break;
        case "2":
          actionSelection(currentAccount, currentAccount.getChequeTotal(), currentAccount.getTypeChequing());
          break;
        case "3":
          userChoice = "3";
          break;
        default:
          System.out.println("You have made an invalid choice. Try again.");
          break;
      }

    } while(userChoice != "3");

  }

  public void actionSelection(Account currentAccount, double accountTypeTotal, String accountType){

    Scanner input2 = new Scanner(System.in);
    String userChoice = "0";
    double userAmount = 0.0;

    do{

      System.out.println(accountType + " Account.");
      System.out.println("1 - View balance");
      System.out.println("2 - Withdraw amount");
      System.out.println("3 - Deposit amount");
      System.out.println("4 - Go back");

      userChoice = input2.nextLine();

      if(userChoice == "1" && accountType == "Chequing"){
        currentAccount.getChequeString();
      } else if(userChoice == "1" && accountType == "Savings"){
        currentAccount.getSavingsString();
      } else if(userChoice == "2" && accountType == "Chequing"){
          System.out.println("How much would you like to withdraw? (Type -1 to go back)");
          userAmount = input2.nextDouble();
          if(userAmount == -1){
            break;
          } else {
            System.out.println("You've withdrawn " + currentAccount.getMoneyFormat(userAmount));
            System.out.println("Y");
          }
      }

    } while(userChoice != "3");


  }

}
