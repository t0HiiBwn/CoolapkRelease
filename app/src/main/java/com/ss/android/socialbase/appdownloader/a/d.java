package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* compiled from: DevicePlans */
public class d {
    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        a a = a.a(downloadInfo);
        if (str.equals("v1")) {
            return new j(context, a, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new k(context, a, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, a, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new g(context, a, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new h(context, a, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (!TextUtils.isEmpty(dBJsonString)) {
                return new i(context, a, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
            }
            return null;
        } else if (str.equals("custom")) {
            return new c(context, a, file.getAbsolutePath(), jSONObject);
        } else {
            if (!str.equals("vbi")) {
                return null;
            }
            t downloadFileUriProvider = Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId());
            String d = com.ss.android.socialbase.appdownloader.d.j().d();
            return new m(context, a, c.a(downloadInfo.getId(), downloadFileUriProvider, context, d, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
        }
    }

    public static boolean a(Context context, String str, JSONObject jSONObject, a aVar) {
        if (context == null || str == null) {
            return false;
        }
        a aVar2 = null;
        String b = c.b();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("v1")) {
            aVar2 = new j(context, aVar, b);
        } else if (str.equals("v2")) {
            aVar2 = new k(context, aVar, b);
        } else if (str.equals("v3")) {
            aVar2 = new l(context, aVar, b);
        } else if (str.equals("o1")) {
            aVar2 = new g(context, aVar, b);
        } else if (str.equals("o2")) {
            aVar2 = new h(context, aVar, b);
        } else if (str.equals("o3")) {
            aVar2 = new i(context, aVar, b, b, b);
        } else if (str.equals("custom")) {
            aVar2 = new c(context, aVar, b, jSONObject);
        } else if (str.equals("vbi")) {
            aVar2 = new m(context, aVar, b);
        }
        if (aVar2 == null || !aVar2.a()) {
            return false;
        }
        return true;
    }
}
