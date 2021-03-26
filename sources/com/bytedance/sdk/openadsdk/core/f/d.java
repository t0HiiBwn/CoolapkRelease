package com.bytedance.sdk.openadsdk.core.f;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PermissionsManager */
public class d {
    private static final String a = "d";
    private static d e;
    private static final Map<String, Integer> f;
    private final Set<String> b = new HashSet(1);
    private final List<WeakReference<e>> c = new ArrayList(1);
    private final List<e> d = new ArrayList(1);

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_location")));
        hashMap.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_location")));
        hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_read_phone_state")));
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_external_storage")));
        if (Build.VERSION.SDK_INT >= 16) {
            hashMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(ac.b(p.a(), "tt_request_permission_descript_external_storage")));
        }
    }

    public static d a() {
        if (e == null) {
            e = new d();
        }
        return e;
    }

    private d() {
        b();
    }

    private synchronized void b() {
        if (Build.VERSION.SDK_INT > 28) {
            c();
            return;
        }
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e2) {
                Log.e(a, "Could not access field", e2);
            }
            this.b.add(str);
        }
    }

    private void c() {
        PackageInfo packageInfo;
        String[] strArr;
        Context a2 = p.a();
        if (a2 != null) {
            try {
                PackageManager packageManager = a2.getPackageManager();
                String packageName = a2.getPackageName();
                if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(packageName, 4096)) == null || (strArr = packageInfo.requestedPermissions) == null)) {
                    if (strArr.length != 0) {
                        for (int i = 0; i < strArr.length; i++) {
                            if (!TextUtils.isEmpty(strArr[i])) {
                                this.b.add(strArr[i]);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized void a(String[] strArr, e eVar) {
        if (eVar != null) {
            eVar.a(strArr);
            this.d.add(eVar);
            this.c.add(new WeakReference<>(eVar));
        }
    }

    private synchronized void a(e eVar) {
        Iterator<WeakReference<e>> it2 = this.c.iterator();
        while (it2.hasNext()) {
            WeakReference<e> next = it2.next();
            if (next.get() == eVar || next.get() == null) {
                it2.remove();
            }
        }
        Iterator<e> it3 = this.d.iterator();
        while (it3.hasNext()) {
            if (it3.next() == eVar) {
                it3.remove();
            }
        }
    }

    public synchronized boolean a(Context context, String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (ad.e()) {
            if (a.a(context, str) && (b.a(context, str) == 0 || !this.b.contains(str))) {
                z = true;
            }
            return z;
        }
        if (b.a(context, str) == 0 || !this.b.contains(str)) {
            z = true;
        }
        return z;
    }

    public synchronized void a(Activity activity, String[] strArr, e eVar) {
        if (activity != null) {
            try {
                a(strArr, eVar);
                if (Build.VERSION.SDK_INT < 23) {
                    b(activity, strArr, eVar);
                } else {
                    List<String> c2 = c(activity, strArr, eVar);
                    if (c2.isEmpty()) {
                        a(eVar);
                    } else {
                        b.a(activity, (String[]) c2.toArray(new String[c2.size()]), 1);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return;
        }
        return;
    }

    private void b(Activity activity, String[] strArr, e eVar) {
        boolean z;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.b.contains(str)) {
                        z = eVar.a(str, c.NOT_FOUND);
                    } else if (b.a(activity, str) != 0) {
                        z = eVar.a(str, c.DENIED);
                    } else {
                        z = eVar.a(str, c.GRANTED);
                    }
                    if (z) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(eVar);
    }

    private List<String> c(Activity activity, String[] strArr, e eVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!this.b.contains(str)) {
                if (eVar != null) {
                    eVar.a(str, c.NOT_FOUND);
                }
            } else if (!a(activity, str)) {
                arrayList.add(str);
            } else if (eVar != null) {
                eVar.a(str, c.GRANTED);
            }
        }
        return arrayList;
    }

    public synchronized void a(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (ad.e() && !a.a(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0.remove();
     */
    private void a(String[] strArr, int[] iArr, String[] strArr2) {
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<e>> it2 = this.c.iterator();
            while (it2.hasNext()) {
                e eVar = it2.next().get();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (eVar == null) {
                        break;
                    } else if (eVar.a(strArr[i], iArr[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            Iterator<e> it3 = this.d.iterator();
            while (it3.hasNext()) {
                it3.next();
                it3.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
