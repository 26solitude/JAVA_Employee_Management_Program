package GUI;

import employee.*;

import javax.swing.*;
import java.awt.*;

public class Menu {
    static EmployeeSet set = new EmployeeSet();

    public static void showRegisterMenu(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "직원 등록", true);
        dialog.setLayout(new GridLayout(2, 1));
        dialog.setSize(300, 200);

        JButton registerFullTimeButton = new JButton("정규직 등록");
        JButton registerPartTimeButton = new JButton("임시직 등록");

        registerFullTimeButton.addActionListener(e -> {
            dialog.dispose();
            showFullTimeRegisterMenu(parentFrame);
        });

        registerPartTimeButton.addActionListener(e -> {
            dialog.dispose();
            showPartTimeRegisterMenu(parentFrame);
        });

        dialog.add(registerFullTimeButton);
        dialog.add(registerPartTimeButton);

        dialog.setVisible(true);
    }

    public static void showFullTimeRegisterMenu(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "정규직 등록", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(400, 400);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(nameLabel, constraints);

        JTextField nameField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(nameField, constraints);

        // Department field
        JLabel departmentLabel = new JLabel("부서:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        dialog.add(departmentLabel, constraints);

        DepartmentEnum[] departments = DepartmentEnum.values();
        String[] departmentOptions = new String[departments.length];
        for (int i = 0; i < departments.length; i++) {
            departmentOptions[i] = departments[i].getMessage();
        }
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        constraints.gridx = 1;
        dialog.add(departmentComboBox, constraints);

        // Position field
        JLabel positionLabel = new JLabel("직위:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        dialog.add(positionLabel, constraints);

        PositionEnum[] positions = PositionEnum.values();
        String[] positionOptions = new String[positions.length];
        for (int i = 0; i < positions.length; i++) {
            positionOptions[i] = positions[i].getMessage();
        }
        JComboBox<String> positionComboBox = new JComboBox<>(positionOptions);
        constraints.gridx = 1;
        dialog.add(positionComboBox, constraints);

        // Grade field
        JLabel gradeLabel = new JLabel("Grade:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        dialog.add(gradeLabel, constraints);

        JTextField gradeField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(gradeField, constraints);

        // Buttons
        JButton saveButton = new JButton("저장");
        constraints.gridx = 0;
        constraints.gridy = 4;
        dialog.add(saveButton, constraints);

        JButton cancelButton = new JButton("돌아가기...");
        constraints.gridx = 1;
        dialog.add(cancelButton, constraints);

        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                DepartmentEnum department = DepartmentEnum.values()[departmentComboBox.getSelectedIndex()];
                PositionEnum position = PositionEnum.values()[positionComboBox.getSelectedIndex()];
                int grade = Integer.parseInt(gradeField.getText());

                set.RegisterFullTimeEmp(name, department, position, grade);
                JOptionPane.showMessageDialog(parentFrame, "정규직 등록 완료!");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parentFrame, "잘못된 입력입니다. 숫자를 입력해 주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showPartTimeRegisterMenu(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "임시직 등록", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(400, 300);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(nameLabel, constraints);

        JTextField nameField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(nameField, constraints);

        // Department field
        JLabel departmentLabel = new JLabel("부서:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        dialog.add(departmentLabel, constraints);

        DepartmentEnum[] departments = DepartmentEnum.values();
        String[] departmentOptions = new String[departments.length];
        for (int i = 0; i < departments.length; i++) {
            departmentOptions[i] = departments[i].getMessage();
        }
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        constraints.gridx = 1;
        dialog.add(departmentComboBox, constraints);

        // Hours field
        JLabel hoursLabel = new JLabel("Hours:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        dialog.add(hoursLabel, constraints);

        JTextField hoursField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(hoursField, constraints);

        // Buttons
        JButton saveButton = new JButton("저장");
        constraints.gridx = 0;
        constraints.gridy = 3;
        dialog.add(saveButton, constraints);

        JButton cancelButton = new JButton("돌아가기...");
        constraints.gridx = 1;
        dialog.add(cancelButton, constraints);

        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                DepartmentEnum department = DepartmentEnum.values()[departmentComboBox.getSelectedIndex()];
                int hours = Integer.parseInt(hoursField.getText());

                set.RegisterPartTimeEmp(name, department, hours);
                JOptionPane.showMessageDialog(parentFrame, "임시직 등록 완료!");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parentFrame, "잘못된 입력입니다. 숫자를 입력해 주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showSearchMenu(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "직원 검색", true);
        dialog.setLayout(new GridLayout(5, 1));
        dialog.setSize(300, 200);

        JButton searchAllButton = new JButton("모든 직원 검색");
        JButton searchFullTimeButton = new JButton("모든 정규직 검색");
        JButton searchPartTimeButton = new JButton("모든 임시직 검색");
        JButton searchNameButton = new JButton("이름으로 검색");

        searchAllButton.addActionListener(e -> {
            StringBuilder result = new StringBuilder();
            for (Employee employee : set.employees) {
                employee.print(result);
            }
            JTextArea textArea = new JTextArea(result.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(parentFrame, scrollPane, "모든 직원 검색 결과", JOptionPane.INFORMATION_MESSAGE);
        });

        searchFullTimeButton.addActionListener(e -> {
            StringBuilder result = new StringBuilder();
            for (Employee employee : set.employees) {
                if (employee instanceof FullTimeEmp) {
                    employee.print(result);
                }
            }
            JTextArea textArea = new JTextArea(result.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(parentFrame, scrollPane, "정규직 검색 결과", JOptionPane.INFORMATION_MESSAGE);
        });

        searchPartTimeButton.addActionListener(e -> {
            StringBuilder result = new StringBuilder();
            for (Employee employee : set.employees) {
                if (employee instanceof PartTimeEmp) {
                    employee.print(result);
                }
            }
            JTextArea textArea = new JTextArea(result.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(parentFrame, scrollPane, "임시직 검색 결과", JOptionPane.INFORMATION_MESSAGE);
        });

        searchNameButton.addActionListener(e -> {
            String name = Utils.getName(parentFrame);
            StringBuilder result = new StringBuilder();
            boolean found = false;
            for (Employee employee : set.employees) {
                if (employee.getName().equals(name)) {
                    employee.print(result);
                    found = true;
                }
            }
            JTextArea textArea = new JTextArea(result.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            if (found) {
                JOptionPane.showMessageDialog(parentFrame, scrollPane, "이름 검색 결과", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "해당 직원이 없습니다.");
            }
        });

        dialog.add(searchAllButton);
        dialog.add(searchFullTimeButton);
        dialog.add(searchPartTimeButton);
        dialog.add(searchNameButton);

        dialog.setVisible(true);
    }

    public static void showUpdateMenu(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "직원 갱신", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(300, 200);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel searchNameLabel = new JLabel("이름으로 검색:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(searchNameLabel, constraints);

        JTextField nameField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(nameField, constraints);

        JButton searchButton = new JButton("검색");
        constraints.gridx = 2;
        dialog.add(searchButton, constraints);

        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            Employee employee = set.searchEmployeeByName(name);
            if (employee != null) {
                dialog.dispose();
                showUpdateEmployeeInfo(parentFrame, employee);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "해당 직원이 없습니다.");
            }
        });

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showUpdateEmployeeInfo(JFrame parentFrame, Employee employee) {
        JDialog dialog = new JDialog(parentFrame, "직원 정보", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(400, 300);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        StringBuilder result = new StringBuilder();
        employee.print(result);

        JTextArea textArea = new JTextArea(result.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        dialog.add(scrollPane, constraints);

        JButton nextButton = new JButton("다음");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        dialog.add(nextButton, constraints);

        JButton backButton = new JButton("돌아가기...");
        constraints.gridx = 1;
        dialog.add(backButton, constraints);

        nextButton.addActionListener(e -> {
            dialog.dispose();
            showUpdateEmployeeId(parentFrame, employee);
        });

        backButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showUpdateEmployeeId(JFrame parentFrame, Employee employee) {
        JDialog dialog = new JDialog(parentFrame, "ID 입력", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(300, 150);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(idLabel, constraints);

        JTextField idField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(idField, constraints);

        JButton nextButton = new JButton("다음");
        constraints.gridx = 0;
        constraints.gridy = 1;
        dialog.add(nextButton, constraints);

        JButton cancelButton = new JButton("취소");
        constraints.gridx = 1;
        dialog.add(cancelButton, constraints);

        nextButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (id == employee.getId()) {
                    dialog.dispose();
                    if (employee instanceof FullTimeEmp) {
                        showFullTimeUpdateMenu(parentFrame, (FullTimeEmp) employee);
                    } else {
                        showPartTimeUpdateMenu(parentFrame, (PartTimeEmp) employee);
                    }
                } else {
                    JOptionPane.showMessageDialog(parentFrame, "ID가 일치하지 않습니다.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parentFrame, "잘못된 입력입니다. 숫자를 입력해 주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showFullTimeUpdateMenu(JFrame parentFrame, FullTimeEmp employee) {
        JDialog dialog = new JDialog(parentFrame, "정규직 정보 갱신", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(400, 400);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(nameLabel, constraints);

        JTextField nameField = new JTextField(employee.getName(), 20);
        constraints.gridx = 1;
        dialog.add(nameField, constraints);

        // Department field
        JLabel departmentLabel = new JLabel("부서:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        dialog.add(departmentLabel, constraints);

        DepartmentEnum[] departments = DepartmentEnum.values();
        String[] departmentOptions = new String[departments.length];
        for (int i = 0; i < departments.length; i++) {
            departmentOptions[i] = departments[i].getMessage();
        }
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setSelectedItem(employee.getDepartment().getMessage());
        constraints.gridx = 1;
        dialog.add(departmentComboBox, constraints);

        // Position field
        JLabel positionLabel = new JLabel("직위:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        dialog.add(positionLabel, constraints);

        PositionEnum[] positions = PositionEnum.values();
        String[] positionOptions = new String[positions.length];
        for (int i = 0; i < positions.length; i++) {
            positionOptions[i] = positions[i].getMessage();
        }
        JComboBox<String> positionComboBox = new JComboBox<>(positionOptions);
        positionComboBox.setSelectedItem(employee.getPosition().getMessage());
        constraints.gridx = 1;
        dialog.add(positionComboBox, constraints);

        // Grade field
        JLabel gradeLabel = new JLabel("Grade:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        dialog.add(gradeLabel, constraints);

        JTextField gradeField = new JTextField(String.valueOf(employee.getGrade()), 20);
        constraints.gridx = 1;
        dialog.add(gradeField, constraints);

        // Buttons
        JButton saveButton = new JButton("저장");
        constraints.gridx = 0;
        constraints.gridy = 4;
        dialog.add(saveButton, constraints);

        JButton cancelButton = new JButton("돌아가기...");
        constraints.gridx = 1;
        dialog.add(cancelButton, constraints);

        saveButton.addActionListener(e -> {
            try {
                employee.setName(nameField.getText());
                employee.setDepartment(DepartmentEnum.values()[departmentComboBox.getSelectedIndex()]);
                employee.setPosition(PositionEnum.values()[positionComboBox.getSelectedIndex()]);
                employee.setGrade(Integer.parseInt(gradeField.getText()));

                set.UpdateFullTime(employee, employee.getName(), employee.getDepartment(), employee.getPosition(), employee.getGrade());
                JOptionPane.showMessageDialog(parentFrame, "정규직 정보 갱신 완료!");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parentFrame, "잘못된 입력입니다. 숫자를 입력해 주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showPartTimeUpdateMenu(JFrame parentFrame, PartTimeEmp employee) {
        JDialog dialog = new JDialog(parentFrame, "임시직 정보 갱신", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(400, 300);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(nameLabel, constraints);

        JTextField nameField = new JTextField(employee.getName(), 20);
        constraints.gridx = 1;
        dialog.add(nameField, constraints);

        // Department field
        JLabel departmentLabel = new JLabel("부서:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        dialog.add(departmentLabel, constraints);

        DepartmentEnum[] departments = DepartmentEnum.values();
        String[] departmentOptions = new String[departments.length];
        for (int i = 0; i < departments.length; i++) {
            departmentOptions[i] = departments[i].getMessage();
        }
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setSelectedItem(employee.getDepartment().getMessage());
        constraints.gridx = 1;
        dialog.add(departmentComboBox, constraints);

        // Hours field
        JLabel hoursLabel = new JLabel("Hours:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        dialog.add(hoursLabel, constraints);

        JTextField hoursField = new JTextField(String.valueOf(employee.getHours()), 20);
        constraints.gridx = 1;
        dialog.add(hoursField, constraints);

        // Buttons
        JButton saveButton = new JButton("저장");
        constraints.gridx = 0;
        constraints.gridy = 3;
        dialog.add(saveButton, constraints);

        JButton cancelButton = new JButton("돌아가기...");
        constraints.gridx = 1;
        dialog.add(cancelButton, constraints);

        saveButton.addActionListener(e -> {
            try {
                employee.setName(nameField.getText());
                employee.setDepartment(DepartmentEnum.values()[departmentComboBox.getSelectedIndex()]);
                employee.setHours(Integer.parseInt(hoursField.getText()));

                set.UpdatePartTime(employee, employee.getName(), employee.getDepartment(), employee.getHours());
                JOptionPane.showMessageDialog(parentFrame, "임시직 정보 갱신 완료!");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parentFrame, "잘못된 입력입니다. 숫자를 입력해 주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showDeleteMenu(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "직원 삭제", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(300, 200);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel searchNameLabel = new JLabel("이름으로 검색:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(searchNameLabel, constraints);

        JTextField nameField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(nameField, constraints);

        JButton searchButton = new JButton("검색");
        constraints.gridx = 2;
        dialog.add(searchButton, constraints);

        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            Employee employee = set.searchEmployeeByName(name);
            if (employee != null) {
                dialog.dispose();
                showDeleteEmployeeInfo(parentFrame, employee);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "해당 직원이 없습니다.");
            }
        });

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showDeleteEmployeeInfo(JFrame parentFrame, Employee employee) {
        JDialog dialog = new JDialog(parentFrame, "직원 정보", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(400, 300);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        StringBuilder result = new StringBuilder();
        employee.print(result);

        JTextArea textArea = new JTextArea(result.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        dialog.add(scrollPane, constraints);

        JButton nextButton = new JButton("다음");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        dialog.add(nextButton, constraints);

        JButton backButton = new JButton("돌아가기...");
        constraints.gridx = 1;
        dialog.add(backButton, constraints);

        nextButton.addActionListener(e -> {
            dialog.dispose();
            showDeleteEmployeeId(parentFrame, employee);
        });

        backButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showDeleteEmployeeId(JFrame parentFrame, Employee employee) {
        JDialog dialog = new JDialog(parentFrame, "ID 입력", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setSize(300, 150);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dialog.add(idLabel, constraints);

        JTextField idField = new JTextField(20);
        constraints.gridx = 1;
        dialog.add(idField, constraints);

        JButton nextButton = new JButton("다음");
        constraints.gridx = 0;
        constraints.gridy = 1;
        dialog.add(nextButton, constraints);

        JButton cancelButton = new JButton("취소");
        constraints.gridx = 1;
        dialog.add(cancelButton, constraints);

        nextButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (id == employee.getId()) {
                    dialog.dispose();
                    showDeleteConfirmation(parentFrame, employee);
                } else {
                    JOptionPane.showMessageDialog(parentFrame, "ID가 일치하지 않습니다.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parentFrame, "잘못된 입력입니다. 숫자를 입력해 주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    public static void showDeleteConfirmation(JFrame parentFrame, Employee employee) {
        int response = JOptionPane.showConfirmDialog(parentFrame, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            set.DeleteEmployee(employee);
            JOptionPane.showMessageDialog(parentFrame, "직원 삭제 완료!");
        } else {
            JOptionPane.showMessageDialog(parentFrame, "삭제가 취소되었습니다.");
        }
    }
}
