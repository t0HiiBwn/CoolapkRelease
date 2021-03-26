package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.c.g;
import com.huawei.updatesdk.service.e.c;
import com.huawei.updatesdk.service.f.a;
import com.huawei.updatesdk.service.otaupdate.c;
import java.io.Serializable;
import java.util.concurrent.Executors;

public class AppUpdateActivity extends Activity implements com.huawei.updatesdk.service.b.b, b {
    private String a = "com.huawei.appmarket";
    private AlertDialog b;
    private com.huawei.updatesdk.service.f.a c;
    private com.huawei.updatesdk.service.f.a d;
    private ProgressBar e;
    private TextView f;
    private boolean g = false;
    private boolean h = false;
    private ApkUpgradeInfo i = null;
    private boolean j = false;
    private boolean k = false;
    private com.huawei.updatesdk.a.b.b.b l;
    private int m = -99;
    private int n = -99;
    private int o = -99;
    private Intent p = null;
    private d q;

    public class a implements c.a {
        public a() {
        }

        @Override // com.huawei.updatesdk.service.otaupdate.c.a
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                try {
                    Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateRemindAction");
                    intent.setPackage("com.huawei.appmarket");
                    AppUpdateActivity.this.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    com.huawei.updatesdk.a.a.b.a.a.a.d("AppUpdateActivity", "goHiappUpgrade error: " + e.toString());
                }
            }
            AppUpdateActivity.this.finish();
        }
    }

    private static class b implements DialogInterface.OnDismissListener {
        private b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra("dialogstatus", 10001);
            d.a().b(intent);
        }
    }

    private static class c implements DialogInterface.OnShowListener {
        private c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra("dialogstatus", 10002);
            d.a().b(intent);
        }
    }

    private class d extends com.huawei.updatesdk.a.b.c.a {
        private d() {
        }

        @Override // com.huawei.updatesdk.a.b.c.a
        public void a(Context context, com.huawei.updatesdk.a.b.c.b bVar) {
            if (bVar.d()) {
                if (AppUpdateActivity.this.c != null) {
                    AppUpdateActivity.this.c.c();
                }
                AppUpdateActivity.this.f();
                String b = bVar.b();
                String dataString = bVar.c().getDataString();
                if (dataString != null && dataString.length() >= 9) {
                    String substring = dataString.substring(8);
                    if ("android.intent.action.PACKAGE_ADDED".equals(b) && AppUpdateActivity.this.a.equals(substring)) {
                        d.a().a(AppUpdateActivity.this.a(6, 0, -1));
                        g.a.a(substring, 1);
                        AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                        appUpdateActivity.a(appUpdateActivity.i.getPackage_(), AppUpdateActivity.this.i.getDetailId_());
                        if (AppUpdateActivity.this.j) {
                            AppUpdateActivity appUpdateActivity2 = AppUpdateActivity.this;
                            appUpdateActivity2.d(appUpdateActivity2.i);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public Intent a(int i2, int i3, int i4) {
        Intent intent = new Intent();
        intent.putExtra("downloadStatus", i4);
        intent.putExtra("installState", i2);
        intent.putExtra("installType", i3);
        return intent;
    }

    private void a() {
        a.a(this, this.q);
        com.huawei.updatesdk.service.b.c.b().b(this);
        com.huawei.updatesdk.a.b.b.b bVar = this.l;
        if (bVar != null) {
            bVar.b();
        }
        f.a((b) null);
    }

    private void a(View view) {
        try {
            ScrollView scrollView = (ScrollView) view.findViewById(g.a(this, "scroll_layout"));
            if (Build.VERSION.SDK_INT >= 22) {
                TypedValue typedValue = new TypedValue();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getTheme().resolveAttribute(16843987, typedValue, true);
                ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, displayMetrics);
                scrollView.setPadding(complexToDimensionPixelSize, 0, complexToDimensionPixelSize, 0);
            }
        } catch (Exception e2) {
            com.huawei.updatesdk.a.a.b.a.a.a.d("AppUpdateActivity", e2.toString());
        }
    }

    private void a(com.huawei.updatesdk.a.b.c.b bVar) {
        if (this.e != null) {
            this.e.setProgress(i.a(bVar.a("download_apk_already", 0), bVar.a("download_apk_size", 0)));
            this.f.setText(i.a((int) ((((float) this.e.getProgress()) / ((float) this.e.getMax())) * 100.0f)));
        }
    }

    private void a(ApkUpgradeInfo apkUpgradeInfo, TextView textView) {
        if (textView != null) {
            if (apkUpgradeInfo.getDiffSize_() > 0) {
                String a2 = i.a(this, apkUpgradeInfo.getLongSize_());
                SpannableString spannableString = new SpannableString(a2);
                spannableString.setSpan(new StrikethroughSpan(), 0, a2.length(), 33);
                spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, (int) textView.getTextSize(), null, null), 0, spannableString.length(), 33);
                textView.setText(spannableString);
                return;
            }
            textView.setVisibility(8);
        }
    }

    private void a(String str) {
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage(this.a);
        intent.putExtra("APP_PACKAGENAME", str);
        intent.putExtra("APP_MUST_UPDATE_BTN", this.k);
        try {
            this.h = false;
            startActivityForResult(intent, 1002);
        } catch (ActivityNotFoundException e2) {
            com.huawei.updatesdk.a.a.b.a.a.a.d("AppUpdateActivity", "goHiappUpgrade error: " + e2.toString());
            this.h = true;
            Intent intent2 = new Intent();
            intent2.putExtra("status", 8);
            d.a().b(intent2);
            d(this.i);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.m = 1;
            finish();
            return;
        }
        Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
        intent.setPackage(this.a);
        intent.putExtra("appDetailId", str2);
        intent.putExtra("thirdId", str);
        intent.addFlags(268468224);
        try {
            startActivity(intent);
            if (!this.j) {
                finish();
            }
        } catch (ActivityNotFoundException unused) {
            f.a(this);
            f.a(this.a);
            Intent intent2 = new Intent();
            intent2.putExtra("status", 8);
            d.a().b(intent2);
            if (this.d != null) {
                this.d.c();
            }
        }
    }

    private void b() {
        com.huawei.updatesdk.service.f.a aVar = this.d;
        if (aVar != null) {
            aVar.a(new b());
            this.d.a(new c());
        }
    }

    private void b(com.huawei.updatesdk.a.b.c.b bVar) {
        Bundle a2 = bVar.a();
        if (a2 != null) {
            int i2 = a2.getInt("download_status_param", -1);
            d.a().a(a(-1, -1, i2));
            if (!com.huawei.updatesdk.a.b.b.a.a.b(i2)) {
                f();
                if (com.huawei.updatesdk.a.b.b.a.a.a(i2)) {
                    Toast.makeText(this, getString(g.b(this, "upsdk_third_app_dl_install_failed")), 0).show();
                    finish();
                }
            }
        }
    }

    private void b(final ApkUpgradeInfo apkUpgradeInfo) {
        final com.huawei.updatesdk.service.f.a a2 = com.huawei.updatesdk.service.f.a.a(this, null, getString(g.b(this, "upsdk_install")));
        a2.a(new com.huawei.updatesdk.service.f.b() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass6 */

            @Override // com.huawei.updatesdk.service.f.b
            public void a() {
                if (!com.huawei.updatesdk.a.a.c.b.b.a(AppUpdateActivity.this)) {
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    Toast.makeText(appUpdateActivity, g.b(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
                    AppUpdateActivity.this.finish();
                    return;
                }
                AppUpdateActivity.this.e(apkUpgradeInfo);
                a2.c();
            }

            @Override // com.huawei.updatesdk.service.f.b
            public void b() {
                a2.c();
                if (AppUpdateActivity.this.j) {
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    appUpdateActivity.d(appUpdateActivity.i);
                    return;
                }
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
            }
        });
        String string = getString(g.b(this, "upsdk_app_download_info_new"));
        a2.a(new a.b() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass7 */

            @Override // com.huawei.updatesdk.service.f.a.b
            public void a() {
                AppUpdateActivity.this.finish();
            }
        });
        a2.a(a.EnumC0080a.CONFIRM, string);
        a2.a(new DialogInterface.OnKeyListener() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass8 */

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (AppUpdateActivity.this.j) {
                    a2.c();
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    appUpdateActivity.d(appUpdateActivity.i);
                    return true;
                }
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        com.huawei.updatesdk.service.f.a a2 = com.huawei.updatesdk.service.f.a.a(this, null, getString(g.b(this, "upsdk_third_app_dl_cancel_download_prompt_ex")));
        this.c = a2;
        a2.a(new com.huawei.updatesdk.service.f.b() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass3 */

            @Override // com.huawei.updatesdk.service.f.b
            public void a() {
                AppUpdateActivity.this.e.setProgress(0);
                AppUpdateActivity.this.e.setMax(0);
                AppUpdateActivity.this.f.setText("");
                AppUpdateActivity.this.f();
                if (AppUpdateActivity.this.l != null) {
                    AppUpdateActivity.this.l.a();
                }
                AppUpdateActivity.this.c.c();
                if (AppUpdateActivity.this.j) {
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    appUpdateActivity.d(appUpdateActivity.i);
                    return;
                }
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
            }

            @Override // com.huawei.updatesdk.service.f.b
            public void b() {
                AppUpdateActivity.this.c.c();
            }
        });
        String string = getString(g.b(this, "upsdk_third_app_dl_sure_cancel_download"));
        this.c.a(new a.b() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass4 */

            @Override // com.huawei.updatesdk.service.f.a.b
            public void a() {
                AppUpdateActivity.this.finish();
            }
        });
        this.c.a(a.EnumC0080a.CONFIRM, string);
    }

    private long c(ApkUpgradeInfo apkUpgradeInfo) {
        return (apkUpgradeInfo.getPackingType_() != 1 || apkUpgradeInfo.getBundleSize_() <= 0) ? apkUpgradeInfo.getDiffSize_() > 0 ? (long) apkUpgradeInfo.getDiffSize_() : apkUpgradeInfo.getLongSize_() : apkUpgradeInfo.getBundleSize_();
    }

    /* access modifiers changed from: private */
    public void c() {
        if (!com.huawei.updatesdk.service.e.c.a(this, this.a)) {
            if (com.huawei.updatesdk.a.b.a.a.a() == null) {
                com.huawei.updatesdk.a.b.a.a.a(this);
            }
            f.a(this);
            f.a(this.a);
            this.d.c();
            return;
        }
        a(this.i.getPackage_(), this.i.getDetailId_());
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        if (i2 == 5 || i2 == 4) {
            Toast.makeText(this, getString(g.b(this, "upsdk_third_app_dl_install_failed")), 0).show();
            g.a.a(this.a, -1000001);
            finish();
        }
        if (i2 == 7) {
            g.a.a(this.a, -1000001);
            if (this.g) {
                d(this.i);
            } else {
                finish();
            }
        }
    }

    private void c(final com.huawei.updatesdk.a.b.c.b bVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                Bundle a2 = bVar.a();
                if (a2 != null) {
                    int i = a2.getInt("INSTALL_STATE");
                    d.a().a(AppUpdateActivity.this.a(i, a2.getInt("INSTALL_TYPE"), -1));
                    AppUpdateActivity.this.c(i);
                }
            }
        });
    }

    private void c(final String str) {
        AlertDialog alertDialog = this.b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.b = new AlertDialog.Builder(this).create();
            View inflate = LayoutInflater.from(this).inflate(g.d(this, "upsdk_app_dl_progress_dialog"), (ViewGroup) null);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(g.a(this, "third_app_dl_progressbar"));
            this.e = progressBar;
            progressBar.setMax(100);
            this.f = (TextView) inflate.findViewById(g.a(this, "third_app_dl_progress_text"));
            inflate.findViewById(g.a(this, "cancel_bg")).setOnClickListener(new View.OnClickListener() {
                /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass5 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AppUpdateActivity.this.b(str);
                }
            });
            this.b.setView(inflate);
            this.b.setCancelable(false);
            this.b.setCanceledOnTouchOutside(false);
            if (!a.a(this)) {
                this.b.show();
            }
            this.f.setText(i.a(0));
        }
    }

    private void d() {
        int b2 = com.huawei.updatesdk.service.e.b.a().b();
        if (b2 >= 11 && b2 < 17) {
            this.d.a(g.e(this, "upsdk_update_all_button"), g.f(this, "upsdk_white"));
        }
    }

    /* access modifiers changed from: private */
    public void d(ApkUpgradeInfo apkUpgradeInfo) {
        if (apkUpgradeInfo == null) {
            finish();
            return;
        }
        String string = getString(g.b(this, "upsdk_ota_title"));
        String string2 = getString(g.b(this, "upsdk_ota_notify_updatebtn"));
        String string3 = getString(g.b(this, "upsdk_ota_cancel"));
        d(string);
        if (1 == apkUpgradeInfo.getIsCompulsoryUpdate_()) {
            string3 = getString(g.b(this, "upsdk_ota_force_cancel_new"));
            if (this.k) {
                this.d.a();
            }
            this.g = true;
        }
        this.d.a(new com.huawei.updatesdk.service.f.b() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass9 */

            @Override // com.huawei.updatesdk.service.f.b
            public void a() {
                AppUpdateActivity.this.o = 101;
                if (!com.huawei.updatesdk.a.a.c.b.b.a(AppUpdateActivity.this)) {
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    Toast.makeText(appUpdateActivity, g.b(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
                    AppUpdateActivity.this.m = 2;
                    AppUpdateActivity.this.finish();
                    return;
                }
                AppUpdateActivity.this.c();
            }

            @Override // com.huawei.updatesdk.service.f.b
            public void b() {
                AppUpdateActivity.this.d.c();
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.o = 100;
                if (!AppUpdateActivity.this.j) {
                    c cVar = new c();
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    cVar.a(appUpdateActivity, new a());
                    return;
                }
                AppUpdateActivity.this.finish();
            }
        });
        b();
        this.d.a(new a.b() {
            /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass10 */

            @Override // com.huawei.updatesdk.service.f.a.b
            public void a() {
                AppUpdateActivity.this.finish();
            }
        });
        if (this.g) {
            this.d.a(false);
        } else {
            this.d.a(new DialogInterface.OnKeyListener() {
                /* class com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 0) {
                        return false;
                    }
                    AppUpdateActivity.this.m = 4;
                    AppUpdateActivity.this.finish();
                    return true;
                }
            });
        }
        this.d.a(a.EnumC0080a.CONFIRM, string2);
        this.d.a(a.EnumC0080a.CANCEL, string3);
        d();
    }

    private void d(String str) {
        View inflate = LayoutInflater.from(this).inflate(g.d(this, "upsdk_ota_update_view"), (ViewGroup) null);
        ((TextView) inflate.findViewById(g.a(this, "content_textview"))).setText(TextUtils.isEmpty(this.i.getNewFeatures_()) ? getString(g.b(this, "upsdk_choice_update")) : this.i.getNewFeatures_());
        ((TextView) inflate.findViewById(g.a(this, "version_textview"))).setText(this.i.getVersion_());
        ((TextView) inflate.findViewById(g.a(this, "appsize_textview"))).setText(i.a(this, c(this.i)));
        ((TextView) inflate.findViewById(g.a(this, "name_textview"))).setText(this.i.getName_());
        a(this.i, (TextView) inflate.findViewById(g.a(this, "allsize_textview")));
        a(inflate);
        com.huawei.updatesdk.service.f.a a2 = com.huawei.updatesdk.service.f.a.a(this, str, null);
        this.d = a2;
        a2.a(inflate);
    }

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        d dVar = new d();
        this.q = dVar;
        a.a(this, intentFilter, dVar);
    }

    /* access modifiers changed from: private */
    public void e(ApkUpgradeInfo apkUpgradeInfo) {
        e();
        c(apkUpgradeInfo.getPackage_());
        com.huawei.updatesdk.a.b.b.b bVar = new com.huawei.updatesdk.a.b.b.b(new com.huawei.updatesdk.a.b.b.a(apkUpgradeInfo.getDownurl_(), apkUpgradeInfo.getLongSize_(), apkUpgradeInfo.getSha256_()));
        this.l = bVar;
        bVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            AlertDialog alertDialog = this.b;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
        } catch (IllegalArgumentException unused) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("AppUpdateActivity", "progressDialog dismiss IllegalArgumentException");
        }
    }

    @Override // com.huawei.updatesdk.service.otaupdate.b
    public void a(int i2) {
        Toast.makeText(this, getString(g.b(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        d.a().a(i2);
        finish();
    }

    @Override // com.huawei.updatesdk.service.b.b
    public void a(int i2, com.huawei.updatesdk.a.b.c.b bVar) {
        if (bVar != null) {
            if (i2 == 0) {
                b(bVar);
            } else if (1 == i2) {
                a(bVar);
            } else if (2 == i2) {
                c(bVar);
            }
        }
    }

    @Override // com.huawei.updatesdk.service.otaupdate.b
    public void a(ApkUpgradeInfo apkUpgradeInfo) {
        if (apkUpgradeInfo != null) {
            com.huawei.updatesdk.service.b.c.b().a(this);
            b(apkUpgradeInfo);
            return;
        }
        Toast.makeText(this, getString(g.b(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        finish();
    }

    @Override // com.huawei.updatesdk.service.otaupdate.b
    public void b(int i2) {
        Toast.makeText(this, getString(g.b(this, "upsdk_connect_server_fail_prompt_toast")), 0).show();
        d.a().a(i2);
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.g) {
            overridePendingTransition(0, 0);
        }
        Intent intent = new Intent();
        this.p = intent;
        intent.putExtra("status", this.m);
        this.p.putExtra("failcause", this.n);
        this.p.putExtra("compulsoryUpdateCancel", this.g);
        this.p.putExtra("buttonstatus", this.o);
        d.a().b(this.p);
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1002) {
            if (intent != null) {
                com.huawei.updatesdk.a.b.c.b a2 = com.huawei.updatesdk.a.b.c.b.a(intent);
                this.m = i3;
                this.n = a2.b("installResultCode", -99);
                if (this.i.getIsCompulsoryUpdate_() == 1) {
                    this.g = a2.a("compulsoryUpdateCancel", false);
                }
            }
            if (this.i.getIsCompulsoryUpdate_() == 1 && i3 == 4) {
                this.g = true;
            }
            this.o = i3 == 4 ? 100 : 101;
            if (!this.h) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        Bundle a2 = com.huawei.updatesdk.a.b.c.b.a(getIntent()).a();
        if (a2 == null) {
            super.finish();
            return;
        }
        Serializable serializable = a2.getSerializable("app_update_parm");
        if (serializable == null || !(serializable instanceof ApkUpgradeInfo)) {
            this.m = 3;
            finish();
            return;
        }
        this.i = (ApkUpgradeInfo) serializable;
        this.k = a2.getBoolean("app_must_btn", false);
        if (this.i.getIsCompulsoryUpdate_() == 1) {
            this.j = true;
        }
        if (!TextUtils.isEmpty(h.a().b())) {
            this.a = h.a().b();
        }
        if (this.i.getDevType_() == 1 && com.huawei.updatesdk.service.e.c.a(this) == c.a.INSTALLED) {
            a(this.i.getPackage_());
        } else {
            d(this.i);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.huawei.updatesdk.service.f.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
            this.c = null;
        }
        com.huawei.updatesdk.service.f.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.c();
            this.d = null;
        }
        f();
        a();
        super.onDestroy();
        finishActivity(1002);
    }
}
