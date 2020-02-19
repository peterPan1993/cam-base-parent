package com.base.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.base.service.DataBaseService;
import com.base.util.DataBaseUtils;

public class TestBase {

	public static void main(String[] args) {
		DataBaseService service = DataBaseUtils.initService("AssetBaseSoftServiceImpl");
		Map<String, Object> map = new HashMap<>();
//		Map<String, Object> where = new HashMap<>();
//		where.put("assetId", 1);
		
//		map.put("typeId", 12);
//		map.put("assetCase", 2);
//		map.put("number", "Cs001");
//		map.put("assetName", "测试的1");
//		map.put("state", "待入库");
//		map.put("version", "待入库");
//		int result = service.updateById(map, 1);
//		System.out.println(result);
		try {
			//System.out.println(build(service.list(map)));
			Properties properties = new Properties();  
			properties.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
			properties.setProperty("jdbc.url", "jdbc:mysql://127.0.0.1:3306/cam_base?characterEncoding=utf-8&amp;useSSL=false&amp;useUnicode=true");
			properties.setProperty("jdbc.username", "root");
			properties.setProperty("jdbc.password", "root");
			DataBaseUtils.setConfigData(properties);
			
			System.out.println(DataBaseUtils.initData());

//			System.out.println(Integer.valueOf(1) == Integer.valueOf("1"));// true
//			Properties properties = new Properties();
//			System.out.println(properties.setProperty("a", "2"));
//			System.out.println(properties.setProperty("a", "false"));
//			System.setProperties(properties);
//			System.out.println(Integer.getInteger("a"));
//			System.out.println(Boolean.getBoolean("aa"));
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String build(Object object) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if (object == null) {
			buffer.append("null");
		} else if (object instanceof String) {
			String string = (String) object;
			string = string.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
			string = string.replaceAll("\\\\", "\\\\\\\\");
			string = string.replaceAll("\"", "\\\\\"");
			buffer.append("\"").append(string).append("\"");
		} else if (object instanceof Integer || object instanceof Short || object instanceof Long) {
			buffer.append(object);
		} else if(object instanceof BigDecimal){
			DecimalFormat format = new DecimalFormat("#");
			buffer.append("\"" + format.format(object) + "\"");
		} else if (object instanceof Date) {
			// buffer.append("\"").append(DateUtil.formatDateTime((Date) object)).append("\"");
			buffer.append("\"").append(object.toString()).append("\"");
		} else if (object instanceof Map) {
			buffer.append("{");
			Map map = (Map) object;
			Set set = map.keySet();
			Iterator iterator = set.iterator();
			boolean comma = false;
			while (iterator.hasNext()) {
				if (comma) {
					buffer.append(",\r\n");
				} else {
					comma = true;
				}
				Object key = iterator.next();
				buffer.append("\"").append(key).append("\": ");
				Object value = map.get(key);
				buffer.append(build(value));
			}
			buffer.append("}");
		} else if (object instanceof List) {
			buffer.append("[");
			// list里的元素要是Map或List
			List list = (List) object;
			int count = list.size();
			boolean comma = false;
			for (int i = 0; i < count; i++) {
				if (comma) {
					buffer.append(",\r\n");
				} else {
					comma = true;
				}
				Object value = list.get(i);
				buffer.append(build(value));
			}
			buffer.append("]");
		} else if (object instanceof Boolean) {
			buffer.append(object);
		} else if (object instanceof int[]) {
			buffer.append("[");
			int[] intArray = (int[]) object;
			boolean comma = false;
			for (int i = 0; i < intArray.length; i++) {
				if (comma) {
					buffer.append(", ");
				} else {
					comma = true;
				}
				buffer.append(intArray[ i ]);
			}
			buffer.append("]");
		} else {
			System.out.println(object.toString());
			buffer.append(object.toString());
//			buffer.append("{");
//			Class c = object.getClass();
//			Field[] fields = c.getFields();
//			boolean comma = false;
//			for (int i = 0; i < fields.length; i++) {
//				if (comma) {
//					buffer.append(",\r\n");
//				} else {
//					comma = true;
//				}
//				//buffer.append(fields[ i ].getName()).append(":"); //key没有双引号
//				buffer.append("\"").append(fields[ i ].getName()).append("\"").append(": ");
//				buffer.append(build(fields[ i ].get(object)));
//			}
//			buffer.append("}");
		}
		return buffer.toString();
	}

}
