
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageAnimationApp extends JFrame implements Runnable {
    private int imageX, imageY, imageWidth, imageHeight, imageSpeedX, imageSpeedY;
    private int frameWidth = 1500, frameHeight = 600;
    private BufferedImage image;
    private Thread animationThread;
    private Random random = new Random();

    public ImageAnimationApp() {
        setTitle("Image Animation Application");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // Load the image
        try {
            image = ImageIO.read(new File("6010598201956092091.jpg")); 
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // exit if the image fails to load
        }

        // image position and speed
        imageX = random.nextInt(frameWidth - imageWidth);
        imageY = random.nextInt(frameHeight - imageHeight);
        imageSpeedX = random.nextInt(5) + 2;
        imageSpeedY = random.nextInt(5) + 2;

        animationThread = new Thread(this);
        animationThread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // clear the frame
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, frameWidth, frameHeight);

        // drow the image
        if (image != null) {
            g.drawImage(image, imageX, imageY, this);
        }
    }

    @Override
    public void run() {
        while (true) {
            // update image position
            imageX += imageSpeedX;
            imageY += imageSpeedY;

            //  frame edges
            if (imageX <= 0 || imageX + imageWidth >= frameWidth) {
                imageSpeedX = -imageSpeedX; // reverse X direction
            }
            if (imageY <= 0 || imageY + imageHeight >= frameHeight) {
                imageSpeedY = -imageSpeedY; // reverse Y direction
            }

            // repaint the frame with updated image position
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageAnimationApp app = new ImageAnimationApp();
            app.setVisible(true);
        });
    }
}
 
    

