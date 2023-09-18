import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class OptionMenu {
    
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.0");
    
    Map<Integer, Integer> validAccounts = new HashMap<>();
    validAccounts.put(123456789, 1234);
    validAccounts.put(987654321, 4321);

    public void login(Map<Integer, Integer> validAccounts){
      Scanner inputLogin = new Scanner(System.in);
        int x = 0;

        do {
            try {
                System.out.println("Welcome to Chris's ATM! Input your account number and pin to access your account. ");
                System.out.println("Enter account number");
                int userAccountNum = inputLogin.nextInt();
                System.out.println("Enter pin:");
                int userPin = inputLogin.nextInt();
                
                for(Entry<Integer, Integer> entry : validAccounts.entrySet()){
                  if(entry.getKey() == userAccountNum && entry.getValue() == userPin){

                  }
                }
                
                // Add your logic to check the account number and PIN here
                // For example, you can use an if statement to validate the credentials

                // If the credentials are valid, set x to 1 to exit the loop
                // x = 1;
            } catch (InputMismatchException e) {
                System.out.println("Invalid action. Input only numbers.");
                inputLogin.nextLine(); // Consume the invalid input
            }
        } while (x == 0);

    }


    
}
