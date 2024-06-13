package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.Utils;

public class EmployeeSet {
    final int MAX_SIZE = 100;    // 배열 길이
    int indexFullTime = 10101;            // 등록된 정규직 직원에 대한 인원 수
    int indexPartTime = 50101;            // 등록된 임시직 직원에 대한 인원 수
    List<Employee> employees;
    int index;

    public EmployeeSet() {
        employees = new ArrayList<>();
        index = 0;
    }

    public void RegisterFullTimeEmp(Scanner s) {
        System.out.println("");
        System.out.println(">>> 정규직 등록 <<<");

        int id = indexFullTime;
        String name = Utils.getName(s);
        DepartmentEnum department = Utils.getDepartment(s);
        PositionEnum position = Utils.getPosition(s);
        int grade = Utils.getGrade(s);

        employees.add(new FullTimeEmp(id, name, department, position, grade));
        indexFullTime++;
        index++;
    }

    public void RegisterPartTimeEmp(Scanner s) {
        System.out.println("");
        System.out.println(">>> 임시직 등록 <<<");

        int id = indexPartTime;
        String name = Utils.getName(s);
        DepartmentEnum department = Utils.getDepartment(s);
        int hours = Utils.getHours(s);

        employees.add(new PartTimeEmp(id, name, department, hours));
        indexPartTime++;
        index++;
    }

    public void SearchAll() {
        for (Employee employee : employees) {
            employee.print();
        }
    }

    public void searchFullTime() {
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmp) {
                employee.print();
            }
        }
    }

    public void searchPartTime() {
        for (Employee employee : employees) {
            if (employee instanceof PartTimeEmp) {
                employee.print();
            }
        }
    }

    public boolean searchName(Scanner s) {
        boolean find = true;

        System.out.println("검색할 이름을 입력하세요");
        String name = Utils.getName(s);
        for (Employee employee : employees) {
            if (employee.name.equals(name)) {
                employee.print();
                find = false;
            }
        }
        if (find) {
            System.out.println("!!! 해당 이름의 직원이 없습니다.");
            return false;
        }

        return true;
    }

    public Employee searchId(Scanner s) {
        while (true) {
            System.out.print(">> id: ");
            int id = s.nextInt();
            for (Employee employee : employees) {
                if (employee.id == id) {
                    return employee;
                }
            }

            System.out.println("!!! 해당 아이디의 직원이 없습니다.");
        }
    }

    public void UpdateById(Scanner s) {
        System.out.println("\n갱신할 직원의 id 확인을 위해 직원 이름을 검색합니다.\n");
        boolean check = false;
        while (!check) {
            check = searchName(s);
        }
        System.out.println("");

        System.out.println("정보를 갱신할 직원의 id를 입력하세요");
        Employee findByID = searchId(s);
        System.out.println("갱신할 정보를 입력하세요");
        if (findByID.id / 10000 == 1) {
            UpdateFullTime(s, (FullTimeEmp) findByID);
        } else {
            UpdatePartTime(s, (PartTimeEmp) findByID);
        }

        System.out.println("\n=== 갱신 결과 ===");
        findByID.print();

    }

    public void DeleteEmployee(Scanner s) {
        System.out.println("\n삭제할 직원의 id 확인을 위해 직원 이름을 검색합니다.\n");
        boolean check = false;
        while (!check) {
            check = searchName(s);
        }
        System.out.println("");

        System.out.println("삭제할 id를 입력하세요");
        Employee findByID = searchId(s);

        System.out.printf("\n%s 삭제하겠습니까? (1:예, 2:아니오)\n", findByID.name);
        int input = s.nextInt();
        if(input == 1){
            System.out.println("해당 직원을 삭제하였습니다.");
            DeleteEmployee(findByID);
        }else{
            System.out.println("작업을 취소하였습니다.");
        }

    }

    private void DeleteEmployee(Employee findByID) {
        employees.remove(findByID);
    }

    public void UpdateFullTime(Scanner s, FullTimeEmp employee) {
        employee.setName(Utils.getName(s));
        employee.setDepartment(Utils.getDepartment(s));
        employee.setPosition(Utils.getPosition(s));
        employee.setGrade(Utils.getGrade(s));
    }

    public void UpdatePartTime(Scanner s, PartTimeEmp employee) {
        employee.setName(Utils.getName(s));
        employee.setDepartment(Utils.getDepartment(s));
        employee.setHours(Utils.getHours(s));
    }
}
