package Ui.AdminUI.Patient;

import classes.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ModyPatient {

    TypeClass.patient modyPatient;
    int index;

    public ModyPatient(TypeClass.patient patient, int index) {
        this.modyPatient = patient;
        this.index = index;
        FrameWindow window = new FrameWindow("Agregar Paciente", 550, 700);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AddPatientP(window));
    }

    public JPanel AddPatientP(JFrame Actualframe) {
        UiConts conts = new UiConts();

        JPanel ModyPatientPanel = new JPanel();
        ModyPatientPanel.setLayout(new BorderLayout());
        ModyPatientPanel.setBounds(0, 0, 500, 700);

        JLabel title = new JLabel();
        title.setText("Añadir Doctor");
        title.setFont(conts.boldText(30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(conts.TextColor);
        title.setPreferredSize(new Dimension(0, 100));

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        ComponentsContructor contructor = new ComponentsContructor(200, 40);

        JTextField name = new JTextField(modyPatient.name);
        JPanel namePanel = contructor.createTextfield("Nombre Completo", name);
        form.add(namePanel);

        JTextField lastName = new JTextField(modyPatient.lastName);
        JPanel lastNamePanel = contructor.createTextfield("\n", lastName);
        form.add(lastNamePanel);

        JTextField password = new JTextField(modyPatient.password);
        JPanel passwordPanel = contructor.createTextfield("Contraseña", password);
        passwordPanel.setPreferredSize(new Dimension(410, 80));
        form.add(passwordPanel);

        JTextField age = new JTextField();
        age.setText(String.valueOf(modyPatient.age));
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
        gender.setSelectedItem(modyPatient.gender ? genders[0] : genders[1]);
        gender.setSize(new Dimension(250, 30));
        gender.setBackground(Color.white);
        gender.setForeground(conts.TextColor);
        gender.setFocusable(false);

        genderPanel.add(gender);

        form.add(genderPanel);

        JButton ModyPatient = new JButton();
        ModyPatient.setPreferredSize(new Dimension(250, 50));
        ModyPatient.setText("Crear Doctor");
        ModyPatient.setBackground(conts.TextColor);
        ModyPatient.setForeground(Color.white);
        ModyPatient.setBorder(BorderFactory.createEtchedBorder());
        ModyPatient.setFocusable(false);

        ModyPatient.addActionListener(e -> {
            String nameI = name.getText(), lastNameI = lastName.getText(), passwordI = password.getText();
            if (nameI.isEmpty()
                    || lastNameI.isEmpty()
                    || passwordI.isEmpty()
                    || age.getText().isEmpty()
                    || genders[gender.getSelectedIndex()] == null
                    || !age.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Complete todas las casillas y por favor ingrese datos validos", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            } else {
                BaseData modyPatient = new BaseData();
                modyPatient.ChangePatient(index, new TypeClass.patient(nameI, lastNameI, passwordI, Integer.parseInt(age.getText()), Objects.equals(genders[gender.getSelectedIndex()], "Hombre")));
                JOptionPane.showMessageDialog(null, "Paciente creado con exito\nSu codigo de usuario es " + BaseData.patientList.getLast().code, "Crear Paciente", JOptionPane.INFORMATION_MESSAGE);
                Object[] PatienteTab = {BaseData.patientList.getLast().code, nameI, lastNameI, age.getText(), genders[gender.getSelectedIndex()]};

                AdminPatient.model.setValueAt(PatienteTab[0], index, 0);
                AdminPatient.model.setValueAt(PatienteTab[1], index, 1);
                AdminPatient.model.setValueAt(PatienteTab[2], index, 2);
                AdminPatient.model.setValueAt(PatienteTab[3], index, 3);
                AdminPatient.model.setValueAt(PatienteTab[4], index, 4);

                Actualframe.dispose();
            }
        });

        form.add(ModyPatient);
        ModyPatientPanel.add(title, BorderLayout.NORTH);
        ModyPatientPanel.add(form, BorderLayout.CENTER);

        return ModyPatientPanel;
    }
}
