package classes;

import java.util.ArrayList;
import java.util.List;

public class BaseData {
    public static List<UserType.doctor> doctorList = new ArrayList<UserType.doctor>();
    public static List<UserType.patient> patientList = new ArrayList<UserType.patient>();

    public void addPatient(String name, String lastName, String password, int age, boolean gender) {
        patientList.add(new UserType.patient("", "", "", 0, false));
    }

}
