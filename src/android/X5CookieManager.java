import android.annotation.TargetApi;
import android.os.Build;

import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;

import org.apache.cordova.ICordovaCookieManager;

class X5CookieManager implements ICordovaCookieManager {

    protected final WebView webView;
    private final CookieManager cookieManager;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public X5CookieManager(WebView webview) {
        webView = webview;
        cookieManager = CookieManager.getInstance();

        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);
    }

    public void setCookiesEnabled(boolean accept) {
        cookieManager.setAcceptCookie(accept);
    }

    public void setCookie(final String url, final String value) {
        cookieManager.setCookie(url, value);
    }

    public String getCookie(final String url) {
        return cookieManager.getCookie(url);
    }

    public void clearCookies() {
        cookieManager.removeAllCookie();
    }

    public void flush() {
        cookieManager.flush();
    }
}
