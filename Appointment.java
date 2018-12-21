import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

 public class Appointment implements Serializable {
	static Scanner scan = new Scanner(System.in);
	public int Date;
	public String Persons, Location;
	static ArrayList<Appointment> AppointmentMap = new ArrayList<Appointment>();
	
	public Appointment(int Date, String Persons, String Location) {
		this.Date = Date; 
		this.Persons = Persons; 
		this.Location = Location;
	}
	
	static void createAppointment() {
		System.out.print("��ӳ�¥(ex.20181201): ");
		int date = scan.nextInt();
		System.out.print("������ ���: ");
		String persons = scan.nextLine();
		System.out.print("������: ");
		String location = scan.nextLine();
		
		Appointment appointmentTemp = new Appointment(date,persons,location);
		AppointmentMap.add(appointmentTemp);
		System.out.println("����Ǿ����ϴ�.\n");
	}
	
	static void createAppointment(int Date, String Persons, String Location) {
		Appointment appointmentTemp = new Appointment(Date,Persons,Location);
		AppointmentMap.add(appointmentTemp);
		System.out.println("����Ǿ����ϴ�.\n");
	}
	
	static void saveAppointmentFile() throws Exception {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\ssseoyoon\\pbk_My-Note\\Appointment.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
		
		try {
			oos.writeObject(AppointmentMap);
			oos.close();
			System.out.println("Appointment.txt �� ����Ǿ����ϴ�.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		oos.close();
	}
	
	static void openAppointmentFile() throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\ssseoyoon\\pbk_My-Note\\Appointment.txt");
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
			 		
		try {	
			ArrayList<Appointment> appointlist = (ArrayList<Appointment>) ois.readObject();
		}
		catch(FileNotFoundException e){
			System.out.println("������ ã�� ���Ͽ����ϴ�.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		ois.close();
	}
	
	static void viewAppointment() {
		if(AppointmentMap.isEmpty()) {
			System.out.println("����� ����� �����ϴ�.\n");
			return;
		}
		else {
			System.out.println("=========================\n");
			
			for(int index = 0; index < AppointmentMap.size(); index++) {
				int number = index + 1;
				System.out.println(number+". ��ӳ�¥ : "+AppointmentMap.get(index).Date+"\n");
			}	
			
			System.out.println("=========================\n");
			viewAppointmentSubMenu();	
		}
	}
	
	static void printViewAppointmentDetails(int index) {
		System.out.println("��ӳ�¥ : "+AppointmentMap.get(index).Date+"\t������ ��� : "+AppointmentMap.get(index).Persons+"\t������ : "+AppointmentMap.get(index).Location+"\n");
	}
	
	static String UpdateTab="1";
	static String DeleteTab="2";
	static String GoBackTab="0";
	
	static void viewAppointmentSubMenu() {
		System.out.println("�������� Ȯ���� ����� ��ȣ�� �Է��ϼ��� : ");
		int number = scan.nextInt();
		int index = number-1;
		
		if (index < AppointmentMap.size()) {
			printViewAppointmentDetails(index);
			
			System.out.println("1. Update 2. Delete 0. Go Back\n");
			System.out.println("�޴����� : ");
			String ViewSubMenu;
			ViewSubMenu = scan.nextLine();
		
			if(ViewSubMenu.equals(UpdateTab)) {
				updateAppointment(index);
			}
			else if(ViewSubMenu.equals(DeleteTab)) {
				deleteAppointment(index);
			}
			else 
				return;
		}
		else {
			System.out.println("����� ����� �����ϴ�.\n");
			return;
		}
	}
	
	static void updateAppointment(int index) {								
		if (index < AppointmentMap.size()) {									
			int tempDate = AppointmentMap.get(index).Date;
			String tempPersons = AppointmentMap.get(index).Persons;
			String tempLocation = AppointmentMap.get(index).Location;
			
			System.out.print("������ �ʿ����� ���� �׸��� ��ĭ���� �μ���.\n");
			
			System.out.print("��ӳ�¥(ex.20181201): ");
			int updateDate = scan.nextInt();							
			System.out.print("������ ���: ");
			String updatePersons = scan.nextLine();							
			System.out.print("������: ");
			String updateLocation = scan.nextLine();						
			
			Integer updatedate = updateDate;
			if (updatedate != null) {tempDate = updateDate;}
			if(!updatePersons.equals("")) {tempPersons = updatePersons;}
			if(!updateLocation.equals("")) {tempLocation = updateLocation;}
			
			AppointmentMap.remove(index);
			Appointment.createAppointment(tempDate, tempPersons, tempLocation);
		}
		else {
			System.out.println("����� ����� �����ϴ�.");
			return;
		}
	}
	
	static void deleteAppointment(int index) {
		if (index < AppointmentMap.size()) {
			System.out.println("���� �����Ͻðڽ��ϱ�?(y/n) : ");
			String choice = scan.nextLine();
			
			if(choice.equals("y")) {
				AppointmentMap.remove(index);
				System.out.println("�����Ǿ����ϴ�.\n");
			}
			else 
				System.out.println("��ҵǾ����ϴ�.\n");	
		}
		else {
			System.out.println("����� ����� �����ϴ�.\n");
			return;
		}
	}
 }