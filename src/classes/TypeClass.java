package classes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TypeClass {

    public static List<String> codeGenerates = new ArrayList<String>();

    public class Admin {
        public static String code = "202300638";
        public String name = "admin";
        public static String password = "proyectoIPC1";
    }

    public static class Product {
        public String product;
        public double price;
        public String description;
        public int count;

        public Product(String product, String description, double price, int count) {
            this.product = product;
            this.description = description;
            this.price = price;
            this.count = count;
        }
    }

    public static class DoctorAppointment {
        public appointment appointment;
        public int indexAppointmetn;
        public patient patient;

        public DoctorAppointment(appointment appointment, patient patient, int indexAppointmetn) {
            this.indexAppointmetn = indexAppointmetn;
            this.appointment = appointment;
            this.patient = patient;
        }
    }

    public static class Doctor {
        public String name;
        public String lastName;
        public String specialty;
        public String password;
        public String phone;
        public String code;
        public int age;
        public boolean gender;

        public List<DoctorAppointment> doctorAppoitment = new ArrayList<>();
        public List<String> doctorHorary = new ArrayList<>();

        public Doctor(String name, String lastName, String specialty, String password, String phone, int age, boolean gender) {
            this.code = generateCode();
            this.name = name;
            this.lastName = lastName;
            this.specialty = specialty;
            this.phone = phone;
            this.password = password;
            this.age = age;
            this.gender = gender;
        }

        public String getCode() {
            return this.code;
        }

        public String getSpecialty() {
            return this.specialty;
        }

    }

    public static class appointment {
        public String description, Speciality;
        public LocalDate date;
        public Doctor doctor;
        public String horary;
        public int indexPatient;
        public String aprobated;

        public appointment(String description, String Speciality, LocalDate date, String horary, Doctor doctor, int indexPatient) {
            this.aprobated = "Sin procesar";
            this.horary = horary;
            this.indexPatient = indexPatient;
            this.description = description;
            this.Speciality = Speciality;
            this.date = date;
            this.doctor = doctor;
        }
    }

    public static class patient {
        public String name, lastName, password, code;
        public static List<appointment> ListAppointment = new ArrayList<>();
        public int age;
        public boolean gender;

        public patient(String name, String lastName, String password, int age, boolean gender) {
            this.code = generateCode();
            this.name = name;
            this.lastName = lastName;
            this.password = password;
            this.age = age;
            this.gender = gender;
        }
    }

    public static String generateCode() {
        Random random = new Random();

        while (true) {
            int longitud = random.nextInt(5 - 3 + 1) + 5;
            StringBuilder codigo = new StringBuilder();

            for (int i = 0; i < longitud; i++) {
                char caracter = (char) (random.nextInt(10) + '0');
                codigo.append(caracter);
            }

            String codigoStr = codigo.toString();
            if (!codeGenerates.contains(codigoStr)) {
                codeGenerates.add(codigoStr);
                return codigoStr;
            }
        }


    }

}
