import Ui.AdminUI.AdminTabbedPane;
import Ui.LoginUI;
import classes.FrameWindow;
import classes.UserType;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {


        JTabbedPane tabbedPane = new JTabbedPane();

    /*    JPanel panel1 = new JPanel();
        tabbedPane.addTab("Pestaña 1", panel1);

        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Pestaña 2", panel2);


        FrameWindow window = new FrameWindow("Hospital Genesis", 1000, 600);
        window.getContentPane().add(tabbedPane);*/

        UserType addAdmin = new UserType();
        FrameWindow window = new FrameWindow("Hospital Genesis", 1000, 600);
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png")));
        UserType.codeGenerates.add("202300638");

        window.add(new AdminTabbedPane().AdminPanel()
                // new LoginUI().loginWindow()


        );


    }
}
