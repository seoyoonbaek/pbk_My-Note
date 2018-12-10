import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends TodoList {
	public Main(String Name, String PhoneNumber, String Email) {
		super(Name, PhoneNumber, Email);
		// TODO Auto-generated constructor stub
	}

	public static String mainMenu() {
		return "1. Contact 2. TodoList 3. Appointment 4. Quit ";
	}

	static String ContactTab;
	static String TodoListTab;
	static String AppointmentTab;
	static String QuitTab;

	public static String subMenu() {
		return "1. Create 2. View 3. Save \t 0. Go to Main";
	}

	static String CreateTab;
	static String ViewTab;
	static String SaveTab;
	static String GoToMainTab;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(mainMenu());
			String MainMenu;
			MainMenu = scan.nextLine();

			if (MainMenu.equals(ContactTab)) {

			}

			if (MainMenu.equals(TodoListTab)) {
				// 파일 오픈

				while (true) {
					System.out.println(subMenu());
					String SubMenu;
					SubMenu = scan.nextLine();

					if (SubMenu.equals(CreateTab)) {
						TodoList.createTodoList();
						continue;
					}

					else if (SubMenu.equals(ViewTab)) {
						System.out.println("========");
						TodoList.viewTodoListlist();
						System.out.println("========");

						TodoList.viewTodoListundermenu();
					}

					else if (SubMenu.equals(SaveTab)) {
					// 파일 저장
					}

			}
			if (MainMenu.equals(AppointmentTab)) {

			}

			else {
				System.out.println("종료하시겠습니까?");
				break;
			}
		}
		scan.close();

	}
}