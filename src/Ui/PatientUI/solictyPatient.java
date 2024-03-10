package Ui.PatientUI;

import classes.BaseData;
import classes.ComponentsContructor;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class solictyPatient {

    public List<String> specialitys = new ArrayList<>();
    public List<String> doctorsName = new ArrayList<>();
    public List<String> horarysDoctor = new ArrayList<>();
    public List<Integer> indexDoctors = new ArrayList<>();
    public List<String> Dates = new ArrayList<>();

    public TypeClass.patient patient;

    solictyPatient(TypeClass.patient patient) {
        this.patient = patient;
        LinkedHashSet<String> dupliquesSpecialitys = new LinkedHashSet<String>();
        for (TypeClass.Doctor doctor : BaseData.doctorList) dupliquesSpecialitys.add(doctor.specialty);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        specialitys = dupliquesSpecialitys.stream().toList();
        for (int i = 0; i < 6; i++) Dates.add(today.plusDays(i).format(formatter));
    }

    public JPanel solictyPatientPanel() {
        UiConts conts = new UiConts();
        JPanel solcityPanel = new JPanel();
        solcityPanel.setLayout(new BorderLayout(10, 30));
        solcityPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ComponentsContructor ComboBoxContructor = new ComponentsContructor(250, 30);

        JLabel titleSolcity = new JLabel();
        titleSolcity.setText("SOLICITAR CITA");
        titleSolcity.setFont(conts.boldText(25));
        titleSolcity.setForeground(conts.background);
        solcityPanel.add(titleSolcity, BorderLayout.NORTH);

        JPanel form = new JPanel();
        form.setLayout(new BorderLayout(0, 15));
        JPanel destinyInfo = new JPanel();
        destinyInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        destinyInfo.setPreferredSize(new Dimension(800, 120));

        DefaultComboBoxModel DoctorModel = new DefaultComboBoxModel(), HoraryModel = new DefaultComboBoxModel();


        JComboBox specialytList = new JComboBox(specialitys.toArray());
        JPanel specialityPanel = ComboBoxContructor.createComboBox("Especialidad", specialytList);
        specialytList.addItemListener(e -> {
            DoctorModel.removeAllElements();
            indexDoctors = new ArrayList<>();
            doctorsName = new ArrayList<>();
            for (TypeClass.Doctor doctor1 : BaseData.doctorList.stream().filter(doctor -> doctor.specialty.equals(specialitys.get(specialytList.getSelectedIndex()))).toList()) {
                indexDoctors.add(BaseData.doctorList.indexOf(doctor1));
                doctorsName.add(doctor1.name);
            }
            DoctorModel.addAll(doctorsName);
        });
        destinyInfo.add(specialityPanel);

        JComboBox doctorsList = new JComboBox(DoctorModel);
        JPanel doctorPanel = ComboBoxContructor.createComboBox("Doctores", doctorsList);
        doctorsList.addItemListener(e -> {
            HoraryModel.removeAllElements();
            horarysDoctor = new ArrayList<>();
            horarysDoctor = BaseData.doctorList.get(indexDoctors.get(doctorsList.getSelectedIndex())).doctorHorary;
            HoraryModel.addAll(horarysDoctor);
        });
        destinyInfo.add(doctorPanel);

        JComboBox HoraryList = new JComboBox(HoraryModel);
        JPanel HoraryPanel = ComboBoxContructor.createComboBox("Horarios       ", HoraryList);
        destinyInfo.add(HoraryPanel);

        JComboBox DateList = new JComboBox(Dates.toArray());
        JPanel DatePanel = ComboBoxContructor.createComboBox("Fechas    ", DateList);
        destinyInfo.add(DatePanel);
        form.add(destinyInfo, BorderLayout.NORTH);

        ComponentsContructor contructorTexfield = new ComponentsContructor(750, 80);
        JTextArea descriptionAppoint = new JTextArea();
        descriptionAppoint.setLineWrap(true);
        descriptionAppoint.setWrapStyleWord(true);
        JPanel descripAppont = contructorTexfield.createTextArea("Motivo de la cita", descriptionAppoint);
        form.add(descripAppont, BorderLayout.CENTER);
        solcityPanel.add(form);

        JButton addAppointment = new JButton();
        addAppointment.setPreferredSize(new Dimension(250, 50));
        addAppointment.setText("Solicitar Cita");
        addAppointment.setBackground(conts.TextColor);
        addAppointment.setForeground(Color.white);
        addAppointment.setBorder(BorderFactory.createEtchedBorder());
        addAppointment.setFocusable(false);
        addAppointment.addActionListener(e -> {
            BaseData data = new BaseData();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(Dates.get(DateList.getSelectedIndex()), formatter);
            TypeClass.appointment appointment = new TypeClass.appointment(descriptionAppoint.getText(), specialitys.get(specialytList.getSelectedIndex()), date, horarysDoctor.get(HoraryList.getSelectedIndex()), data.getDoctorList().get(indexDoctors.get(doctorsList.getSelectedIndex())), data.getPatientList().indexOf(patient));
            data.setAppointment(indexDoctors.get(doctorsList.getSelectedIndex()), new TypeClass.DoctorAppointment(appointment, patient, 0));
            data.addAppointmentPatient(data.getPatientList().indexOf(patient), appointment);

            Object[] rowData = {descriptionAppoint.getText(), Dates.get(DateList.getSelectedIndex()), "Sin confirmar"};
            verificSolictyP.modelPatient.addRow(rowData);
        });
        form.add(addAppointment, BorderLayout.SOUTH);

        return solcityPanel;
    }
}
