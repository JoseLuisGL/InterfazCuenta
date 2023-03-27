import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Splash extends JWindow {
    public Splash() {
        ImageIcon image = new ImageIcon("img/sol.png");
        JLabel label = new JLabel(image);
        getContentPane().add(label, BorderLayout.CENTER);
        setSize(image.getIconWidth(), image.getIconHeight());
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
