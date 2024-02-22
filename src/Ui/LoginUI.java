package Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

public class LoginUI {

    public JPanel loginWindow() {
        JPanel panellogin = new JPanel();
        JPanel panelText = new JPanel();
        JPanel panel = new JPanel();

        panelText.setBackground(new Color(0x1c3142));
        panelText.setBounds(0, 0, 350, 600);
        panelText.setLayout(new BorderLayout());

        JLabel Text = new JLabel();
        Text.setText("HOSPITAL GENESIS");
        Text.setVerticalTextPosition(JLabel.BOTTOM);
        Text.setHorizontalTextPosition(JLabel.CENTER);
        Text.setVerticalAlignment(JLabel.CENTER);
        Text.setHorizontalAlignment(JLabel.CENTER);
        Text.setFont(new Font("Roboto", Font.BOLD, 30));
        Text.setForeground(Color.white);
        Text.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/logo.png")));
        panelText.add(Text);

        panellogin.setBounds(350, 0, 630, 600);
        panellogin.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));

        JPanel TitlePanel = new JPanel();
        TitlePanel.setLayout(new BorderLayout());
        TitlePanel.setPreferredSize(new Dimension(630, 130));
        panellogin.add(TitlePanel, BorderLayout.NORTH);

        JLabel Title = new JLabel();
        Title.setText("Iniciar Sesion");
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setFont(new Font("Roboto", Font.BOLD, 25));
        TitlePanel.add(Title, BorderLayout.SOUTH);

        labeTextfield FieldCreator = new labeTextfield(300, 30);

        JTextField userData = new JTextField();
        JPanel userPanel = FieldCreator.createTextfield("Usuario", userData);
        panellogin.add(userPanel);

        JTextField password = new JTextField();

        JPanel passwordPanel = FieldCreator.createTextfield("Contraseña", password);
        panellogin.add(passwordPanel);

        JButton login = new JButton();
        login.setPreferredSize(new Dimension(250, 50));
        login.setText("Iniciar secion");
        login.setBackground(new Color(0x40617c));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEtchedBorder());
        login.setFocusable(false);
        UIManager.put("Button.focus", Color.yellow);
        panellogin.add(login);

        JPanel newUser = new JPanel();
        JLabel createUser = new JLabel();
        JLabel infUser = new JLabel();
        infUser.setText("¿No tiene usuario?");
        infUser.setFont(new Font("Roboto", Font.PLAIN, 15));
        createUser.setText(" Crea uno ahora");
        createUser.setForeground(new Color(0x5c8cae));
        createUser.setFont(new Font("Roboto", Font.BOLD, 15));
        createUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click");
            }
        });
        newUser.add(infUser);
        newUser.add(createUser);

        newUser.setLayout(new FlowLayout());
        newUser.setPreferredSize(new Dimension(500, 50));
        panellogin.add(newUser);


        panel.setBounds(0, 0, 1000, 600);
        panel.setLayout(null);
        panel.add(panellogin);
        panel.add(panelText);
        return panel;
    }

    private static class labeTextfield {

        labeTextfield(double width, double height) {
        }

        public JPanel createTextfield(String textTitle, JTextField textField) {
            JPanel PanelField = new JPanel();
            JLabel title = new JLabel();
            textField = new JTextField();

            title.setText(textTitle);
            title.setFont(new Font("Roboto", Font.PLAIN, 20));

            textField.setPreferredSize(new Dimension(450, 40));
            textField.setForeground(new Color(0x1c3142));
            textField.setBackground(Color.WHITE);

            PanelField.setLayout(new BorderLayout(0, 10));
            PanelField.add(title, BorderLayout.NORTH);
            PanelField.add(textField, BorderLayout.CENTER);
            return PanelField;

        }

    }
}
