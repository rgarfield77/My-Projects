import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton convertButton;
    private JButton clearButton;
    private JPanel CurrencyConverterPanel;


    public CurrencyConverter(){
        setContentPane(CurrencyConverterPanel);
        setTitle("Currency Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount= Double.parseDouble(textField1.getText());
                String selectedCurrency =(String) comboBox1.getSelectedItem();
                double exchangeRate;
                switch (selectedCurrency){
                    case"US":
                        exchangeRate = 129.02;
                        break;
                    case "CAN":
                        exchangeRate = 97.50;
                        break;
                    case "Euro":
                        exchangeRate = 164.33;
                        break;
                    default:
                        JOptionPane.showMessageDialog(CurrencyConverter.this, "Please select a valid currency.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                double jmdAmount = amount * exchangeRate;
                textField2.setText(String.valueOf(jmdAmount));
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField1.setText("");
                textField2.setText("");

                comboBox1.setSelectedIndex(0);

            }
        });
    }

    public static void main(String[] args){

        new CurrencyConverter();
    }
}
