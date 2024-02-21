package methods;

import javax.swing.JFrame;
import java.awt.*;

public class FrameWindow extends JFrame {
    public FrameWindow() {
        this.setTitle("Hospital Genesis");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLayout(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("assets/icon.png")));
        this.setVisible(true);
    }
}
