package classes;

import java.util.ArrayList;
import java.util.List;

public class BaseData {
    public static List<TypeClass.Doctor> doctorList = new ArrayList<TypeClass.Doctor>();
    public static List<TypeClass.Product> productList = new ArrayList<>();
    public static List<TypeClass.patient> patientList = new ArrayList<TypeClass.patient>();


    public void addPatient(String name, String lastName, String password, int age, boolean gender) {
        patientList.add(new TypeClass.patient(name, lastName, password, age, gender));
    }

    public void ChangePatient(int index, TypeClass.patient newData) {
        patientList.set(index, newData);
    }

    public void addDoctor(String name, String lastName, String especiality, String phone, String password, int age, boolean gender) {
        doctorList.add(new TypeClass.Doctor(name, lastName, especiality, phone, password, age, gender));
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
