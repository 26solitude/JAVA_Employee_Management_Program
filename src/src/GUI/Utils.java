package GUI;

import javax.swing.*;
import employee.DepartmentEnum;
import employee.PositionEnum;
import java.awt.*;

public class Utils {

    public static String getName(JFrame parentFrame) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Enter name:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "Name Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return textField.getText();
        } else {
            return null;
        }
    }

    public static DepartmentEnum getDepartment(JFrame parentFrame) {
        DepartmentEnum[] departments = DepartmentEnum.values();
        String[] options = new String[departments.length];
        for (int i = 0; i < departments.length; i++) {
            options[i] = departments[i].getMessage();
        }

        JComboBox<String> comboBox = new JComboBox<>(options);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Select department:"));
        panel.add(comboBox);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "Department Selection", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return departments[comboBox.getSelectedIndex()];
        } else {
            return null;
        }
    }

    public static PositionEnum getPosition(JFrame parentFrame) {
        PositionEnum[] positions = PositionEnum.values();
        String[] options = new String[positions.length];
        for (int i = 0; i < positions.length; i++) {
            options[i] = positions[i].getMessage();
        }

        JComboBox<String> comboBox = new JComboBox<>(options);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Select position:"));
        panel.add(comboBox);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "Position Selection", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return positions[comboBox.getSelectedIndex()];
        } else {
            return null;
        }
    }

    public static int getGrade(JFrame parentFrame) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Enter grade:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "Grade Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return Integer.parseInt(textField.getText());
        } else {
            return -1;
        }
    }

    public static int getHours(JFrame parentFrame) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Enter hours:"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel, "Hours Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return Integer.parseInt(textField.getText());
        } else {
            return -1;
        }
    }
}
