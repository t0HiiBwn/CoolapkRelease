package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AuthAgent extends BaseApi {
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    private IUiListener c;
    private String d;
    private WeakReference<Activity> e;

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = "libwbsafeedit";
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        } else if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = "libwbsafeedit_64";
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        } else if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = "libwbsafeedit_x86";
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
        } else if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = "libwbsafeedit_x86_64";
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        } else {
            SECURE_LIB_FILE_NAME = "libwbsafeedit";
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        }
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    /* compiled from: ProGuard */
    private class c implements IUiListener {
        private final IUiListener b;
        private final boolean c;
        private final Context d;

        public c(Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.d = context;
            this.b = iUiListener;
            this.c = z;
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (!(string == null || AuthAgent.this.b == null || string3 == null)) {
                    AuthAgent.this.b.setAccessToken(string, string2);
                    AuthAgent.this.b.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.d, AuthAgent.this.b);
                }
                String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.d.getSharedPreferences("pfStore", 0).edit().putString("pf", string4).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            f.b();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.b.onError(uiError);
            f.b();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.b.onCancel();
            f.b();
        }
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener) {
        return doLogin(activity, str, iUiListener, false, null);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment) {
        this.d = str;
        this.e = new WeakReference<>(activity);
        this.c = iUiListener;
        if (com.tencent.open.utils.f.a(activity, this.b.getAppId()).b("C_LoginWeb") || !a(activity, fragment, z)) {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "1", "0", "0");
            f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
            b bVar = new b(this.c);
            this.c = bVar;
            return a(z, bVar);
        }
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
        d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "0", "0", "0");
        return 1;
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.c = null;
    }

    private int a(boolean z, IUiListener iUiListener) {
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(e.a());
        Bundle a2 = a();
        if (z) {
            a2.putString("isadd", "1");
        }
        a2.putString("scope", this.d);
        a2.putString("client_id", this.b.getAppId());
        if (isOEM) {
            a2.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            a2.putString("pf", "openmobile_android");
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        a2.putString("sign", h.b(e.a(), str));
        a2.putString("time", str);
        a2.putString("display", "mobile");
        a2.putString("response_type", "token");
        a2.putString("redirect_uri", "auth://tauth.qq.com/");
        a2.putString("cancel_display", "1");
        a2.putString("switch", "1");
        a2.putString("status_userip", j.a());
        final String str2 = g.a().a(e.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(a2);
        final c cVar = new c(e.a(), iUiListener, true, false);
        f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        i.a(new Runnable() {
            /* class com.tencent.connect.auth.AuthAgent.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
                r0 = (android.app.Activity) r3.c.e.get();
             */
            @Override // java.lang.Runnable
            public void run() {
                final Activity activity;
                h.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
                JniInterface.loadSo();
                if (AuthAgent.this.e != null && activity != null) {
                    activity.runOnUiThread(new Runnable() {
                        /* class com.tencent.connect.auth.AuthAgent.AnonymousClass1.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (JniInterface.isJniOk) {
                                a aVar = new a(activity, "action_login", str2, cVar, AuthAgent.this.b);
                                if (!activity.isFinishing()) {
                                    aVar.show();
                                    return;
                                }
                                return;
                            }
                            f.d("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                            TDialog tDialog = new TDialog(activity, "", AuthAgent.this.a(""), null, AuthAgent.this.b);
                            if (!activity.isFinishing()) {
                                tDialog.show();
                            }
                        }
                    });
                }
            }
        });
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    private boolean a(Activity activity, Fragment fragment, boolean z) {
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent b2 = b("com.tencent.open.agent.AgentActivity");
        if (b2 != null) {
            Bundle a2 = a();
            if (z) {
                a2.putString("isadd", "1");
            }
            a2.putString("scope", this.d);
            a2.putString("client_id", this.b.getAppId());
            if (isOEM) {
                a2.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
            } else {
                a2.putString("pf", "openmobile_android");
            }
            a2.putString("need_pay", "1");
            a2.putString("oauth_app_name", h.a(e.a()));
            b2.putExtra("key_action", "action_login");
            b2.putExtra("key_params", a2);
            b2.putExtra("appid", this.b.getAppId());
            if (a(b2)) {
                this.c = new b(this.c);
                UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.c);
                if (fragment != null) {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, b2, 11101);
                } else {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, b2, 11101);
                }
                f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                d.a().a(0, "LOGIN_CHECK_SDK", "1000", this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        d.a().a(1, "LOGIN_CHECK_SDK", "1000", this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    protected void a(IUiListener iUiListener) {
        String str;
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.b.getAccessToken();
        String openId = this.b.getOpenId();
        String appId = this.b.getAppId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = j.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (TextUtils.isEmpty(str)) {
            f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle a2 = a();
        a2.putString("encrytoken", str);
        HttpUtils.requestAsync(this.b, e.a(), "https://openmobile.qq.com/user/user_login_statis", a2, "POST", null);
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }

    protected void b(IUiListener iUiListener) {
        Bundle a2 = a();
        a2.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.b, e.a(), "https://openmobile.qq.com/v3/user/get_info", a2, "GET", new BaseApi.TempRequestListener(new a(iUiListener)));
    }

    /* compiled from: ProGuard */
    private class a implements IUiListener {
        IUiListener a;

        public a(IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            if (obj == null) {
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i = jSONObject.getInt("ret");
                if (i == 0) {
                    str = "success";
                } else {
                    str = jSONObject.getString("msg");
                }
                IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onComplete(new JSONObject().put("ret", i).put("msg", str));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements IUiListener {
        IUiListener a;
        private final String c = "sendinstall";
        private final String d = "installwording";
        private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        public b(IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject;
            String str;
            if (obj != null && (jSONObject = (JSONObject) obj) != null) {
                boolean z = false;
                try {
                    if (jSONObject.getInt("sendinstall") == 1) {
                        z = true;
                    }
                    str = jSONObject.getString("installwording");
                } catch (JSONException unused) {
                    f.d("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    str = "";
                }
                String decode = URLDecoder.decode(str);
                f.a("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx");
                if (z && !TextUtils.isEmpty(decode)) {
                    a(decode, this.a, obj);
                } else if (this.a != null) {
                    if (AuthAgent.this.b != null) {
                        AuthAgent.this.b.saveSession(jSONObject);
                    }
                    this.a.onComplete(obj);
                }
            }
        }

        /* compiled from: ProGuard */
        private abstract class a implements View.OnClickListener {
            Dialog d;

            a(Dialog dialog) {
                this.d = dialog;
            }
        }

        private void a(String str, final IUiListener iUiListener, final Object obj) {
            Activity activity;
            PackageInfo packageInfo;
            if (AuthAgent.this.e != null && (activity = (Activity) AuthAgent.this.e.get()) != null) {
                Dialog dialog = new Dialog(activity);
                dialog.requestWindowFeature(1);
                PackageManager packageManager = activity.getPackageManager();
                Drawable drawable = null;
                try {
                    packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    drawable = packageInfo.applicationInfo.loadIcon(packageManager);
                }
                View.OnClickListener r5 = new a(dialog) {
                    /* class com.tencent.connect.auth.AuthAgent.b.AnonymousClass1 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.a();
                        if (this.d != null && this.d.isShowing()) {
                            this.d.dismiss();
                        }
                        IUiListener iUiListener = iUiListener;
                        if (iUiListener != null) {
                            iUiListener.onComplete(obj);
                        }
                    }
                };
                View.OnClickListener r6 = new a(dialog) {
                    /* class com.tencent.connect.auth.AuthAgent.b.AnonymousClass2 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (this.d != null && this.d.isShowing()) {
                            this.d.dismiss();
                        }
                        IUiListener iUiListener = iUiListener;
                        if (iUiListener != null) {
                            iUiListener.onComplete(obj);
                        }
                    }
                };
                ColorDrawable colorDrawable = new ColorDrawable();
                colorDrawable.setAlpha(0);
                dialog.getWindow().setBackgroundDrawable(colorDrawable);
                dialog.setContentView(a(activity, drawable, str, r5, r6));
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.connect.auth.AuthAgent.b.AnonymousClass3 */

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        IUiListener iUiListener = iUiListener;
                        if (iUiListener != null) {
                            iUiListener.onComplete(obj);
                        }
                    }
                });
                if (activity != null && !activity.isFinishing()) {
                    dialog.show();
                }
            }
        }

        private Drawable a(String str, Context context) {
            Bitmap bitmap;
            Drawable drawable = null;
            try {
                InputStream open = context.getApplicationContext().getAssets().open(str);
                if (open == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        bitmap = BitmapFactory.decodeStream(open);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
                }
                drawable = Drawable.createFromStream(open, str);
                open.close();
                return drawable;
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }

        private View a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (f * 14.0f);
            int i3 = (int) (18.0f * f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, (int) (6.0f * f), i3);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams2.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i4 = (int) (12.0f * f);
            layoutParams3.setMargins(0, 0, 0, i4);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i5 = (int) (45.0f * f);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i5);
            layoutParams5.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams5.leftMargin = i6;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i5);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i6;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
            relativeLayout.setPadding(i2, 0, i4, i4);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        protected void a() {
            Activity activity;
            Bundle b2 = AuthAgent.this.b();
            if (AuthAgent.this.e != null && (activity = (Activity) AuthAgent.this.e.get()) != null) {
                HttpUtils.requestAsync(AuthAgent.this.b, activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b2, "POST", null);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }
    }
}
