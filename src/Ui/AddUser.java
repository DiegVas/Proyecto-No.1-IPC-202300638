package Ui;

import classes.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AddUser {

    AddUser() {
        FrameWindow window = new FrameWindow("Crear Usuario", 550, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(form(window));
    }

    public JPanel form(JFrame actualFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 500, 600);
        UiConts conts = new UiConts();

        JLabel title = new JLabel();
        title.setText("Crear Usuario");
        title.setFont(conts.boldText(30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(conts.TextColor);
        title.setPreferredSize(new Dimension(0, 100));

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        ComponentsContructor contructor = new ComponentsContructor(200, 40);

        JTextField name = new JTextField();
        JPanel namePanel = contructor.createTextfield("Nombre Completo", name);
        form.add(namePanel);

        JTextField lastName = new JTextField();
        JPanel lastNamePanel = contructor.createTextfield("\n", lastName);
        form.add(lastNamePanel);

        JPasswordField password = new JPasswordField();
        JPanel passwordPanel = contructor.createTextfield("Contraseña", password);
        passwordPanel.setPreferredSize(new Dimension(410, 80));
        form.add(passwordPanel);

        JTextField age = new JTextField();
        JPanel agePanel = contructor.createTextfield("Edad", age);
        form.add(agePanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setPreferredSize(new Dimension(200, 70));
        genderPanel.setLayout(new BorderLayout());

        JLabel genderTitle = new JLabel();
        genderTitle.setText("Genero");
        genderTitle.setFont(conts.plainText(20));
        genderTitle.setPreferredSize(new Dimension(250, 30));
        genderPanel.add(genderTitle, BorderLayout.NORTH);

        String[] genders = {"Hombre", "Mujer"};
        JComboBox gender = new JComboBox(genders);
        gender.setSelectedItem(null);
        gender.setSize(new Dimension(250, 30));
        gender.setBackground(Color.white);
        gender.setForeground(conts.TextColor);
        gender.setFocusable(false);

        genderPanel.add(gender);

        form.add(genderPanel);

        JButton addUser = new JButton();
        addUser.setPreferredSize(new Dimension(250, 50));
        addUser.setText("Crear usaurio");
        addUser.setBackground(conts.TextColor);
        addUser.setForeground(Color.white);
        addUser.setBorder(BorderFactory.createEtchedBorder());
        addUser.setFocusable(false);

        addUser.addActionListener(e -> {
            if (name.getText().isEmpty()
                    || lastName.getText().isEmpty()
                    || String.valueOf(password.getPassword()).isEmpty()
                    || age.getText().isEmpty()
                    || genders[gender.getSelectedIndex()] == null
                    || !age.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Complete todas las casillas y por favor ingrese datos validos", "Crear usuario", JOptionPane.ERROR_MESSAGE);

            } else {
                BaseData newUser = new BaseData();
                newUser.addPatient(name.getText(), lastName.getText(), String.valueOf(password.getPassword()), Integer.parseInt(age.getText()), Objects.equals(genders[gender.getSelectedIndex()], "Hombre"));
                JOptionPane.showMessageDialog(null, "Usuario creado con exito\nSu codigo de usuario es " + BaseData.patientList.getLast().code, "Crear usuario", JOptionPane.INFORMATION_MESSAGE);
                actualFrame.dispose();
            }
        });

        form.add(addUser);
        panel.add(title, BorderLayout.NORTH);
        panel.add(form, BorderLayout.CENTER);

        return panel;
    }

}
