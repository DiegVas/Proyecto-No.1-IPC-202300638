package Ui;

import classes.*;

import javax.swing.*;
import java.awt.*;

public class AddUser {

    AddUser() {
        FrameWindow window = new FrameWindow("Crear Usuario", 600, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(form(window));
    }

    public JPanel form(JFrame actualFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 600, 600);
        UiConts conts = new UiConts();

        JLabel title = new JLabel();
        title.setText("Crear Usuario");
        title.setFont(conts.boldText(30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(conts.TextColor);
        title.setPreferredSize(new Dimension(0, 100));

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        TextfiledContructor contructor = new TextfiledContructor(250, 40);

        JTextField name = new JTextField();
        JPanel namePanel = contructor.createTextfield("Nombre Completo", name);
        form.add(namePanel);

        JTextField lastName = new JTextField();
        JPanel lastNamePanel = contructor.createTextfield("\n", lastName);
        form.add(lastNamePanel);

        JTextField password = new JTextField();
        JPanel passwordPanel = contructor.createTextfield("Contraseña", password);
        passwordPanel.setPreferredSize(new Dimension(510, 80));
        form.add(passwordPanel);

        JTextField age = new JTextField();
        JPanel agePanel = contructor.createTextfield("Edad", age);
        form.add(agePanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setPreferredSize(new Dimension(250, 70));
        genderPanel.setLayout(new BorderLayout());

        JLabel genderTitle = new JLabel();
        genderTitle.setText("Genero");
        genderTitle.setFont(conts.boldText(20));
        genderTitle.setPreferredSize(new Dimension(250, 30));
        genderPanel.add(genderTitle, BorderLayout.NORTH);

        JPanel genderGroup = new JPanel();
        JRadioButton male = new JRadioButton("Hombre");
        male.setFont(conts.boldText(15));
        JRadioButton famale = new JRadioButton("Mujer");
        famale.setFont(conts.boldText(15));
        genderGroup.add(male);
        genderGroup.add(famale);
        genderPanel.add(genderGroup, BorderLayout.WEST);

        ButtonGroup ButtonGroup = new ButtonGroup();
        ButtonGroup.add(male);
        ButtonGroup.add(famale);
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
                    || password.getText().isEmpty()
                    || age.getText().isEmpty()
                    || ButtonGroup.getSelection() == null
                    || !age.getText().matches("\\d+")) {

                JOptionPane.showMessageDialog(null, "Complete todas las casillas y por favor ingrese datos validos", "Crear usuario", JOptionPane.ERROR_MESSAGE);

            } else {
                BaseData newUser = new BaseData();
                newUser.addPatient(name.getText(), lastName.getText(), password.getText(), Integer.parseInt(age.getText()), ButtonGroup.getSelection() == male.getModel());
                JOptionPane.showMessageDialog(null, "Usuario creado con exito\nSu codigo de usuario es " + newUser.patientList.getLast().code, "Crear usuario", JOptionPane.INFORMATION_MESSAGE);
                actualFrame.dispose();
            }
        });

        form.add(addUser);
        panel.add(title, BorderLayout.NORTH);
        panel.add(form, BorderLayout.CENTER);

        return panel;
    }

}
