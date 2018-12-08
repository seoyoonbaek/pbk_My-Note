import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Appointment {
	static Scanner scan = new Scanner(System.in);
	
	public int Date;
	public String Persons, Location;
	
	static ArrayList<Appointment> AppointmentMap = new ArrayList<Appointment>();
	
	static void createAppointment(int Date, String Persons, String Location) {
		System.out.print("약속날짜: ");
		int date = scan.nextLine();
		System.out.print("만나는 사람: ");
		String persons = scan.nextLine();
		System.out.print("약속장소: ");
		String location = scan.nextLine();
		
		Appointment appointmentTemp = new Appointment(date,persons,location);
		AppointmentMap.add(appointmentTemp);
	}
	
	static void saveAppointment() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Appointment.txt"));
		oos.writeObject(AppointmentMap);
		System.out.println("Appointment.txt 에 저장되었습니다.");
		oos.close();
	}
	
	static void openContactFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Appointment.txt"));
			AppointmentMap = (HashMap<Integer,Appointment>)ois.readObject();
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
			System.out.println("저장된 약속이 없습니다.");
			return;
		}
		else {
			for(int index = 0; index < AppointmentMap.size();index++) {
				int number = index + 1;
				System.out.println(number+". 약속날짜 : "+AppointmentMap.get(index).Date+"\n");
			}
		}
	}
	
	static void printViewAppointmentDetails() {
		System.out.println("약속날짜 : "+AppointmentMap.get(index).Date+"\t만나는 사람 : "+AppointmentMap.get(index).Persons+"\t약속장소 : "+AppointmentMap.get(index).Location+"\n");
	}
	
	static void viewAppointmentDetails(int Number) {
		if(AppointmentMap.isEmpty()) {
			System.out.println("저장된 약속이 없습니다.");
		}
		else {
			int index = Number - 1;
			printViewAppointmentDetails();
		}
	}
		
	static void deleteAppointment(int number) {
		if (number <= AppointmentMap.size()) {
			int index = number-1;
			AppointmentMap.remove(index);
		}
		else {
			System.out.println("저장된 항목이 없습니다.");
			return;
		}
	}
	static void updateAppointment(int number) {								//index를 number로 바꿈
		index = number-1;
		
		if (index <= ContactMap.size()) {									//등호 넣음
			String tempDate = AppointmentMap.get(index).Date;
			String tempPersons = AppointmentMap.get(index).Persons;
			String tempLocation = AppointmentMap.get(index).Location;
			
			//System.out.print("수정이 필요하지 않은 항목은 빈칸으로 두세요.");
			
			System.out.print("약속날짜: ");
			String updateDate = scan.nextLine();							//temp1 -> updateDate로 수정
			System.out.print("만나는 사람: ");
			String updatePersons = scan.nextLine();							//수정
			System.out.print("약속장소: ");
			String updateLocation = scan.nextLine();						//수정
			
			if (!temp1.equals("")) {tempDate = updateDate;}
			if(!temp2.equals("")) {tempPersons = updatePersons;}
			if(!temp3.equals("")) {tempLocation = updateLocation;}
			
			AppointmentMap.remove(index);
			Appointment.createAppointment(tempDate, tempPersons, tempLocation);
		}
		else {
			System.out.println("저장된 항목이 없습니다.");
		}
	}
	
	static void clearAppointmentMap() {
		AppointmentMap.clear();
	}
	
	public Appointment(int Date, String Persons, String Location) {
		this.Date = Date; this.Persons = Persons; this.Location = Location;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
