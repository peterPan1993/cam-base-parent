package com.base.service.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.base.util.DataBaseUtils;

public class BaseService {
	
	public static SqlSession getSession() throws IOException {
        return DataBaseUtils.getSession();
	}
	
	/**
	 * 检查基础必填数据是否都填了
	 * @param map
	 * @return
	 */
	protected boolean checkBaseMap(Map<String, Object> map) {
		if (map.get("typeId") == null) {
			return false;
		}
		if (map.get("assetCase") == null) {
			return false;
		}
		if (map.get("number") == null) {
			return false;
		}
		if (map.get("assetName") == null) {
			return false;
		}
		if (map.get("state") == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 检查是否需要修改基础表
	 * @param map
	 * @return
	 */
	protected boolean updateBaseMap(Map<String, Object> map) {
		if (map.get("supplierId") != null) {
			return true;
		}
		if (map.get("typeId") != null) {
			return true;
		}
		if (map.get("assetCase") != null) {
			return true;
		}
		if (map.get("number") != null) {
			return true;
		}
		if (map.get("editNumber") != null) {
			return true;
		}
		if (map.get("assetName") != null) {
			return true;
		}
		if (map.get("financeCoding") != null) {
			return true;
		}
		if (map.get("state") != null) {
			return true;
		}
		if (map.get("unit") != null) {
			return true;
		}
		if (map.get("assetCount") != null) {
			return true;
		}
		if (map.get("price") != null) {
			return true;
		}
		if (map.get("buyTime") != null) {
			return true;
		}
		if (map.get("picture") != null) {
			return true;
		}
		if (map.get("canUse") != null) {
			return true;
		}
		return false;
	}
}
