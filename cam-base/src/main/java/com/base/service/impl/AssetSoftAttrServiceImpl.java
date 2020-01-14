package com.base.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.base.dao.AssetSoftAttrDAO;
import com.base.service.DataBaseService;

public class AssetSoftAttrServiceImpl extends BaseService implements DataBaseService {

	@Override
	public int save(Map<String, Object> map) {
		int result = 0;
		if (checkMap(map)) {
			SqlSession sqlSession = null;
			try {
				sqlSession = super.getSession();
				AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
				result = mapper.save(map);
				if (result > 0 && map.get("attrId") != null) {
					result = Integer.parseInt(map.get("attrId").toString());
				}
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
		}
		return result;
	}
	private boolean checkMap(Map<String, Object> map) {
		if (map.get("attrName") == null) {
			return false;
		}
		if (map.get("attrType") == null) {
			return false;
		}
		return true;
	}

	@Override
	public int updateById(Map<String, Object> map, int id) {
		int result = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.updateById(map, id);
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
		return result;
	}

	@Override
	public int updateByIds(Map<String, Object> map, int[] ids) {
		int result = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.updateByIds(map, ids);
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
		return result;
	}

	@Override
	public int update(Map<String, Object> map, Map<String, Object> where) {
		int result = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.update(map, where);
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
		return result;
	}

	@Override
	public int deleteById(int id) {
		int result = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.deleteById(id);
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
		return result;
	}

	@Override
	public int deleteByIds(int[] ids) {
		int result = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.deleteByIds(ids);
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
		return result;
	}

	@Override
	public int delete(Map<String, Object> map) {
		int result = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.delete(map);
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
		return result;
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		List<Map<String, Object>> result = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.list(map);
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
		return result;
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map, List<Map<String, Object>> orderSort) {
		List<Map<String, Object>> result = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result = mapper.listWithOrder(map, orderSort);
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
		return result;
	}

	@Override
	public Map<String, Object> list(Map<String, Object> map, int pageNo, int pageSize) {
		Map<String, Object> result = new HashMap<>(2);
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result.put("rows", mapper.listPage(map, (pageNo - 1) * pageSize, pageSize));
			result.put("total", mapper.count(map));
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
		return result;
	}

	@Override
	public Map<String, Object> list(Map<String, Object> map, int pageNo, int pageSize,
			List<Map<String, Object>> orderSort) {
		Map<String, Object> result = new HashMap<>(2);
		SqlSession sqlSession = null;
		try {
			sqlSession = super.getSession();
			AssetSoftAttrDAO mapper = sqlSession.getMapper(AssetSoftAttrDAO.class);
			result.put("rows", mapper.listPageWithOrder(map, orderSort, (pageNo - 1) * pageSize, pageSize));
			result.put("total", mapper.count(map));
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
		return result;
	}

}
