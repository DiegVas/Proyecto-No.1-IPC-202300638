package Ui.PatientUI;

import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;

public class verificSolictyP {
    TypeClass.patient patient;

    verificSolictyP(TypeClass.patient patient) {
        this.patient = patient;
    }

    public JPanel verificPanel() {
        UiConts conts = new UiConts();
        JPanel verificPanel = new JPanel();
        return verificPanel;

    }
}
