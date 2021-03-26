package com.huawei.updatesdk.service.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.huawei.updatesdk.service.c.c;
import com.huawei.updatesdk.support.pm.PackageInstallerActivity;
import java.io.File;

public class a {
    private static void a() {
        g.a(4, -10002);
    }

    protected static void a(Context context, b bVar) {
        b(context, bVar);
    }

    private static void b(Context context, b bVar) {
        if (bVar == null) {
            com.huawei.updatesdk.a.a.b.a.a.a.d("InstallProcess", "system install failed,task is null");
            return;
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("InstallProcess", "systemInstall begin!!!task:" + bVar.toString());
        bVar.a(c.a.NOT_HANDLER);
        g.a(3, 1);
        File file = new File(bVar.d());
        if (!file.exists() || !file.isFile() || file.length() <= 0) {
            com.huawei.updatesdk.a.a.b.a.a.a.d("InstallProcess", "system install failed,file not existed filePath:" + bVar.d());
            g.a(4, -10003);
            return;
        }
        Intent intent = new Intent(context, PackageInstallerActivity.class);
        intent.putExtra("install_path", bVar.d());
        intent.putExtra("install_packagename", bVar.c());
        intent.putExtra("install_change_path_times", bVar.f());
        if (!(context instanceof Activity)) {
            intent.setFlags(402653184);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            a();
            com.huawei.updatesdk.a.a.b.a.a.a.a("InstallProcess", " can not start install !", e);
        }
    }
}
