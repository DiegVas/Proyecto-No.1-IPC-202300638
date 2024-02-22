import Ui.LoginUI;
import classes.FrameWindow;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        FrameWindow window = new FrameWindow();
        window.add(new LoginUI().loginWindow());

    }
}
