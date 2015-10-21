package com.qing.dbservice;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;

/**
 * Created by zwq on 2015-7-30 下午2:14:43 <br/>
 * @param <T0,T1>
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
	
	/**
	 * 插入List集合的所有数据
	 * @param daoSession
	 * @param dao
	 * @param list
	 * @return
	 */
	public final long insertList(AbstractDaoSession daoSession, final T0 dao, final List<T1> list) {
		if(list==null || list.isEmpty()) return -1;
		daoSession.runInTx(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					((AbstractDao<T1, Object>)dao).insertOrReplace(list.get(i));
				}
			}
		});
		return list.size();
	}
	
	/**
	 * 删除List集合中的所有数据记录
	 * @param daoSession
	 * @param dao
	 * @param list
	 * @return
	 */
	public final long deleteList(AbstractDaoSession daoSession, final T0 dao, final List<T1> list) {
		if(list==null || list.isEmpty()) return -1;
		daoSession.runInTx(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					((AbstractDao<T1, Object>)dao).deleteInTx(list.get(i));
				}
			}
		});
		return list.size();
	}
	
	/**
	 * 更新List集合中的所有数据的记录
	 * @param daoSession
	 * @param dao
	 * @param list
	 * @return
	 */
	public final long updateList(AbstractDaoSession daoSession, final T0 dao, final List<T1> list) {
		if(list==null || list.isEmpty()) return -1;
		daoSession.runInTx(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				for (int i = 0; i < list.size(); i++) {
					((AbstractDao<T1, Object>)dao).updateInTx(list.get(i));
				}
			}
		});
		return list.size();
	}
}
