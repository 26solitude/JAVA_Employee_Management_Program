package menus;

import java.util.Scanner;

import employee.EmployeeSet;
import utils.Utils;

public class Menu {
    static EmployeeSet set = new EmployeeSet();

    public MainMenuEnum MainMenu(Scanner s) {
        System.out.println("");
        System.out.println("======== Main GUIMenu ===");
        for (MainMenuEnum m : MainMenuEnum.values()) {
            System.out.println("  " + m.getCode() + ". " + m.getMessage());
        }

        int n;
        MainMenuEnum select = null;
        while (true) {
            n = Utils.checkInputInteger(s, "선택>>> ");

            // 유효한 값 입력 확인
            boolean valid = false;
            for (MainMenuEnum m : MainMenuEnum.values()) {
                if (n == m.getCode()) {
                    valid = true;
                    select = m;
                    break;
                }
            }

            if (valid) {
                break;
            }
            System.out.println("Invalid Input. Try again");
        }

        return select;
    }


    public RegisterMenuEnum RegisterMenu(Scanner s) {
        int n = 0;
        RegisterMenuEnum select = null;

        while (n != 19) {
            System.out.println("");
            System.out.println("======== Register GUIMenu ===");
            for (RegisterMenuEnum m : RegisterMenuEnum.values()) {
                System.out.println("  " + m.getCode() + ". " + m.getMessage());
            }

            while (true) {
                n = Utils.checkInputInteger(s, "선택>>> ");

                // 유효한 값 입력 확인
                boolean valid = false;
                for (RegisterMenuEnum m : RegisterMenuEnum.values()) {
                    if (n == m.getCode()) {
                        valid = true;
                        select = m;
                        switch (select) {
                            case REGISTER_FULL_TIME:
                                set.RegisterFullTimeEmp(s);
                                break;
                            case REGISTER_PART_TIME:
                                set.RegisterPartTimeEmp(s);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                }

                if (valid) {
                    break;
                }
                System.out.println("Invalid Input. Try again");
            }
        }

        return select;
    }

    public SearchMenuEnum SearchMenu(Scanner s) {
        int n = 0;
        SearchMenuEnum select = null;
        while (n != 29) {
            System.out.println("");
            System.out.println("======== Search GUIMenu ===");

            for (SearchMenuEnum m : SearchMenuEnum.values()) {
                System.out.println("  " + m.getCode() + ". " + m.getMessage());
            }

            select = null;
            while (true) {
                n = Utils.checkInputInteger(s, "선택>>> ");

                // 유효한 값 입력 확인
                boolean valid = false;
                for (SearchMenuEnum m : SearchMenuEnum.values()) {
                    if (n == m.getCode()) {
                        valid = true;
                        select = m;
                        switch (select){
                            case SEARCH_ALL :
                                set.SearchAll();
                                break;
                            case SEARCH_FULL_TIME:
                                set.searchFullTime();
                                break;
                            case SEARCH_PART_TIME:
                                set.searchPartTime();
                                break;
                            case SEARCH_NAME:
                                set.searchName(s);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                }

                if (valid) {
                    break;
                }
                System.out.println("Invalid Input. Try again");
            }
        }
        return select;
    }

    public UpdateMenuEnum UpdateMenu(Scanner s) {
        int n = 0;
        UpdateMenuEnum select = null;
        while (n != 39) {
            System.out.println("");
            System.out.println("======== Update GUIMenu ===");

            for (UpdateMenuEnum m : UpdateMenuEnum.values()) {
                System.out.println("  " + m.getCode() + ". " + m.getMessage());
            }

            select = null;
            while (true) {
                n = Utils.checkInputInteger(s, "선택>>> ");

                // 유효한 값 입력 확인
                boolean valid = false;
                for (UpdateMenuEnum m : UpdateMenuEnum.values()) {
                    if (n == m.getCode()) {
                        valid = true;
                        select = m;
                        switch (select){
                            case UPDATE_BY_ID:
                                set.UpdateById(s);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                }

                if (valid) {
                    break;
                }
                System.out.println("Invalid Input. Try again");
            }
        }
        return select;
    }

    public DeleteMenuEnum DeleteMenu(Scanner s) {
        int n = 0;
        DeleteMenuEnum select = null;

        while (n != 49) {
            System.out.println("");
            System.out.println("======== Delete GUIMenu ===");

            for (DeleteMenuEnum m : DeleteMenuEnum.values()) {
                System.out.println("  " + m.getCode() + ". " + m.getMessage());
            }

            select = null;
            while (true) {
                n = Utils.checkInputInteger(s, "선택>>> ");

                // 유효한 값 입력 확인
                boolean valid = false;
                for (DeleteMenuEnum m : DeleteMenuEnum.values()) {
                    if (n == m.getCode()) {
                        valid = true;
                        select = m;
                        switch (select){
                            case DELETE:
                                set.DeleteEmployee(s);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                }

                if (valid) {
                    break;
                }
                System.out.println("Invalid Input. Try again");
            }
        }

        return select;
    }
}
