/**
 * 
 */

/**
 * @author Mjolnir
 *
 */
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class Contact_01 extends Contact{
	public Contact_01(String Name, String PhoneNumber, String Email) {
		super(Name, PhoneNumber, Email);
		// TODO Auto-generated constructor stub
	}
	public static String mainMenu() {
		return "1. Contact 2. TodoList 3. Appointment 4. Quit ";
	}
	public static String subMenu() {
		return "1. Create 2. View 3. Save \t 0. Go to Main";
	}
	public static String ViewSubMenu() {
		return "1. Update 2. Delete 0. Go Back";
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub 
		Scanner scan = new Scanner(System.in);
		HashMap<String,Contact> ContactMap = new HashMap<String,Contact>();
		HashMap<String,TodoList> todoList = new HashMap<String,TodoList>();
		HashMap<String,Appointment> app = new HashMap<String,Appointment>();
		
		
		while(true) {
			System.out.print(mainMenu());
			String main = scan.nextLine();
			if (main.equals("1")) { //Contact
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Contact.dat"));
				ContactMap = (HashMap<String,Contact>) ois.readObject();
				ois.close();
				while(true) {
				System.out.print(subMenu());
				String sub = scan.nextLine();
				if (sub.equals("1")) { //create
					System.out.print("이름: ");
					String temp1 = scan.nextLine();
					System.out.print("전화번호: ");
					String temp2 = scan.nextLine();
					System.out.print("이메일: ");
					String temp3 = scan.nextLine();
					
					Contact c = new Contact(temp1,temp2,temp3);
					ContactMap.put(temp1, c);
				
				}
				if (sub.equals("2")) { //view
					
					Iterator<String> keys = ContactMap.keySet().iterator();
					int i = 1;
					while(keys.hasNext()) {
						String key = keys.next();
						System.out.println(i+". "+ContactMap.get(key).Name+ContactMap.get(key).PhoneNumber+ContactMap.get(key).Email);
						i++;
					}
					String vsMenu;
					while(true) {
						System.out.print(ViewSubMenu());
						vsMenu = scan.nextLine();
						
						if (vsMenu.equals("1")){//update
						
							
						}
						if (vsMenu.equals("2")){//delete
						
						}
						if (vsMenu.equals("0")){break;} //go back
					}
				if (sub.equals("3")) { //Save
					ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream("Contact.dat"));
					oos.writeObject(ContactMap);
					System.out.println("Contact.dat 에 저장되었습니다.");
					oos.close();
				}
				if (sub.equals("0")) {break;}
				}
			}
			if (main.equals("2")) {
				
			}
			if (main.equals("3")) {
				
			}
			if (main.equals("4")) {break;}
			
			
		}
		scan.close();
		}


	}
}