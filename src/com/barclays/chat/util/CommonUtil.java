package com.barclays.chat.util;

import java.util.Date;

public class CommonUtil {
	
	public String getCurrentTime(){
		Date user_date = new Date();
		/*int hrs=user_date.getHours();
		int hrs = (int) (user_date.getHours() <10 ? "0"+user_date.getHours():user_date.getHours());
		int min = (int) (user_date.getMinutes() <10 ? "0"+user_date.getMinutes():user_date.getMinutes());
		int sec = (int) (user_date.getSeconds() <10 ? "0"+user_date.getSeconds():user_date.getSeconds());*/
		String cur_time = "";//(hrs+ ":"+ min+ ":"+sec);
		return cur_time;
		
	}

}
