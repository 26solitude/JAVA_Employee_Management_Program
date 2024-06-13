package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.Menu;

public class EmployeeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("직원 관리 시스템");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new GridLayout(5, 1));

            JLabel label = new JLabel("직원 관리 시스템", SwingConstants.CENTER);
            JButton registerButton = new JButton("직원 등록");
            JButton searchButton = new JButton("직원 검색");
            JButton updateButton = new JButton("직원 갱신");
            JButton deleteButton = new JButton("직원 삭제");

            registerButton.addActionListener(e -> Menu.showRegisterMenu(frame));
            searchButton.addActionListener(e -> Menu.showSearchMenu(frame));
            updateButton.addActionListener(e -> Menu.showUpdateMenu(frame));
            deleteButton.addActionListener(e -> Menu.showDeleteMenu(frame));

            frame.add(label);
            frame.add(registerButton);
            frame.add(searchButton);
            frame.add(updateButton);
            frame.add(deleteButton);

            frame.setVisible(true);
        });
    }
}
