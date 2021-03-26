package com.tencent.connect.auth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.b;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends Dialog {
    private String a;
    private b b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private com.tencent.open.c.c j;
    private Context k;

    /* renamed from: l  reason: collision with root package name */
    private com.tencent.open.web.security.b f1446l;
    private boolean m = false;
    private int n;
    private String o;
    private String p;
    private long q = 0;
    private long r = 30000;
    private HashMap<String, Runnable> s;

    static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.a + obj;
        aVar.a = str;
        return str;
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.n;
        aVar.n = i2 + 1;
        return i2;
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.k = context;
        this.a = str2;
        this.b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.d = new c(this.b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.f1446l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.m) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* compiled from: ProGuard */
    private class c extends Handler {
        private b b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.b.a((String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else if (i == 3) {
                a.b(a.this.k, (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements IUiListener {
        String a;
        String b;
        private String d;
        private IUiListener e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(j.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, "服务器返回数据格式有误!", str));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g a2 = g.a();
            a2.a(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.a;
            } else {
                str = this.a;
            }
            g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    private class C0126a extends WebViewClient {
        private C0126a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri;
            f.a("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c = j.c(str);
                a aVar = a.this;
                aVar.m = aVar.e();
                if (!a.this.m) {
                    if (c.optString("fail_cb", null) != null) {
                        a.this.a(c.optString("fail_cb"), "");
                    } else if (c.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        String str2 = "?";
                        if (aVar2.a.indexOf(str2) > -1) {
                            str2 = "&";
                        }
                        a.a(aVar2, (Object) str2);
                        a.a(a.this, (Object) "browser_error=1");
                        a.this.j.loadUrl(a.this.a);
                    } else {
                        String optString = c.optString("redir", null);
                        if (optString != null) {
                            a.this.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.b.onComplete(j.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                a.this.b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith("auth://close")) {
                a.this.dismiss();
                return true;
            } else if (str.startsWith("download://") || str.endsWith(".apk")) {
                try {
                    if (str.startsWith("download://")) {
                        uri = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        uri = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    a.this.k.startActivity(intent);
                } catch (Exception e) {
                    f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                try {
                    List<String> pathSegments = Uri.parse(str).getPathSegments();
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.g.setVisibility(8);
                        a.this.j.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.g.setVisibility(0);
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (str.startsWith("auth://onLoginSubmit")) {
                try {
                    List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                    if (!pathSegments2.isEmpty()) {
                        a.this.p = pathSegments2.get(0);
                    }
                } catch (Exception unused2) {
                }
                return true;
            } else if (a.this.f1446l.a(a.this.j, str)) {
                return true;
            } else {
                f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!j.b(a.this.k)) {
                a.this.b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
            } else if (!a.this.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
                if (a.this.n >= 1 || elapsedRealtime >= a.this.r) {
                    a.this.j.loadUrl(a.this.a());
                    return;
                }
                a.m(a.this);
                a.this.d.postDelayed(new Runnable() {
                    /* class com.tencent.connect.auth.a.C0126a.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.j.loadUrl(a.this.o);
                    }
                }, 500);
            } else {
                a.this.b.onError(new UiError(i, str, str2));
                a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            a aVar = a.this;
            d dVar = new d(aVar.o);
            a.this.s.put(str, dVar);
            a.this.d.postDelayed(dVar, 120000);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.g.setVisibility(8);
            if (a.this.j != null) {
                a.this.j.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            f.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            if (Locale.getDefault().getLanguage().equals("zh")) {
                str2 = "ssl证书无效，是否继续访问？";
                str = "是";
                str3 = "否";
            } else {
                str2 = "The SSL certificate is invalid,do you countinue?";
                str = "yes";
                str3 = "no";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(a.this.k);
            builder.setMessage(str2);
            builder.setPositiveButton(str, new DialogInterface.OnClickListener() {
                /* class com.tencent.connect.auth.a.C0126a.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(str3, new DialogInterface.OnClickListener() {
                /* class com.tencent.connect.auth.a.C0126a.AnonymousClass3 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    a.this.dismiss();
                }
            });
            builder.create().show();
        }
    }

    /* compiled from: ProGuard */
    class d implements Runnable {
        String a = "";

        public d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + a.this.o);
            if (this.a.equals(a.this.o)) {
                a.this.b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public String a() {
        String str = this.a;
        String str2 = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str2;
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.j = new com.tencent.open.c.c(this.k);
        if (Build.VERSION.SDK_INT >= 11) {
            this.j.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        this.e = new FrameLayout(this.k);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.addView(this.j);
        this.e.addView(this.g);
        setContentView(this.e);
    }

    private void c() {
        TextView textView;
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        if (this.i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new FrameLayout(this.k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = 80;
        layoutParams3.rightMargin = 80;
        layoutParams3.topMargin = 40;
        layoutParams3.bottomMargin = 40;
        layoutParams3.gravity = 17;
        this.g.setLayoutParams(layoutParams3);
        this.g.setBackgroundResource(17301504);
        this.g.addView(this.f);
    }

    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new C0126a());
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass1 */

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.j.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass2 */

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.a);
        String str = this.a;
        this.o = str;
        this.j.loadUrl(str);
        this.j.setVisibility(4);
        this.j.getSettings().setSavePassword(false);
        this.f1446l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.connect.auth.a.AnonymousClass3 */

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean e() {
        b a2 = b.a();
        String c2 = a2.c();
        b.a aVar = new b.a();
        aVar.a = this.c;
        aVar.b = this;
        aVar.c = c2;
        String a3 = a2.a(aVar);
        String str = this.a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b2 = j.b(this.a);
        b2.putString("token_key", c2);
        b2.putString("serial", a3);
        b2.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
        this.a = str2;
        return j.a(this.k, str2);
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("type");
            Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        com.tencent.open.c.c cVar = this.j;
        if (cVar != null) {
            cVar.destroy();
            this.j = null;
        }
    }
}
