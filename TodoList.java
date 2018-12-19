import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TodoList {
	static Scanner scan = new Scanner(System.in);
	public String Today, Due, Description;
	static ArrayList<TodoList> TodoListMap = new ArrayList<TodoList>();

	static void createTodoList() {

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);
		String temp1 = mTime;

		System.out.print("����: ");
		String temp2 = scan.nextLine();

		System.out.print("����: ");
		String temp3 = scan.nextLine();

		TodoList tempTodoList = new TodoList(temp1, temp2, temp3);

		TodoListMap.add(tempTodoList);

		System.out.println("����Ǿ����ϴ�.\n");

		
	}
	
	static void createTodoList(String Today, String Due, String Description) {
		TodoList tempTodoList = new TodoList(Today, Due, Description);
		TodoListMap.add(tempTodoList);
	}

//�ٽ��ؾ��� save
	static void saveTodoList() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TodoList.txt"));
		oos.writeObject(TodoListMap);
		System.out.println("Contact.txt �� ����Ǿ����ϴ�.");
		oos.close();
	}

//�ٽ��ؾ��� open
	static void openTodoListFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Contact.txt"));
			TodoListMap = (ArrayList<TodoList>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("������ ã�� ���Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("������ �����Ƚ��ϴ�."); // ���߿� �����ڵ�;
			System.out.println(e);
		}

	}

	static void viewTodoListlist() {
		if (TodoListMap.isEmpty()) {
			System.out.println("����� ������ �����ϴ�.");
			return;
		} else {
			for (int index = 0; index < TodoListMap.size(); index++) {
				int number = index + 1;
				System.out.println(number + ". �̸� : " + TodoListMap.get(index).Today + "\n");
			}
		}
	}

	static String UpdateTab="1";
	static String DeleteTab="2";
	static String GoBackTab="0";

	static void viewTodoListundermenu() {
		
		System.out.println("1. Update 2. Delete 0. Go Back");
		String ViewSubMenu;
		ViewSubMenu = scan.nextLine();
		
		if (ViewSubMenu.equals(UpdateTab)) {
			TodoList.updateContact();
			System.out.println("�����Ǿ����ϴ�.");
		}
		
		else if (ViewSubMenu.equals(DeleteTab)) {
			
			System.out.println("���� �����Ͻðڽ��ϱ�?");
			String choice = scan.nextLine();
			
			if(choice.equals("y")) {
				TodoList.deleteContact();
				System.out.println("�����Ǿ����ϴ�.");
			}
			else 
				System.out.println("��ҵǾ����ϴ�.");
			
		}
	}

	static void deleteContact() {
		System.out.println("�����Ͻ� ��ȣ�� �ۼ����ּ���.");
		int index = scan.nextInt();

		if (index <= TodoListMap.size()) {
			index = index - 1;
			TodoListMap.remove(index);
		} else {
			System.out.println("����� �׸��� �����ϴ�.");
			return;
		}
	}

	static void updateContact() {

		System.out.println("�����Ͻ� ��ȣ�� �ۼ����ּ���.");
		int index = scan.nextInt();

		index = index - 1;
		if (index < TodoListMap.size()) {
			String tempToday = TodoListMap.get(index).Today;
			String tempDue = TodoListMap.get(index).Due;
			String tempDescription = TodoListMap.get(index).Description;

			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
			Date currentTime = new Date();
			String mTime = mSimpleDateFormat.format(currentTime);
			String temp1 = mTime;

			System.out.print("����: ");
			String temp2 = scan.nextLine();
			System.out.print("����: ");
			String temp3 = scan.nextLine();

			if (!temp1.equals("")) {
				tempToday = temp1;
			}
			if (!temp2.equals("")) {
				tempDue = temp2;
			}
			if (!temp3.equals("")) {
				tempDescription = temp3;
			}

			TodoListMap.remove(index);
			
			TodoList.createTodoList(tempToday, tempDue, tempDescription);
		} 
		
		else {
			System.out.println("����� �׸��� �����ϴ�.");
		}
	}

	static void clearTodoListMap() {
		TodoListMap.clear();
	}

	public TodoList(String Name, String PhoneNumber, String Email) {
		this.Today = Name;
		this.Due = PhoneNumber;
		this.Description = Email;
	}

	

}
