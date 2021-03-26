package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.br;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.proto.e;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ImprintHandler implements FileLockCallback {
    private static final String a = "ImprintHandler";
    private static Object b = new Object();
    private static final String c = ".imprint";
    private static final byte[] d = "pbl0".getBytes();
    private static Map<String, ArrayList<UMImprintChangeCallback>> f = new HashMap();
    private static Object g = new Object();
    private static ImprintHandler j = null;
    private static Context k = null;

    /* renamed from: l  reason: collision with root package name */
    private static FileLockUtil f1491l = null;
    private static final int m = 0;
    private static final int n = 1;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();
    private d e;
    private a h = new a();
    private com.umeng.commonsdk.statistics.proto.d i = null;

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i2) {
        if (i2 == 0) {
            j.e();
        } else if (i2 == 1) {
            j.a(file);
        }
        return true;
    }

    private ImprintHandler(Context context) {
        k = context.getApplicationContext();
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (j == null) {
                j = new ImprintHandler(context);
                FileLockUtil fileLockUtil = new FileLockUtil();
                f1491l = fileLockUtil;
                if (fileLockUtil != null) {
                    f1491l.doFileOperateion(new File(k.getFilesDir(), ".imprint"), j, 0);
                }
            }
            imprintHandler = j;
        }
        return imprintHandler;
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            try {
                int i2 = 0;
                if (f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i2 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i2)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i2 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i2)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(k, th);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            synchronized (g) {
                try {
                    if (f.containsKey(str)) {
                        ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                        if (uMImprintChangeCallback != null && arrayList.size() > 0) {
                            int size = arrayList.size();
                            ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    break;
                                } else if (uMImprintChangeCallback == arrayList.get(i2)) {
                                    ULog.i("--->>> removeCallback: remove index " + i2);
                                    arrayList.remove(i2);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                            if (arrayList.size() == 0) {
                                ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                                f.remove(str);
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(k, th);
                }
            }
        }
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            a(str, uMImprintChangeCallback);
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            b(str, uMImprintChangeCallback);
        }
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintPreProcessCallback != null) {
            synchronized (p) {
                try {
                    if (!o.containsKey(str)) {
                        o.put(str, uMImprintPreProcessCallback);
                        UMRTLog.i("MobclickRT", "--->>> registPreProcessCallback: key : " + str + " regist success.");
                    } else {
                        UMRTLog.i("MobclickRT", "--->>> key : " + str + " PreProcesser has registed!");
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(k, th);
                }
            }
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (p) {
                try {
                    if (o.containsKey(str)) {
                        UMRTLog.i("MobclickRT", "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                        f.remove(str);
                    } else {
                        UMRTLog.i("MobclickRT", "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(k, th);
                }
            }
        }
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((e) entry.getValue()).d()) {
                sb.append(((e) entry.getValue()).b());
            }
            sb.append(((e) entry.getValue()).e());
            sb.append(((e) entry.getValue()).h());
        }
        sb.append(dVar.b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (e eVar : dVar.c().values()) {
            byte[] reverseHexString = DataHelper.reverseHexString(eVar.h());
            byte[] a2 = a(eVar);
            int i2 = 0;
            while (true) {
                if (i2 < 4) {
                    if (reverseHexString[i2] != a2[i2]) {
                        return false;
                    }
                    i2++;
                }
            }
        }
        return true;
    }

    public byte[] a(e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = d;
        byte[] bArr2 = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i2] = (byte) (array[i2] ^ bArr[i2]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar = this.i;
                if (dVar == null) {
                    return null;
                }
                if (dVar.b() <= 0) {
                    return null;
                }
                return new br().a(this.i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(k, th);
            return null;
        }
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, e> c2 = dVar.c();
        if (c2.containsKey("umtt")) {
            c2.remove("umtt");
            this.h.a("umtt");
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d dVar2;
        boolean z;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d("MobclickRT", "Imprint is null");
            }
        } else if (c(dVar)) {
            boolean z2 = AnalyticsConstants.UM_DEBUG;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar3 = this.i;
                com.umeng.commonsdk.statistics.proto.d d2 = d(dVar);
                String str = null;
                String i2 = dVar3 == null ? null : dVar3.i();
                if (dVar3 == null) {
                    dVar2 = e(d2);
                } else {
                    dVar2 = a(dVar3, d2, hashMap);
                }
                this.i = dVar2;
                if (dVar2 != null) {
                    str = dVar2.i();
                }
                z = !a(i2, str);
            }
            if (this.i != null) {
                boolean z3 = AnalyticsConstants.UM_DEBUG;
                if (z) {
                    this.h.a(this.i);
                    d dVar4 = this.e;
                    if (dVar4 != null) {
                        dVar4.onImprintChanged(this.h);
                    }
                }
            }
            if (hashMap.size() > 0) {
                synchronized (g) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f.get(key);
                            if (arrayList != null) {
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    arrayList.get(i3).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                }
            }
        } else if (AnalyticsConstants.UM_DEBUG) {
            UMRTLog.e("MobclickRT", "Imprint is not valid");
        }
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        ArrayList<UMImprintChangeCallback> arrayList;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, e> c2 = dVar.c();
        for (Map.Entry<String, e> entry : dVar2.c().entrySet()) {
            int i2 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().a;
                synchronized (p) {
                    if (!TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    c2.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        if (!TextUtils.isEmpty(key) && f.containsKey(key) && f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i("MobclickRT", "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (g) {
                    if (!TextUtils.isEmpty(key2) && f.containsKey(key2) && (arrayList = f.get(key2)) != null) {
                        while (i2 < arrayList.size()) {
                            arrayList.get(i2).onImprintValueChanged(key2, null);
                            i2++;
                        }
                    }
                }
                c2.remove(key2);
                this.h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, e> c2 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c2.size() / 2);
        Iterator<Map.Entry<String, e>> it2 = c2.entrySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                Map.Entry<String, e> next = it2.next();
                if (!next.getValue().d()) {
                    arrayList3.add(next.getKey());
                } else {
                    String key = next.getKey();
                    String str = next.getValue().a;
                    synchronized (p) {
                        z = !TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                    }
                    if (z) {
                        arrayList3.add(key);
                    }
                    synchronized (g) {
                        if (!TextUtils.isEmpty(key) && f.containsKey(key) && (arrayList2 = f.get(key)) != null) {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                arrayList2.get(i2).onImprintValueChanged(key, str);
                            }
                        }
                    }
                }
            } else {
                for (String str2 : arrayList3) {
                    synchronized (g) {
                        if (!TextUtils.isEmpty(str2) && f.containsKey(str2) && (arrayList = f.get(str2)) != null) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                arrayList.get(i3).onImprintValueChanged(str2, null);
                            }
                        }
                    }
                    c2.remove(str2);
                }
                return dVar;
            }
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.i;
    }

    public a c() {
        return this.h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[SYNTHETIC, Splitter:B:21:0x0038] */
    private void e() {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e2;
        File file = new File(k.getFilesDir(), ".imprint");
        synchronized (b) {
            if (file.exists()) {
                byte[] bArr = null;
                try {
                    fileInputStream = k.openFileInput(".imprint");
                    try {
                        bArr = HelperUtils.readStreamToByteArray(fileInputStream);
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            e2.printStackTrace();
                            HelperUtils.safeClose(fileInputStream);
                            if (bArr != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    fileInputStream = null;
                    e2.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    if (bArr != null) {
                    }
                } catch (Throwable th3) {
                    fileInputStream = null;
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                HelperUtils.safeClose(fileInputStream);
                if (bArr != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new bl().a(dVar, bArr);
                        this.i = dVar;
                        this.h.a(dVar);
                        this.i = d(this.i);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }

    private void a(File file) {
        if (this.i != null) {
            try {
                synchronized (b) {
                    byte[] a2 = new br().a(this.i);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(a2);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose(fileOutputStream);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.i != null && f1491l != null) {
            File file = new File(k.getFilesDir(), ".imprint");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        UMCrashManager.reportCrash(k, e2);
                    }
                }
            }
            f1491l.doFileOperateion(file, j, 1);
        }
    }

    public static class a {
        private Map<String, String> a = new HashMap();

        a() {
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar != null) {
                b(dVar);
            }
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            e eVar;
            if (dVar != null) {
                try {
                    if (dVar.e()) {
                        Map<String, e> c = dVar.c();
                        for (String str : c.keySet()) {
                            if (!TextUtils.isEmpty(str) && (eVar = c.get(str)) != null) {
                                String b = eVar.b();
                                if (!TextUtils.isEmpty(b)) {
                                    this.a.put(str, b);
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        Log.i("ImprintHandler", "imKey is " + str + ", imValue is " + b);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (this.a.size() > 0) {
                    String str3 = this.a.get(str);
                    if (!TextUtils.isEmpty(str3)) {
                        return str3;
                    }
                    return str2;
                }
            }
            return str2;
        }
    }
}
