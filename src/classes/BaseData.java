package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BaseData {
    public static List<TypeClass.Doctor> doctorList = new ArrayList<TypeClass.Doctor>();
    public static List<TypeClass.Product> productList = new ArrayList<>();
    public static List<TypeClass.patient> patientList = new ArrayList<TypeClass.patient>();


    public void pruebaDoctor() {
        addDoctor("Gonzales", "Panzal", "Odontologia", "123456789", "asdfqwe", 42, true);
        addDoctor("Gonzales", "Panzal", "Odontologia", "123456789", "asdfqwe", 42, true);
        addDoctor("Gonzales", "Panzal", "Odontologia", "123456789", "asdfqwe", 42, true);

        addPatient("maldonado", "velasquez", "12345", 18, false);
        BaseData.patientList.getFirst().ListAppointment.add(new TypeClass.appointment("asdasd", "ASS", LocalDate.now(), "800", BaseData.doctorList.getFirst(), 0));
        addPatient("maldonado", "velasquez", "12345", 18, false);
        addPatient("maldonado", "velasquez", "12345", 18, false);
        addPatient("maldonado", "velasquez", "12345", 18, false);

        addProduct("Medicina", "1234567891011121314151617181920", 150, 20);
        addProduct("Medicina", "Alta medicina", 150, 20);
        addProduct("Medicina", "Alta medicina", 150, 20);

        BaseData.doctorList.getFirst().doctorAppoitment.add(0, new TypeClass.DoctorAppointment(new TypeClass.appointment("aaa", "aaa", LocalDate.now(), "8:00", BaseData.doctorList.getFirst(), 0), BaseData.patientList.getFirst(), 0));
        BaseData.doctorList.getFirst().doctorAppoitment.add(0, new TypeClass.DoctorAppointment(new TypeClass.appointment("aaa", "aaa", LocalDate.now(), "9:00", BaseData.doctorList.getFirst(), 0), BaseData.patientList.getFirst(), 0));


    }

    public void addPatient(String name, String lastName, String password, int age, boolean gender) {
        patientList.add(new TypeClass.patient(name, lastName, password, age, gender));
    }

    public void addAppointmentPatient(int index, TypeClass.appointment appointment) {
        patientList.get(index).ListAppointment.add(appointment);
        System.out.println(patientList.get(index).ListAppointment);
    }

    public void ChangePatient(int index, TypeClass.patient newData) {
        patientList.set(index, newData);
    }

    public void addDoctor(String name, String lastName, String especiality, String phone, String password, int age, boolean gender) {
        doctorList.add(new TypeClass.Doctor(name, lastName, especiality, phone, password, age, gender));
    }

    public void setAppointment(int index, TypeClass.DoctorAppointment appointment) {
        doctorList.get(index).doctorAppoitment.add(appointment);
        System.out.println(doctorList.get(index).doctorAppoitment);
    }

    public void ChangeDoctor(int index, TypeClass.Doctor newData) {
        doctorList.set(index, newData);
    }

    public void addProduct(String name, String description, double price, int count) {
        productList.add(new TypeClass.Product(name, description, price, count));
    }

    public void changeProduct(int index, TypeClass.Product newData) {
        productList.set(index, newData);
    }

    public List<TypeClass.Doctor> getDoctorList() {
        return doctorList;
    }

    public List<TypeClass.Product> getProductList() {
        return productList;
    }

    ;

    public List<TypeClass.patient> getPatientList() {
        return patientList;
    }

}
