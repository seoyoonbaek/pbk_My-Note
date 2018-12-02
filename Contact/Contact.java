import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Contact {
	static Scanner scan = new Scanner(System.in);
	public String Name, PhoneNumber, Email;
		static HashMap<String,Contact> ContactMap = new HashMap<String,Contact>();
	
	static void createContact(String Name, String PhoneNumber, String Email) {
		/*System.out.print("이름: ");
		String temp1 = scan.nextLine();
		System.out.print("전화번호: ");
		String temp2 = scan.nextLine();
		System.out.print("이메일: ");
		String temp3 = scan.nextLine();
		Contact c = new Contact(temp1,temp2,temp3);*/
		Contact contact = new Contact(Name, PhoneNumber,Email);
		ContactMap.put(Name, contact);
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
			ContactMap = (HashMap<String,Contact>)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException fnf){
			System.out.println("파일을 찾지 못하였습니다.");
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	static void viewContact() {
		if(ContactMap.isEmpty()) {
			System.out.println("저장된 연락처가 없습니다.");
			return ;
		}
		Set<String> keys = ContactMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Contact details = ContactMap.get(name);
			System.out.println("이름 : "+details.Name+"\t연락처 : "+details.PhoneNumber+"\t이메일 : "+details.Email );
		}
	}
	static void deleteContact(String key) {
		if (ContactMap.containsKey(key)) {
			ContactMap.remove(key);
		}
		else {
			System.out.println("저장된 항목이 없습니다.");
			return;
		
		}
	}
	static void updateContact(String key) {
		if (ContactMap.containsKey(key)) {
			String tempName = ContactMap.get(key).Name;
			String tempPhoneNumber = ContactMap.get(key).PhoneNumber;
			String tempEmail = ContactMap.get(key).Email;
			System.out.print("이름: ");
			String temp1 = scan.nextLine();
			if (!temp1.equals("")) {tempName = temp1;}
			System.out.print("전화번호: ");
			String temp2 = scan.nextLine();
			if(!temp2.equals("")) {tempPhoneNumber = temp2;}
			System.out.print("이메일: ");
			String temp3 = scan.nextLine();
			if(!temp3.equals("")) {tempEmail = temp3;}
			ContactMap.remove(key);
			Contact.createContact(tempName, tempPhoneNumber, tempEmail);
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
