import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Appointment {
	public Main_A(int Date, String Persons, String Location) {
		super(Date, Persons, Location);
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
		// TODO Auto-generated method stub 
		Scanner scan = new Scanner(System.in);
		
		ContactTab = CreateTab = "1";
		TodoListTab = ViewTab = "2";
		AppointmentTab = SaveTab = "3";
		GoToMainTab = "0";
		
		//HashMap<String,TodoList> TodoListMap = new HashMap<String,TodoList>();
		//HashMap<Integer,Appointment> AppointmentMap = new HashMap<Integer,Appointment>();
		
		while(true) {
			System.out.println(mainMenu());
			String MainMenu;
			String mainMenuNum;
			mainMenuNum = scan.nextLine();
			
			if (mainMenuNum.equals(ContactTab)) {
				try {
					Contact.openContactFile();
					System.out.println("연락처를 불러왔습니다.");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				while(true) {
					System.out.println(subMenu());
					String subMenuNum;
					subMenuNum = scan.nextLine();
					
					if(subMenuNum.equals(CreateTab)) {
						Contact.createContact();
					}
					if(subMenuNum.equals(ViewTab))) {
						Contact.viewContact;						
					}
					if(subMenuNum.equals("3")) {
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
					else
						break;
				}
			}
			
			else if (mainMenuNum.equals(TodoListTab)) {
				// 파일 오픈

				while (true) {
					System.out.println(subMenu());
					String SubMenu;
					SubMenu = scan.nextLine();

					if (SubMenu.equals(CreateTab)) {
						TodoList.createTodoList();
					}

					else if (SubMenu.equals(ViewTab)) {
						TodoList.viewTodoListlist();
					}

					else if (SubMenu.equals(SaveTab)) {
					// 파일 저장
					}
				
			}			
			
			else if (mainMenuNum.equals(AppointmentTab)) {
				try {
					Appointment.openAppointmentFile();
					System.out.println("약속을 불러왔습니다.");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(true) {
					System.out.println(subMenu());
					String subMenuNum;
					subMenuNum = scan.nextLine();
		
					if(subMenuNum.equals(CreateTab)) 
						createAppointment();
					
					else if(subMenuNum.equals(ViewTab)) 
						viewAppointment();
					
					else if(subMenuNum.equals(SaveTab)) {
						try {
							Appointment.saveAppointment();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						break;
				}
			}
			else	{
				System.out.println("종료하시겠습니까?(y/n) : ");	
				String choice = scan.nextLine();
				
				if(choice.equals("y")) 
					break;
				else 
					continue;
			}
		}	
	}
}