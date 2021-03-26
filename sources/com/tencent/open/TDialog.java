package com.tencent.open;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.c.b;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class TDialog extends b {
    static final FrameLayout.LayoutParams c = new FrameLayout.LayoutParams(-1, -1);
    static Toast d = null;
    private static WeakReference<ProgressDialog> f;
    private WeakReference<Context> e;
    private String g;
    private OnTimeListener h;
    private IUiListener i;
    private FrameLayout j;
    private b k;

    /* renamed from: l  reason: collision with root package name */
    private Handler f1453l;
    private boolean m = false;
    private QQToken n = null;

    /* compiled from: ProGuard */
    private class THandler extends Handler {
        private OnTimeListener b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.b.a((String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else if (i != 3) {
                if (i == 5 && TDialog.this.e != null && TDialog.this.e.get() != null) {
                    TDialog.d((Context) TDialog.this.e.get(), (String) message.obj);
                }
            } else if (TDialog.this.e != null && TDialog.this.e.get() != null) {
                TDialog.c((Context) TDialog.this.e.get(), (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    private static class OnTimeListener implements IUiListener {
        String a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private IUiListener e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = new WeakReference<>(context);
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

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.e = new WeakReference<>(context);
        this.g = str2;
        this.h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f1453l = new THandler(this.h, context.getMainLooper());
        this.i = iUiListener;
        this.n = qQToken;
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    private void a() {
        new TextView(this.e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        b bVar = new b(this.e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        this.j = new FrameLayout(this.e.get());
        layoutParams.gravity = 17;
        this.j.setLayoutParams(layoutParams);
        this.j.addView(this.k);
        setContentView(this.j);
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.k, str);
        } catch (Exception unused) {
        }
    }

    private void b() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new FbWebViewClient());
        this.k.setWebChromeClient(this.b);
        this.k.clearFormData();
        WebSettings settings = this.k.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            WeakReference<Context> weakReference = this.e;
            if (!(weakReference == null || weakReference.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(this.e.get().getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.a.a(new JsListener(), "sdk_js_if");
            this.k.loadUrl(this.g);
            this.k.setLayoutParams(c);
            this.k.setVisibility(4);
            this.k.getSettings().setSavePassword(false);
        }
    }

    /* compiled from: ProGuard */
    private class JsListener extends a.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            f.b("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onCancelAddShare(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel("cancel");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onCancelInvite() {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f1453l.obtainMessage(1, str).sendToTarget();
            f.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onCancel(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f1453l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void showMsg(String str) {
            TDialog.this.f1453l.obtainMessage(3, str).sendToTarget();
        }

        public void onLoad(String str) {
            TDialog.this.f1453l.obtainMessage(4, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri;
            f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.g.a().a((Context) TDialog.this.e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.h.onComplete(j.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://cancel")) {
                TDialog.this.h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://close")) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
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
                    if (!(TDialog.this.e == null || TDialog.this.e.get() == null)) {
                        ((Context) TDialog.this.e.get()).startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                return true;
            } else {
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TDialog.this.h.onError(new UiError(i, str, str2));
            if (!(TDialog.this.e == null || TDialog.this.e.get() == null)) {
                Toast.makeText((Context) TDialog.this.e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.k.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                Toast toast = d;
                if (toast == null) {
                    d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    d.setText(string);
                    d.setDuration(0);
                }
                d.show();
            } else if (i2 == 1) {
                Toast toast2 = d;
                if (toast2 == null) {
                    d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    d.setText(string);
                    d.setDuration(1);
                }
                d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str) {
        WeakReference<ProgressDialog> weakReference;
        if (context != null && str != null) {
            try {
                JSONObject d2 = j.d(str);
                int i2 = d2.getInt("action");
                String string = d2.getString("msg");
                if (i2 == 1) {
                    WeakReference<ProgressDialog> weakReference2 = f;
                    if (weakReference2 != null) {
                        if (weakReference2.get() != null) {
                            f.get().setMessage(string);
                            if (!f.get().isShowing()) {
                                f.get().show();
                                return;
                            }
                            return;
                        }
                    }
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else if (i2 == 0 && (weakReference = f) != null && weakReference.get() != null && f.get().isShowing()) {
                    f.get().dismiss();
                    f = null;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
