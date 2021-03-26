package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import com.ss.android.a.a.a.q;
import com.ss.android.a.a.c.c;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.a.d;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.downloadlib.h.i;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static a d;
    protected Intent a = null;
    private boolean b;
    private b c;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(k.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, com.ss.android.downloadad.a.b.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 2);
        c2.putExtra("open_url", str);
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    public static void b(String str, com.ss.android.downloadad.a.b.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 11);
        c2.putExtra("package_name", str);
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    public static void a(com.ss.android.downloadad.a.b.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 4);
        c2.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    public static void a(com.ss.android.downloadad.a.b.a aVar, a aVar2) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 9);
        d = aVar2;
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    public static void a(long j) {
        Intent intent = new Intent(k.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private static Intent c(com.ss.android.downloadad.a.b.a aVar) {
        return new Intent(k.a(), TTDelegateActivity.class);
    }

    public static void b(com.ss.android.downloadad.a.b.a aVar) {
        a(aVar, 5, "", "", "");
    }

    public static void a(com.ss.android.downloadad.a.b.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3);
    }

    public static void b(com.ss.android.downloadad.a.b.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3);
    }

    private static void a(com.ss.android.downloadad.a.b.a aVar, int i, String str, String str2, String str3) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            c2.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            c2.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            c2.putExtra("message_text", str);
        }
        c2.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.a = getIntent();
        k.b(this);
        a();
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a = intent;
        k.b(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        k.f().a(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        DownloadInfo a2;
        super.onStop();
        if (this.b && this.c != null && (a2 = g.a((Context) null).a(this.c.a())) != null && a2.getCurBytes() >= a2.getTotalBytes() && !isFinishing()) {
            finish();
        }
    }

    protected void a() {
        Intent intent = this.a;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    a(this.a.getStringExtra("open_url"));
                    break;
                case 3:
                case 6:
                default:
                    c.a((Activity) this);
                    break;
                case 4:
                    c(this.a.getLongExtra("model_id", 0));
                    break;
                case 5:
                    b(this.a.getLongExtra("model_id", 0));
                    break;
                case 7:
                case 8:
                    c();
                    break;
                case 9:
                    a aVar = d;
                    if (aVar != null) {
                        aVar.a();
                    }
                    c.a((Activity) this);
                    break;
                case 10:
                    d(this.a.getLongExtra("app_info_id", 0));
                    break;
                case 11:
                    b(this.a.getStringExtra("package_name"));
                    break;
            }
            this.a = null;
        }
    }

    private void c() {
        String str;
        long longExtra = this.a.getLongExtra("model_id", 0);
        String stringExtra = this.a.getStringExtra("message_text");
        String stringExtra2 = this.a.getStringExtra("positive_button_text");
        String stringExtra3 = this.a.getStringExtra("negative_button_text");
        int intExtra = this.a.getIntExtra("type", 0);
        b d2 = f.a().d(longExtra);
        d.a c2 = new d.a(this).a(false).a(stringExtra).b(stringExtra2).c(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.d.b.a() != null) {
                c2.a(com.ss.android.downloadlib.addownload.d.b.a());
                c2.a().show();
                str = "download_percent";
            } else {
                return;
            }
        } else if (intExtra != 8) {
            str = "";
        } else if (com.ss.android.downloadlib.addownload.d.a.a() != null) {
            c2.a(com.ss.android.downloadlib.addownload.d.a.a());
            c2.a().show();
            str = "apk_size";
        } else {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.b = true;
            this.c = d2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", str);
                jSONObject.putOpt("pause_optimise_action", "show_dialog");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.a().a("pause_optimise", jSONObject, (com.ss.android.downloadad.a.b.a) d2);
        }
    }

    private void b(long j) {
        if (m.a() != null) {
            b d2 = f.a().d(j);
            if (d2 != null) {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(d2.s());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - d2.S()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(d2.T()));
                    if (downloadInfo != null) {
                        jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                        jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                        jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.a().a("pause_reserve_wifi_dialog_show", jSONObject, (com.ss.android.downloadad.a.b.a) d2);
            }
            new d.a(this).a(false).a(m.a()).a().show();
            this.b = true;
            this.c = d2;
        }
    }

    private void b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            c.a((Activity) this);
            return;
        }
        AnonymousClass1 r0 = new q() {
            /* class com.ss.android.downloadlib.activity.TTDelegateActivity.AnonymousClass1 */
            private WeakReference<Activity> c;

            {
                this.c = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.ss.android.a.a.a.q
            public void a() {
                i.a(str);
                c.a(this.c.get());
            }

            @Override // com.ss.android.a.a.a.q
            public void a(String str) {
                i.a(str, str);
                c.a(this.c.get());
            }
        };
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                k.f().a(this, strArr, r0);
            } catch (Exception unused) {
                r0.a();
            }
        } else {
            r0.a();
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            c.a((Activity) this);
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra("start_only_for_android", true);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            c.a((Activity) this);
            throw th;
        }
        c.a((Activity) this);
    }

    private void b(String str) {
        Intent f = com.ss.android.downloadlib.h.k.f(this, str);
        if (f == null) {
            c.a((Activity) this);
            return;
        }
        try {
            f.addFlags(268435456);
            f.putExtra("start_only_for_android", true);
            startActivity(f);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            c.a((Activity) this);
            throw th;
        }
        c.a((Activity) this);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0037: APUT  (r1v2 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v2 java.lang.String) */
    private void c(long j) {
        final b d2 = f.a().d(j);
        if (d2 == null) {
            com.ss.android.downloadlib.h.k.b();
            c.a((Activity) this);
            return;
        }
        com.ss.android.a.a.a.k d3 = k.d();
        c.a a2 = new c.a(this).a("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(d2.M()) ? "刚刚下载的应用" : d2.M();
        d3.b(a2.b(String.format("%1$s已安装完成，是否立即打开？", objArr)).c("打开").d("取消").a(false).a(com.ss.android.downloadlib.h.k.c(this, d2.e())).a(new c.b() {
            /* class com.ss.android.downloadlib.activity.TTDelegateActivity.AnonymousClass2 */

            @Override // com.ss.android.a.a.c.c.b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.a.b(d2);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.a.a.c.c.b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.a().a("market_openapp_cancel", (com.ss.android.downloadad.a.b.a) d2);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.a.a.c.c.b
            public void c(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }
        }).a(2).a());
        com.ss.android.downloadlib.e.a.a().a("market_openapp_window_show", (com.ss.android.downloadad.a.b.a) d2);
    }

    private void d(long j) {
        new com.ss.android.downloadlib.addownload.compliance.a(this, j).show();
    }
}
