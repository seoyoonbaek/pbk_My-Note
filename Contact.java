
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
		System.out.println("Contact.txt �� ����Ǿ����ϴ�.");
		oos.close();
	}
	static void openContactFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Contact.txt"));
			ContactMap = (ArrayList<Contact>)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException fnf){
			System.out.println("������ ã�� ���Ͽ����ϴ�.");
		}
		catch(IOException e) {
			System.out.println("������ �����Ƚ��ϴ�."); //���߿� �����ڵ�;
			System.out.println(e);
		}
		
	}
	static void viewContactList() {
		if(ContactMap.isEmpty()) {
			System.out.println("����� ����ó�� �����ϴ�.");
			return ;
		}
		else {
			for(int index = 0; index<ContactMap.size();index++) {
				int number = index +1;
				System.out.println(number +". �̸� : "+ContactMap.get(index).Name+"\n");
			}
		}
	}

	static void deleteContact(int number) {
		if (number <= ContactMap.size()) {
			int index = number-1;
			ContactMap.remove(index);
		}
		else {
			System.out.println("����� �׸��� �����ϴ�.");
			return;
		}
	}
	static void updateContact(int index) {
		index=index-1;
		if (index < ContactMap.size()) {
			String Name = ContactMap.get(index).Name;
			String PhoneNumber = ContactMap.get(index).PhoneNumber;
			String Email = ContactMap.get(index).Email;
			
			System.out.print("�̸�: ");
			String tempName = scan.nextLine();
			System.out.print("��ȭ��ȣ: ");
			String tempPhoneNumber = scan.nextLine();
			System.out.print("�̸���: ");
			String tempEmail = scan.nextLine();
			
			if (!tempName.equals("")) {Name = tempName;}
			if(!tempPhoneNumber.equals("")) {PhoneNumber = tempPhoneNumber;}
			if(!tempEmail.equals("")) {Email = tempEmail;}
			
			ContactMap.remove(index);
			Contact.createContact(Name, PhoneNumber, Email);
		}
		else {
			System.out.println("����� �׸��� �����ϴ�.");
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