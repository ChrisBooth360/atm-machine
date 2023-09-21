import java.text.DecimalFormat;
import java.util.Objects;

public class Account {

    int accountNum;
    int pinNum;
    double savingsTotal;
    double chequeTotal;

    Account(int accountNum, int pinNum){
        this.accountNum = accountNum;
        this.pinNum = pinNum;
        this.savingsTotal = 100.0;
        this.chequeTotal = 100.0;
    }

    public double getSavingsTotal(){
        
        return savingsTotal;
    }

    public double getChequeTotal(){
        return chequeTotal;
    }

    public void setSavingsTotal(double newSavings){
        
        savingsTotal += newSavings;
    }

    public void setChequeTotal(double newCheque){

        chequeTotal += newCheque;
    }

    public String getAccountString(String accountType){
        
        if(Objects.equals(accountType, "Savings")){
            return "The total in your Savings Account is " + getMoneyFormat(savingsTotal);
        } else {
            return "The total in your Cheque Account is " + getMoneyFormat(chequeTotal);
        }
        
    }

    public String getMoneyFormat(double moneyDouble){

        DecimalFormat moneyFormat = new DecimalFormat("'R'###,##0.00");
        return moneyFormat.format(moneyDouble);

    }

    
}
