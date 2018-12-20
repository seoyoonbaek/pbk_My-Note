
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Contact {
	static Scanner scan = new Scanner(System.in);
	public String Name, PhoneNumber, Email;
		static ArrayList<Contact> ContactMap = new ArrayList<Contact>();
	
	static void createContact(String Name, String PhoneNumber, String Email) {
		Contact contactTemp = new Contact(Name, PhoneNumber,Email);
		ContactMap.add(contactTemp);
		
	}
	static void saveContact() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Contact.txt"));
		oos.writeObject(ContactMap);
		System.out.println("Contact.txt 에 저장되었습니다.");
		oos.close();
	}
	static void openContactFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Contact.txt"));
			ContactMap = (ArrayList<Contact>)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException fnf){
			System.out.println("파일을 찾지 못하였습니다.");
		}
		catch(IOException e) {
			System.out.println("에러가 나버렸습니다."); //나중에 지울코듸;
			System.out.println(e);
		}
		
	}
	static void viewContactList() {
		if(ContactMap.isEmpty()) {
			System.out.println("저장된 연락처가 없습니다.");
			return ;
		}
		else {
			for(int index = 0; index<ContactMap.size();index++) {
				int number = index +1;
				System.out.println(number +". 이름 : "+ContactMap.get(index).Name+"\n");
			}
		}
	}

	static void deleteContact(int number) {
		if (number <= ContactMap.size()) {
			int index = number-1;
			ContactMap.remove(index);
		}
		else {
			System.out.println("저장된 항목이 없습니다.");
			return;
		}
	}
	static void updateContact(int index) {
		index=index-1;
		if (index < ContactMap.size()) {
			String Name = ContactMap.get(index).Name;
			String PhoneNumber = ContactMap.get(index).PhoneNumber;
			String Email = ContactMap.get(index).Email;
			
			System.out.print("이름: ");
			String tempName = scan.nextLine();
			System.out.print("전화번호: ");
			String tempPhoneNumber = scan.nextLine();
			System.out.print("이메일: ");
			String tempEmail = scan.nextLine();
			
			if (!tempName.equals("")) {Name = tempName;}
			if(!tempPhoneNumber.equals("")) {PhoneNumber = tempPhoneNumber;}
			if(!tempEmail.equals("")) {Email = tempEmail;}
			
			ContactMap.remove(index);
			Contact.createContact(Name, PhoneNumber, Email);
		}
		else {
			System.out.println("저장된 항목이 없습니다.");
		}
	}
	
	static void clearContactMap() {
		ContactMap.clear();
	}
	
	public Contact(String Name, String PhoneNumber, String Email) {
		this.Name = Name; this.PhoneNumber = PhoneNumber;
		this.Email = Email;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}