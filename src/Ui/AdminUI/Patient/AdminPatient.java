package Ui.AdminUI.Patient;

import classes.BaseData;
import classes.UiConts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminPatient {

    public static DefaultTableModel model = new DefaultTableModel();

    public JPanel Panel() {

        String[] headers = {"Codigo", "Nombre", "Apellido", "Edad", "Genero"};
        model.setColumnIdentifiers(headers);

        UiConts conts = new UiConts();
        JPanel aPatientPanel = new JPanel();
        aPatientPanel.setLayout(new BorderLayout(10, 30));
        aPatientPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titlePatient = new JLabel();
        JTable PatientList = new JTable(model);
        PatientList.setForeground(conts.TextColor);
        PatientList.getTableHeader().setBackground(conts.background);
        PatientList.getTableHeader().setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(PatientList);

        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setPreferredSize(new Dimension(300, 500));
        ButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton AddPatient = new JButton();
        AddPatient.setPreferredSize(new Dimension(130, 50));
        AddPatient.setText("Crear Paciente");
        AddPatient.setBackground(conts.TextColor);
        AddPatient.setForeground(Color.white);
        AddPatient.setBorder(BorderFactory.createEtchedBorder());
        AddPatient.setFocusable(false);
        AddPatient.addActionListener(e -> {
            AddPatient doctor = new AddPatient();
        });

        JButton ModyPatient = new JButton();
        ModyPatient.setPreferredSize(new Dimension(130, 50));
        ModyPatient.setText("Modificar Paciente");
        ModyPatient.setBackground(conts.TextColor);
        ModyPatient.setForeground(Color.white);
        ModyPatient.setBorder(BorderFactory.createEtchedBorder());
        ModyPatient.setFocusable(false);
        ModyPatient.addActionListener(e -> {
            int index = PatientList.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un paciente", "Eliminar paciente", JOptionPane.QUESTION_MESSAGE);
                return;
            }
            Ui.AdminUI.Patient.ModyPatient modyPatient = new ModyPatient(BaseData.patientList.get(index), index);

        });

        JButton DeletePatient = new JButton();
        DeletePatient.setPreferredSize(new Dimension(250, 50));
        DeletePatient.setText("Elminiar paciente");
        DeletePatient.setBackground(conts.TextColor);
        DeletePatient.setForeground(Color.white);
        DeletePatient.setBorder(BorderFactory.createEtchedBorder());
        DeletePatient.setFocusable(false);
        DeletePatient.addActionListener(e -> {
            int index = PatientList.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un paciente", "Eliminar paciente", JOptionPane.QUESTION_MESSAGE);
                return;
            }

            int response = JOptionPane.showConfirmDialog(null, "Esta seguro de elminar al paciente " + BaseData.patientList.get(index).name, "Eliminar Paciente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) return;

            BaseData.patientList.remove(index);
            model.removeRow(index);
        });

        ButtonsPanel.add(AddPatient);
        ButtonsPanel.add(ModyPatient);
        ButtonsPanel.add(DeletePatient);

        titlePatient.setText("LISTADO PACIENTE");
        titlePatient.setFont(conts.boldText(25));
        titlePatient.setForeground(conts.background);

        aPatientPanel.add(ButtonsPanel, BorderLayout.EAST);
        aPatientPanel.add(scrollPane, BorderLayout.CENTER);
        aPatientPanel.add(titlePatient, BorderLayout.NORTH);

        return aPatientPanel;
    }
}
