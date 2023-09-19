import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class OptionMenu {

  public void login() {

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

    Scanner inputAccount = new Scanner(System.in);
    String userChoice = "0";

    do{

      System.out.println("Which account would you like to access? Input number as choice.");
      System.out.println("1 - Savings Account");
      System.out.println("2 - Chequing Account");
      System.out.println("3 - exit");

      userChoice = inputAccount.nextLine();

      switch(userChoice){
        case "1":
          actionSelection(currentAccount, currentAccount.getTypeSavings());
          break;
        case "2":
          actionSelection(currentAccount, currentAccount.getTypeChequing());
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

  public void actionSelection(Account currentAccount, String accountType){

    Scanner inputAction = new Scanner(System.in);
    String userChoice = "0";

    do{

      System.out.println(accountType + " Account.");
      System.out.println("1 - View balance");
      System.out.println("2 - Withdraw amount");
      System.out.println("3 - Deposit amount");
      System.out.println("4 - Go back");

      userChoice = inputAction.nextLine();

      switch(userChoice){
        case "1":
          String balance = currentAccount.getAccountString(accountType);
          System.out.println(balance);
          break;
        case "2":
          withdrawal(currentAccount, accountType);
          break;
        case "3":
          deposit(currentAccount, accountType);
        case "4":
          userChoice = "4";
          break;
        default:
          System.out.println("Invalid input. Try again.");
      }

    } while(userChoice != "4");


  }

  public void withdrawal(Account currentAccount, String accountType){
    Scanner inputWithdrawal = new Scanner(System.in);
    
    System.out.println("Input the amount you want to withdraw from your " + accountType + " account.");
    
    double userAmount = inputWithdrawal.nextDouble();

    double newBalance = 0.0;

    if(accountType == "Savings"){
      newBalance = currentAccount.getSavingsTotal() - userAmount;
    } else {
      newBalance = currentAccount.getChequeTotal() - userAmount;
    }

    if(newBalance < 0){
      System.out.println("You cannot overdraw from this account.");
    } else if(accountType == "Savings") {
      currentAccount.setSavingsTotal(newBalance);
      currentAccount.getAccountString(accountType);
    } else if (accountType == "Chequing"){
      currentAccount.setChequeTotal(newBalance);
      currentAccount.getAccountString(accountType);
    }

    
  }

  public void deposit(Account currentAccount, String accountType){
    Scanner inputDeposit = new Scanner(System.in);

  }

}
