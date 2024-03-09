package classes;

import javax.swing.*;
import java.awt.*;

public class ComponentsContructor {

    int width, height;

    public ComponentsContructor(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public JPanel createTextfield(String textTitle, JTextField textField) {
        JPanel PanelField = new JPanel();
        JLabel title = new JLabel();

        title.setText(textTitle);
        title.setFont(new Font("Roboto", Font.PLAIN, 20));

        textField.setPreferredSize(new Dimension(width, height));
        textField.setForeground(new UiConts().TextColor);
        textField.setBackground(Color.WHITE);

        PanelField.setLayout(new BorderLayout(0, 10));
        PanelField.add(title, BorderLayout.NORTH);
        PanelField.add(textField, BorderLayout.CENTER);
        return PanelField;

    }

    public JPanel createTextArea(String textTitle, JTextArea textArea) {
        JPanel PanelTextArea = new JPanel();
        JLabel title = new JLabel();

        title.setText(textTitle);
        title.setFont(new Font("Roboto", Font.PLAIN, 20));

        textArea.setPreferredSize(new Dimension(width, height));
        textArea.setForeground(new UiConts().TextColor);
        textArea.setBackground(Color.WHITE);

        PanelTextArea.setLayout(new BorderLayout(0, 10));
        PanelTextArea.add(title, BorderLayout.NORTH);
        PanelTextArea.add(textArea, BorderLayout.CENTER);
        return PanelTextArea;
    }

    public JPanel createComboBox(String title, JComboBox comboBox) {
        UiConts conts = new UiConts();
        JPanel ComboBoxPanel = new JPanel();
        JLabel ComoboBoxLabel = new JLabel();
        ComoboBoxLabel.setText(title);
        ComoboBoxLabel.setFont(conts.boldText(15));
        ComoboBoxLabel.setForeground(conts.background);
        ComboBoxPanel.add(ComoboBoxLabel, BorderLayout.NORTH);

        comboBox.setSelectedItem(null);
        comboBox.setPreferredSize(new Dimension(250, 30));
        comboBox.setBackground(Color.white);
        comboBox.setForeground(conts.TextColor);
        comboBox.setFocusable(false);
        ComboBoxPanel.add(comboBox);
        return ComboBoxPanel;
    }


}
