import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Contact {
	static Scanner scan = new Scanner(System.in);
	public String Name, PhoneNumber, Email;
		static ArrayList<Contact> ContactMap = new ArrayList<Contact>();
	
	static void createContact(String Name, String PhoneNumber, String Email) {
		/*System.out.print("�̸�: ");
		String temp1 = scan.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String temp2 = scan.nextLine();
		System.out.print("�̸���: ");
		String temp3 = scan.nextLine();
		Contact c = new Contact(temp1,temp2,temp3);*/
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
	/* ���⼭ ���� ������ �̸��� �Ҷ�� ������ �Ұ��� �ƴϸ� �̸� ��ȭ��ȣ �̸��� �� �Ҷ�� ������ �ϰ� �ٷ� ������Ʈ ����Ʈ �޴� ������,,,
	static void viewContactDetails(int Number) {
		if(ContactMap.isEmpty()) {
			System.out.println("����� ����ó�� �����ϴ�.");
		}
		else {
				int index = Number -1;
				System.out.println("�̸� : "+ContactMap.get(index).Name+"\t����ó : "+ContactMap.get(index).PhoneNumber+"\t�̸��� : "+ContactMap.get(index).Email+"\n");
			
		}
	}*/ //���� ����ڽ��ϴ�;
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
			String tempName = ContactMap.get(index).Name;
			String tempPhoneNumber = ContactMap.get(index).PhoneNumber;
			String tempEmail = ContactMap.get(index).Email;
			
			System.out.print("�̸�: ");
			String temp1 = scan.nextLine();
			System.out.print("��ȭ��ȣ: ");
			String temp2 = scan.nextLine();
			System.out.print("�̸���: ");
			String temp3 = scan.nextLine();
			
			if (!temp1.equals("")) {tempName = temp1;}
			if(!temp2.equals("")) {tempPhoneNumber = temp2;}
			if(!temp3.equals("")) {tempEmail = temp3;}
			
			ContactMap.remove(index);
			Contact.createContact(tempName, tempPhoneNumber, tempEmail);
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
