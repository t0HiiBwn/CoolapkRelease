package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TTDelegateActivity extends Activity {
    private Intent a;
    private AlertDialog b;
    private TTAdDislike c;
    private e d;
    private d e;
    private com.bytedance.sdk.openadsdk.core.widget.a f;
    private b g;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, new b.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    u.b("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    public static void a(String str, String str2, String str3) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str, String str2, String str3, String str4, boolean z) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 7);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str3);
        intent.putExtra("dialog_app_manage_model", str2);
        intent.putExtra("dialog_app_manage_model_icon_url", str4);
        intent.putExtra("dialog_app_detail_is_download_type", z);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 8);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str3);
        intent.putExtra("dialog_app_detail_is_download_type", z);
        intent.putExtra("dialog_app_manage_model", str2);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 9);
        intent.putExtra("dialog_app_manage_model", str);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        intent.putExtra("dialog_btn_yes_key", str4);
        intent.putExtra("dialog_btn_no_key", str5);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(l lVar) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("materialmeta", lVar.aF().toString());
        if (p.a() != null) {
            p.a().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        this.a = getIntent();
        if (p.a() == null) {
            p.a(this);
        }
        com.bytedance.sdk.openadsdk.g.a.a().a(this);
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (p.a() == null) {
            p.a(this);
        }
        try {
            setIntent(intent);
            this.a = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            b();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            AlertDialog alertDialog = this.b;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.b.dismiss();
            }
            d dVar = this.e;
            if (dVar != null && dVar.isShowing()) {
                this.e.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.a aVar = this.f;
            if (aVar != null && aVar.isShowing()) {
                this.f.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.b bVar = this.g;
            if (bVar != null && bVar.isShowing()) {
                this.g.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    private void b() {
        try {
            Intent intent = this.a;
            if (intent != null) {
                int intExtra = intent.getIntExtra("type", 0);
                String stringExtra = this.a.getStringExtra("app_download_url");
                this.a.getStringExtra("app_name");
                switch (intExtra) {
                    case 1:
                        return;
                    case 2:
                        c();
                        return;
                    case 3:
                        b(stringExtra, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_content_key"));
                        return;
                    case 4:
                        b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
                        return;
                    case 5:
                        b(stringExtra, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_content_key"), this.a.getStringExtra("dialog_btn_yes_key"), this.a.getStringExtra("dialog_btn_no_key"));
                        return;
                    case 6:
                        d(this.a.getStringExtra("materialmeta"));
                        return;
                    case 7:
                        Intent intent2 = this.a;
                        if (intent2 != null) {
                            b(intent2.getStringExtra("dialog_app_manage_model"), stringExtra, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_app_manage_model_icon_url"), this.a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                            return;
                        }
                        return;
                    case 8:
                        b(this.a.getStringExtra("dialog_app_manage_model"), stringExtra, this.a.getStringExtra("dialog_title_key"), this.a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        return;
                    case 9:
                        c(this.a.getStringExtra("dialog_app_manage_model"));
                        return;
                    default:
                        finish();
                        return;
                }
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void b(final String str, final String str2, final String str3, String str4, final boolean z) {
        String str5;
        String str6;
        c b2;
        try {
            String str7 = "";
            if (TextUtils.isEmpty(str) || (b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(str))) == null) {
                str6 = str7;
                str5 = str6;
            } else {
                str7 = b2.b();
                str5 = b2.c();
                str6 = b2.g();
                if (TextUtils.isEmpty(str6)) {
                    str6 = str3;
                }
            }
            d dVar = this.e;
            if (dVar == null || !dVar.isShowing()) {
                d a2 = new d(this).a(str6).b(str7).c(str4).d(str5).a(new d.a() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass7 */

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void a(Dialog dialog) {
                        g.b(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void b(Dialog dialog) {
                        TTDelegateActivity.this.c(str, str2, str3, z);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void c(Dialog dialog) {
                        g.d(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void d(Dialog dialog) {
                        TTDelegateActivity.this.b(str);
                    }
                });
                this.e = a2;
                a2.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void b(final String str, final String str2, String str3, boolean z) {
        try {
            com.bytedance.sdk.openadsdk.core.widget.a aVar = this.f;
            if (aVar == null || !aVar.isShowing()) {
                com.bytedance.sdk.openadsdk.core.widget.a aVar2 = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
                this.f = aVar2;
                aVar2.a(str3).a(new a.AbstractC0047a() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass8 */

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.AbstractC0047a
                    public void a(Dialog dialog) {
                        g.b(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.AbstractC0047a
                    public void b(Dialog dialog) {
                        g.d(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.AbstractC0047a
                    public void c(Dialog dialog) {
                        TTDelegateActivity.this.b(str);
                    }
                });
                this.f.a(z);
                this.f.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        try {
            com.bytedance.sdk.openadsdk.core.widget.b bVar = this.g;
            if (bVar != null) {
                bVar.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.b bVar2 = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
            this.g = bVar2;
            bVar2.a(new b.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass9 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    if (TTDelegateActivity.this.g != null) {
                        TTDelegateActivity.this.g.dismiss();
                    }
                }
            });
            this.g.show();
        } catch (Throwable unused) {
        }
    }

    private void c(String str) {
        try {
            com.bytedance.sdk.openadsdk.core.widget.b bVar = this.g;
            if (bVar != null) {
                bVar.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.b bVar2 = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
            this.g = bVar2;
            bVar2.a(new b.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass10 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.g.show();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public void c(final String str, final String str2, String str3, boolean z) {
        try {
            com.bytedance.sdk.openadsdk.core.widget.a aVar = this.f;
            if (aVar != null) {
                aVar.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.a aVar2 = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
            this.f = aVar2;
            aVar2.a(str3).a(new a.AbstractC0047a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass11 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.AbstractC0047a
                public void a(Dialog dialog) {
                    g.b(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.AbstractC0047a
                public void b(Dialog dialog) {
                    if (TTDelegateActivity.this.f != null) {
                        TTDelegateActivity.this.f.dismiss();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.AbstractC0047a
                public void c(Dialog dialog) {
                    TTDelegateActivity.this.b(str);
                }
            });
            this.f.a(z);
            this.f.show();
        } catch (Throwable unused) {
        }
    }

    private void d(String str) {
        if (str != null && this.c == null) {
            try {
                com.bytedance.sdk.openadsdk.dislike.b bVar = new com.bytedance.sdk.openadsdk.dislike.b(this, com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(str)));
                this.c = bVar;
                bVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass12 */

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onRefuse() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str) {
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        TTAdDislike tTAdDislike = this.c;
        if (tTAdDislike != null) {
            tTAdDislike.showDislikeDialog(0);
        }
    }

    private void b(final String str, String str2, String str3, String str4, String str5) {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.d == null) {
            this.d = new e(this).a(str2).b(str3).c(str4).d(str5).a(new e.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass14 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                public void a(Dialog dialog) {
                    g.b(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                public void b(Dialog dialog) {
                    g.c(str);
                    TTDelegateActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass13 */

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    g.d(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
        if (!this.d.isShowing()) {
            this.d.show();
        }
        this.b = this.d;
    }

    private void b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
        } else if (Build.VERSION.SDK_INT >= 23) {
            try {
                com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass2 */

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a() {
                        h.a(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a(String str) {
                        h.a(str, str);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            u.b("TT_AD_SDK", "已经有权限");
            finish();
        }
    }

    private void b(final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = ac.a(this, "tt_tip");
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        a(str2, str3, new DialogInterface.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass3 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass4 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.c(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass5 */

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                g.d(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                TTCustomController e2 = i.d().e();
                boolean isCanUseLocation = e2.isCanUseLocation();
                boolean isCanUsePhoneState = e2.isCanUsePhoneState();
                boolean isCanUseWriteExternal = e2.isCanUseWriteExternal();
                ArrayList arrayList = new ArrayList();
                if (isCanUseLocation) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (isCanUsePhoneState) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (isCanUseWriteExternal) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.AnonymousClass6 */

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a() {
                        com.bytedance.sdk.openadsdk.j.e.a(new a(), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a(String str) {
                        "android.permission.READ_PHONE_STATE".equals(str);
                        com.bytedance.sdk.openadsdk.j.e.a(new a(), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            u.b("TT_AD_SDK", "已经有Read phone state权限");
            finish();
        }
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        String str3;
        try {
            if (this.b == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    str3 = "Theme.Dialog.TTDownload";
                } else {
                    str3 = "Theme.Dialog.TTDownloadOld";
                }
                this.b = new AlertDialog.Builder(this, ac.g(this, str3)).create();
            }
            this.b.setTitle(String.valueOf(str));
            this.b.setMessage(String.valueOf(str2));
            this.b.setButton(-1, ac.a(this, "tt_label_ok"), onClickListener);
            this.b.setButton(-2, ac.a(this, "tt_label_cancel"), onClickListener2);
            this.b.setOnCancelListener(onCancelListener);
            if (!this.b.isShowing()) {
                this.b.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.downloadnew.a.g.a();
            k.j(p.a());
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, iArr);
        com.bytedance.sdk.openadsdk.j.e.a(new a(), 1);
        finish();
    }
}
