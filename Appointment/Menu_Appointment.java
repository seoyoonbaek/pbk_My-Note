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


public class Menu_Appointment extends Appointment {
	public main(int Date, String Persons, String Location) {
		super(Date, Persons, Location);
		// TODO Auto-generated constructor stub
	}
	public static String printMainMenu() {											//
		System.out.println("1. Contact 2. TodoList 3. Appointment 4. Quit ");
	}
	
	static String ContactTab;
	static String TodoListTab;
	static String AppointmentTab;
	static String QuitTab;
	
	public static String printSubMenu() {											//
		System.out.println("1. Create 2. View 3. Save \t 0. Go to Main");
	}
	
	static String CreateTab;
	static String ViewTab;
	static String SaveTab;
	static String GoToMainTab;
	
	public static String printView_SubMenu() {										//
		System.out.println("1. Update 2. Delete 0. Go Back");
	}
	
	static String UpdateTab;
	static String DeleteTab;
	static String GoBackTab;
	
	public static String printDeleteCheck() {										//이름바꿈
		System.out.println("정말로 삭제하시겠습니까?(y/n) : ");		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		Scanner scan = new Scanner(System.in);
		
		ContactTab = CreateTab = UpdateTab = "1";
		TodoListTab = ViewTab = DeleteTab = "2";
		AppointmentTab = SaveTab = "3";
		GoToMainTab = GoBackTab = "0";
		
		//HashMap<String,TodoList> TodoListMap = new HashMap<String,TodoList>();
		//HashMap<Integer,Appointment> AppointmentMap = new HashMap<Integer,Appointment>();
		
		while(true) {
			printMainMenu();
			String mainMenuNum;
			mainMenuNum = scan.nextLine();
			
			if (mainMenuNum.equals("1")) {
				try {
					Contact.openContactFile();
					System.out.println("연락처를 불러왔습니다.");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				while(true) {
					printSubMenu();
					String subMenuNum;
					subMenuNum = scan.nextLine();
					
					if(subMenuNum.equals("1")) {
						Contact.createContact();
					}
					if(subMenuNum.equals("2")) {
						System.out.println("========");
						Contact.viewContact();
						System.out.println("========");
						
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
			
			if (mainMenuNum.equals("2")) {
				
			}
			
			if (mainMenuNum.equals("3")) {
				try {
					Appointment.openAppointmentFile();
					System.out.println("약속을 불러왔습니다.");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(true) {
					printSubMenu();
					String subMenuNum;
					subMenuNum = scan.nextLine();
		
					if(subMenuNum.equals("1")) {
						Appointment.createAppointment();
					}
					if(subMenuNum.equals("2")) {
						System.out.println("========");
						Appointment.viewAppointment();
						System.out.println("========");
					}
					if(subMenuNum.equals("3")) {
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
				System.out.println("종료하시겠습니까?");
			}
		}	
	}
}