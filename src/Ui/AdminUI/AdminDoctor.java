package Ui.AdminUI;

import classes.BaseData;
import classes.UiConts;
import classes.UserType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AdminDoctor {

    public static DefaultTableModel model = new DefaultTableModel();

    public JPanel Panel() {

        String[] headers = {"Codigo", "Nombre", "Apellido", "Edad", "Especialidad", "Telefono", "Genero"};
        model.setColumnIdentifiers(headers);

        UiConts conts = new UiConts();
        JPanel aDoctorPanel = new JPanel();
        aDoctorPanel.setLayout(new BorderLayout(10, 30));
        aDoctorPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleDoctor = new JLabel();
        JTable DoctorList = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(DoctorList);

        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setPreferredSize(new Dimension(300, 500));
        ButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton AddDoctor = new JButton();
        AddDoctor.setPreferredSize(new Dimension(130, 50));
        AddDoctor.setText("Crear Doctor");
        AddDoctor.setBackground(conts.TextColor);
        AddDoctor.setForeground(Color.white);
        AddDoctor.setBorder(BorderFactory.createEtchedBorder());
        AddDoctor.setFocusable(false);
        AddDoctor.addActionListener(e -> {
            Ui.AdminUI.AddDoctor doctor = new AddDoctor();
        });

        JButton ModyDoctor = new JButton();
        ModyDoctor.setPreferredSize(new Dimension(130, 50));
        ModyDoctor.setText("Modificar Doctor");
        ModyDoctor.setBackground(conts.TextColor);
        ModyDoctor.setForeground(Color.white);
        ModyDoctor.setBorder(BorderFactory.createEtchedBorder());
        ModyDoctor.setFocusable(false);
        ModyDoctor.addActionListener(e -> {
        });

        JButton DeleteDoctor = new JButton();
        DeleteDoctor.setPreferredSize(new Dimension(250, 50));
        DeleteDoctor.setText("Elminiar Doctor");
        DeleteDoctor.setBackground(conts.TextColor);
        DeleteDoctor.setForeground(Color.white);
        DeleteDoctor.setBorder(BorderFactory.createEtchedBorder());
        DeleteDoctor.setFocusable(false);


        ButtonsPanel.add(AddDoctor);
        ButtonsPanel.add(ModyDoctor);
        ButtonsPanel.add(DeleteDoctor);

        titleDoctor.setText("LISTADO DOCTORES");
        titleDoctor.setFont(conts.boldText(25));
        titleDoctor.setForeground(conts.background);

        aDoctorPanel.add(ButtonsPanel, BorderLayout.EAST);
        aDoctorPanel.add(scrollPane, BorderLayout.CENTER);
        aDoctorPanel.add(titleDoctor, BorderLayout.NORTH);


        return aDoctorPanel;
    }
}
