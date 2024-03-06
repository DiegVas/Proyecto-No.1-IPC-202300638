package Ui.PatientUI;

import Ui.AdminUI.Doctor.AdminDoctor;
import Ui.AdminUI.Patient.AdminPatient;
import Ui.AdminUI.Product.AdminProduct;
import classes.FrameWindow;
import classes.UiConts;

import javax.swing.*;
import java.awt.*;

public class AdminTabbedPane {
    public AdminTabbedPane() {
        FrameWindow window = new FrameWindow("Administrador", 1000, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AdminPanel());
    }

    public JPanel AdminPanel() {

        UiConts conts = new UiConts();

        JPanel AdminPane = new JPanel();
        AdminPane.setLayout(new BorderLayout());
        AdminPane.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        AdminPane.setBackground(conts.background);

        JLabel AdminTitle = new JLabel();
        AdminTitle.setText("Administrador");
        AdminTitle.setFont(conts.boldText(30));
        AdminTitle.setForeground(Color.white);
        AdminTitle.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        AdminPane.add(AdminTitle, BorderLayout.NORTH);

        JTabbedPane managePanel = new JTabbedPane();
        managePanel.setBackground(Color.white);

        managePanel.add("Doctores", new AdminDoctor().Panel());
        managePanel.add("Pacientes", new AdminPatient().Panel());
        managePanel.add("Productos", new AdminProduct().Panel());

        JLabel TabSize = new JLabel();
        TabSize.setPreferredSize(new Dimension(200, 30));

        managePanel.addChangeListener(e -> {

        });

        AdminPane.add(managePanel, BorderLayout.CENTER);


        return AdminPane;
    }

}
