/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: DateUtilTest.java 
 * @Prject: zhaowei.common
 * @Package: com.zhaowei.common.utils 
 * @Description: TODO
 * @author: zw   
 * @date: 2019年9月5日 下午4:49:18 
 * @version: V1.0   
 */


import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import com.zhaowei.common.DateUtil;

/** 
 * @ClassName: DateUtilTest 
 * @Description: TODO
 * @author: zw
 * @date: 2019年9月5日 下午4:49:18  
 */
public class DateUtilTest {

	/**
	 * Test method for {@link com.zhaowei.common.utils.DateUtil#getDateByInitMonth(java.util.Date)}.
	 */
	@Test
	public void getDateByInitMonth() {
		
		
		Calendar c = Calendar.getInstance();
		c.set(2000, 1, 8);
		Date date = DateUtil.getDateByInitMonth(c.getTime());
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}
	//测试月末
	@Test
	public void getDateByFullMonth() {
		
		/*
		 * Calendar c = Calendar.getInstance(); c.set(2018, 3, 8); Date date =
		 * DateUtil.getDateByFullMonth(c.getTime()) ; SimpleDateFormat df = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); System.out.println(df.format(date));
		 */
		
	    Random rndYear=new Random();
        int year=rndYear.nextInt(43)+1959;  //生成[2000,2017]的整数；年
        Random rndMonth=new Random();
        int month=rndMonth.nextInt(12)+1;   //生成[1,12]的整数；月
        Random rndDay=new Random(); 
        int Day=rndDay.nextInt(30)+1;       //生成[1,30)的整数；日
        Random rndHour=new Random();
        int hour=rndHour.nextInt(23);       //生成[0,23)的整数；小时
        Random rndMinute=new Random(); 
        int minute=rndMinute.nextInt(60);   //生成分钟
        Random rndSecond=new Random();
        int second=rndSecond.nextInt(60);   //秒
        if(month==2) {
        	Day=rndDay.nextInt(29)+1;
		} /*
			 * int[] big = {1,3,5,7,8,10,12}; int[] little = {4,6,9,11}; for (int
			 * i=0;i<6;i++) { if(month==big[i]) { Day=rndDay.nextInt(31)+1; } if
			 * (month==little[i]) { Day=rndDay.nextInt(30)+1; } }
			 */
    System.out.println(year+"-"+month+"-"+Day+"  "+hour+":"+minute+":"+second); 

	}
	
		@Test
		public void test1() {
			//获取月初
			Date date = DateUtil.getDateByInitMonth(new Date());
			SimpleDateFormat df = new SimpleDateFormat();
			String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
			sql.replace("{1}", df.format(date));
			Date date2 = DateUtil.getDateByFullMonth(new Date());
			String replace = sql.replace("{1}", df.format(date2));
			System.out.println(replace);
		}
	

}
