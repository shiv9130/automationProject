package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	
	public int generateRandomNo() {
		Random rno = new Random();
		int random = rno.nextInt(999);
		return random;
		
	}
	
	public String currentdate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		String cDate = sdf.format(date);
		return cDate;
	}
	
	public String Nextdate(int days) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String cDate = sdf.format(date);
	    Calendar cal = sdf.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,days);
	    String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}

}
