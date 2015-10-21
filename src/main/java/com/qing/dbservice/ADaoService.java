package com.qing.dbservice;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;

/**
 * Created by zwq on 2015-7-30 下午2:14 <br/>
 * @param <T0,T1>
 * 此类实现了大部分的方法
 */
public abstract class ADaoService<T0,T1> implements IDaoService<T0, T1>{
	
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

	public abstract T0 getDao();

	public abstract AbstractDaoSession getDaoSession();
	
	/**
	 * 获取Dao对象
	 */
	private AbstractDao<T1, Object> mDao;
	
	@SuppressWarnings("unchecked")
	private AbstractDao<T1, Object> getAbstractDao(){
		if(mDao==null){
			mDao = (AbstractDao<T1, Object>) getDao();
		}
		return mDao;
	}
	
	@Override
	public long insert(T1 entity) {
		return getAbstractDao().insert(entity);
	}

	@Override
	public long insert(List<T1> list) {
		return insertList(getDaoSession(), getAbstractDao(), list);
	}
	
	/**
	 * 插入List集合的所有数据
	 * @param daoSession
	 * @param dao
	 * @param list
	 * @return
	 */
	private final long insertList(AbstractDaoSession daoSession, final AbstractDao<T1, Object> dao, final List<T1> list) {
		if(list==null || list.isEmpty()) return -1;
		daoSession.runInTx(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					dao.insertOrReplace(list.get(i));
				}
			}
		});
		return list.size();
	}

	@Override
	public long deleteById(long key) {
		return getAbstractDao().deleteByKey(key);
	}

	@Override
	public long delete(T1 entity) {
		return getAbstractDao().delete(entity);
	}

	@Override
	public long delete(List<T1> list) {
		return deleteList(getDaoSession(), getAbstractDao(), list);
	}
	
	/**
	 * 删除List集合中的所有数据记录
	 * @param daoSession
	 * @param dao
	 * @param list
	 * @return
	 */
	private final long deleteList(AbstractDaoSession daoSession, final AbstractDao<T1, Object> dao, final List<T1> list) {
		if(list==null || list.isEmpty()) return -1;
		daoSession.runInTx(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					dao.deleteInTx(list.get(i));
				}
			}
		});
		return list.size();
	}

	@Override
	public void deleteAll() {
		getAbstractDao().deleteAll();
	}

	@Override
	public long update(T1 entity) {
		return getAbstractDao().update(entity);
	}

	@Override
	public long update(List<T1> list) {
		return updateList(getDaoSession(), getAbstractDao(), list);
	}
	
	/**
	 * 更新List集合中的所有数据的记录
	 * @param daoSession
	 * @param dao
	 * @param list
	 * @return
	 */
	private final long updateList(AbstractDaoSession daoSession, final AbstractDao<T1, Object> dao, final List<T1> list) {
		if(list==null || list.isEmpty()) return -1;
		daoSession.runInTx(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					dao.updateInTx(list.get(i));
				}
			}
		});
		return list.size();
	}

	@Override
	public T1 findById(long key) {
		return getAbstractDao().load(key);
	}

//	@Override
//	public T1 find(String... args) {
//		return null;
//	}

//	@Override
//	public List<T1> findAll(String... args) {
//		return null;
//	}

	@Override
	public List<T1> findAll() {
		return getAbstractDao().loadAll();
	}

	@Override
	public long getCounts() {
		return getAbstractDao().count();
	}
	
}
