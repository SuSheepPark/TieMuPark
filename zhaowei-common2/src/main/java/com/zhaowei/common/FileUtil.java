/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: FileUtil.java 
 * @Prject: zhaowei-common2
 * @Package: com.zhaowei.common 
 * @Description: TODO
 * @author: zw   
 * @date: 2019年11月21日 上午8:13:03 
 * @version: V1.0   
 */
package com.zhaowei.common;

/** 
 * @ClassName: FileUtil 
 * @Description: TODO
 * @author: zw
 * @date: 2019年11月21日 上午8:13:03  
 */
public class FileUtil {

	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
		if(null!=fileName && fileName.length()>0) {
			return fileName.substring(fileName.lastIndexOf("."));
		}
		return fileName;
	}

	
	
}
