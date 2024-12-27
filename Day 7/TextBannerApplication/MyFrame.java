
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame implements Runnable {

    JLabel TextLabel;
    int xPosition = 0;
    int yPosition;
    String text = "Welcome To Java World! ^-^";
    Thread thread;

    public MyFrame() {
        // Frame properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Text Banner Program ^-^");
        this.setSize(600, 400);
        this.setResizable(true);

        // Text label
        TextLabel = new JLabel(text);
        TextLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        TextLabel.setForeground(new Color(238, 130, 238));
        TextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(null);
        yPosition = this.getHeight() / 2 - 25; // Adjust for label height (approx. 50px)
        TextLabel.setBounds(xPosition, yPosition, 800, 50);
        this.add(TextLabel);
        this.setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            // Scroll the text horizontally
            xPosition -= 5;
            if (xPosition + TextLabel.getWidth() < 0) {
                xPosition = this.getWidth();
            }
            
          TextLabel.setBounds(xPosition, yPosition, 800, 50);

            // Repaint and delay
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
