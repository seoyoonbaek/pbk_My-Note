import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TodoList implements Serializable {
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

	static void viewTodoListlist() {
		if (TodoListMap.isEmpty()) {
			System.out.println("����� ������ �����ϴ�.");
			return;
		} else {
			
			System.out.println("=========================\n");
			for (int index = 0; index < TodoListMap.size(); index++) {
				int number = index + 1;
				System.out.println(number + ". ���� : " + TodoListMap.get(index).Due + "\n");
			}
			System.out.println("=========================\n");
			viewTodoListundermenu();	
		}
	
	}
	
	static void printViewTodoListDetails(int index) {
		System.out.println("���ó�¥ : "+TodoListMap.get(index).Today+"\t���� : "+TodoListMap.get(index).Due+"\t���� : "+TodoListMap.get(index).Description+"\n");
	}

	static String UpdateTab = "1";
	static String DeleteTab = "2";
	static String GoBackTab = "0";

	static void viewTodoListundermenu() {
		
		System.out.print("�������� Ȯ���� todolist�� ��ȣ�� �Է��ϼ��� : ");
		int number = scan.nextInt();
		int index = number-1;
		String ViewSubMenu;

		if (index < TodoListMap.size()) {
			printViewTodoListDetails(index);
			while(true) {
			System.out.println("1. Update 2. Delete 0. Go Back\n");
			System.out.println("�޴����� : ");  //�� �ι� ��µǴ��� ���� �� �� �� �� ��
			ViewSubMenu = scan.nextLine();
		
			if(ViewSubMenu.equals(UpdateTab)) {
				updateTodoList(index);
			}
			else if(ViewSubMenu.equals(DeleteTab)) {
				deleteTodoList(index);
			}
			
			else if(ViewSubMenu.equals(GoBackTab)) {
				break;
			}
		}}
		else {
			System.out.println("����� ����� �����ϴ�.\n");
			return;
		}
	}

	static void deleteTodoList(int index) {
		if (index < TodoListMap.size()) {
			System.out.println("���� �����Ͻðڽ��ϱ�?(y/n) : ");
			String choice = scan.nextLine();
			
			if(choice.equals("y")) {
				TodoListMap.remove(index);
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

	static void updateTodoList(int index) {

		if (index < TodoListMap.size()) {									
			String tempToday = TodoListMap.get(index).Today;
			String tempDue = TodoListMap.get(index).Due;
			String tempDescription = TodoListMap.get(index).Description;
			
			System.out.print("������ �ʿ����� ���� �׸��� ��ĭ���� �μ���.\n");
			
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
			Date currentTime = new Date();
			String mTime = mSimpleDateFormat.format(currentTime);
			String updateToday = mTime;
			
			System.out.print("����: ");
			String updateDue = scan.nextLine();							
			System.out.print("����: ");
			String updateDescription = scan.nextLine();						
			
			if (!updateToday.equals("")) {tempToday = updateToday;}
			if(!updateDue.equals("")) {tempDue = updateDue;}
			if(!updateDescription.equals("")) {tempDescription = updateDescription;}
			
			TodoListMap.remove(index);
			TodoList.createTodoList(tempToday, tempDue, tempDescription);
		}
		else {
			System.out.println("����� ������ �����ϴ�.");
			return;
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

	public static void fileOpen() {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		try {
			in = new FileInputStream("C:\\Users\\sookmyung\\Desktop\\pbk_My-Note\\TodoList.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);

			TodoListMap = (ArrayList) oin.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void fileSave() {

		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("C:\\Users\\sookmyung\\Desktop\\pbk_My-Note\\TodoList.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			ArrayList<TodoList> list = new ArrayList<>();

			oout.writeObject(TodoListMap);
			System.out.println("���� ���� ����");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
