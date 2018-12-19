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

		System.out.print("기한: ");
		String temp2 = scan.nextLine();

		System.out.print("내용: ");
		String temp3 = scan.nextLine();

		TodoList tempTodoList = new TodoList(temp1, temp2, temp3);

		TodoListMap.add(tempTodoList);

		System.out.println("저장되었습니다.\n");

		
	}
	
	static void createTodoList(String Today, String Due, String Description) {
		TodoList tempTodoList = new TodoList(Today, Due, Description);
		TodoListMap.add(tempTodoList);
	}

//다시해야함 save
	static void saveTodoList() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TodoList.txt"));
		oos.writeObject(TodoListMap);
		System.out.println("Contact.txt 에 저장되었습니다.");
		oos.close();
	}

//다시해야함 open
	static void openTodoListFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Contact.txt"));
			TodoListMap = (ArrayList<TodoList>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("파일을 찾지 못하였습니다.");
		} catch (IOException e) {
			System.out.println("에러가 나버렸습니다."); // 나중에 지울코듸;
			System.out.println(e);
		}

	}

	static void viewTodoListlist() {
		if (TodoListMap.isEmpty()) {
			System.out.println("저장된 일정이 없습니다.");
			return;
		} else {
			for (int index = 0; index < TodoListMap.size(); index++) {
				int number = index + 1;
				System.out.println(number + ". 이름 : " + TodoListMap.get(index).Today + "\n");
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
			System.out.println("수정되었습니다.");
		}
		
		else if (ViewSubMenu.equals(DeleteTab)) {
			
			System.out.println("정말 삭제하시겠습니까?");
			String choice = scan.nextLine();
			
			if(choice.equals("y")) {
				TodoList.deleteContact();
				System.out.println("삭제되었습니다.");
			}
			else 
				System.out.println("취소되었습니다.");
			
		}
	}

	static void deleteContact() {
		System.out.println("삭제하실 번호를 작성해주세요.");
		int index = scan.nextInt();

		if (index <= TodoListMap.size()) {
			index = index - 1;
			TodoListMap.remove(index);
		} else {
			System.out.println("저장된 항목이 없습니다.");
			return;
		}
	}

	static void updateContact() {

		System.out.println("수정하실 번호를 작성해주세요.");
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

			System.out.print("기한: ");
			String temp2 = scan.nextLine();
			System.out.print("내용: ");
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
			System.out.println("저장된 항목이 없습니다.");
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
