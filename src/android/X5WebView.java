import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;


public class X5WebView extends WebView implements CordovaWebViewEngine.EngineView {

    X5WebChromeClient chromeClient;

    private X5WebViewClient viewClient;
    private X5WebViewEngine parentEngine;

    public X5WebView(Context context) {
        this(context, null);
    }

    public X5WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // Package visibility to enforce that only X5WebViewEngine should call this method.
    void init(X5WebViewEngine parentEngine) {
        this.parentEngine = parentEngine;
        if (this.viewClient == null) {
            setWebViewClient(new X5WebViewClient(parentEngine));
        }

        if (this.chromeClient == null) {
            setWebChromeClient(new X5WebChromeClient(parentEngine));
        }
    }

    @Override
    public CordovaWebView getCordovaWebView() {
        return parentEngine != null ? parentEngine.getCordovaWebView() : null;
    }

    @Override
    public void setWebViewClient(WebViewClient client) {
        viewClient = (X5WebViewClient)client;
        super.setWebViewClient(client);
    }

    @Override
    public void setWebChromeClient(WebChromeClient client) {
        chromeClient = (X5WebChromeClient)client;
        super.setWebChromeClient(client);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Boolean ret = parentEngine.client.onDispatchKeyEvent(event);
        if (ret != null) {
            return ret;
        }
        return super.dispatchKeyEvent(event);
    }
}
