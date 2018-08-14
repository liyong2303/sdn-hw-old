package com.ky.test;
/*
 *作者：barret
 *日期：2018年2月5日
 *
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test{


	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("month:"+month);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String currentTime = sdf.format(Calendar.getInstance().getTime());
		System.out.println("CurrentTime:"+currentTime);
	}
}
