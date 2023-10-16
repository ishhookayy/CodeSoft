import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private final JComboBox<String> baseCurrencyComboBox;
    private final JComboBox<String> targetCurrencyComboBox;
    private final JTextField amountTextField;
    private final JLabel resultLabel;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel currencyConvert = new JPanel();
        currencyConvert.setLayout(new GridLayout(5, 2));

        baseCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY", "INR", "CAD","GBP","AUD","HKD","NZD","CHF"});
        targetCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY", "INR", "CAD","GBP","AUD","HKD","NZD","CHF"});
        amountTextField = new JTextField();
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        currencyConvert.add(new JLabel("Base Currency:"));
        currencyConvert.add(baseCurrencyComboBox);
        currencyConvert.add(new JLabel("Target Currency:"));
        currencyConvert.add(targetCurrencyComboBox);
        currencyConvert.add(new JLabel("Amount:"));
        currencyConvert.add(amountTextField);
        currencyConvert.add(new JLabel("Result:"));
        currencyConvert.add(resultLabel);
        currencyConvert.add(convertButton);

        add(currencyConvert);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String baseCurrency = baseCurrencyComboBox.getSelectedItem().toString();
                String targetCurrency = targetCurrencyComboBox.getSelectedItem().toString();
                try {
                    double amount = Double.parseDouble(amountTextField.getText());
                    double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);
                    resultLabel.setText("Converted Amount: " + convertedAmount + " " + targetCurrency);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid amount.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }

    private double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        return switch (baseCurrency) {
            case "USD" -> USDCONVERTER(amount, targetCurrency);
            case "EUR" -> EURCONVERTER(amount, targetCurrency);
            case "JPY" -> JPYCONVERTER(amount, targetCurrency);
            case "INR" -> INRCONVERTER(amount, targetCurrency);
            case "CAD" -> CADCONVERTER(amount, targetCurrency);
            case "GBP" -> GBPCONVERTER(amount, targetCurrency);
            case "AUD" -> AUDCONVERTER(amount, targetCurrency);
            case "HKD" -> HKDCONVERTER(amount, targetCurrency);
            case "NZD" -> NZDCONVERTER(amount, targetCurrency);
            case "CHF" -> CHFCONVERTER(amount, targetCurrency);
            default ->
                // Handle other conversion scenarios or provide error handling
                    -1.0; // Indicate an invalid or unsupported conversion

        };
    }



    private double GBPCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "GBP" -> amount;
            case "USD" -> amount * 1.22;
            case "EUR" -> amount * 1.16;
            case "JPY" -> amount * 182.64;
            case "INR" -> amount * 101.61;
            case "CAD" -> amount * 1.66;
            case "AUD" -> amount * 1.93;
            case "HKD" -> amount * 9.55;
            case "NZD" -> amount * 2.06;
            case "CHF" -> amount * 1.10;
            default -> -1.0;
        };
    }

    private double AUDCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "AUD" -> amount;
            case "USD" -> amount * 0.63;
            case "EUR" -> amount * 0.60;
            case "JPY" -> amount * 94.85;
            case "INR" -> amount * 52.75;
            case "CAD" -> amount * 0.86;
            case "GBP" -> amount * 0.52;
            case "HKD" -> amount * 4.96;
            case "NZD" -> amount * 1.07;
            case "CHF" -> amount * 0.57;
            default -> -1.0;
        };
    }

    private double HKDCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "HKD" -> amount;
            case "USD" -> amount * 0.13;
            case "EUR", "CHF" -> amount * 0.12;
            case "JPY" -> amount * 19.13;
            case "INR" -> amount * 10.64;
            case "CAD" -> amount * 0.17;
            case "GBP" -> amount * 0.10;
            case "AUD" -> amount * 0.20;
            case "NZD" -> amount * 0.22;
            default -> -1.0;
        };
    }

    private double NZDCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "NZD" -> amount;
            case "USD" -> amount * 0.59;
            case "EUR" -> amount * 0.56;
            case "JPY" -> amount * 88.64;
            case "INR" -> amount * 49.32;
            case "CAD" -> amount * 0.81;
            case "GBP" -> amount * 0.49;
            case "AUD" -> amount * 0.93;
            case "HKD" -> amount * 4.63;
            case "CHF" -> amount * 0.53;
            default -> -1.0;
        };
    }

    private double CHFCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "CHF" -> amount;
            case "USD" -> amount * 1.11;
            case "EUR" -> amount * 1.05;
            case "JPY" -> amount * 166.10;
            case "INR" -> amount * 92.42;
            case "CAD" -> amount * 1.51;
            case "GBP" -> amount * 0.91;
            case "AUD" -> amount * 1.75;
            case "HKD" -> amount * 8.69;
            case "NZD" -> amount * 1.87;
            default -> -1.0;
        };
    }
    private double CADCONVERTER(double amount, String targetCurrency) {
        return switch (targetCurrency) {
            case "CAD" -> amount;
            case "EUR" -> amount * 0.70;
            case "JPY" -> amount * 109.90;
            case "INR" -> amount * 61.13;
            case "USD" -> amount * 0.73;
            case "GBP" -> amount * 0.60;
            case "AUD" -> amount * 1.16;
            case "HKD" -> amount * 5.74;
            case "NZD" -> amount * 1.24;
            case "CHF" -> amount * 0.66;
            default -> -1.0;
        };
    }

    private double INRCONVERTER(double amount, String targetCurrency) {
        return switch (targetCurrency) {
            case "INR" -> amount;
            case "EUR", "CHF" -> amount * 0.011;
            case "JPY" -> amount * 1.80;
            case "USD" -> amount * 0.012;
            case "CAD" -> amount * 0.016;
            case "GBP" -> amount * 0.0098;
            case "AUD" -> amount * 0.019;
            case "HKD" -> amount * 0.094;
            case "NZD" -> amount * 0.020;
            default -> -1.0;
        };
    }

    private double JPYCONVERTER(double amount, String targetCurrency) {
        return switch (targetCurrency) {
            case "JPY" -> amount;
            case "EUR" -> amount * 0.0063;
            case "USD" -> amount * 0.0067;
            case "INR" -> amount * 0.56;
            case "CAD" -> amount * 0.0091;
            case "GBP" -> amount * 0.0055;
            case "AUD", "HKD" -> amount * 0.052;
            case "NZD" -> amount * 0.011;
            case "CHF" -> amount * 0.0060;
            default -> -1.0;
        };
    }

    private double USDCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "USD" -> amount;
            case "EUR" -> amount * 0.95;
            case "JPY" -> amount * 149.60;
            case "INR" -> amount * 83.20;
            case "CAD" -> amount * 1.36;
            case "GBP" -> amount * 0.82;
            case "AUD" -> amount * 1.58;
            case "HKD" -> amount * 7.82;
            case "NZD" -> amount * 1.69;
            case "CHF" -> amount * 0.90;
            default -> -1.0;
        };
    }
    private double EURCONVERTER(double amount,String targetCurrency){
        return switch (targetCurrency) {
            case "EUR" -> amount;
            case "USD" -> amount * 1.05;
            case "JPY" -> amount * 157.77;
            case "INR" -> amount * 87.76;
            case "CAD" -> amount * 1.44;
            case "GBP" -> amount * 0.86;
            case "AUD" -> amount * 1.66;
            case "HKD" -> amount * 8.26;
            case "NZD" -> amount * 1.78;
            case "CHF" -> amount * 0.95;
            default -> -1.0;
        };
    }
}
