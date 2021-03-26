package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.d.a;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

public class DownloadTaskDeleteActivity extends Activity {
    private k a;
    private Intent b;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.b = getIntent();
        b();
        k kVar = this.a;
        if (kVar != null && !kVar.b()) {
            this.a.a();
        } else if (this.a == null) {
            finish();
        }
    }

    private void b() {
        Intent intent;
        if (this.a == null && (intent = this.b) != null) {
            final boolean z = false;
            try {
                final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
                final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
                if (downloadInfo != null) {
                    String title = downloadInfo.getTitle();
                    if (TextUtils.isEmpty(title)) {
                        Log.w("DeleteActivity", "Missing appName; skipping handle");
                        return;
                    }
                    String format = String.format(getString(i.a(this, "tt_appdownloader_notification_download_delete")), title);
                    c a2 = d.j().a();
                    l lVar = null;
                    if (a2 != null) {
                        lVar = a2.a(this);
                    }
                    if (lVar == null) {
                        lVar = new a(this);
                    }
                    if (lVar != null) {
                        int a3 = i.a(this, "tt_appdownloader_tip");
                        int a4 = i.a(this, "tt_appdownloader_label_ok");
                        int a5 = i.a(this, "tt_appdownloader_label_cancel");
                        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("cancel_with_net_opt", 0) == 1 && e.g() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                            z = true;
                        }
                        if (z) {
                            a4 = i.a(this, "tt_appdownloader_label_reserve_wifi");
                            a5 = i.a(this, "tt_appdownloader_label_cancel_directly");
                            format = getResources().getString(i.a(this, "tt_appdownloader_resume_in_wifi"));
                        }
                        lVar.a(a3).a(format).a(a4, new DialogInterface.OnClickListener() {
                            /* class com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass3 */

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (z) {
                                    downloadInfo.setOnlyWifi(true);
                                    Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                        /* class com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass3.AnonymousClass1 */

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                                        }
                                    }, 100);
                                } else {
                                    DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
                                }
                                DownloadTaskDeleteActivity.this.finish();
                            }
                        }).b(a5, new DialogInterface.OnClickListener() {
                            /* class com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass2 */

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (z) {
                                    DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
                                }
                                DownloadTaskDeleteActivity.this.finish();
                            }
                        }).a(new DialogInterface.OnCancelListener() {
                            /* class com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass1 */

                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                DownloadTaskDeleteActivity.this.finish();
                            }
                        });
                        this.a = lVar.a();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, int i) {
        com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
        if (b2 != null) {
            b2.a(downloadInfo);
        }
        ab downloadNotificationEventListener = Downloader.getInstance(b.L()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.a(10, downloadInfo, "", "");
        }
        if (b.L() != null) {
            Downloader.getInstance(b.L()).cancel(i);
        }
    }
}
