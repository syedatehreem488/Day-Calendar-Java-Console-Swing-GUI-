import javax.swing.*;
import java.awt.*;

public class CalenderGUI {

    // ===== Your DayType logic =====
    public static class DayType {
        String day;
        private static final String[] DaysOfWeek = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

        public DayType() {
            this.day = DaysOfWeek[0];
        }

        public String getDay() {
            return this.day;
        }

        public void setDay(String day) {
            for (String d : DaysOfWeek) {
                if (d.equalsIgnoreCase(day)) {
                    this.day = d;
                    return;
                }
            }
            this.day = DaysOfWeek[0]; // default Sunday
        }

        public int indexDay() {
            for (int i = 0; i < DaysOfWeek.length; i++) {
                if (DaysOfWeek[i].equals(this.day)) {
                    return i;
                }
            }
            return 0;
        }

        public void nextDay() {
            int i = indexDay();
            this.day = DaysOfWeek[(i + 1) % DaysOfWeek.length];
        }

        public void previousDay() {
            int i = indexDay();
            this.day = DaysOfWeek[(i - 1 + DaysOfWeek.length) % DaysOfWeek.length];
        }

        public void newDay(int n) {
            int i = indexDay();
            int newIndex = (i + n) % DaysOfWeek.length;
            if (newIndex < 0) newIndex += DaysOfWeek.length;
            this.day = DaysOfWeek[newIndex];
        }
    }

    // ===== GUI =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DayType day = new DayType();

            JFrame frame = new JFrame("Day Calendar (Swing)");
            frame.setSize(500, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(10, 10));

            // Top label
            JLabel titleLabel = new JLabel("Current Day: " + day.getDay(), SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            frame.add(titleLabel, BorderLayout.NORTH);

            // Center panel
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

            // Set day controls
            JPanel setDayPanel = new JPanel(new FlowLayout());
            JComboBox<String> dayCombo = new JComboBox<>(new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"});
            dayCombo.setSelectedItem(day.getDay());
            JButton setDayBtn = new JButton("Set Day");

            setDayPanel.add(new JLabel("Select Day:"));
            setDayPanel.add(dayCombo);
            setDayPanel.add(setDayBtn);

            // Navigation buttons
            JPanel navPanel = new JPanel(new FlowLayout());
            JButton prevBtn = new JButton("Previous Day");
            JButton nextBtn = new JButton("Next Day");
            navPanel.add(prevBtn);
            navPanel.add(nextBtn);

            // Move N panel
            JPanel moveNPanel = new JPanel(new FlowLayout());
            JTextField moveNField = new JTextField(10);
            JButton moveNBtn = new JButton("Move N Days");
            moveNPanel.add(new JLabel("Enter N:"));
            moveNPanel.add(moveNField);
            moveNPanel.add(moveNBtn);

            // Week view
            JPanel weekPanel = new JPanel(new GridLayout(1, 7, 5, 5));
            JLabel[] dayBoxes = new JLabel[7];
            String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

            for (int i = 0; i < 7; i++) {
                JLabel lbl = new JLabel(days[i], SwingConstants.CENTER);
                lbl.setOpaque(true);
                lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lbl.setFont(new Font("Arial", Font.BOLD, 14));
                dayBoxes[i] = lbl;
                weekPanel.add(lbl);
            }

            // Add panels to center
            centerPanel.add(setDayPanel);
            centerPanel.add(navPanel);
            centerPanel.add(moveNPanel);
            centerPanel.add(Box.createVerticalStrut(10));
            centerPanel.add(weekPanel);

            frame.add(centerPanel, BorderLayout.CENTER);

            // Helper to refresh UI
            Runnable refreshUI = () -> {
                titleLabel.setText("Current Day: " + day.getDay());
                dayCombo.setSelectedItem(day.getDay());

                for (int i = 0; i < 7; i++) {
                    if (days[i].equals(day.getDay())) {
                        dayBoxes[i].setBackground(new Color(76, 175, 80)); // green
                        dayBoxes[i].setForeground(Color.WHITE);
                    } else {
                        dayBoxes[i].setBackground(new Color(230, 230, 230)); // light gray
                        dayBoxes[i].setForeground(Color.BLACK);
                    }
                }
            };

            refreshUI.run();

            // Button actions
            setDayBtn.addActionListener(e -> {
                day.setDay((String) dayCombo.getSelectedItem());
                refreshUI.run();
            });

            nextBtn.addActionListener(e -> {
                day.nextDay();
                refreshUI.run();
            });

            prevBtn.addActionListener(e -> {
                day.previousDay();
                refreshUI.run();
            });

            moveNBtn.addActionListener(e -> {
                try {
                    int n = Integer.parseInt(moveNField.getText());
                    day.newDay(n);
                    refreshUI.run();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.setLocationRelativeTo(null); // center on screen
            frame.setVisible(true);
        });
    }
}
