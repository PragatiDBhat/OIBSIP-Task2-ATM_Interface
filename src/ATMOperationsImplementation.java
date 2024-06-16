import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ATMOperationsImplementation implements ATMOperationsInterface {
    private double balance = 0.0;
    private List<String> miniStatement = new ArrayList<>();

    @Override
    public void viewBalance() {
        String balanceInfo = "Current Balance: " + balance;
        miniStatement.add(balanceInfo);
        JOptionPane.showMessageDialog(null, balanceInfo);
    }

    @Override
    public void withdrawAmount(double withdrawAmt) {
        if (balance >= withdrawAmt) {
            balance -= withdrawAmt;
            String withdrawInfo = "Withdrawn Amount: " + withdrawAmt;
            miniStatement.add(withdrawInfo);
            JOptionPane.showMessageDialog(null, withdrawInfo);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds");
        }
    }

    @Override
    public void depositAmount(double depositAmt) {
        balance += depositAmt;
        String depositInfo = "Deposited Amount: " + depositAmt;
        miniStatement.add(depositInfo);
        JOptionPane.showMessageDialog(null, depositInfo);
    }

    @Override
    public void viewMiniStatement() {
        StringBuilder statement = new StringBuilder("Mini-statement: Last 5 transactions\n");
        int start = Math.max(0, miniStatement.size() - 5);
        for (int i = start; i < miniStatement.size(); i++) {
            statement.append(miniStatement.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, statement.toString());
    }
}
