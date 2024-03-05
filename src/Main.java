import Ui.AdminUI.AdminTabbedPane;
import Ui.LoginUI;
import classes.FrameWindow;
import classes.UserType;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserType addAdmin = new UserType();
        FrameWindow window = new FrameWindow("Hospital Genesis", 1000, 600);
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png")));
        UserType.codeGenerates.add("202300638");

        window.add(new AdminTabbedPane().AdminPanel());
        //window.add(new LoginUI().loginWindow());

    }
}
