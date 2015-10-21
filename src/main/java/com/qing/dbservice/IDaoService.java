package com.qing.dbservice;

import java.util.List;

import de.greenrobot.dao.AbstractDaoSession;

/**
 * Author: zwq <br/>
 * Date: 2015-7-30 <br/>
 * Time: 下午2:14:43 <br/>
 * @param <T0,T1>
 */
public interface IDaoService<T0,T1> {
	/**
	private static className daoService;
	private static DaoSession daoSession;
	private static T0 dao;
	private className(){ }
	
	public static className getDaoService(Context context){
		if(daoService==null){
			GreenDao.Init(context);
			daoSession = GreenDao.getDaoSession();
			daoService = new className();
			dao = daoSession.get T0();
		}
		return daoService;
	}
	*/
	
	public T0 getDao();

	public AbstractDaoSession getDaoSession();
	
	public long insert(T1 entity);
	
	public long insert(List<T1> list);
	
	public long deleteById(long key);
	
	public long delete(T1 entity);
	
	public long delete(List<T1> list);
	
	public void deleteAll();
	
	public long update(T1 entity);
	
	public long update(List<T1> list);
	
	public T1 findById(long key);
	
	public T1 find(String... args);
	
	public List<T1> findAll(String... args);
	
	public List<T1> findAll();
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public long getCounts();

}
