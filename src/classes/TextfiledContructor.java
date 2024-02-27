package classes;

import javax.swing.*;
import java.awt.*;

public class TextfiledContructor {

    int width, height;

    public TextfiledContructor(int width, int height) {
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
}
