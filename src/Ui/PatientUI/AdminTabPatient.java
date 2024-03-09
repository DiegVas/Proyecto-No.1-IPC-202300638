package Ui.PatientUI;

import Ui.AdminUI.Doctor.AdminDoctor;
import Ui.AdminUI.Patient.AdminPatient;
import Ui.AdminUI.Product.AdminProduct;
import classes.FrameWindow;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import java.awt.*;

public class AdminTabPatient {

    public TypeClass.patient patientUser;
    public int indexPatient;

    public AdminTabPatient(TypeClass.patient patient, int indexPatient) {
        this.patientUser = patient;
        this.indexPatient = indexPatient;
      /*  FrameWindow window = new FrameWindow("Paciente", 1000, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AdminPanel());*/
    }

    public JPanel AdminPanel() {

        UiConts conts = new UiConts();

        JPanel AdminPane = new JPanel();
        AdminPane.setLayout(new BorderLayout());
        AdminPane.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        AdminPane.setBackground(conts.background);

        JLabel AdminTitle = new JLabel();
        AdminTitle.setText("Paciente");
        AdminTitle.setFont(conts.boldText(30));
        AdminTitle.setForeground(Color.white);
        AdminTitle.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        AdminPane.add(AdminTitle, BorderLayout.NORTH);

        JTabbedPane managePanel = new JTabbedPane();
        managePanel.setBackground(Color.white);

        managePanel.add("Solicitar cita", new solictyPatient(patientUser).solictyPatientPanel());
        managePanel.add("Verificar cita", new verificSolictyP(patientUser).verificPanel());
        managePanel.add("Farmacia", new farmacyShow().farmacyPanel());

        JLabel TabSize = new JLabel();
        TabSize.setPreferredSize(new Dimension(200, 30));

        managePanel.addChangeListener(e -> {

        });

        AdminPane.add(managePanel, BorderLayout.CENTER);


        return AdminPane;
    }

}
