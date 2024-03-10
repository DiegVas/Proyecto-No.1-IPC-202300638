package Ui.DoctorUI;

import classes.BaseData;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        UiConts conts = new UiConts();

        JPanel appointpanel = new JPanel();
        appointpanel.setLayout(new BorderLayout(10, 15));
        appointpanel.setBorder(new EmptyBorder(5, 15, 15, 15));

        JLabel appointmentTitle = new JLabel();
        appointmentTitle.setText("Citas");
        appointmentTitle.setFont(conts.boldText(25));
        appointmentTitle.setForeground(conts.background);
        appointpanel.add(appointmentTitle, BorderLayout.NORTH);

        JPanel listAppointment = new JPanel();
        listAppointment.setLayout(new GridLayout(3, 1, 10, 10));

        for (TypeClass.DoctorAppointment doctorAppointment : doctorAppointments) {
            JPanel doctorAppontPanel = new JPanel();
            doctorAppontPanel.setLayout(new BorderLayout());
            doctorAppontPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            doctorAppontPanel.setBackground(conts.background);

            JPanel headderPanel = new JPanel();
            headderPanel.setBackground(conts.background);
            headderPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
            headderPanel.setPreferredSize(new Dimension(100, 50));

            JLabel appointmentDate = new JLabel();
            appointmentDate.setText(doctorAppointment.appointment.date.format(formatter));
            appointmentDate.setFont(conts.boldText(15));
            appointmentDate.setForeground(Color.white);
            headderPanel.add(appointmentDate);

            JLabel appointmentHorary = new JLabel();
            appointmentHorary.setText(doctorAppointment.appointment.horary);
            appointmentHorary.setFont(conts.boldText(15));
            appointmentHorary.setForeground(Color.white);
            headderPanel.add(appointmentHorary);

            doctorAppontPanel.add(headderPanel, BorderLayout.NORTH);

            JLabel appointdescription = new JLabel();
            appointdescription.setText(doctorAppointment.appointment.description);
            appointdescription.setFont(conts.plainText(15));
            appointdescription.setForeground(Color.white);
            doctorAppontPanel.add(appointdescription, BorderLayout.CENTER);

            JPanel appontbutton = new JPanel();
            appontbutton.setLayout(new FlowLayout(0, 15, 10));
            appontbutton.setBackground(conts.background);

            JButton confirmButton = new JButton();
            confirmButton.setPreferredSize(new Dimension(150, 30));
            confirmButton.setText("Confirmar cita");
            confirmButton.setBackground(conts.TextColor);
            confirmButton.setForeground(Color.white);
            confirmButton.setBorder(BorderFactory.createEtchedBorder());
            confirmButton.setFocusable(false);
            confirmButton.addActionListener(e -> {
                int appointmentindex = BaseData.patientList.get(doctorAppointment.appointment.indexPatient).ListAppointment.indexOf(doctorAppointment.appointment);
                BaseData.patientList.get(doctorAppointment.appointment.indexPatient).ListAppointment.get(appointmentindex).aprobated = "Aprobado";
                BaseData.doctorList.get(indexDoctor).doctorAppoitment.remove(doctorAppointment);
                System.out.println(BaseData.patientList.get(doctorAppointment.appointment.indexPatient).ListAppointment.get(appointmentindex).aprobated);
            });
            appontbutton.add(confirmButton);

            JButton denegateButton = new JButton();
            denegateButton.setPreferredSize(new Dimension(150, 30));
            denegateButton.setText("Denegar cita");
            denegateButton.setBackground(conts.TextColor);
            denegateButton.setForeground(Color.white);
            denegateButton.setBorder(BorderFactory.createEtchedBorder());
            denegateButton.setFocusable(false);
            denegateButton.addActionListener(e -> {
                int appointmentindex = BaseData.patientList.get(doctorAppointment.appointment.indexPatient).ListAppointment.indexOf(doctorAppointment.appointment);
                BaseData.patientList.get(doctorAppointment.appointment.indexPatient).ListAppointment.get(appointmentindex).aprobated = "No aprobado";
                BaseData.doctorList.get(indexDoctor).doctorAppoitment.remove(doctorAppointment);
                System.out.println(BaseData.patientList.get(doctorAppointment.appointment.indexPatient).ListAppointment.get(appointmentindex).aprobated);
            });

            appontbutton.add(denegateButton);
            doctorAppontPanel.add(appontbutton, BorderLayout.EAST);


            JLabel appointPatient = new JLabel();
            appointPatient.setText("Solicitado por: " + BaseData.patientList.get(doctorAppointment.appointment.indexPatient).name);
            appointPatient.setFont(conts.boldText(15));
            appointPatient.setForeground(Color.white);
            doctorAppontPanel.add(appointPatient, BorderLayout.SOUTH);


            listAppointment.add(doctorAppontPanel);

        }
        appointpanel.add(listAppointment);

        return appointpanel;
    }
}
