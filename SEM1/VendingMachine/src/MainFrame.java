import Domen.Product;
import VendingMachines.VendingMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {
    private final Font txtFont = new Font("Tahoma", Font.PLAIN, 16);
    private final DefaultListModel<String> dlm = new DefaultListModel<String>();

    public void initialize(VendingMachine iMachine) {
        // Наполнение модели данными
        List<Product> products = iMachine.getProducts();
        ListIterator<Product> iterator = products.listIterator(products.size());
        while (iterator.hasPrevious()) {
            Product prod = iterator.previous();
            dlm.add(0, prod.getProductName() + " (price:" + prod.getPrice() + ")");
        }

        JList<String> listProduct = new JList<String>(dlm);
        listProduct.setFont(txtFont);

        // Создание элементов
        JLabel lbGetCash = new JLabel("Поле ввода наличности");

        JTextField tfGetCash = new JTextField();
        tfGetCash.setEditable(false);
        tfGetCash.setHorizontalAlignment(JTextField.CENTER);
        tfGetCash.setMaximumSize(new Dimension(290, 30));

        // Создание кнопок
        Dimension btnSize = new Dimension(145, 27);
        JButton btnBuy = new JButton("Купить продукт");
        btnBuy.setFocusPainted(false);
        btnBuy.setPreferredSize(btnSize);
        btnBuy.setMaximumSize(btnBuy.getPreferredSize());
        btnBuy.addActionListener(e -> {
            String input = tfGetCash.getText();
            if (Objects.equals(input, "")) {
                tfGetCash.setText(" - Выберите товар -");
            } else {
                try {
                    Double.parseDouble(input);
                    tfGetCash.setText(" - Заберите покупку -");
                } catch (NumberFormatException ex) {
                    tfGetCash.setText(" - Ошибка! -");
                }

            }

        });

        JButton btnClear = new JButton("Очистить");
        btnClear.setFocusPainted(false);
        btnClear.setPreferredSize(btnSize);
        btnClear.setMaximumSize(btnClear.getPreferredSize());
        btnClear.addActionListener(e -> {
            tfGetCash.setText("");
        });

        JFrame frame = new JFrame("Vending Machines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание панели
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // Левая панель
        JPanel leftPanel = new JPanel(new GridLayout());
        leftPanel.add(new JScrollPane(listProduct));

        // Правая панель
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        rightPanel.add(lbGetCash);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(tfGetCash);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(btnBuy);
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(btnClear);

        // Добавляем левую панель
        gbc.weightx = 0.9;
        gbc.weighty = 1.0;
        panel.add(leftPanel, gbc);

        // Добавляем правую панель
        gbc.gridx = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 1.0;
        panel.add(rightPanel, gbc);

        frame.getContentPane().add(panel);
        frame.setBounds(150, 150, 500, 300);
        frame.setVisible(true);
        frame.setResizable(false);

        // Подключения слушателя списка продуктов
        listProduct.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                JList<String> source = (JList<String>) e.getSource();
                int selectedIndex = source.getSelectedIndex();
                Product prod = products.get(selectedIndex);
                tfGetCash.setText(String.valueOf(prod.getPrice()));
            }
        });
    }
    /*
     * Слушатель списка
     */

}