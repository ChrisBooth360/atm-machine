import java.util.*;
import java.util.Map.Entry;

public class OptionMenu {

  private static final int EXIT_CODE = 0;
  private static final String SAVINGS = "Savings";
  private static final String CHEQUE = "Cheque";
  private static final String INVALID_AMOUNT_MESSAGE = "Please input a valid amount.";
  private static final String INVALID_CHOICE_MESSAGE = "You have made an invalid choice. Try again.";
  private final Scanner inputScanner; // Declare a single scanner for System.in

  public OptionMenu() {
    inputScanner = new Scanner(System.in); // Initialize the scanner in the constructor
  }

  public void login() {
    Map<Integer, Integer> validAccounts = new HashMap<>();
    validAccounts.put(1, 2);
    validAccounts.put(987654321, 4321);

    try {
      while(true) {
        System.out.println(
            "Welcome to Chris's ATM! Input your account number and pin to access your account. (Type '0' to quit).");
        System.out.println("Enter account number:");
        int userAccountNum = inputScanner.nextInt();

        if(userAccountNum == EXIT_CODE){
          break;
        }

        System.out.println("Enter pin:");
        int userPin = inputScanner.nextInt();

        if(userPin == EXIT_CODE){
          break;
        }


        boolean accountFound = false;

        for (Entry<Integer, Integer> entry : validAccounts.entrySet()) {
          if (entry.getKey() == userAccountNum && entry.getValue() == userPin) {
            accountFound = true;
            Account currentAccount = new Account(userAccountNum, userPin);
            accountSelection(currentAccount);
            break;
          }
        }

        if (!accountFound) {
          System.out.println("Your account does not exist. Try again.");
        }
        break;
      } 
    } catch (InputMismatchException e) {
        System.out.println("Invalid action. Input only numbers.");
        inputScanner.next();
    }
  }

  public void accountSelection(Account currentAccount) {
    while (true) {
      try {
        System.out.println("Which account would you like to access? Input number as choice.");
        System.out.println("1 - " + SAVINGS + " Account");
        System.out.println("2 - " + CHEQUE + " Account");
        System.out.println("0 - Exit");

        int userChoice = inputScanner.nextInt();

        switch (userChoice) {
          case 1:
            actionSelection(currentAccount, SAVINGS);
            break;
          case 2:
            actionSelection(currentAccount, CHEQUE);
            break;
          case EXIT_CODE:
            return;
          default:
            System.out.println(INVALID_CHOICE_MESSAGE);
            break;
        }
      } catch (InputMismatchException e) {
        System.out.println(INVALID_CHOICE_MESSAGE);
        inputScanner.next();
      }
    } 
  }

  public void actionSelection(Account currentAccount, String accountType) {
    while (true) {
      try {
        System.out.println(accountType + " Account.");
        System.out.println("1 - View balance");
        System.out.println("2 - Withdraw amount");
        System.out.println("3 - Deposit amount");
        System.out.println("0 - Go back");

        int userChoice = inputScanner.nextInt();

        switch (userChoice) {
          case 1:
            String balance = currentAccount.getAccountString(accountType);
            System.out.println(balance);
            break;
          case 2:
            withdrawal(currentAccount, accountType);
            break;
          case 3:
            deposit(currentAccount, accountType);
            break;
          case EXIT_CODE:
            return;
          default:
            System.out.println(INVALID_CHOICE_MESSAGE);
            break;
        }
      } catch (InputMismatchException e) {
        System.out.println(INVALID_CHOICE_MESSAGE);
        inputScanner.next();
      }
    }
  }

  public void withdrawal(Account currentAccount, String accountType) {
    try {
      System.out.println("Input the amount you want to withdraw from your " + accountType + " account.");
      double userAmount = inputScanner.nextDouble();

      if (accountType.equals(SAVINGS) && currentAccount.getSavingsTotal() - userAmount >= 0.0) {
        currentAccount.setSavingsTotal(-userAmount);
      } else if (accountType.equals(CHEQUE) && currentAccount.getChequeTotal() - userAmount >= 0.0) {
        currentAccount.setChequeTotal(-userAmount);
      } else {
        System.out.println("You do not have enough funds to withdraw that amount.");
      }

      System.out.println(currentAccount.getAccountString(accountType));
    } catch (InputMismatchException e) {
      System.out.println(INVALID_AMOUNT_MESSAGE);
      inputScanner.next();
    }
  }

  public void deposit(Account currentAccount, String accountType) {
    try {
      System.out.println("Input the amount you want to deposit into your " + accountType + " account.");
      double userAmount = inputScanner.nextDouble();

      if (userAmount < 0.0) {
        System.out.println(INVALID_AMOUNT_MESSAGE);
        return;
      }

      if (accountType.equals(SAVINGS)) {
        currentAccount.setSavingsTotal(userAmount);
      } else {
        currentAccount.setChequeTotal(userAmount);
      }

      System.out.println(currentAccount.getAccountString(accountType));
    } catch (InputMismatchException e) {
      System.out.println(INVALID_AMOUNT_MESSAGE);
      inputScanner.next();
    }
  }
}
