package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.appdownloader.view.a;
import com.ss.android.socialbase.downloader.downloader.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationPermissionHelper */
public class d {
    private static final String a = "d";
    private static List<n> b = new ArrayList();
    private static a c;
    private static AlertDialog d;

    public static boolean a() {
        try {
            return NotificationManagerCompat.from(b.L()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (d.class) {
            try {
                AlertDialog alertDialog = d;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    d = null;
                }
                for (n nVar : b) {
                    if (nVar != null) {
                        if (z) {
                            nVar.a();
                        } else {
                            nVar.b();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    public static synchronized void a(final Activity activity, final n nVar) {
        synchronized (d.class) {
            if (nVar != null) {
                if (activity != null) {
                    try {
                        if (!activity.isFinishing()) {
                            int a2 = i.a(b.L(), "tt_appdownloader_notification_request_title");
                            int a3 = i.a(b.L(), "tt_appdownloader_notification_request_message");
                            int a4 = i.a(b.L(), "tt_appdownloader_notification_request_btn_yes");
                            int a5 = i.a(b.L(), "tt_appdownloader_notification_request_btn_no");
                            b.add(nVar);
                            AlertDialog alertDialog = d;
                            if (alertDialog == null || !alertDialog.isShowing()) {
                                d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface.OnClickListener() {
                                    /* class com.ss.android.socialbase.appdownloader.e.d.AnonymousClass3 */

                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        d.b(activity, nVar);
                                        dialogInterface.cancel();
                                        AlertDialog unused = d.d = null;
                                    }
                                }).setNegativeButton(a5, new DialogInterface.OnClickListener() {
                                    /* class com.ss.android.socialbase.appdownloader.e.d.AnonymousClass2 */

                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        d.a(false);
                                    }
                                }).setOnKeyListener(new DialogInterface.OnKeyListener() {
                                    /* class com.ss.android.socialbase.appdownloader.e.d.AnonymousClass1 */

                                    @Override // android.content.DialogInterface.OnKeyListener
                                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                        if (i != 4) {
                                            return false;
                                        }
                                        if (keyEvent.getAction() == 1) {
                                            d.a(false);
                                        }
                                        return true;
                                    }
                                }).setCancelable(false).show();
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        a(false);
                    }
                }
                nVar.b();
                return;
            }
            return;
        }
    }

    public static void b(Activity activity, n nVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = a;
                    a aVar = (a) fragmentManager.findFragmentByTag(str);
                    c = aVar;
                    if (aVar == null) {
                        c = new a();
                        fragmentManager.beginTransaction().add(c, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    c.a();
                    return;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        nVar.a();
    }
}
