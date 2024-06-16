import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static final int ATM_NUMBER = 12345;
    private static final int ATM_PIN = 123;

    public static void main(String[] args) {
        ATMOperationsInterface op = new ATMOperationsImplementation();
        JFrame frame = new JFrame("ATM Machine");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel loginPanel = new JPanel(null);
        JPanel operationsPanel = new JPanel(null);

        JLabel userLabel = new JLabel("ATM Number:");
        userLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        loginPanel.add(userText);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(pinLabel);

        JPasswordField pinText = new JPasswordField(20);
        pinText.setBounds(100, 50, 165, 25);
        loginPanel.add(pinText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginPanel.add(loginButton);

        JLabel loginMessage = new JLabel("");
        loginMessage.setBounds(10, 110, 300, 25);
        loginPanel.add(loginMessage);

        JButton balanceButton = new JButton("Get Balance");
        balanceButton.setBounds(10, 20, 150, 25);
        operationsPanel.add(balanceButton);

        JButton withdrawButton = new JButton("Withdraw Amount");
        withdrawButton.setBounds(10, 60, 150, 25);
        operationsPanel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit Amount");
        depositButton.setBounds(10, 100, 150, 25);
        operationsPanel.add(depositButton);

        JButton miniStatementButton = new JButton("View Mini-Statement");
        miniStatementButton.setBounds(10, 140, 150, 25);
        operationsPanel.add(miniStatementButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(10, 180, 150, 25);
        operationsPanel.add(exitButton);

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(operationsPanel, "Operations");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int atmNum = Integer.parseInt(userText.getText());
                int pinNum = Integer.parseInt(new String(pinText.getPassword()));

                if (ATM_NUMBER == atmNum && ATM_PIN == pinNum) {
                    loginMessage.setText("Logged in Successfully");
                    cardLayout.show(mainPanel, "Operations");
                } else {
                    loginMessage.setText("Wrong ATM Number or Pin");
                }
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                op.viewBalance();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String withdrawAmtStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                double withdrawAmt = Double.parseDouble(withdrawAmtStr);
                op.withdrawAmount(withdrawAmt);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String depositAmtStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                double depositAmt = Double.parseDouble(depositAmtStr);
                op.depositAmount(depositAmt);
            }
        });

        miniStatementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                op.viewMiniStatement();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(mainPanel);
        cardLayout.show(mainPanel, "Login");
        frame.setVisible(true);
    }
}
