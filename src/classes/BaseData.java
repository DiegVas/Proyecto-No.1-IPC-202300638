package classes;

import java.util.ArrayList;
import java.util.List;

public class BaseData {
    public static List<UserType.Doctor> doctorList = new ArrayList<UserType.Doctor>();
    public static List<UserType.patient> patientList = new ArrayList<UserType.patient>();

    public void addPatient(String name, String lastName, String password, int age, boolean gender) {
        patientList.add(new UserType.patient(name, lastName, password, age, gender));
    }

    public List<UserType.Doctor> getDoctorList() {
        return doctorList;
    }

    public List<UserType.patient> getPatientList() {
        return patientList;
    }

}
