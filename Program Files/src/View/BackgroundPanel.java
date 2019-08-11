package View;

import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {
    private Image image;

    public BackgroundPanel(String backgroundPic) {
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("/Resources/images/" + backgroundPic), backgroundPic));
        } catch (Exception e) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
