package com.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.base.dao.AssetBaseDAO;
import com.base.service.DataBaseService;

public class DataBaseUtils {
	private DataBaseUtils() {}

	private static SqlSession session;

	public static void setConfigData(Properties properties) throws IOException {
		if (session == null) {
			InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(reader, properties);
			session = factory.openSession();
		}
	}
	public static SqlSession getSession() throws IOException {
		if (session == null)
			throw new RuntimeException("请先设置数据库连接配置！");
        return session;
	}
	
	public static boolean initData() {
		SqlSession sqlSession = null;
		try {
			sqlSession = DataBaseUtils.getSession();
			AssetBaseDAO baseMapper = sqlSession.getMapper(AssetBaseDAO.class);
			operate(baseMapper, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.commit();
				sqlSession.close();
			}
		}
		return true;
	}
	
	public static boolean rebuildData() {
		SqlSession sqlSession = null;
		try {
			sqlSession = DataBaseUtils.getSession();
			AssetBaseDAO baseMapper = sqlSession.getMapper(AssetBaseDAO.class);
			operate(baseMapper, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.commit();
				sqlSession.close();
			}
		}
		return true;
	}
	
	private static void operate(AssetBaseDAO baseMapper, boolean dropTable) {
		if (dropTable) {
			baseMapper.dropBaseTable();
			baseMapper.dropBaseFixedTable();
			baseMapper.dropBaseFlowTable();
			baseMapper.dropBaseInteTable();
			baseMapper.dropBaseSoftTable();
			baseMapper.dropBaseSupplierTable();
			baseMapper.dropBaseTypeTable();
			baseMapper.dropSoftAttrTable();
			baseMapper.dropSoftAuthorizeTypeTable();
			baseMapper.dropSoftModeTable();
			baseMapper.dropSoftTypeTable();
			baseMapper.dropSoftwareTable();
		}
		
		baseMapper.createBaseTable();
		baseMapper.createBaseFixedTable();
		baseMapper.createBaseFlowTable();
		baseMapper.createBaseInteTable();
		baseMapper.createBaseSoftTable();
		baseMapper.createBaseSupplierTable();
		baseMapper.createBaseTypeTable();
		baseMapper.createSoftAttrTable();
		baseMapper.createSoftAuthorizeTypeTable();
		baseMapper.createSoftModeTable();
		baseMapper.createSoftTypeTable();
		baseMapper.createSoftwareTable();
	}
	
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
