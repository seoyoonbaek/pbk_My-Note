import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

public class JonggangTest {

	SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
	Date currentTime = new Date();
	String mTime = mSimpleDateFormat.format(currentTime);
	
	
	@BeforeEach
	void testinit() {
		
		TodoList.createTodoList(mTime, "12/21", "종강");
		TodoList.fileSave();
		TodoList.fileOpen();
		
	}
	
	@Test
	void testdeleteTodoList() {
		TodoList.deleteTodoList(0);
		
		String input = "y";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
		assertNull(TodoList.TodoListMap);
	}
	
	@Test
	void testcreateTodoList() {
		TodoList.createTodoList(mTime, "12/26", "크리스마스파티");
		
		TodoList tempTodoList = new TodoList(mTime, "12/26", "크리스마스파티");
		TodoList.TodoListMap.add(tempTodoList);
		
		assertEquals(TodoList.TodoListMap.get(1),TodoList.TodoListMap.get(2));
	}

}
