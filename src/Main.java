import Ui.AdminUI.AdminTabbedPane;
import Ui.LoginUI;
import classes.FrameWindow;
import classes.TypeClass;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        TypeClass addAdmin = new TypeClass();
        FrameWindow window = new FrameWindow("Hospital Genesis", 1000, 600);
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png")));
        TypeClass.codeGenerates.add("202300638");

        //window.add(new AdminTabbedPane().AdminPanel());
        window.add(new LoginUI().loginWindow());

    }
}
