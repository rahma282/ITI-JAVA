import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class Frame extends JFrame {
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;

    public Frame() {
        // Frame properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program ^-^");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLayout(new GridLayout(3, 1)); // Arrange labels in 3 rows

        // Date-time formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        // Time label
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0, 255, 0));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(timeLabel);

        // Day label
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(dayLabel);

        // Date label
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(dateLabel);

        // Start the timer
        updateClock();

        this.setVisible(true);
    }

    public void updateClock() {
        Timer timer = new Timer(1000, e -> {
            String time = timeFormat.format(Calendar.getInstance().getTime());
            String day = dayFormat.format(Calendar.getInstance().getTime());
            String date = dateFormat.format(Calendar.getInstance().getTime());

            timeLabel.setText(time);
            dayLabel.setText(day);
            dateLabel.setText(date);
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Frame();
    }
}
