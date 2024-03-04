package Ui;

import Ui.AdminUI.AdminTabbedPane;
import classes.BaseData;
import classes.UiConts;
import classes.TextfiledContructor;
import classes.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.ClassLoader.*;

public class LoginUI {

    public JPanel loginWindow() {
        JPanel panellogin = new JPanel();
        JPanel panelText = new JPanel();
        JPanel panel = new JPanel();

        UiConts conts = new UiConts();

        panelText.setBackground(conts.background);
        panelText.setBounds(0, 0, 350, 600);
        panelText.setLayout(new BorderLayout());

        JLabel Text = new JLabel();
        Text.setText("HOSPITAL GENESIS");
        Text.setVerticalTextPosition(JLabel.BOTTOM);
        Text.setHorizontalTextPosition(JLabel.CENTER);
        Text.setVerticalAlignment(JLabel.CENTER);
        Text.setHorizontalAlignment(JLabel.CENTER);
        Text.setFont(conts.boldText(30));
        Text.setForeground(Color.white);
        Text.setIcon(new ImageIcon(getSystemResource("Images/logo.png")));
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
        Title.setFont(conts.boldText(25));
        TitlePanel.add(Title, BorderLayout.SOUTH);

        TextfiledContructor FieldCreator = new TextfiledContructor(450, 40);

        JTextField userData = new JTextField();
        JPanel userPanel = FieldCreator.createTextfield("Usuario", userData);
        panellogin.add(userPanel);

        JTextField password = new JTextField();

        JPanel passwordPanel = FieldCreator.createTextfield("Contraseña", password);
        panellogin.add(passwordPanel);

        JButton login = new JButton();
        login.setPreferredSize(new Dimension(250, 50));
        login.setText("Iniciar secion");
        login.setBackground(conts.TextColor);
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEtchedBorder());
        login.setFocusable(false);
        login.addActionListener(e -> {
            BaseData a = new BaseData();
            for (int i = 0; i < a.getPatientList().size(); i++) {
                System.out.println(a.getPatientList().get(i).code);
            }

            if (userData.getText().equals(UserType.Admin.code) && password.getText().equals(UserType.Admin.password)) {
                AdminTabbedPane adminPanel = new AdminTabbedPane();
            } else {

                if (BaseData.patientList.stream().anyMatch(code -> code.code.equals(userData.getText()))) {

                    if (BaseData.patientList.stream().anyMatch(passwordF -> passwordF.password.equals(password.getText()))) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Iniciar sesion", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (BaseData.doctorList.stream().anyMatch(code -> code.code.equals(userData.getText()))) {

                    if (BaseData.doctorList.stream().anyMatch(passwordF -> passwordF.password.equals(password.getText()))) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Iniciar sesion", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "NO se encontro ningun usuario", "Iniciar sesion", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panellogin.add(login);

        JPanel newUser = new JPanel();
        JLabel createUser = new JLabel();
        JLabel infUser = new JLabel();
        infUser.setText("¿No tiene usuario?");
        infUser.setFont(conts.plainText(15));
        createUser.setText(" Crea uno ahora");
        createUser.setForeground(conts.secundaryColor);
        createUser.setFont(conts.boldText(15));
        createUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addUser addWindow = new addUser();
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

}
