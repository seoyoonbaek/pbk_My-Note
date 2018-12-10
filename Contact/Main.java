/**
 * 
 */

/**
 * @author Mjolnir
 *
 */
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class main extends Contact {
	public main(String Name, String PhoneNumber, String Email) {
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
	
	public static String viewSubMenu() {
		return "1. Update 2. Delete 0. Go Back";
	}
	static String UpdateTab;
	static String DeleteTab;
	static String GoBackTab;
	
	public static String deleteCancel() {
		return "정말로 삭제하시겠습니까? y/n ";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Scanner scan = new Scanner(System.in);
		//Contact 해쉬맵 이름은 HashMap<String, Contact> ContactMap
		//HashMap<String,TodoList> TodoListMap = new HashMap<String,TodoList>();
		//HashMap<String,Appointment> AppointmentMap = new HashMap<String,Appointment>();
		
		ContactTab = CreateTab = UpdateTab = "1";
		TodoListTab = ViewTab = DeleteTab = "2";
		AppointmentTab = SaveTab = "3";
		GoToMainTab = GoBackTab = "0";
		while(true) {
			System.out.println(mainMenu());
			String MainMenu;
			MainMenu = scan.nextLine();
			if (MainMenu.equals(ContactTab)) {
				try {
					Contact.openContactFile();
					System.out.println("연락처를 불러왔습니다.");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(true) {
					System.out.println(subMenu());
					String SubMenu;
					SubMenu = scan.nextLine();
					if(SubMenu.equals(CreateTab)) {
						System.out.print("이름: ");
						String Name = scan.nextLine();
						System.out.print("전화번호: ");
						String PhoneNumber = scan.nextLine();
						System.out.print("이메일: ");
						String Email = scan.nextLine();
						Contact.createContact(Name, PhoneNumber, Email);
						System.out.println("저장되었습니다.\n");
						continue;
					}
					if(SubMenu.equals(ViewTab)) {
						System.out.println("========");
						Contact.viewContactList();
						System.out.println("========");
						
						System.out.println(viewSubMenu());
						String ViewSubMenu;
						ViewSubMenu = scan.nextLine();
						if (ViewSubMenu.equals(UpdateTab)) {
							System.out.println("수정하실 번호를 작성해주세요.");
							int index = scan.nextInt();
							Contact.updateContact(index);
							System.out.println("수정되었습니다.");
						}
						if (ViewSubMenu.equals(DeleteTab)) {
							System.out.println("삭제하실 번호를 작성해주세요.");
							int index = scan.nextInt();
							System.out.println(deleteCancel());
							String choice = scan.nextLine();
							if(choice.equals("y")) {
								Contact.deleteContact(index);
								System.out.println("삭제되었습니다.");
							}
							else {
								System.out.println("취소되었습니다.");
							}
						}
						
						
					}
					if(SubMenu.equals(SaveTab)) {
						try {
							Contact.saveContact();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else {continue;}
					
				}
				
			}
			if (MainMenu.equals(TodoListTab)) {
				
			}
			if (MainMenu.equals(AppointmentTab)) {
				
			}
			else	{
				System.out.println("종료하시겠습니까?");
				break;
			}
		}scan.close();
		
		
	}
}