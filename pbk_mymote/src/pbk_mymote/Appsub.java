<<<<<<< HEAD
package pbk_mymote;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;





public class Appsub {

   public static String subMenu() {
	   
	   return "1. Create 2. View 3. Save 0. Go to Main\n\n 메뉴 입력 >>";
	   }
   
   static void CreateAppointment(int Date, String Persons, String Location) {
	  
	   Appointment appoint = new Appointment(Date, Persons, Location);
       map.put(Date, appoint);
	   }




   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

      // TODO Auto-generated method stub
      Scanner s = new Scanner(System.in);
      HashMap<String,Appointment> map = new HashMap<>();
      
      while(true) {
         System.out.print(subMenu());
         
         String submenu = s.nextLine();

         if (submenu.equals("1")) {

            System.out.print("약속 날짜 : ");
            int Date = s.nextInt();
            System.out.print("만나는 사람 : ");
            String Persons = s.nextLine();
            System.out.print("약속 장소 : ");
            String Location = s.nextLine();
            
            CreateAppointment(Date, Persons, Location);

          
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



=======
package pbk_mymote;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;





public class Appsub {

   public static String subMenu() {
	   
	   return "1. Create 2. View 3. Save 0. Go to Main\n\n 메뉴 입력 >>";
	   }
   
   static void CreateAppointment(int Date, String Persons, String Location) {
	  
	   Appointment appoint = new Appointment(Date, Persons, Location);
       map.put(Date, appoint);
	   }




   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

      // TODO Auto-generated method stub
      Scanner s = new Scanner(System.in);
      HashMap<String,Appointment> map = new HashMap<>();
      
      while(true) {
         System.out.print(subMenu());
         
         String submenu = s.nextLine();

         if (submenu.equals("1")) {

            System.out.print("약속 날짜 : ");
            int Date = s.nextInt();
            System.out.print("만나는 사람 : ");
            String Persons = s.nextLine();
            System.out.print("약속 장소 : ");
            String Location = s.nextLine();
            
            CreateAppointment(Date, Persons, Location);

          
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



>>>>>>> a06ec88016b0fd5bfe429f72b92d121793d737bc
}