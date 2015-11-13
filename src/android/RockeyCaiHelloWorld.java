package org.apache.cordova.rockeycai;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

/**
 * 
 * @ClassName: RockeyCaiHelloWorld
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: RockeyCai
 * @date: 2015-11-13 下午5:23:58
 * 
 */
public class RockeyCaiHelloWorld extends CordovaPlugin {

    private Context mContext = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	// TODO Auto-generated method stub
	super.initialize(cordova, webView);
	mContext = webView.getContext();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

	if ("sayHello".equals(action)) {
	    String message = args.getString(0);
	    this.sayHello(message, callbackContext);
	    return true;
	}

	if ("sayHelloAndCallBack".equals(action)) {
	    String message = args.getString(0);
	    this.sayHelloAndCallBack(message, callbackContext);
	    return true;
	}
	
	if ("openPage".equals(action)) {
	    String message = args.getString(0);
	    this.openPage(message, callbackContext);
	    return true;
	}
	
	if ("openPageVC".equals(action)) {
	    String message = args.getString(0);
	    this.openPageVC(message, callbackContext);
	    return true;
	}

	return false;
    }

    /**
     * 打印前台js传递过来数据入口
     * 
     * @Title: sayHello
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param message
     * @param: @param callbackContext
     * @return: void
     */
    private void sayHello(String message, CallbackContext callbackContext) {

	System.out.println("--javaScript Call sayHello:HelloWorld----");
	callbackContext.success();
    }

    /**
     * 打印前台js传递过来数据入口,然后把数据给回调方法
     * 
     * @Title: sayHelloAndCallBack
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param message
     * @param: @param callbackContext
     * @return: void
     * @throws JSONException
     */
    private void sayHelloAndCallBack(String message, CallbackContext callbackContext) throws JSONException {

	System.out.println("--javaScript Call sayHelloAndCallBack----");
	JSONObject jsonObject = new JSONObject();
	// 设置返回值
	jsonObject.put("result", "result data");
	callbackContext.success(jsonObject);
    }

    /**
     * 打开插件中的页面
     * @Title: openPage   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param message
     * @param: @param callbackContext
     * @param: @throws JSONException      
     * @return: void
     */
    private void openPage(String message, CallbackContext callbackContext) throws JSONException {

	System.out.println("--javaScript Call openPage----");
	JSONObject jsonObject = new JSONObject();
	// 设置返回值
	jsonObject.put("result", "openPage");
	callbackContext.success(jsonObject);
    }
    
    /**
     * 打开插件中的页面
     * @Title: openPage   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param message
     * @param: @param callbackContext
     * @param: @throws JSONException      
     * @return: void
     */
    private void openPageVC(String message, CallbackContext callbackContext) throws JSONException {
	
	System.out.println("--javaScript Call openPageVC----");
	JSONObject jsonObject = new JSONObject();
	// 设置返回值
	jsonObject.put("result", "openPage");
	callbackContext.success(jsonObject);
	
	this.cordova.getActivity().runOnUiThread(new Runnable() {
	    
	    @Override
	    public void run() {
		// TODO Auto-generated method stub
		Toast.makeText(cordova.getActivity(), "原生Toast", Toast.LENGTH_LONG).show();
	    }
	});
	
	
    }

}
