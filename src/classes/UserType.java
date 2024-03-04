package classes;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UserType {

    public static List<String> codeGenerates = new ArrayList<String>();

    public class Admin {
        public static String code = "202300638";
        public String name = "admin";
        public static String password = "proyectoIPC1";

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

        Doctor(String name, String lastName, String specialty, String password, String phone, int age, boolean gender) {
            this.code = generateCode();
            this.name = name;
            this.lastName = lastName;
            this.specialty = specialty;
            this.password = password;
            this.phone = phone;
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

    public static class patient {
        public String name, lastName, password, code;
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
            int longitud = random.nextInt(7 - 5 + 1) + 7;
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
