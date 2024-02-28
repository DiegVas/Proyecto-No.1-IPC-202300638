package Ui.AdminUI;

import classes.FrameWindow;
import classes.UiConts;

import javax.swing.*;
import java.awt.*;

public class AdminTabbedPane {
    public AdminTabbedPane() {
      /*  FrameWindow window = new FrameWindow("Administrador", 1000, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AdminPanel());*/
    }

    public JTabbedPane AdminPanel() {
        JTabbedPane managePanel = new JTabbedPane();
        JPanel aDoctorPanel = new JPanel();
        aDoctorPanel.setLayout(new GridLayout());

        managePanel.add("Doctores", new AdminDoctor().Panel());
        managePanel.add("Pacientes", new AdminPatient().Panel());
        managePanel.add("Productos", new AdminStore().Panel());

        managePanel.addChangeListener(e -> {
        });


        return managePanel;
    }

}
