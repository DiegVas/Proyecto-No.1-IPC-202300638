package Ui.AdminUI.Doctor;

import classes.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ModyDoctor {

    TypeClass.Doctor doctorMody;
    int index;

    public ModyDoctor(TypeClass.Doctor doctorMody, int index) {
        this.doctorMody = doctorMody;
        this.index = index;
        FrameWindow window = new FrameWindow("Agregar doctor", 550, 700);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AddDoctorP(window));
    }

    public JPanel AddDoctorP(JFrame Actualframe) {
        UiConts conts = new UiConts();

        JPanel ModyDoctorPanel = new JPanel();
        ModyDoctorPanel.setLayout(new BorderLayout());
        ModyDoctorPanel.setBounds(0, 0, 500, 700);

        JLabel title = new JLabel();
        title.setText("Añadir Doctor");
        title.setFont(conts.boldText(30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(conts.TextColor);
        title.setPreferredSize(new Dimension(0, 100));

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        TextfiledContructor contructor = new TextfiledContructor(200, 40);

        JTextField name = new JTextField(doctorMody.name);
        JPanel namePanel = contructor.createTextfield("Nombre Completo", name);
        form.add(namePanel);

        JTextField lastName = new JTextField(doctorMody.lastName);
        JPanel lastNamePanel = contructor.createTextfield("\n", lastName);
        form.add(lastNamePanel);

        JTextField especiality = new JTextField(doctorMody.specialty);
        JPanel especialityPanel = contructor.createTextfield("Especialidad", especiality);
        form.add(especialityPanel);

        JTextField phone = new JTextField(doctorMody.phone);
        JPanel phonePanel = contructor.createTextfield("Telefono", phone);
        form.add(phonePanel);

        JTextField password = new JTextField(doctorMody.password);
        JPanel passwordPanel = contructor.createTextfield("Contraseña", password);
        passwordPanel.setPreferredSize(new Dimension(410, 80));
        form.add(passwordPanel);

        JTextField age = new JTextField();
        age.setText(String.valueOf(doctorMody.age));
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
        gender.setSelectedItem(doctorMody.gender ? genders[0] : genders[1]);
        gender.setSize(new Dimension(250, 30));
        gender.setBackground(Color.white);
        gender.setForeground(conts.TextColor);
        gender.setFocusable(false);

        genderPanel.add(gender);

        form.add(genderPanel);

        JButton ModyDoctor = new JButton();
        ModyDoctor.setPreferredSize(new Dimension(250, 50));
        ModyDoctor.setText("Crear Doctor");
        ModyDoctor.setBackground(conts.TextColor);
        ModyDoctor.setForeground(Color.white);
        ModyDoctor.setBorder(BorderFactory.createEtchedBorder());
        ModyDoctor.setFocusable(false);

        ModyDoctor.addActionListener(e -> {
            String nameI = name.getText(), lastNameI = lastName.getText(), especialityI = especiality.getText(), phoneI = phone.getText(), passwordI = password.getText();
            if (nameI.isEmpty()
                    || lastNameI.isEmpty()
                    || especialityI.isEmpty()
                    || phoneI.isEmpty()
                    || passwordI.isEmpty()
                    || age.getText().isEmpty()
                    || genders[gender.getSelectedIndex()] == null
                    || !age.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Complete todas las casillas y por favor ingrese datos validos", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            } else {
                BaseData modyDoctor = new BaseData();
                modyDoctor.ChangeDoctor(index, new TypeClass.Doctor(nameI, lastNameI, especialityI, phoneI, passwordI, Integer.parseInt(age.getText()), Objects.equals(genders[gender.getSelectedIndex()], "Hombre")));
                JOptionPane.showMessageDialog(null, "Doctor creado con exito\nSu codigo de usuario es " + BaseData.doctorList.getLast().code, "Crear Doctor", JOptionPane.INFORMATION_MESSAGE);
                Object[] doctorTab = {BaseData.doctorList.getLast().code, nameI, lastNameI, age.getText(), especialityI.toLowerCase(), phoneI, genders[gender.getSelectedIndex()]};

                AdminDoctor.model.setValueAt(doctorTab[0], index, 0);
                AdminDoctor.model.setValueAt(doctorTab[1], index, 1);
                AdminDoctor.model.setValueAt(doctorTab[2], index, 2);
                AdminDoctor.model.setValueAt(doctorTab[3], index, 3);
                AdminDoctor.model.setValueAt(doctorTab[4], index, 4);
                AdminDoctor.model.setValueAt(doctorTab[5], index, 5);
                AdminDoctor.model.setValueAt(doctorTab[6], index, 6);

                Actualframe.dispose();
            }
        });

        form.add(ModyDoctor);
        ModyDoctorPanel.add(title, BorderLayout.NORTH);
        ModyDoctorPanel.add(form, BorderLayout.CENTER);

        return ModyDoctorPanel;
    }
}
