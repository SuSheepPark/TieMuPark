/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: StreamUtil.java 
 * @Prject: zhaowei-common2
 * @Package: com.zhaowei.common 
 * @Description: TODO
 * @author: zw   
 * @date: 2019年11月21日 上午8:13:12 
 * @version: V1.0   
 */
package com.zhaowei.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/** 
 * @ClassName: StreamUtil 
 * @Description: TODO
 * @author: zw
 * @date: 2019年11月21日 上午8:13:12  
 */
public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传入无限个。(10分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(AutoCloseable ... ables){
	//TODO 实现代码
		if(ables!=null && ables.length>0) {
			for (AutoCloseable autoCloseable : ables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(InputStream src){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int x=0;
		try {
			//-1表示读完
			while((x=src.read(b))!=-1) {
				out.write(b);
			}
			return out.toString("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关流
			closeAll(out,src);
		}
		return null;

	}
	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile){
	//TODO 实现代码
		
		FileInputStream inputstream;
		
		try {
			inputstream = new FileInputStream(txtFile);
			return readTextFile(inputstream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}
