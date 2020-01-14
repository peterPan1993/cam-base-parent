package com.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AssetSoftAuthorizeTypeDAO {
	int save(Map<String, Object> map);
	
	int updateById(@Param("map") Map<String, Object> map, @Param("id") int id);
	int updateByIds(@Param("map") Map<String, Object> map, @Param("ids") int[] ids);
	int update(@Param("map") Map<String, Object> map, @Param("where") Map<String, Object> where);
	
	int deleteById(int id);
	int deleteByIds(int[] ids);
	int delete(Map<String, Object> map);
	
	List<Map<String, Object>> list(Map<String, Object> map);
	List<Map<String, Object>> listWithOrder(@Param("map") Map<String, Object> map,
			@Param("orderSort") List<Map<String, Object>> orderSort);
	
	int count(Map<String, Object> map);
	List<Map<String, Object>> listPage(@Param("map") Map<String, Object> map,
			@Param("offset") int offset, @Param("limit") int limit);
	List<Map<String, Object>> listPageWithOrder(@Param("map") Map<String, Object> map,
			@Param("orderSort") List<Map<String, Object>> orderSort, @Param("offset") int offset,
			@Param("limit") int limit);
}
