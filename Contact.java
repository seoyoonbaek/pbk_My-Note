
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
	static void createContact() {
		System.out.println("�̸� : ");
		String Name = scan.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String PhoneNumber = scan.nextLine();
		System.out.println("�̸���");
		String Email = scan.nextLine();
		
		Contact tempContact = new Contact(Name,PhoneNumber,Email);
		ContactMap.add(tempContact);
		System.out.println("����Ǿ����ϴ�.");
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
	static void viewContactListDetails(int number) {
		int index = number -1;
		if(index < ContactMap.size()) {
			System.out.println("�̸� : "+ContactMap.get(index).Name);
			if(!ContactMap.get(index).PhoneNumber.equals("")) {
				System.out.println("��ȭ��ȣ : " + ContactMap.get(index).PhoneNumber);
			}
			if(!ContactMap.get(index).Email.equals("")) {
				System.out.println("�̸��� : "+ ContactMap.get(index).Email);
			}
		}
		else {
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
		}
	}
	static String UpdateTab = "1";
	static String DeleteTab = "2";
	static String GoBackTab = "3";
	
	static void viewContactListundermenu() {
		System.out.println("�� ������ Ȯ���� ����ó�� ��ȣ�� �Է��ϼ��� : ");
		int number = scan.nextInt();
		int index = number -1;
		String ViewSubMenu;
		
		if(index < ContactMap.size()) {
			viewContactListDetails(index);
			while(true) {
				System.out.println("1. Update    2. Delete   0. Go Back");
				System.out.println("�޴����� : ");
				ViewSubMenu = scan.nextLine();
				
				if(ViewSubMenu.equals(UpdateTab)) {
					updateContact(index);
				}
				else if (ViewSubMenu.equals(DeleteTab)) {
					deleteContact(index);
				}
				else if(ViewSubMenu.equals(GoBackTab)) {
					break;
				}
					
			}
		}
		
	}
	static void deleteContact(int index) {
		if (index < ContactMap.size()) {
			ContactMap.remove(index);
		}
		else {
			System.out.println("����� �׸��� �����ϴ�.");
			return;
		}
	}
	static void updateContact(int index) {
		if (index < ContactMap.size()) {
			String Name = ContactMap.get(index).Name;
			String PhoneNumber = ContactMap.get(index).PhoneNumber;
			String Email = ContactMap.get(index).Email;
			
			System.out.println("������ �ʿ����� ���� �׸��� ��ĭ���� �μ���.");
			
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
	public static void OpenContactFile() {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream("C:\\");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ContactMap = (ArrayList)oin.readObject();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void SaveContactFile() {
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		try {
			out = new FileOutputStream("C:\\");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			//ArrayList<Contact> list = new ArrayList<>();
			
			oout.writeObject(ContactMap);
			System.out.println("���� ���� ����");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oout.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public Contact(String Name, String PhoneNumber, String Email) {
		this.Name = Name; this.PhoneNumber = PhoneNumber;
		this.Email = Email;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}