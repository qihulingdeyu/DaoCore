package com.qing.dbservice;

import java.util.List;

/**
 * Created by zwq on 2015-7-30 下午2:14 <br/>
 * @param <T>
 *
 */
public interface IDaoService<T> {

	public long insert(T entity);
	
	public long insert(List<T> list);
	
	public long deleteById(long key);
	
	public long delete(T entity);
	
	public long delete(List<T> list);
	
	public void deleteAll();
	
	public long update(T entity);
	
	public long update(List<T> list);
	
	public T findById(long key);
	
	public T find(String... args);
	
	public List<T> findAll(String... args);
	
	public List<T> findAll();
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public long getCounts();

}
