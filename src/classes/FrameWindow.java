package classes;

import javax.swing.*;

import java.awt.*;

public class FrameWindow extends JFrame {
    public FrameWindow(String title, int widht, int height) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(widht, height);
        this.setBackground(new UiConts().tercyColor);
        this.setVisible(true);
    }
}
