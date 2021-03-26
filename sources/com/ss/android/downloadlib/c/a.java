package com.ss.android.downloadlib.c;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.ss.android.a.a.a.k;
import com.ss.android.a.a.b.c;

/* compiled from: DefaultDownloadUIFactory */
public class a implements k {
    @Override // com.ss.android.a.a.a.k
    public void a(int i, Context context, c cVar, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.a.a.a.k
    public Dialog b(com.ss.android.a.a.c.c cVar) {
        return a(cVar);
    }

    private static Dialog a(final com.ss.android.a.a.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(cVar.a).setTitle(cVar.b).setMessage(cVar.c).setPositiveButton(cVar.d, new DialogInterface.OnClickListener() {
            /* class com.ss.android.downloadlib.c.a.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.h != null) {
                    cVar.h.a(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.e, new DialogInterface.OnClickListener() {
            /* class com.ss.android.downloadlib.c.a.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.h != null) {
                    cVar.h.b(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(cVar.f);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.ss.android.downloadlib.c.a.AnonymousClass3 */

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.h != null) {
                    cVar.h.c(dialogInterface);
                }
            }
        });
        if (cVar.g != null) {
            show.setIcon(cVar.g);
        }
        return show;
    }
}
