package employeeTest;

import java.util.Scanner;

import menus.MainMenuEnum;
import menus.Menu;

public class EmployeeTest {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            MainMenuEnum mm = menu.MainMenu(scanner);
            if(mm == MainMenuEnum.REGISTER) {
                menu.RegisterMenu(scanner);
            }
            else if(mm == MainMenuEnum.SEARCH) {
                menu.SearchMenu(scanner);
            }
            else if( mm == MainMenuEnum.UPDATE){
                menu.UpdateMenu(scanner);
            }
            else if(mm == MainMenuEnum.DELETE){
                menu.DeleteMenu(scanner);
            }
            else if(mm == MainMenuEnum.EXIT) {
                System.out.print("Good BYE!");
                scanner.close();
                break;
            }
        }

        scanner.close();
    }
}
