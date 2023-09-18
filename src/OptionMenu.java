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

  public void accountSelection(Account curreAccount){

    

  }

}
