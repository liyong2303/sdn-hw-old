package com.ky.util.countTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	private Logger log = LoggerFactory.getLogger(DateUtil.class);
	public static int getCurrentYearMonth() {
		return Integer.parseInt(new SimpleDateFormat("yyyyMM").format(Calendar.getInstance().getTime()));
	}

	public static String getWeekOfDate() {
		Date now = new Date();
		String[] weekdays = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" };
		Calendar c = Calendar.getInstance();
		c.setTime(now);

		int w = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;

		return weekdays[w];
	}
	
	 public static int countMin(Date beginTime, Date endTime) {
		long b = getDate(beginTime).getTime();
		long e = getDate(endTime).getTime();
		int cnt = (int) (e - b) / (1000 * 60);  //计算分钟
		if((e - b) % (1000 * 60)>0){          //
			cnt=cnt+1;
		}
		return cnt;
	}
	 
	 public static int countMins(Date beginTime, Date endTime) {
		 long b = new Date(beginTime.getYear(), beginTime.getMonth(), beginTime.getDate(), beginTime.getHours(), beginTime.getMinutes(), beginTime.getSeconds()).getTime();
		 long e = new Date(endTime.getYear(), endTime.getMonth(), endTime.getDate(), endTime.getHours(), endTime.getMinutes(), endTime.getSeconds()).getTime();
		 System.out.println("开始时间戳：\t" + b + "\t结束时间戳：\t" + e);
		 int cnt = (int) (e - b) / (1000 * 60);  //计算分钟
		 if((e - b) % (1000 * 60)>0){          //
			 cnt=cnt+1;
		 }
		 return cnt;
	 }
	 
	public static long countSec(Date beginTime, Date endTime){
		 return (endTime.getTime()-beginTime.getTime())/1000;
	 }
	 
	public static Date setQueryTime(String time) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("HHmm");
		Date d=format.parse(time);
		Date now=new Date();
		d.setYear(now.getYear());
		d.setMonth(now.getMonth());
		d.setDate(now.getDate());
//		d.setSeconds(now.getSeconds());
		return d;
	}
 /*  public static void main(String[] args) throws ParseException {
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  
	   Date now=new Date();
	   String str="2018-03-20 17:54:49";
	   Date d=sdf.parse(str);
	   System.out.println(sdf.format(d));
	   System.out.println(sdf.format(now));
	   System.out.println(countSec(d, now));
	   
	   System.out.println(sdf.format(setQueryTime("1759")));
}*/
	
	public static void main(String[] args) throws InterruptedException {
		/*for (int i = 0; i < 100; i++) {
			Date d1 = new Date();
			System.out.println(d1.getTime()+"---------------"+d1);
			Thread.sleep(500);
			Date d2 = new Date();
			System.out.println(d2.getTime()+"--------------"+d2);
			System.out.println("-------------------------:"+countMins(d1, d2));
		}*/
		Date d = new Date();
		System.out.println(d);
		Date d2 = getDate(d);
		System.out.println(d2);
	}
	
	public static Date getDate(Date date){
		if(date != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.MILLISECOND, 0);
//			System.out.println(calendar.get(Calendar.DATE));
//			System.out.println(calendar.getTime());
			return calendar.getTime();
		}
		return null;
	} 
}
