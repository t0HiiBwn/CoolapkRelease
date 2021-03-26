package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: InstallConfirm */
public class j extends b {
    private String a = ResourceLoaderUtil.getString("hms_update_title");

    @Override // com.huawei.hms.update.ui.b
    protected AlertDialog a() {
        int stringId = ResourceLoaderUtil.getStringId("hms_update_message_new");
        int stringId2 = ResourceLoaderUtil.getStringId("hms_install");
        AlertDialog.Builder builder = new AlertDialog.Builder(f(), g());
        builder.setMessage(f().getString(stringId, new Object[]{this.a}));
        builder.setPositiveButton(stringId2, new DialogInterface.OnClickListener() {
            /* class com.huawei.hms.update.ui.j.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                j.this.e();
            }
        });
        builder.setNegativeButton(ResourceLoaderUtil.getStringId("hms_cancel"), new DialogInterface.OnClickListener() {
            /* class com.huawei.hms.update.ui.j.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                j.this.b();
            }
        });
        return builder.create();
    }

    public void a(String str) {
        this.a = str;
    }
}
