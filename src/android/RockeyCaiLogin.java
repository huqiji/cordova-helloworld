package org.apache.cordova.rockeycai;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

/**
 * @ClassName: RockeyCaiLogin
 * @Description:登录插件
 * @author: RockeyCai
 * @date: 2015-11-13 下午3:16:08
 * 
 */
public class RockeyCaiLogin extends CordovaPlugin {

    private static final String saveNameKey = "saveNameKey";
    private static final String savePasswordKey = "savePasswordKey";

    private static final String fNameKey = "fName";
    private static final String fPasswordKey = "fPassword";
    private static final String saveUserInfoKey = "saveUserInfo";
    private static final String isLogin = "isLogin";

    private Context mContext = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	// TODO Auto-generated method stub
	super.initialize(cordova, webView);
	mContext = webView.getContext();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	
	if ("getSaveUserInfoAction".equals(action)) {
	    String message = args.getString(0);
	    this.getSaveUserInfoAction(message, callbackContext);
	    return true;
	} 
	
	if ("loginAction".equals(action)) {
	    String message = args.getString(0);
	    this.loginAction(message, callbackContext);
	    return true;
	} 
	
	if ("getUserInfoAction".equals(action)) {
	    String message = args.getString(0);
	    this.getUserInfoAction(message, callbackContext);
	    return true;
	} 
	
	if ("logoutAction".equals(action)) {
	    String message = args.getString(0);
	    this.logoutAction(message, callbackContext);
	    return true;
	}
	
	return false;
    }


    /**
     * 获取记住的用户名密码
     * 
     * @Title: getSaveUserInfoAction
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param message
     * @param: @param callbackContext
     * @return: void
     */
    private void getSaveUserInfoAction(String message, CallbackContext callbackContext) {

	JSONObject jsonObject = new JSONObject();
	String fName = "";
	String fPassword = "";
	String saveUserInfo = getValueForKey(saveUserInfoKey);
	// 获取登录状态
	try {
	    jsonObject.put(isLogin, this.getValueForKey(isLogin));

	    // 获取保存用户名密码
	    if ("1".equals(saveUserInfo)) {
		fName = getValueForKey(saveUserInfoKey);
		fPassword = getValueForKey(savePasswordKey);
	    }

	    if (saveUserInfo == null || saveUserInfo.isEmpty()) {
		saveUserInfo = "1";
	    }
	    jsonObject.put(fNameKey, fName);
	    jsonObject.put(fPasswordKey, fPassword);
	    // 是否记住密码标签
	    jsonObject.put(saveUserInfoKey, saveUserInfo);

	    callbackContext.success(jsonObject);

	} catch (JSONException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    callbackContext.error(e.getMessage());
	}
    }

    
    /**
     * 登录请求
     * 
     * @Title: loginAction
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param message
     * @param: @param callbackContext
     * @return: void
     */
    private void loginAction(String message, CallbackContext callbackContext) {
	try {
	    JSONObject jsonObj = new JSONObject(message);

	    String fName = jsonObj.getString(fNameKey);
	    String fPassword = jsonObj.getString(fPasswordKey);
	    String saveUserInfo = jsonObj.getString(saveUserInfoKey);

	    if ("admin".equals(fName) && "123456".equals(fPassword)) {
		// 获取登录状态
		RockeyCaiAppHpler.setSharedString(mContext, isLogin, "1");

		callbackContext.success("1");

	    } else {
		callbackContext.success("0");
	    }

	    RockeyCaiAppHpler.setSharedString(mContext, saveUserInfoKey, saveUserInfo);

	    if ("1".equals(saveUserInfo)) {
		RockeyCaiAppHpler.setSharedString(mContext, saveNameKey, fName);
		RockeyCaiAppHpler.setSharedString(mContext, savePasswordKey, fPassword);
	    } else {
		RockeyCaiAppHpler.removeSharedString(mContext, saveNameKey);
		RockeyCaiAppHpler.removeSharedString(mContext, savePasswordKey);
	    }

	    // 登录成功用户名密码
	    RockeyCaiAppHpler.setSharedString(mContext, fNameKey, String.format("%s昵称", fName));
	    RockeyCaiAppHpler.setSharedString(mContext, fPasswordKey, fPasswordKey);

	} catch (JSONException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();

	    callbackContext.error("Expected one non-empty string argument.");
	}
    }

    /**
     * 获取登录用的信息
     * 
     * @Title: getUserInfoAction
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param message
     * @param: @param callbackContext
     * @return: void
     */
    private void getUserInfoAction(String message, CallbackContext callbackContext) {

	String fName = this.getValueForKey(fNameKey);
	callbackContext.success(fName);
    }

    /**
     * 注销登录
     * 
     * @Title: logoutAction
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param message
     * @param: @param callbackContext
     * @return: void
     */
    private void logoutAction(String message, CallbackContext callbackContext) {

	// 获取登录状态
	RockeyCaiAppHpler.removeSharedString(mContext, isLogin);
	callbackContext.success();
    }

    private String getValueForKey(String key) {
	return RockeyCaiAppHpler.getSharedString(mContext, key);
    }

}
