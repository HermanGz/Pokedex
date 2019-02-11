package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String imgPath, int width, int height) {
        try {
            this.img = ImgResize(imgPath, width, height);
        } catch (IOException ex) {
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public Image ImgResize(String img, int width, int height) throws IOException {
        File inputFile = new File(img);
        BufferedImage inputImage = ImageIO.read(inputFile);

        BufferedImage outputImage = new BufferedImage(width, height, inputImage.getType());

        Graphics2D g2d = outputImage.createGraphics();

        g2d.drawImage(inputImage, 0, 0, width, height, null);
        g2d.dispose();

        return outputImage;
    }

}
