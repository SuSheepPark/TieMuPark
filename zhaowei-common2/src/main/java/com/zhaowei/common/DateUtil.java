/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: DateUtil.java 
 * @Prject: zhaowei-common2
 * @Package: com.zhaowei.common 
 * @Description: TODO
 * @author: zw   
 * @date: 2019年11月21日 上午8:12:52 
 * @version: V1.0   
 */
package com.zhaowei.common;

import java.util.Calendar;
import java.util.Date;

/** 
 * @ClassName: DateUtil 
 * @Description: TODO
 * @author: zw
 * @date: 2019年11月21日 上午8:12:52  
 */
public class DateUtil {

	
	/*
	 * 方法1：(10分) 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	 * 则返回的结果为2019-05-01 00:00:00
	 */
	public static Date getDateByInitMonth(Date src){
		Calendar instance = Calendar.getInstance();
		instance.setTime(src);
		instance.set(Calendar.DAY_OF_MONTH, 1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		return instance.getTime();
	}

	
	/*
	* 方法2：(10分)
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date src){
		Calendar instance = Calendar.getInstance();
		instance.setTime(src);
		instance.add(Calendar.MONTH, 1);
		Date date = getDateByInitMonth(instance.getTime());
		instance.setTime(date);
		instance.set(Calendar.SECOND, -1);
		return instance.getTime();
	}

	
	
	
	
}
