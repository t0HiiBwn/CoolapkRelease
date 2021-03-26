package com.tencent.android.tpush;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class TpnsActivity extends Activity {
    public static final String CHECK_CODE = "checkCode";
    public static final String CUSTOM_CONTENT = "customContent";
    public static final String JUMP_type = "jumpType";
    public static final String MSG_TYPE = "msgType";
    public static final String TARGE_ACTIVITY = "targetActivity";
    public static final String TIMESTAMP = "timestamp";
    static Application.ActivityLifecycleCallbacks a = null;
    static List<String> b = null;
    static String c = "";
    static long d;
    static long e;
    private String f = "";
    private int g = 100;

    private boolean a(Intent intent) {
        if (intent == null || !intent.hasExtra("protect")) {
            return false;
        }
        String stringExtra = intent.getStringExtra("protect");
        if (j.b(stringExtra)) {
            return false;
        }
        try {
            Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
            if (valueOf.longValue() <= 0 || System.currentTimeMillis() < valueOf.longValue()) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            TLogger.i("TpnsActivity", "TpnsActivity receiver intent:" + intent);
            if (!(intent == null || intent.getExtras() == null)) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey("pushChannel") && (extras.get("pushChannel") instanceof String) && (string = extras.getString("pushChannel")) != null && !TextUtils.isEmpty(string)) {
                    int intValue = Integer.valueOf(string).intValue();
                    this.g = intValue;
                    if (intValue == 101) {
                        b(intent);
                    }
                }
            }
            if (a(intent)) {
                int intExtra = intent.getIntExtra("action_type", NotificationAction.activity.getType());
                if (intExtra == NotificationAction.activity.getType()) {
                    d(intent);
                } else if (intExtra == NotificationAction.action_package.getType()) {
                    e(intent);
                } else if (intExtra == NotificationAction.url.getType()) {
                    b(0, intent);
                } else {
                    if (intExtra != NotificationAction.intent.getType()) {
                        if (intExtra != NotificationAction.intent_with_action.getType()) {
                            finish();
                            return;
                        }
                    }
                    b(1, intent);
                }
            } else {
                c(intent);
            }
        } catch (Throwable unused) {
        }
    }

    private void b(Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra("checkCode");
        String md5 = Md5.md5(intent.getStringExtra("msgId"));
        if (md5 == null || !stringExtra.equals(md5)) {
            finish();
        } else {
            String string = extras.getString("content");
            TLogger.ii("TpnsActivity", "fcmChannelDeepLink content ：" + string);
            if (string != null && !TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    JSONObject optJSONObject = jSONObject.optJSONObject("action");
                    int optInt = optJSONObject.optInt("action_type", 0);
                    String optString = optJSONObject.optString("activity");
                    String optString2 = optJSONObject.optJSONObject("browser").optString("url");
                    String optString3 = optJSONObject.optString("intent");
                    String optString4 = jSONObject.optString("custom_content");
                    final XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt == 3) {
                                if (optString3 != null && !TextUtils.isEmpty(optString3)) {
                                    xGPushClickedResult.activityName = optString3;
                                    c(optString3);
                                }
                            }
                        } else if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                            xGPushClickedResult.activityName = optString2;
                            b(optString2);
                        }
                    } else if (optString == null || TextUtils.isEmpty(optString)) {
                        xGPushClickedResult.activityName = optString;
                        a();
                    } else {
                        xGPushClickedResult.activityName = optString;
                        a(optString);
                    }
                    xGPushClickedResult.notificationActionType = optInt;
                    xGPushClickedResult.customContent = optString4;
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            TpnsActivity.this.a(extras, xGPushClickedResult);
                        }
                    });
                } catch (Throwable th) {
                    TLogger.ii("TpnsActivity", "TpnsActivity fcmChannelDeepLink e:" + th);
                }
            }
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle, XGPushClickedResult xGPushClickedResult) {
        Object th;
        String str;
        String str2;
        long j;
        int i;
        try {
            String string = bundle.getString("groupId");
            String string2 = bundle.getString("ts");
            String string3 = bundle.getString("targetType");
            String string4 = bundle.getString("busiMsgId");
            String string5 = bundle.getString("msgId");
            String string6 = bundle.getString("pushTime");
            String string7 = bundle.getString("source");
            String string8 = bundle.getString("type");
            String string9 = bundle.getString("pushChannel");
            String string10 = bundle.getString("templateId");
            String string11 = bundle.getString("traceId");
            try {
                Intent intent = new Intent();
                long j2 = 0;
                if (string4 != null) {
                    str2 = "traceId";
                    str = "templateId";
                    j = Long.valueOf(e).longValue();
                } else {
                    str2 = "traceId";
                    str = "templateId";
                    j = 0;
                }
                intent.putExtra("busiMsgId", j);
                intent.putExtra("msgId", string5 != null ? Long.valueOf(string5).longValue() : 0);
                intent.putExtra("type", string8 != null ? Long.valueOf(string8).longValue() : 1);
                intent.putExtra("groupId", string);
                int i2 = 101;
                intent.putExtra("pushChannel", string9 != null ? Integer.valueOf(string9).intValue() : 101);
                intent.putExtra("targetType", string3 != null ? Long.valueOf(string3).longValue() : 0);
                intent.putExtra("pushTime", string6 != null ? Long.valueOf(string6).longValue() * 1000 : 0);
                intent.putExtra("source", string7 != null ? Long.valueOf(string7).longValue() : 0);
                intent.putExtra("timestamps", string2 != null ? Long.valueOf(string2).longValue() * 1000 : 0);
                intent.putExtra(str, string10);
                intent.putExtra(str2, string11);
                g(intent);
                Intent intent2 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                intent2.setPackage(getApplicationContext().getPackageName());
                intent2.putExtra("TPUSH.FEEDBACK", 4);
                intent2.putExtra("TPUSH.ERRORCODE", 0);
                if (string9 != null) {
                    i2 = Integer.valueOf(string9).intValue();
                }
                intent2.putExtra("PUSH.CHANNEL", i2);
                intent2.putExtra("action", NotificationAction.clicked.getType());
                if (xGPushClickedResult.notificationActionType != 0) {
                    i = xGPushClickedResult.notificationActionType;
                } else {
                    i = NotificationAction.activity.getType();
                }
                intent2.putExtra("notificationActionType", i);
                intent2.putExtra("custom_content", xGPushClickedResult.customContent);
                if (string5 != null) {
                    j2 = Long.valueOf(string5).longValue();
                }
                intent2.putExtra("msgId", j2);
                intent2.putExtra(str, string10);
                intent2.putExtra(str2, string11);
                if (xGPushClickedResult.activityName == null || TextUtils.isEmpty(xGPushClickedResult.activityName)) {
                    String a2 = a(this);
                    this.f = a2;
                    intent2.putExtra("activity", a2);
                } else {
                    intent2.putExtra("activity", xGPushClickedResult.activityName);
                }
                d.a(getApplicationContext(), intent2);
            } catch (Throwable th2) {
                th = th2;
                TLogger.ii("TpnsActivity", "TpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
            }
        } catch (Throwable th3) {
            th = th3;
            TLogger.ii("TpnsActivity", "TpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
        }
    }

    private void c(Intent intent) {
        String md5;
        if (intent != null) {
            try {
                final Uri data = intent.getData();
                if (data != null) {
                    String uri = data.toString();
                    TLogger.ii("TpnsActivity", "TpnsActivity receiver otherChannelDeepLink url:" + uri);
                    String queryParameter = data.getQueryParameter("msgId");
                    String queryParameter2 = data.getQueryParameter("checkCode");
                    if (queryParameter != null && !TextUtils.isEmpty(queryParameter) && queryParameter2 != null && !TextUtils.isEmpty(queryParameter2) && (md5 = Md5.md5(queryParameter)) != null && queryParameter2.equals(md5)) {
                        String queryParameter3 = data.getQueryParameter("jumpType");
                        String queryParameter4 = data.getQueryParameter("targetActivity");
                        if (!(queryParameter3 == null || queryParameter4 == null)) {
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                if (queryParameter4 != null && queryParameter4.length() > 0) {
                                    if (queryParameter3 != null && queryParameter3.equals("0")) {
                                        a();
                                    } else if (queryParameter3 != null && queryParameter3.equals("1")) {
                                        a(queryParameter4);
                                    } else if (queryParameter3 != null && queryParameter3.equals("2")) {
                                        b(queryParameter4);
                                    } else if (queryParameter3 != null && queryParameter3.equals("3")) {
                                        c(queryParameter4);
                                    }
                                }
                                CommonWorkingThread.getInstance().execute(new Runnable() {
                                    /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass3 */

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TpnsActivity.this.a(data);
                                    }
                                });
                            }
                        }
                        TLogger.i("TpnsActivity", "TpnsActivity receiver jumpType == null || targetIntent == null");
                        a();
                        CommonWorkingThread.getInstance().execute(new Runnable() {
                            /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass3 */

                            @Override // java.lang.Runnable
                            public void run() {
                                TpnsActivity.this.a(data);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                TLogger.ii("TpnsActivity", "TpnsActivity receiver e:" + th);
                finish();
                return;
            }
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void a(Uri uri) {
        String str;
        Object th;
        String str2;
        String str3;
        long j;
        long j2;
        String str4;
        try {
            String queryParameter = uri.getQueryParameter("jumpType");
            String queryParameter2 = uri.getQueryParameter("busiMsgId");
            String queryParameter3 = uri.getQueryParameter("msgId");
            String queryParameter4 = uri.getQueryParameter("msgType");
            try {
                String queryParameter5 = uri.getQueryParameter("groupId");
                String queryParameter6 = uri.getQueryParameter("pushChannel");
                try {
                    String queryParameter7 = uri.getQueryParameter("targetType");
                    String queryParameter8 = uri.getQueryParameter("pushTime");
                    String queryParameter9 = uri.getQueryParameter("source");
                    String queryParameter10 = uri.getQueryParameter("timestamp");
                    String queryParameter11 = uri.getQueryParameter("customContent");
                    String queryParameter12 = uri.getQueryParameter("targetActivity");
                    String queryParameter13 = uri.getQueryParameter("tmpl");
                    String queryParameter14 = uri.getQueryParameter("trace");
                    Intent intent = new Intent();
                    long j3 = 0;
                    if (queryParameter2 != null) {
                        str3 = queryParameter8;
                        str2 = queryParameter9;
                        j = Long.valueOf(queryParameter2).longValue();
                    } else {
                        str3 = queryParameter8;
                        str2 = queryParameter9;
                        j = 0;
                    }
                    intent.putExtra("busiMsgId", j);
                    intent.putExtra("msgId", queryParameter3 != null ? Long.valueOf(queryParameter3).longValue() : 0);
                    intent.putExtra("type", queryParameter4 != null ? Long.valueOf(queryParameter4).longValue() : 1);
                    intent.putExtra("groupId", queryParameter5);
                    int i = 0;
                    intent.putExtra("pushChannel", queryParameter6 != null ? Integer.valueOf(queryParameter6).intValue() : 0);
                    intent.putExtra("targetType", queryParameter7 != null ? Long.valueOf(queryParameter7).longValue() : 0);
                    intent.putExtra("pushTime", str3 != null ? Long.valueOf(str3).longValue() * 1000 : 0);
                    if (str2 != null) {
                        j2 = Long.valueOf(str2).longValue();
                        str4 = "source";
                    } else {
                        str4 = "source";
                        j2 = 0;
                    }
                    intent.putExtra(str4, j2);
                    intent.putExtra("timestamps", queryParameter10 != null ? Long.valueOf(queryParameter10).longValue() * 1000 : 0);
                    intent.putExtra("templateId", queryParameter13);
                    intent.putExtra("traceId", queryParameter14);
                    g(intent);
                    str = "TpnsActivity";
                    try {
                        TLogger.i(str, "TpnsActivity receiver params : msgBuildId " + queryParameter2 + " , msgId = " + queryParameter3 + " , jumpType = " + queryParameter + " , msgType = " + queryParameter4 + " , groupId = " + queryParameter5 + " , pushChannel = " + queryParameter6 + " , targetType = " + queryParameter7 + " , pushTime = " + str3 + " , source = " + str2 + " , timestamp = " + queryParameter10 + " , templateId = " + queryParameter13 + " , traceId = " + queryParameter14);
                        Intent intent2 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                        intent2.setPackage(getApplicationContext().getPackageName());
                        intent2.putExtra("TPUSH.FEEDBACK", 4);
                        intent2.putExtra("TPUSH.ERRORCODE", 0);
                        if (queryParameter6 != null) {
                            i = Integer.valueOf(queryParameter6).intValue();
                        }
                        intent2.putExtra("PUSH.CHANNEL", i);
                        intent2.putExtra("action", NotificationAction.clicked.getType());
                        intent2.putExtra("notificationActionType", queryParameter != null ? Integer.valueOf(queryParameter).intValue() : NotificationAction.activity.getType());
                        intent2.putExtra("custom_content", queryParameter11);
                        if (queryParameter3 != null) {
                            j3 = Long.valueOf(queryParameter3).longValue();
                        }
                        intent2.putExtra("msgId", j3);
                        intent2.putExtra("templateId", queryParameter13);
                        intent2.putExtra("traceId", queryParameter14);
                        if (queryParameter12 == null || TextUtils.isEmpty(queryParameter12)) {
                            String a2 = a(this);
                            this.f = a2;
                            intent2.putExtra("activity", a2);
                        } else {
                            intent2.putExtra("activity", queryParameter12);
                        }
                        d.a(getApplicationContext(), intent2);
                    } catch (Throwable th2) {
                        th = th2;
                        TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = "TpnsActivity";
                    TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
                }
            } catch (Throwable th4) {
                th = th4;
                str = "TpnsActivity";
                TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
            }
        } catch (Throwable th5) {
            th = th5;
            str = "TpnsActivity";
            TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
        }
    }

    private void a(String str) {
        try {
            Intent intent = new Intent();
            TLogger.i("TpnsActivity", "TpnsActivity receiver  jumpOtherChannelActivitys targetActivity = " + str);
            intent.setClassName(getApplicationContext(), str);
            intent.addFlags(536870912);
            intent.addFlags(538968064);
            intent.setFlags(67239936);
            startActivity(intent);
        } catch (Throwable th) {
            TLogger.ii("TpnsActivity", "TpnsActivity receiver jumpOtherChannelActivitys = " + th);
        }
    }

    private void a() {
        Intent intent = new Intent();
        String str = this.f;
        if (str == null || TextUtils.isEmpty(str)) {
            this.f = a(this);
        }
        TLogger.i("TpnsActivity", "TpnsActivity receiver  jumpOtherChannelActivity targetActivity = " + this.f);
        intent.setClassName(getApplicationContext(), this.f);
        intent.addFlags(536870912);
        intent.addFlags(538968064);
        intent.setFlags(67239936);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            TLogger.ii("TpnsActivity", "TpnsActivity receiver ActivityNotFoundException = " + e2);
        }
    }

    private void b(String str) {
        try {
            TLogger.i("TpnsActivity", "TpnsActivity receiver jumpOtherChannelUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Throwable th) {
            TLogger.e("TpnsActivity", "openUrl error.", th);
        }
    }

    private void c(String str) {
        try {
            Intent intent = new Intent();
            TLogger.i("TpnsActivity", "TpnsActivity receiver jumpOtherChannelIntent targetActivity:" + str);
            Uri parse = Uri.parse(str);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } catch (Throwable th) {
            TLogger.e("TpnsActivity", "jumpOtherChannelIntent error.", th);
        }
    }

    private static String a(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (resolveInfo.activityInfo != null) {
                    return resolveInfo.activityInfo.name;
                }
            }
        } catch (Throwable th) {
            TLogger.e("TpnsActivity", "get Activity error", th);
        }
        return null;
    }

    static void a(Application application) {
        if (a == null) {
            a = new Application.ActivityLifecycleCallbacks() {
                /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass4 */

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }
            };
            if (application != null) {
                try {
                    ((Application) application.getApplicationContext()).registerActivityLifecycleCallbacks(a);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void addActivityNames(String str) {
        if (!j.b(str)) {
            if (b == null) {
                b = new ArrayList();
            }
            if (!b.contains(str)) {
                b.add(str);
            }
        }
    }

    public static boolean isMonitorActivityNames(String str) {
        if (b != null && !j.b(str) && b.contains(str)) {
            return true;
        }
        return false;
    }

    private void d(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("activity") != null ? intent.getStringExtra("activity") : "";
            if (XGPushConfig.enableDebug) {
                TLogger.i("TpnsActivity", "activity intent =" + intent + "activity = " + str + "intent.getFlags()" + intent.getFlags());
            }
            d = intent.getLongExtra("msgId", 0);
            e = intent.getLongExtra("busiMsgId", 0);
            c = str;
        } else {
            str = null;
        }
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            intent2.setClassName(getApplicationContext(), str);
            intent.putExtra("tag.tpush.MSG", "true");
            intent2.putExtras(intent);
        }
        intent2.addFlags(536870912);
        intent2.putExtra("tag.tpush.NOTIFIC", XGPushManager.a((Activity) this));
        try {
            a(getApplication());
            startActivity(intent2);
        } catch (ActivityNotFoundException unused) {
        }
        finish();
    }

    private void e(Intent intent) {
        g(intent);
        ResolveInfo d2 = d(intent.getStringExtra("packageName"));
        if (d2 != null) {
            String str = d2.activityInfo.name;
            String str2 = d2.activityInfo.packageName;
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            intent2.setComponent(new ComponentName(str2, str));
            a(0, intent2);
            return;
        }
        a(1, intent);
    }

    private ResolveInfo d(String str) {
        try {
            PackageManager packageManager = getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str2 = resolveInfo.activityInfo.name;
                if (resolveInfo.activityInfo.packageName.equals(str)) {
                    return resolveInfo;
                }
            }
        } catch (Throwable th) {
            TLogger.e("TpnsActivity", "查找主Activity出错", th);
        }
        return null;
    }

    private void a(int i, final Intent intent) {
        if (i == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass7 */

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    TpnsActivity.this.g(intent);
                    TpnsActivity.this.finish();
                }
            }).setTitle("提示").setMessage("是否确定打开此应用？").setPositiveButton("打开", new DialogInterface.OnClickListener() {
                /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass6 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.putExtra("action", NotificationAction.open.getType());
                    TpnsActivity.this.g(intent);
                    try {
                        TpnsActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                    TpnsActivity.this.finish();
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass5 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    TpnsActivity.this.g(intent);
                    dialogInterface.dismiss();
                    TpnsActivity.this.finish();
                }
            });
            builder.create().show();
        }
    }

    private void b(int i, final Intent intent) {
        if (i == 0) {
            final String stringExtra = intent.getStringExtra("activity");
            if (intent.getIntExtra("action_confirm", 0) == 1) {
                AlertDialog.Builder cancelable = new AlertDialog.Builder(this).setTitle("提示").setCancelable(false);
                cancelable.setMessage("是否打开网站:" + stringExtra + "?").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass9 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TpnsActivity.this.a(stringExtra, intent);
                        TpnsActivity.this.finish();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass8 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TpnsActivity.this.g(intent);
                        dialogInterface.cancel();
                        TpnsActivity.this.finish();
                    }
                }).show();
                return;
            }
            a(stringExtra, intent);
        } else if (i != 1) {
        } else {
            if (intent.getIntExtra("action_confirm", 0) == 1) {
                new AlertDialog.Builder(this).setTitle("提示").setCancelable(false).setMessage("继续打开Intent?").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass2 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TpnsActivity.this.f(intent);
                        TpnsActivity.this.finish();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    /* class com.tencent.android.tpush.TpnsActivity.AnonymousClass10 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TpnsActivity.this.g(intent);
                        dialogInterface.cancel();
                        TpnsActivity.this.finish();
                    }
                }).show();
            } else {
                f(intent);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f(Intent intent) {
        Uri uri;
        try {
            Intent intent2 = new Intent();
            int intExtra = intent.getIntExtra("action_type", NotificationAction.intent.getType());
            if (intExtra == NotificationAction.intent.getType()) {
                int intExtra2 = intent.getIntExtra("PUSH.CHANNEL", 100);
                this.g = intExtra2;
                if (intExtra2 == 101 || intExtra2 == 99) {
                    uri = Uri.parse(URLDecoder.decode(intent.getStringExtra("activity"), "UTF-8"));
                } else {
                    uri = Uri.parse(intent.getStringExtra("activity"));
                }
                intent2.setAction("android.intent.action.VIEW");
                intent2.setData(uri);
            } else if (intExtra == NotificationAction.intent_with_action.getType()) {
                intent2.setAction(intent.getStringExtra("activity"));
                intent2.setPackage(getPackageName());
                intent2.setFlags(268435456);
            }
            XGPushManager.a((Activity) this);
            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivity(intent2);
            }
            finish();
        } catch (Throwable th) {
            TLogger.e("TpnsActivity", "openIntent error.", th);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Intent intent) {
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.setFlags(268435456);
            XGPushManager.a((Activity) this);
            startActivity(intent2);
        } catch (Throwable th) {
            TLogger.e("TpnsActivity", "openUrl error.", th);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void g(Intent intent) {
        XGPushManager.a(getApplicationContext(), intent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
