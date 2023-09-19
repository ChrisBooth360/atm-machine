import java.text.DecimalFormat;

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

    public int getAccountNum(){
        return accountNum;
    }

    public int getPinNum(){
        return pinNum;
    }

    public double getSavingsTotal(){
        
        return savingsTotal;
    }

    public double getChequeTotal(){
        return chequeTotal;
    }

    public void setSavingsTotal(double newSavings){
        
        savingsTotal = newSavings;
    }

    public void setChequeTotal(double newCheque){

        double newChequeTotal = chequeTotal + newCheque;
        chequeTotal = newChequeTotal;
    }

    public String getAccountString(String accountType){
        
        if(accountType == "Savings"){
            return "Your total savings is " + getMoneyFormat(savingsTotal);
        } else {
            return "Your total chequing is " + getMoneyFormat(chequeTotal);
        }
        
    }

    public String getTypeSavings(){
        return "Savings";
    }

    public String getTypeChequing(){
        return "Chequing";
    }

    public String getMoneyFormat(double moneyDouble){

        DecimalFormat moneyFormat = new DecimalFormat("'R'###,##0.0");
        String formattedNum = moneyFormat.format(moneyDouble);
        return formattedNum;

    }

    
}
