package View;

import Model.*;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame {
    public static JTextField realTextField1, imaginaryTextField1, realTextField2, imaginaryTextField2;
    public static JLabel resultLabel;

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Калькулятор комплексных чисел");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 150, 0, 0);

        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("Комплексное число 1:");
        label.setHorizontalAlignment(JTextField.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 5, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 30;
        c.weightx = 0.5;
        pane.add(label, c);

        realTextField1 = new JTextField();
        realTextField1.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 1;
        pane.add(realTextField1, c);

        imaginaryTextField1 = new JTextField();
        imaginaryTextField1.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 2;
        pane.add(imaginaryTextField1, c);

        label = new JLabel("Комплексное число 2:");
        label.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 0;
        c.gridy = 1;
        pane.add(label, c);

        realTextField2 = new JTextField();
        realTextField2.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 1;
        pane.add(realTextField2, c);

        imaginaryTextField2 = new JTextField();
        imaginaryTextField2.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 2;
        pane.add(imaginaryTextField2, c);

        JButton sumButton = new JButton("Сложить");
        sumButton.addActionListener(e -> performOperation(new ComplexAddition()));
        c.insets = new Insets(10, 5, 10, 5);
        c.gridx = 0;
        c.gridy = 2;
        pane.add(sumButton, c);

        JButton multiplyButton = new JButton("Умножить");
        multiplyButton.addActionListener(e -> performOperation(new ComplexMultiplication()));
        c.gridx = 1;
        pane.add(multiplyButton, c);

        JButton divideButton = new JButton("Разделить");
        divideButton.addActionListener(e -> performOperation(new ComplexDivision()));
        c.gridx = 2;
        pane.add(divideButton, c);

        resultLabel = new JLabel(" ");
        resultLabel.setHorizontalAlignment(JTextField.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(resultLabel, c);
    }

    private void performOperation(iComplexOperation operation) {
        try {
            double real1 = Double.parseDouble(realTextField1.getText());
            double imaginary1 = Double.parseDouble(imaginaryTextField1.getText());
            double real2 = Double.parseDouble(realTextField2.getText());
            double imaginary2 = Double.parseDouble(imaginaryTextField2.getText());

            ComplexNumber number1 = new ComplexNumber(real1, imaginary1);
            ComplexNumber number2 = new ComplexNumber(real2, imaginary2);

            ComplexNumber result = operation.calculate(number1, number2);

            if (result != null) {
                resultLabel.setText("Результат: " + result);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    resultLabel,
                    "Пожалуйста, введите корректные числа.",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(
                    resultLabel,
                    "Деление на ноль!",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
