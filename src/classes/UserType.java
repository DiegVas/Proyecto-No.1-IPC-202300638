package classes;

public class UserType {

    public class admin {
        String code = "202300638", name = "admin", password = "proyectoIPC1";
    }

    public static class doctor {
        String name, lastName, specialty, password, phone;
        int age;
        boolean gender;

        doctor(String name, String lastName, String specialty, String password, String phone, int age, boolean gender) {
            this.name = name;
            this.lastName = lastName;
            this.specialty = specialty;
            this.password = password;
            this.phone = phone;
            this.age = age;
            this.gender = gender;
        }
    }

    public class patient {
        String name, lastName, password;
        int age;
        boolean gender;

        patient(String name, String lastName, String password, int age, boolean gender) {
            this.name = name;
            this.lastName = lastName;
            this.password = password;
            this.age = age;
            this.gender = gender;
        }
    }


}
