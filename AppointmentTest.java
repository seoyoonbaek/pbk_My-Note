import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;

public class AppointmentTest {

	@BeforeEach
	void testappointmentinit() throws Exception {
		
		Appointment.createAppointment(20180301, "±èÀ¯Áø¹Ú°ÇÈñ", "ÇÐ±³");
		
		Appointment.saveAppointmentFile();
		Appointment.openAppointmentFile();
	}
	
	@Test
	void testcreateAppointment() {
		
		Appointment tempAppointment = new Appointment(20180301, "±èÀ¯Áø¹Ú°ÇÈñ", "ÇÐ±³");
		Appointment.AppointmentMap.add(tempAppointment);
		
		assertEquals(Appointment.AppointmentMap.get(0),Appointment.AppointmentMap.get(1));
	}
	
	@Test
	void testdeleteAppointment() {
		
		Appointment.deleteAppointment(0);
		Appointment.deleteAppointment(1);	
		assertNull(Appointment.AppointmentMap);
	}
}