import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

 public class Appointment {
	static Scanner scan = new Scanner(System.in);
	public int Date;
	public String Persons, Location;
	static ArrayList<Appointment> AppointmentMap = new ArrayList<Appointment>();
	
	static void createAppointment() {
		System.out.print("약속날짜(ex.20181201): ");
		int date = scan.nextInt();
		System.out.print("만나는 사람: ");
		String persons = scan.nextLine();
		System.out.print("약속장소: ");
		String location = scan.nextLine();
		
		Appointment appointmentTemp = new Appointment(date,persons,location);
		AppointmentMap.add(appointmentTemp);
		System.out.println("저장되었습니다.\n");
	}
	
	static void createAppointment(int Date, String Persons, String Location) {
		Appointment appointmentTemp = new Appointment(Date,Persons,Location);
		AppointmentMap.add(appointmentTemp);
		System.out.println("저장되었습니다.\n");
	}
	
	static void saveAppointment() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Appointment.txt"));
		oos.writeObject(AppointmentMap);
		System.out.println("Appointment.txt 에 저장되었습니다.");
		oos.close();
	}
	
	static void openAppointmentFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Appointment.txt"));
			AppointmentMap = (ArrayList<Appointment>)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException fnf){
			System.out.println("파일을 찾지 못하였습니다.");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	static void viewAppointment() {
		if(AppointmentMap.isEmpty()) {
			System.out.println("저장된 약속이 없습니다.\n");
			return;
		}
		else {
			System.out.println("=========================\n");
			
			for(int index = 0; index < AppointmentMap.size();index++) {
				int number = index + 1;
				System.out.println(number+". 약속날짜 : "+AppointmentMap.get(index).Date+"\n");
			}	
			System.out.println("=========================\n");
			viewAppointmentSubMenu();	
		}
	}
	
	static void printViewAppointmentDetails(int index) {
		System.out.println("약속날짜 : "+AppointmentMap.get(index).Date+"\t만나는 사람 : "+AppointmentMap.get(index).Persons+"\t약속장소 : "+AppointmentMap.get(index).Location+"\n");
	}
	
	static String UpdateTab="1";
	static String DeleteTab="2";
	static String GoBackTab="0";
	
	static void viewAppointmentSubMenu() {
		System.out.println("상세정보를 확인할 약속의 번호를 입력하세요 : ");
		int number = scan.nextInt();
		int index = number-1;
		
		if (index < AppointmentMap.size()) {
			printViewAppointmentDetails(index);
			
			System.out.println("1. Update 2. Delete 0. Go Back\n");
			System.out.println("메뉴선택 : ");
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
			System.out.println("저장된 약속이 없습니다.\n");
			return;
		}
	}
	
	static void updateAppointment(int index) {								
		
		if (index < AppointmentMap.size()) {									
			int tempDate = AppointmentMap.get(index).Date;
			String tempPersons = AppointmentMap.get(index).Persons;
			String tempLocation = AppointmentMap.get(index).Location;
			
			System.out.print("수정이 필요하지 않은 항목은 빈칸으로 두세요.\n");
			
			System.out.print("약속날짜(ex.20181201): ");
			int updateDate = scan.nextInt();							
			System.out.print("만나는 사람: ");
			String updatePersons = scan.nextLine();							
			System.out.print("약속장소: ");
			String updateLocation = scan.nextLine();						
			
			Integer updatedate = updateDate;
			if (!updatedate.equals("")) {tempDate = updateDate;}
			if(!updatePersons.equals("")) {tempPersons = updatePersons;}
			if(!updateLocation.equals("")) {tempLocation = updateLocation;}
			
			AppointmentMap.remove(index);
			Appointment.createAppointment(tempDate, tempPersons, tempLocation);
		}
		else {
			System.out.println("저장된 약속이 없습니다.");
			return;
		}
	}
	
	static void deleteAppointment(int index) {
		
		if (index < AppointmentMap.size()) {
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			String choice = scan.nextLine();
			
			if(choice.equals("y")) {
				AppointmentMap.remove(index);
				System.out.println("삭제되었습니다.\n");
			}
			else 
				System.out.println("취소되었습니다.\n");	
		}
		else {
			System.out.println("저장된 약속이 없습니다.\n");
			return;
		}
	}
	
	public Appointment(int Date, String Persons, String Location) {
		this.Date = Date; 
		this.Persons = Persons; 
		this.Location = Location;
	}
 }