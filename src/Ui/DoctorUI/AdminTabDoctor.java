package Ui.DoctorUI;

import Ui.AdminUI.Patient.AdminPatient;
import Ui.AdminUI.Product.AdminProduct;
import Ui.PatientUI.solictyPatient;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import java.awt.*;

public class AdminTabDoctor {

    public TypeClass.Doctor UserDoctor;
    public int indexDoctor;

    public AdminTabDoctor(TypeClass.Doctor doctor, int indexDoctor) {
        this.UserDoctor = doctor;
        this.indexDoctor = indexDoctor;
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
        AdminTitle.setText("Doctor");
        AdminTitle.setFont(conts.boldText(30));
        AdminTitle.setForeground(Color.white);
        AdminTitle.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        AdminPane.add(AdminTitle, BorderLayout.NORTH);

        JTabbedPane managePanel = new JTabbedPane();
        managePanel.setBackground(Color.white);


        managePanel.add("Horario", new AdminPatient().Panel());
        managePanel.add("Asignar Horario", new addHorary(indexDoctor).HoraryTab());

        JLabel TabSize = new JLabel();
        TabSize.setPreferredSize(new Dimension(200, 30));

        managePanel.addChangeListener(e -> {

        });

        AdminPane.add(managePanel, BorderLayout.CENTER);


        return AdminPane;
    }


}
