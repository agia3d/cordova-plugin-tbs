package org.apache.cordova.x5webview;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;

/**
 * Created by ssbunny on 2018/5/22.
 */

public class X5WebViewAPICordovaPlugin extends CordovaPlugin {

    private static final String LOG_TAG = "X5Webview";

    private X5WebView x5webview;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(LOG_TAG, "X5WebViewAPICordovaPlugin initialized!");

        if (webView instanceof X5WebView) {
            this.x5webview = (X5WebView) webView;
        }
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        Log.d(LOG_TAG, "X5WebViewAPICordovaPlugin execute: " + action);
        if (x5webview == null || x5webview.getX5WebViewExtension() == null) {
            callbackContext.error("x5 webview 加载失败!");
            return false;
        }
        if ("gv".equals(action)) {
            getVersion(callbackContext);
        }
        return true;
    }


    private void getVersion(CallbackContext callbackContext) {
        callbackContext.success(x5webview.getX5WebViewExtension().getQQBrowserVersion());
    }
}
