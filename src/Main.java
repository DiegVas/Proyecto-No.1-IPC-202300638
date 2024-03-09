import Ui.AdminUI.AdminTabbedPane;
import Ui.DoctorUI.AdminTabDoctor;
import Ui.LoginUI;
import Ui.PatientUI.AdminTabPatient;
import classes.BaseData;
import classes.FrameWindow;
import classes.TypeClass;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        TypeClass addAdmin = new TypeClass();
        FrameWindow window = new FrameWindow("Hospital Genesis", 1000, 600);
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png")));
        TypeClass.codeGenerates.add("202300638");

        BaseData data = new BaseData();
        data.pruebaDoctor();
        //window.add(new AdminTabbedPane().AdminPanel());
        //window.add(new LoginUI().loginWindow());
        window.add(new AdminTabPatient(data.getPatientList().getFirst(), 0).AdminPanel());
        //window.add(new AdminTabDoctor(data.getDoctorList().getFirst(), 0).AdminPanel());

    }
}
