package Ui.DoctorUI;

import classes.BaseData;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class appointmentAdmin {
    int indexDoctor;
    public List<TypeClass.DoctorAppointment> doctorAppointments = new ArrayList<>();

    appointmentAdmin(int indexDoctor) {
        this.indexDoctor = indexDoctor;
        doctorAppointments = BaseData.doctorList.get(indexDoctor).doctorAppoitment;
    }

    public JPanel appointmentPanel() {
        UiConts conts = new UiConts();
        JPanel appointpanel = new JPanel();
        appointpanel.setLayout(new BorderLayout(10, 15));
        appointpanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel appointmentTitle = new JLabel();
        appointmentTitle.setText("Citas");
        appointmentTitle.setFont(conts.boldText(25));
        appointmentTitle.setForeground(conts.background);
        appointpanel.add(appointmentTitle, BorderLayout.NORTH);

        for (TypeClass.DoctorAppointment doctorAppointment : doctorAppointments) {
            JPanel doctorAppontPanel = new JPanel();
            
        }

        return appointpanel;
    }
}
