package com.alibaba.baichuan.android.trade.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.b.b;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContextManager;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTrackParam;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.biz.webview.AlibcWebViewProxy;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.messagebus.AlibcMessageBusManager;
import com.alibaba.baichuan.trade.common.messagebus.AlibcMessageListener;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import java.util.HashMap;

public class AlibcWebViewActivity extends Activity {
    private static String[] a = {"^http(s)?://oauth\\.(.*)\\.taobao.com/authorize?(.*)", "^http(s)?://oauth\\.taobao.com/authorize?(.*)"};
    private static AlibcTradeContext b = null;
    private static com.alibaba.baichuan.android.trade.usertracker.monitor.a c = null;
    private WebView d;
    private TextView e;
    private View f;
    private View g;
    private View h;
    private a i;

    public class a extends AlibcMessageListener {
        protected a() {
            super(1201, true);
        }

        @Override // com.alibaba.baichuan.trade.common.messagebus.AlibcMessageListener
        public void onMessageEvent(int i, Object obj) {
            if (obj != null && (obj instanceof String)) {
                AlibcWebViewActivity.this.e.setText((String) obj);
            }
        }
    }

    public static AlibcTradeContext a() {
        return b;
    }

    private static String a(WebView webView) {
        AlibcTradeContext context;
        if (!(webView == null || (context = AlibcTradeContextManager.getContext(webView)) == null || context.urlParam == null || context.urlParam.get("ybhpss") == null)) {
            Object obj = context.urlParam.get("ybhpss");
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public static void a(com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar) {
        c = aVar;
    }

    public static void a(AlibcTradeContext alibcTradeContext) {
        b = alibcTradeContext;
    }

    private static boolean a(final WebView webView, final String str) {
        if (AlibcConfigService.getInstance().getLoginDegrade(false)) {
            AlibcLogger.d("AlibcWebViewActivity", "loginDegrade = false,直接采用H5进行登录");
            return false;
        }
        AlibcLogger.d("AlibcWebViewActivity", "调用login sdk接口");
        AlibcLogin.getInstance().showLogin(new AlibcLoginCallback() {
            /* class com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity.AnonymousClass5 */

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onFailure(int i, String str) {
                if (webView != null) {
                    AlibcLogger.d("AlibcWebViewActivity", "登录失败,进入到页面后退逻辑");
                    Activity activity = (Activity) webView.getContext();
                    if (!StringUtils.obj2Boolean(webView.getTag(ResourceUtils.getIdentifier(activity, "id", "com_taobao_nb_sdk_webview_click")))) {
                        if (webView.canGoBack()) {
                            webView.goBack();
                        } else if (activity != null) {
                            activity.finish();
                        }
                    }
                    AlibcWebViewActivity.b(webView, UserTrackerConstants.E_SHOWLOGIN_FAIL, false, i);
                }
            }

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onSuccess(int i, String str, String str2) {
                AlibcLogger.d("AlibcWebViewActivity", "登录成功,重新加载页面");
                webView.setTag(ResourceUtils.getIdentifier(AlibcTradeCommon.context, "id", "webviewload_monitor_cancel_point"), true);
                webView.loadUrl(str);
                AlibcWebViewActivity.b(webView, UserTrackerConstants.E_SHOWLOGIN_SUCCESS, true, 0);
            }
        });
        return true;
    }

    private void b() {
        String stringExtra = getIntent().getStringExtra("bc_webview_activity_title");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.e.setText(stringExtra);
            return;
        }
        this.i = new a();
        AlibcMessageBusManager.getInstance().registerListener(this.i);
    }

    /* access modifiers changed from: private */
    public static void b(WebView webView, String str, boolean z, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", AlibcTradeCommon.getAppKey());
        if (AlibcLogin.getInstance().getSession() != null) {
            hashMap.put("userId", AlibcLogin.getInstance().getSession().openId);
        }
        hashMap.put("utdid", AlibcTradeCommon.getUtdid());
        hashMap.put("ttid", AlibcTradeBiz.getTTID());
        hashMap.put("ybhpss", a(webView));
        hashMap.put("isSuccess", z ? "1" : "0");
        hashMap.put("errorCode", String.valueOf(i2));
        AlibcUserTracker.getInstance().sendCustomHit(str, "", hashMap);
    }

    private void c() {
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_nb_sdk_web_view_activity"), (ViewGroup) null);
        this.d = new WebView(this);
        e();
        linearLayout.addView(this.d, new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.e = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_title"));
        this.g = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        this.h = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        this.f = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar"));
        d();
    }

    private void d() {
        View view = this.g;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlibcWebViewActivity.this.finish();
                }
            });
        }
        View view2 = this.h;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() {
                /* class com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlibcWebViewActivity.this.onBackPressed();
                }
            });
        }
    }

    private void e() {
        AlibcTradeContext a2 = a();
        if (a2 != null) {
            a2.setActivity(this);
            a2.setWebview(this.d);
            AlibcTradeContextManager.setContext(a2);
        }
        AlibcWebViewProxy.initAlibcWebViewProxy(this, this.d, null, null, true, new InterceptorCallback() {
            /* class com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity.AnonymousClass3 */

            @Override // com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback
            public void onFail(int i) {
            }

            @Override // com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback
            public void onInterceptor(AlibcTradeContext alibcTradeContext, UrlRequest urlRequest) {
                AlibcTradeShowParam alibcTradeShowParam = alibcTradeContext.showParam;
                AlibcTradeTaokeParam alibcTradeTaokeParam = alibcTradeContext.taokeParam;
                AlibcTradeTrackParam alibcTradeTrackParam = alibcTradeContext.urlParam;
                AlibcTrade.openByUrl(alibcTradeContext.activity.get(), alibcTradeTrackParam != null ? (String) alibcTradeTrackParam.get("identity") : "", urlRequest.getUrl(), alibcTradeContext.webview.get(), alibcTradeContext.getWebViewClient(), alibcTradeContext.getWebChromeClient(), b.a(alibcTradeShowParam), b.a(alibcTradeTaokeParam), alibcTradeTrackParam, new AlibcTradeCallback() {
                    /* class com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity.AnonymousClass3.AnonymousClass1 */

                    @Override // com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback
                    public void onFailure(int i, String str) {
                    }

                    @Override // com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback
                    public void onTradeSuccess(AlibcTradeResult alibcTradeResult) {
                    }
                });
            }
        });
        this.d.setDownloadListener(new DownloadListener() {
            /* class com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity.AnonymousClass4 */

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                AlibcLogger.i("AlibcWebViewActivity", "url=" + str);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                AlibcWebViewActivity.this.startActivity(intent);
            }
        });
    }

    private void f() {
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            com.alibaba.baichuan.android.trade.usertracker.monitor.a aVar = c;
            if (aVar != null) {
                aVar.i();
            }
            if (!AlibcURLCheck.regular.check(a, stringExtra) || AlibcLogin.getInstance().isLogin()) {
                this.d.loadUrl(stringExtra);
            } else {
                a(this.d, stringExtra);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.d.canGoBack()) {
            this.d.goBack();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        c();
        b();
        f();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        WebView webView = this.d;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.d);
            }
            this.d.removeAllViews();
            this.d.destroy();
        }
        if (this.i != null) {
            AlibcMessageBusManager.getInstance().removeListner(this.i);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            f();
        }
    }
}
