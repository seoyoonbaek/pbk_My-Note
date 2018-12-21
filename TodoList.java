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

	static void viewTodoListlist() {
		if (TodoListMap.isEmpty()) {
			System.out.println("저장된 일정이 없습니다.");
			return;
		} else {
			
			System.out.println("=========================\n");
			for (int index = 0; index < TodoListMap.size(); index++) {
				int number = index + 1;
				System.out.println(number + ". 기한 : " + TodoListMap.get(index).Due + "\n");
			}
			System.out.println("=========================\n");
			viewTodoListundermenu();	
		}
	
	}
	
	static void printViewTodoListDetails(int index) {
		System.out.println("오늘날짜 : "+TodoListMap.get(index).Today+"\t기한 : "+TodoListMap.get(index).Due+"\t내용 : "+TodoListMap.get(index).Description+"\n");
	}

	static String UpdateTab = "1";
	static String DeleteTab = "2";
	static String GoBackTab = "0";

	static void viewTodoListundermenu() {
		
		System.out.print("상세정보를 확인할 todolist의 번호를 입력하세요 : ");
		int number = scan.nextInt();
		int index = number-1;
		String ViewSubMenu;

		if (index < TodoListMap.size()) {
			printViewTodoListDetails(index);
			while(true) {
			System.out.println("1. Update 2. Delete 0. Go Back\n");
			System.out.println("메뉴선택 : ");  //왜 두번 출력되는지 정말 알 수 없 음 ㅜ
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
			System.out.println("저장된 약속이 없습니다.\n");
			return;
		}
	}

	static void deleteTodoList(int index) {
		if (index < TodoListMap.size()) {
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			String choice = scan.nextLine();
			
			if(choice.equals("y")) {
				TodoListMap.remove(index);
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

	static void updateTodoList(int index) {

		if (index < TodoListMap.size()) {									
			String tempToday = TodoListMap.get(index).Today;
			String tempDue = TodoListMap.get(index).Due;
			String tempDescription = TodoListMap.get(index).Description;
			
			System.out.print("수정이 필요하지 않은 항목은 빈칸으로 두세요.\n");
			
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
			Date currentTime = new Date();
			String mTime = mSimpleDateFormat.format(currentTime);
			String updateToday = mTime;
			
			System.out.print("기한: ");
			String updateDue = scan.nextLine();							
			System.out.print("일정: ");
			String updateDescription = scan.nextLine();						
			
			if (!updateToday.equals("")) {tempToday = updateToday;}
			if(!updateDue.equals("")) {tempDue = updateDue;}
			if(!updateDescription.equals("")) {tempDescription = updateDescription;}
			
			TodoListMap.remove(index);
			TodoList.createTodoList(tempToday, tempDue, tempDescription);
		}
		else {
			System.out.println("저장된 일정이 없습니다.");
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
			System.out.println("파일 저장 성공");

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
