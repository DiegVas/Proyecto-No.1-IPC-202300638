package Ui.PatientUI;

import classes.BaseData;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class verificSolictyP {
    TypeClass.patient patient;
    List<TypeClass.appointment> appointments = new ArrayList<>();
    public static DefaultTableModel modelPatient = new DefaultTableModel();

    verificSolictyP(TypeClass.patient patient) {
        BaseData data = new BaseData();
        this.patient = patient;
        appointments = patient.ListAppointment;
    }

    public JPanel verificPanel() {
        String[] header = {"Descripcion", "Fecha", "Estado"};
        UiConts conts = new UiConts();
        JPanel verificPanel = new JPanel();
        verificPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        verificPanel.setLayout(new BorderLayout(10, 15));

        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(800, 500));
        modelPatient.setColumnIdentifiers(header);
        JTable DoctorList = new JTable(modelPatient);
        DoctorList.setForeground(conts.TextColor);
        DoctorList.getTableHeader().setBackground(conts.background);
        DoctorList.getTableHeader().setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(DoctorList);
        tablePanel.add(scrollPane);
        verificPanel.add(tablePanel);


        return verificPanel;

    }
}
