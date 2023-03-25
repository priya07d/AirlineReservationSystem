package com.ars.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*This class is responsible for 
 * a global date time formatter to formate date time
 */
public class DateFormat {
	public static final DateTimeFormatter GlobalDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static LocalDateTime toLocalDateTime(String strDate) {
		return LocalDateTime.parse(strDate, GlobalDateFormatter);
	}
}
