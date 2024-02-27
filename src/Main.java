import Ui.LoginUI;
import classes.FrameWindow;
import classes.UserType;

public class Main {
    public static void main(String[] args) {

        UserType addAdmin = new UserType();
        addAdmin.codeGenerates.add("202300638");
        FrameWindow window = new FrameWindow();
        window.add(new LoginUI().loginWindow());

    }
}
