package com.cognizant.truyum.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date)  {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date newDate;
		try {
			newDate = sdf.parse(date);
			return newDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
