package com.base.util;

import com.base.service.DataBaseService;

public class DataBaseUtils {

	
	public static DataBaseService initService(String serviceName) {
		DataBaseService service = null;
		try {
			Class<?> serviceClass = Class.forName("com.base.service.impl." + serviceName);
			Object obj = serviceClass.newInstance();
			if (obj instanceof DataBaseService) {
				service = (DataBaseService) obj;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return service;
	}
}
