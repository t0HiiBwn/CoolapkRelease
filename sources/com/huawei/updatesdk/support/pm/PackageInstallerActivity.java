package com.huawei.updatesdk.support.pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.b.c.b;
import com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider;
import com.huawei.updatesdk.service.c.g;
import com.huawei.updatesdk.service.c.h;
import java.io.File;

public class PackageInstallerActivity extends Activity {
    private String a = "";
    private String b = "";
    private int c = -1;

    private Intent a(Context context, String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || str.contains("../") || str.contains("..") || str.contains("%00") || str.contains(".\\.\\") || str.contains("./")) {
            throw new IllegalArgumentException("getNomalInstallIntent: Not a standard path");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.INSTALL_PACKAGE");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            uri = UpdateSdkFileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".updateSdk.fileProvider", new File(str));
        } else {
            uri = Uri.fromFile(new File(str));
        }
        intent.setData(uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1000 == i) {
            if (i2 == 0) {
                g.a(7, 0);
            } else {
                int i3 = -10004;
                if (intent != null) {
                    i3 = b.a(intent).b("android.intent.extra.INSTALL_RESULT", -10004);
                }
                String[] a2 = h.a();
                if (Build.VERSION.SDK_INT < 24 && -3 == i3 && this.c < a2.length - 1) {
                    g.a.a(this.b, -3, true);
                } else if (!(i3 == 0 || i3 == 1)) {
                    g.a(4, i3);
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        requestWindowFeature(1);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            str = "PackageInstallerActivity error intent";
        } else {
            b a2 = b.a(intent);
            this.a = a2.a("install_path");
            this.b = a2.a("install_packagename");
            if (TextUtils.isEmpty(this.a)) {
                g.a(4, -3);
                finish();
                str = "PackageInstallerActivity can not find filePath.";
            } else {
                this.c = a2.b("install_change_path_times", -1);
                try {
                    Intent a3 = a(this, this.a);
                    a3.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                    a3.putExtra("android.intent.extra.RETURN_RESULT", true);
                    a.c("PackageInstallerActivity", " onCreate filePath:" + this.a + ",packageName:" + this.b + ",taskId:" + getTaskId());
                    startActivityForResult(a3, 1000);
                    return;
                } catch (Exception unused) {
                    a.d("PackageInstallerActivity", "can not start install action");
                    g.a(4, -2);
                    finish();
                    return;
                }
            }
        }
        a.d("PackageInstallerActivity", str);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        finishActivity(1000);
        super.onDestroy();
        a.c("PackageInstallerActivity", " onDestroy removeTaskId:" + this.a);
    }
}
