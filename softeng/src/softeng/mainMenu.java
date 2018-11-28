package softeng;

import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import softeng.TodoList;

public class mainMenu {
	
	static HashMap<String,TodoList> TodoListMap;
	
	
   public static String mainMenuPrint() {
      return "1.Contact / 2. TodoList / 3. Appointment / 4. Quit \n \n 메뉴 입력 >>";
   }
   
   public static String subMenuPrint() {
	   return "1. Create / 2. View / 3. Save / 0. Go to Main \n \n 메뉴입력 >> ";
   }

   
   public static void CreateTodoList(String Due, String Description, String Today) {
	   Scanner s = new Scanner(System.in);
	   
	   System.out.println("기한을 입력하시오 : ");
	   Due=s.nextLine();
	   
	   System.out.println("내용을 입력하시오 : ");
	   Description=s.nextLine();
	   
	   SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
       Calendar c1 = Calendar.getInstance();
       Today = simple.format(c1.getTime());

       TodoList newtodo = new TodoList(Due, Description, Today);
       TodoListMap.put(Due, newtodo);
       
   }
   
   
   ContactDetails()
   
   
   
   
   
   
   
   
   
   
   
   
   
   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
      
	   
      Scanner s = new Scanner(System.in);
      map = new HashMap<String,TodoList>();
      
      while(true) {
         System.out.print(mainMenuPrint());
         String menu = s.nextLine();
         
         
         
         if (menu.equals("1")) {
            
            //contact 파일 오픈
            }
         else if (menu.equals("2")) {
        	 //todolist 파일 오픈
         }
         else if (menu.equals("3")) {
        	 //appointment 파일 오픈
         }
         else  if (menu.equals("4")) {
        	//끝내기
         }
         
         System.out.print(subMenuPrint());
         String submenu = s.nextLine();
         
         while (submenu.equals("0")) {
        	 
        	 if (menu.equals("1")) {
                 
                 //creat 함수 실행
                 }
              else if (menu.equals("2")) {
             	 //view 함수 실행
              }
              else if (menu.equals("3")) {
             	 //save 함수 실행
              }
              else {
            	  System.out.println("다시 입력 하세요");
              }
         }
      }
   }
            else
            {
            System.out.print("감독 : ");
            String temp2 = s.nextLine();
            System.out.print("장르 : ");
            String temp3 = s.nextLine();
            System.out.print("년도 : ");
            String temp4 = s.nextLine();
            int temp5 = Integer.parseInt(temp4);
            Movie temp = new Movie(temp1, temp2, temp3, temp5);
            map.put(temp1, temp);
            }
            
         }
         if(menu.equals("2")) {
            Iterator<String> keys = map.keySet().iterator();
            while ( keys.hasNext()) {
               String key = keys.next();
               System.out.println("["+map.get(key).getName()+map.get(key).getDir()+map.get(key).getGenre()+map.get(key).getYear()+"]");
            }
         }
         if (menu.equals("3")  ) {
            if (map.size() == 0){
               System.out.println("영화가 없습니다. "); 
               continue;
               }
            System.out.print("검색 제목 입력 : ");
            String key = s.nextLine();
            if(map.containsKey(key)) {
               System.out.println("["+map.get(key).getName()+map.get(key).getDir()+map.get(key).getGenre()+map.get(key).getYear()+"]");
            }
            else {
               System.out.print(key+"은/는 없습니다.");
            }
         }
         if (menu.equals("4")) { // 파일 저장
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("movie.dat"));
            ois.writeObject(map);
            System.out.println("movie.dat 에 저장되었습니다.");
            ois.close();
         }
         if (menu.equals("5")) { // 파일열기
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"));
            map = (HashMap<String, Movie>) ois.readObject();
            System.out.println("movie.dat 로부터 정보를 불러왔습니다. ");
            ois.close();
         }
         if (menu.equals("6")) {
            s.close();
            break;
            }
         
      }
   }

}



