public class ATM {
    private double balance;
    private double debitAmount;
    private double creditAmount;

    public ATM(double balance, double debitAmount, double creditAmount) {
        this.balance = balance;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }
}
