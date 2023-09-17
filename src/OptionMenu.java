import java.util.*;

public class optionMenu extends Account {

    

    public void whichAccount(int choice, Account account){

        Scanner input = new Scanner(System.in);
        String userChoice = "0";

        while(userChoice != "4"){
            System.out.println("Which account would you like to access?");
            System.out.println("1 - Chequing account");
            System.out.println("2 - Savings account");
            System.out.println("3 - Credit account");
            System.out.println("4 - exit");

            try{
                switch(userChoice){
                    case "1":
                        accountAction()
                }
            }


        }

    }

    public void accountAction(Account account){

        

    }
    
}
