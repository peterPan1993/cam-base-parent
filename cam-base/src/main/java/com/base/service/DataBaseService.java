package com.base.service;

import java.util.List;
import java.util.Map;

public interface DataBaseService {

	int save(Map<String, Object> map);
	
	int updateById(Map<String, Object> map, int id);
	int updateByIds(Map<String, Object> map, int[] ids);
	int update(Map<String, Object> map, Map<String, Object> where);
	
	int deleteById(int id);
	int deleteByIds(int[] ids);
	int delete (Map<String, Object> map);
	
	List<Map<String, Object>> list(Map<String, Object> map);
	List<Map<String, Object>> list(Map<String, Object> map, List<Map<String, Object>> orderSort);
	Map<String, Object> list(Map<String, Object> map, int pageNo, int pageSize);
	Map<String, Object> list(Map<String, Object> map, int pageNo, int pageSize, List<Map<String, Object>> orderSort);
	
}
