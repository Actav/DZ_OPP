import View.CalculatorFrame;

import javax.swing.*;

public class Controller {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorFrame calculatorFrame = new CalculatorFrame();
            calculatorFrame.createAndShowGUI();
        });
    }
}
