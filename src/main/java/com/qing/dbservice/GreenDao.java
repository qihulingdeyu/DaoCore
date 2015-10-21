package com.qing.dbservice;
/*
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.qing.dao.DaoMaster;
import com.qing.dao.DaoMaster.DevOpenHelper;
import com.qing.dao.DaoSession;

public class GreenDao {
	// KEEP INCLUDES - put your custom includes here // KEEP INCLUDES END
	// KEEP FIELDS - put your custom fields here // KEEP FIELDS END
	// KEEP METHODS - put your custom methods here // KEEP METHODS END

	private static final String dbName = "jane_db";
	private static GreenDao instance;
	private static Context mContext;
	private static DevOpenHelper helper;
	
	public enum DBType {
		TYPE_READ(0),//0：读
		TYPE_WRITE(1);//1：写
		final int type;
		private DBType(int type) {
			this.type = type;
		}
	}
	private static DBType CUR_TYPE = DBType.TYPE_READ;
	
	private static SQLiteDatabase db;
	private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    
	private GreenDao() {
	}

	public static GreenDao Init(Context context) {
		return Init(context, dbName, null);
	}

	public static GreenDao Init(Context context, String dbName) {
		return Init(context, dbName, null);
	}

	public static GreenDao Init(Context context, String dbName, CursorFactory factory) {
		if (instance == null) {
			instance = new GreenDao();
		}
		if (mContext == null) {
			mContext = context;
		}
		if(helper == null){
			helper = new DevOpenHelper(context, dbName, factory);
		}
		return instance;
	}

//	public static GreenDao getDBHelper() {
//		return instance;
//	}

	public static DevOpenHelper getDevOpenHelper() {
		return helper;
	}

	public static SQLiteDatabase getDB() {
		if(db == null){
			db = helper.getReadableDatabase();
			CUR_TYPE = DBType.TYPE_READ;
		}
		return db;
	}

	public static DaoMaster getDaoMaster() {
		return daoMaster;
	}
	
	*/
/**
	 * DBType.TYPE_WRITE
	 * @return
	 *//*

	public static DaoSession getDaoSession(){
		return getDaoSession(DBType.TYPE_WRITE);
	}

	public static DaoSession getDaoSession(DBType type){
		if(type != CUR_TYPE){
			recycleAll();//清除上一次使用的资源
			if(type == DBType.TYPE_READ){
				db = helper.getReadableDatabase();
				CUR_TYPE = DBType.TYPE_READ;
				
			}else if(type == DBType.TYPE_WRITE){
				db = helper.getWritableDatabase();
				CUR_TYPE = DBType.TYPE_WRITE;
			}
			daoMaster = new DaoMaster(db);
			daoSession = daoMaster.newSession();
			
		}else{
			if(daoSession == null){
				recycleAll();//清除上一次使用的资源
				db = helper.getReadableDatabase();
				CUR_TYPE = DBType.TYPE_READ;
				
				if(daoMaster == null){
					daoMaster = new DaoMaster(db);
				}
				if(daoSession == null){
					daoSession = daoMaster.newSession();
				}
			}
		}
        return daoSession;
	}
	
	private static void recycleAll(){
		if(daoSession != null){
			daoSession.clear();
			daoSession = null;
		}
		if(daoMaster != null){
			daoMaster = null;
		}
		if(db != null){
			db.close();
			db = null;
		}
	}
}*/
