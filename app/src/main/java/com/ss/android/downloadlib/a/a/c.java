package com.ss.android.downloadlib.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.f.b;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: HwMarketDialogUtils */
public class c {
    public static boolean a(Context context, String str, String str2, JSONObject jSONObject, String str3) {
        try {
            b.a();
            d dVar = new d("android.intent.action.VIEW", Uri.parse(String.format(b.a(jSONObject, "ap", str3), str2)));
            String i = com.ss.android.socialbase.appdownloader.f.c.i();
            if (k.d(com.ss.android.downloadlib.addownload.k.a(), i)) {
                dVar.setPackage(i);
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            g gVar = new g();
            e a = a(jSONObject, str3);
            f a2 = a(str, jSONObject, str3);
            if (a != null) {
                if (a2 != null) {
                    gVar.b = a;
                    gVar.a = b.a(jSONObject, "aq", str3);
                    gVar.c = a2;
                    arrayList.add(gVar);
                    dVar.putParcelableArrayListExtra(b.a(jSONObject, "av", str3), arrayList);
                    dVar.addFlags(268468224);
                    dVar.putExtra("start_only_for_android", true);
                    if (!k.a(context, dVar)) {
                        return false;
                    }
                    context.startActivity(dVar);
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static e a(JSONObject jSONObject, String str) {
        String a = b.a(jSONObject, "ar", str);
        String a2 = b.a(jSONObject, "as", str);
        if (k.d(com.ss.android.downloadlib.addownload.k.a(), a)) {
            e eVar = new e();
            eVar.b = a;
            eVar.c = a;
            eVar.d = 100300000;
            eVar.a = 2;
            return eVar;
        } else if (!k.d(com.ss.android.downloadlib.addownload.k.a(), a2)) {
            return null;
        } else {
            e eVar2 = new e();
            eVar2.b = a2;
            eVar2.c = a2;
            eVar2.d = 100300000;
            eVar2.a = 2;
            return eVar2;
        }
    }

    public static f a(String str, JSONObject jSONObject, String str2) {
        String a = b.a(jSONObject, "ar", str2);
        String a2 = b.a(jSONObject, "as", str2);
        if (k.d(com.ss.android.downloadlib.addownload.k.a(), a)) {
            String a3 = b.a(jSONObject, "at", str2);
            f fVar = new f();
            fVar.a = str;
            fVar.b = a3;
            fVar.d = 0;
            fVar.e = 2;
            fVar.c = a3;
            return fVar;
        } else if (!k.d(com.ss.android.downloadlib.addownload.k.a(), a2)) {
            return null;
        } else {
            String a4 = b.a(jSONObject, "au", str2);
            f fVar2 = new f();
            fVar2.a = str;
            fVar2.b = a4;
            fVar2.d = 0;
            fVar2.e = 0;
            fVar2.c = a4;
            return fVar2;
        }
    }
}
