package org.apache.cordova.rockeycai;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;

/**
 * @ClassName: RockeyCaiAppHpler
 * @Description:app帮助类
 * @author: RockeyCai
 * @date: 2015-11-6 上午9:45:04
 * 
 */
public class RockeyCaiAppHpler {

    /** 是否是发布版本，true服务器版本，false 调用本地版本 **/
    public final static boolean APP_IS_RELEASE = false;
    public final static boolean IS_DEBUG = !APP_IS_RELEASE;

    public static final String CONFIG_FILE_NAME = "settingInfo";

    public static final String AUTOU_PLOAD_IMG_TASK_FLAG = "AUTOU_PLOAD_IMG_TASK_FLAG";

    /**
     * @Title: setAutoUploadImgTask
     * @Description: 设置是否自动删除
     * @param: @param mContext
     * @param: @param flag
     * @return: void
     */
    public static void setAutoUploadImgTask(Context mContext, boolean flag) {
	SharedPreferences sp = mContext.getSharedPreferences(CONFIG_FILE_NAME, 0);
	SharedPreferences.Editor editor = sp.edit();
	editor.putBoolean(AUTOU_PLOAD_IMG_TASK_FLAG, flag);
	editor.commit();
    }

    /**
     * @Title: getAutoUploadImgTask
     * @Description: 获取自动上传配置
     * @param: @param mContext
     * @param: @return
     * @return: boolean
     */
    public static boolean getAutoUploadImgTask(Context mContext) {

	SharedPreferences sp = mContext.getSharedPreferences(CONFIG_FILE_NAME, 0);
	return sp.getBoolean(AUTOU_PLOAD_IMG_TASK_FLAG, false);

    }

    /**
     * 判断是否存在sd卡
     * 
     * @return
     */
    public static boolean hasSdcard() {
	String status = Environment.getExternalStorageState();
	return status.equals(Environment.MEDIA_MOUNTED) ? true : false;
    }

    public static String getPath() {
	File path = Environment.getExternalStorageDirectory();
	return path.getPath();
    }


    /**
     * @Title: setSharedData   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param mContext
     * @param: @param key
     * @param: @param value      
     * @return: void
     */
    public static void setSharedString(Context mContext, String key , String value) {
	SharedPreferences sp = mContext.getSharedPreferences(CONFIG_FILE_NAME, 0);
	SharedPreferences.Editor editor = sp.edit();
	editor.putString(key, value);
	editor.commit();
    }
    
    /**
     * @Title: getSharedString   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param mContext
     * @param: @param key
     * @param: @return      
     * @return: String
     */
    public static String getSharedString(Context mContext , String key) {
	SharedPreferences sp = mContext.getSharedPreferences(CONFIG_FILE_NAME, 0);
	return sp.getString(key, key);
    }
    
    
    /**
     * @Title: removeSharedString   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param mContext
     * @param: @param key      
     * @return: void
     */
    public static void removeSharedString(Context mContext , String key) {
	SharedPreferences sp = mContext.getSharedPreferences(CONFIG_FILE_NAME, 0);
	SharedPreferences.Editor editor = sp.edit();
	editor.remove(key);
	editor.commit();
    }
}
