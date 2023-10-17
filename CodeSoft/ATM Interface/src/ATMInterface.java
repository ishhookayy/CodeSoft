import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private final BankAccount bankAccount;
    private final JLabel balanceLabel;
    private final JButton checkBalanceButton;
    private final JButton withdrawButton;
    private final JButton depositButton;

    public ATMInterface() {
        setTitle("ATM Interface");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        bankAccount = new BankAccount(500000); // Initialize with an initial balance

        JPanel atmInterface = new JPanel();
        atmInterface.setLayout(new GridLayout(4, 2));

        balanceLabel = new JLabel("Balance: ₹" );
        atmInterface.add(balanceLabel);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = bankAccount.getBalance();
                balanceLabel.setText("Balance: ₹" + balance);
            }
        });
        atmInterface.add(checkBalanceButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountString = JOptionPane.showInputDialog("Enter withdrawal amount:");
                double amount = Double.parseDouble(amountString);
                                boolean success = bankAccount.withdraw(amount);
                if (success) {
                    balanceLabel.setText("Balance: ₹" + bankAccount.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Withdrawal failed. Please check the amount.");
                }
            }
        });
        atmInterface.add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountString = JOptionPane.showInputDialog("Enter deposit amount:");
                double amount = Double.parseDouble(amountString);
                boolean success = bankAccount.deposit(amount);
                if (success) {
                    balanceLabel.setText("Balance: ₹" + bankAccount.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit failed. Please check the amount.");
                }
            }
        });
        atmInterface.add(depositButton);

        add(atmInterface);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATMInterface().setVisible(true);
            }
        });
    }
}
