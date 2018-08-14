package com.ky.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * 日期工具包
 * @author ahua
 */
public class DateUtil
{
    private static final Logger log = Logger.getLogger(DateUtil.class);
    public static final String DETAIL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    public static final String TABLE_FORMAT = "yyyyMM";
    public static final int MILLISECONDS_PER_SECOND = 1000;
    public static final String datetimeformat = "yyyy-MM-dd HH:mm:ss";
    public static final String dateformat = "yyyy-MM-dd";
    public static final String year = "yyyy";
    public static final String month = "MM";
    public static final String format = "yyyyMMddHHmmss";
    public static final String OPRTIMEF_FORMAT = "yyyyMMddHHmmss";
    public static final String DATESEQ_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String DATEFORMAT2 = "yyyyMMdd";
    public static final String DATEFORMAT3 = "yyyy/MM/dd HH:mm";
    public static final String DATEFORMAT4 = "yyyy-MM-dd HH:mm:ss";
    public static final String GOLD_DATEFORMAT = "yyyyMMddHHmm";
    public static final String TIME = "HH:mm:ss";

    /**
     * 获取当前日期+时间
     */
    public static String getDatetime()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datetimeformat);
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    /**
     * 获取当前时间
     */
    public static String getTime()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME);
        String datetime = dateFormat.format(date);
        return datetime;
    }

    /**
     * 获取当前日期+时间
     * @param date
     * @return String [返回类型]
     */
    public static String getDatetime(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(datetimeformat);
        String datetime = dateFormat.format(date);
        return datetime;
    }

    /**
     * 按指定格式返回String
     * @param aMask
     * @param date
     * @return
     */
    public static String getDatetime_3(String aMask,Date date){
    	SimpleDateFormat dateFormat = new SimpleDateFormat(aMask);
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    /**
     * 获取当前日期+时间
     */
    public static String getDatetime_2()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String datetime = dateFormat.format(date);
        return datetime;
    }

    /**
     * 得到类似20100717000815格式的时间
     * @return yyyyMMddHHmmss
     */
    public static String getOprtime()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(OPRTIMEF_FORMAT);
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    /**
     * 得到类似20100717000815364格式的序列
     * @return yyyyMMddHHmmssSSS
     */
    public static String getDateSeq()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATESEQ_FORMAT);
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    /**
     * 得到类似20100717000815364000格式的序列
     * @return yyyyMMddHHmmssSSS+3位随机数
     */
    public static String getDateRanSeq()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATESEQ_FORMAT);
        String datetime = dateFormat.format(date);
        Random rand =new Random();
        int i =rand.nextInt(999);
        java.text.DecimalFormat format = new java.text.DecimalFormat("000");
        return datetime + format.format(i);
    }

    /**
     * 获取当前日期
     */
    public static String getDate()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
        String datetime = dateFormat.format(date);
        return datetime;
    }


    /**
     * 获取yyyyMMdd 格式日期
     * <功能详细描述>
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String getDate2()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT2);
        String datetime = dateFormat.format(date);
        return datetime;
    }

    /**
     * 获取yyyyMMdd 格式日期
     * <功能详细描述>
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String getDate2(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT2);
        String datetime = dateFormat.format(date);
        return datetime;
    }
    public static Date toDate(String dateStr,String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date datetime = null;
        try {
            datetime = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }

    /**
     * 获取yyyy/MM/dd HH:mm 格式日期
     * @param date
     */
    public static String getDate3(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT3);
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    /**
     * 获取yyyy/MM/dd HH:mm 格式日期
     * @param date
     */
    public static String getDate4(Date date){
    	
    	String dt = "";
    	if(date != null){
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT4);
            dt = dateFormat.format(date);
    	}
    	
    	return dt;
        
    }


    /**
     * 获取年,月
     */
    public static String getYearMonth()
    {
        Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String datetime = dateFormat.format(date);
        return datetime;
    }

    /**
     * 获取每月最后一天
     * @param date 日期
     * @return Date
     */
    public static Date lastDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 把字符串按指定格式转化成Date
     */
    public static Date strToDate(String aMask, String strDate)
    {
        SimpleDateFormat format = new SimpleDateFormat(aMask);
        Date date = null;
        try
        {
            date = format.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期相减得到的毫秒数
     */
    public static long sub(String aMask, String strBeginDate, String strEndDate)
    {
        long dateRange = 0;
        Date beginDate = strToDate(aMask, strBeginDate);
        Date endDate = strToDate(aMask, strEndDate);
        dateRange = endDate.getTime() - beginDate.getTime();
        return dateRange;
    }

    /**
     * 日期相减得到的秒数
     */
    public static String subToSecond(String strBeginDate, String strEndDate)
    {
        String secNum = "";
        long dateRange = sub(datetimeformat, strBeginDate, strEndDate);
        secNum = "" + (dateRange / MILLISECONDS_PER_SECOND);
        return secNum;
    }


    /**
     * 每月自动转换邀请关系表名
     */
    public static String switchRelationTableName()
    {
        String prefix = "";
        try
        {
            String name = DateUtil.getYearMonth();
            prefix = "invite_relation_" + name;
        }
        catch (Exception e)
        {
            logException("switchRelationTableName: " + prefix, e);
            prefix = "";
        }
        return prefix;
    }

    /**
     * 每月自动转换邀请关系表名
     */
    public static String switchStatiscsTableName()
    {
        String prefix = "";
        try
        {
            String name = DateUtil.getYearMonth();
            prefix = "invite_statiscs_" + name;
        }
        catch (Exception e)
        {
            logException("switchRelationTableName: " + prefix, e);
            prefix = "";
        }
        return prefix;
    }

    /**
     * 转换日期格式为：2010-05-29 00:00:00
     */
    public static String switchInviteTime_one()
    {
        String date = DateUtil.getDate();
        String packageInviteTime = date + " 00:00:00";
        return packageInviteTime;
    }

    /**
     * 转换日期格式为：2010-05-29 23:59:59
     */
    public static String switchInviteTime_two()
    {
        String date = DateUtil.getDate();
        String packageInviteTime = date + " 23:59:59";
        return packageInviteTime;
    }

    /**
     * 获取当天的开始时刻
     * @return
     */
    public static Date getDayFirstTime(){
        SimpleDateFormat format=new SimpleDateFormat(datetimeformat);
        Date date=null;
        try
        {
            date=format.parse(switchInviteTime_one());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return  date;
    }

    /**
     * 获取当天的结束时刻
     * @return
     */
    public static Date getDayEndTime(){
        SimpleDateFormat format=new SimpleDateFormat(datetimeformat);
        Date date=null;
        try
        {
            date=format.parse(switchInviteTime_two());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return  date;
    }


    /**
     * 获得指定月第一天
     */
    public static String getMonthfirstDay(Date date)
    {
        SimpleDateFormat yearFormat = new SimpleDateFormat(year);
        String year = yearFormat.format(date.getTime());
        SimpleDateFormat monthFormat = new SimpleDateFormat(month);
        String month = monthFormat.format(date.getTime());
        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR, Integer.valueOf(year));
        time.set(Calendar.MONTH, Integer.valueOf(month) - 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat(datetimeformat);
        return dateFormat.format(time.getTime());
    }
    
    /**
     * 获得当月第一天
     */
    public static String getMonthfirstDay()
    {
        Date date = new Date();
        return getMonthfirstDay(date);
    }

    /**
     * 获得当月第一天的Date对象
     * @return
     */
    public static Date getMonthFirstDate() {
        Calendar time = Calendar.getInstance();
        int year=time.get(Calendar.YEAR);
        int month=time.get(Calendar.MONTH);
        time.clear();
        time.set(Calendar.YEAR, year);
        time.set(Calendar.MONTH, month);
        return time.getTime();
    }

    /**
     * 获得当月最后一天
     * @return String
     */
    public static String getMonthLastDay()
    {
    	Date date = new Date();
        return getMonthLastDay(date);
    }
    
    /**
     * 获得指定月最后一天
     * @return String
     */
    public static String getMonthLastDay(Date date)
    {
        Date lastDate = DateUtil.lastDayOfMonth(date);
        String lastMonth = new SimpleDateFormat(dateformat).format(
        		lastDate) + " 23:59:59";
        return lastMonth;
    }

    /**
     * 获得当月最后一天的Date对象
     * @return
     */
    public static Date getMonthLastDate(){
       String lastDate=getMonthLastDay();
       SimpleDateFormat format=new SimpleDateFormat(datetimeformat);
       Date date=null;
        try
        {
            date=format.parse(lastDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return  date;
    }

    /**
     * 将异常堆栈输出到日志中
     * @param desc 描述
     * @param e 异常
     * @param flag 日志标识
     */
    private static void logException(String desc, Exception e)
    {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        if (desc == null)
            desc = "";
        log.error("log.error: " + desc + "\n" + sw.toString());
    }

    /**
     * 获取当天是周几
     * @param args
     * @throws ParseException
     */
    public static int weekDay(){
    	Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK)-1;
        return weekday;
    }
    
    /**
     * 获取当前年月日
     * @param date
     * @return String [返回类型]
     */
    public static Date getCurrentDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        Date datetime = null;
        try {
        	datetime = dateFormat.parse(dateFormat.format(new Date()));
    	} catch (ParseException e) {
    	   e.printStackTrace();
    	}
        return datetime;
    }
    
    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
        return Integer.parseInt(String.valueOf(between_days));
    }    
    
    
    /**  
     * 计算两个日期之间相差的分钟数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int secondsBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_seconds=(time2-time1)/(1000*60);  
            
       return Integer.parseInt(String.valueOf(between_seconds));           
    }

    public static Date getDateByTimestamp(Long timestamp){
        return new Date(timestamp);
    }


    /** 
     * 获取指定时间对应的毫秒数 
     * @param time "HH:mm:ss" 
     * @return 
     */  
    public static long getTimeMillis(String time) {  
        try {  
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");  
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);  
            return curDate.getTime();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return 0;  
    } 

    /**
     * 给指定日期添加指定的年数，月数，天数，小时数，分钟数，秒数（并|或）
     * @param date
     * @param day
     * @return
     * @throws ParseException
     */
    public static Date addDate(Date date,long year,long month,long day,long hour,long minute,long second){
    	 long time = date.getTime(); // 得到指定日期的毫秒数
    	 if(year != 0){
    		 year = year*365*24*60*60*1000;
     	 }
    	 if(month != 0){
    		 month += month*30*24*60*60*1000;
    	 }
    	 if(day != 0){
    		 day = day*24*60*60*1000;
    	 }
    	 if(hour != 0){
    		 hour = hour*60*60*1000;
    	 }
    	 if(minute != 0){
    		 minute = minute*60*1000;
    	 }
    	 if(second != 0){
    		 second = second*1000;
    	 }
    	 long between = year + month + day + hour + minute + second;
    	 time+=between; // 相加得到新的毫秒数
    	 return new Date(time); // 将毫秒数转换成日期
    	}
    
    /**
     * 根据传进字符串转换成带有年月日时分秒的格式
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str) throws ParseException {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = df.parse(str);
		return date;
	}
    
    public static void main(String args[]) throws ParseException
    {
    	System.out.println(DateUtil.addDate(new Date(), 0, 0, 0, 3, 10, 0));
    }

    
    
}
