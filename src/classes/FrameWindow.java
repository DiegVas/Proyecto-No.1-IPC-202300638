package classes;

import javax.swing.*;

import java.awt.*;

public class FrameWindow extends JFrame {
    public FrameWindow() {
        this.setTitle("Hospital Genesis");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setBackground(new UiConts().tercyColor);
        this.setLayout(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png")));
        this.setVisible(true);

    }
}
