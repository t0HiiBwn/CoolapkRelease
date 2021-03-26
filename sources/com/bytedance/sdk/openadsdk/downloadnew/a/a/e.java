package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.a.a.a.k;
import com.ss.android.a.a.b.c;
import java.lang.ref.WeakReference;

/* compiled from: LibUIFactory */
public class e implements k {
    private final WeakReference<Context> a;

    public e(Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.k
    public void a(int i, Context context, c cVar, String str, Drawable drawable, int i2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Toast.makeText(context, str, 0).show();
            }
        } catch (Exception e) {
            u.f("LibUIFactory", "showToastWithDuration e " + e.getMessage());
        }
    }

    /* renamed from: a */
    public AlertDialog b(com.ss.android.a.a.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.a != null && (cVar.a instanceof Activity)) {
            return a((Activity) cVar.a, cVar);
        }
        c(cVar);
        return null;
    }

    private AlertDialog a(Activity activity, final com.ss.android.a.a.c.c cVar) {
        if (cVar.j == 1) {
            AlertDialog b = b(activity, cVar);
            b.show();
            return b;
        }
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, ac.g(activity, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).setTitle(cVar.b).setMessage(cVar.c).setPositiveButton(cVar.d, new DialogInterface.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.e.AnonymousClass3 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.h != null) {
                    cVar.h.a(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.e, new DialogInterface.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.e.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.h != null) {
                    cVar.h.b(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.e.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.h != null) {
                    cVar.h.c(dialogInterface);
                }
            }
        });
        if (cVar.g != null) {
            onCancelListener.setIcon(cVar.g);
        }
        AlertDialog create = onCancelListener.create();
        create.show();
        return create;
    }

    private AlertDialog b(Activity activity, final com.ss.android.a.a.c.c cVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.e(activity).a(cVar.b).b(cVar.c).c(cVar.d).d(cVar.e).a(cVar.g).a(new e.a() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.e.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void a(Dialog dialog) {
                if (cVar.h != null) {
                    cVar.h.a(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void b(Dialog dialog) {
                if (cVar.h != null) {
                    cVar.h.b(dialog);
                }
            }
        }).a(new DialogInterface.OnCancelListener() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.e.AnonymousClass4 */

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.h != null) {
                    cVar.h.c(dialogInterface);
                }
            }
        });
    }

    private void c(final com.ss.android.a.a.c.c cVar) {
        AnonymousClass6 r5 = new g.a() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.e.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                if (cVar.h != null) {
                    cVar.h.a(new a());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
                if (cVar.h != null) {
                    cVar.h.b(new a());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                if (cVar.h != null) {
                    cVar.h.c(new a());
                }
            }
        };
        if (cVar.j == 1) {
            g.a(String.valueOf(cVar.hashCode()), cVar.b, cVar.c, cVar.d, cVar.e, r5);
        } else {
            g.a(String.valueOf(cVar.hashCode()), cVar.b, cVar.c, r5);
        }
    }

    /* compiled from: LibUIFactory */
    class a implements DialogInterface {
        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }

        a() {
        }
    }
}
