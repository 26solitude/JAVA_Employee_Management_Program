package GUI;

import employee.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSet {
    final int MAX_SIZE = 100;
    int indexFullTime = 10101;
    int indexPartTime = 50101;
    List<Employee> employees;
    int index;
    private static final String FILENAME = "employees.txt";

    public EmployeeSet() {
        employees = new ArrayList<>();
        index = 0;
        loadFromFile();
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public void RegisterFullTimeEmp(String name, DepartmentEnum department, PositionEnum position, int grade) {
        int id = indexFullTime;
        employees.add(new FullTimeEmp(id, name, department, position, grade));
        indexFullTime++;
        index++;
        saveToFile();
    }

    public void RegisterPartTimeEmp(String name, DepartmentEnum department, int hours) {
        int id = indexPartTime;
        employees.add(new PartTimeEmp(id, name, department, hours));
        indexPartTime++;
        index++;
        saveToFile();
    }

    public void DeleteEmployee(Employee employee) {
        employees.remove(employee);
        saveToFile();
    }

    public void UpdateFullTime(FullTimeEmp employee, String name, DepartmentEnum department, PositionEnum position, int grade) {
        employee.setName(name);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setGrade(grade);
        saveToFile();
    }

    public void UpdatePartTime(PartTimeEmp employee, String name, DepartmentEnum department, int hours) {
        employee.setName(name);
        employee.setDepartment(department);
        employee.setHours(hours);
        saveToFile();
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Employee employee : employees) {
                writer.write(employee.toFileString());
                writer.newLine();
            }
            System.out.println("직원 정보가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            employees.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = Employee.fromFileString(line);
                if (employee != null) {
                    employees.add(employee);
                    if (employee instanceof FullTimeEmp) {
                        indexFullTime++;
                    } else if (employee instanceof PartTimeEmp) {
                        indexPartTime++;
                    }
                    index++;
                }
            }
            System.out.println("직원 정보가 성공적으로 불러와졌습니다.");
        } catch (IOException e) {
            System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
