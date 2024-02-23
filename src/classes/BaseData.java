package classes;

import java.util.ArrayList;
import java.util.List;

public class BaseData {
    public static List<UserType.doctor> doctorList = new ArrayList<UserType.doctor>();
    public static List<UserType.patient> patientList = new ArrayList<UserType.patient>();

    public void addPatient() {
        System.out.println(doctorList);
        doctorList.add(new UserType.doctor("", "", "", "", "", 0, false));
        System.out.println(doctorList);
    }

}
