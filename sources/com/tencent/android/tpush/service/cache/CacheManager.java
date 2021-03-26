package com.tencent.android.tpush.service.cache;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class CacheManager {
    private static void a(String str) {
    }

    private CacheManager() {
    }

    /* compiled from: ProGuard */
    static class a implements Runnable {
        private Context a;
        private Map<Long, RegisterEntity> b = new HashMap();

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a(com.tencent.android.tpush.a.c(CacheManager.getContext()));
            } catch (Throwable unused) {
            }
        }

        public synchronized void a(Map<Long, RegisterEntity> map) {
            this.b = map;
        }

        public synchronized Map<Long, RegisterEntity> a() {
            return this.b;
        }
    }

    public static Map<Long, RegisterEntity> getRegInfoByApps(Context context) {
        a aVar = new a(context);
        Thread thread = new Thread(aVar);
        thread.start();
        try {
            thread.join(3500);
        } catch (Throwable th) {
            TLogger.e("CacheManager", th.toString());
        }
        return aVar.a();
    }

    public static String findValidPackageByAccessid(long j) {
        RegisterEntity registerEntity = getRegisterEntityMap().get(Long.valueOf(j));
        if (registerEntity == null || !registerEntity.isRegistered()) {
            return null;
        }
        return registerEntity.packageName;
    }

    public static RegisterEntity findValidRegisterEntityByPkg(String str) {
        if (j.b(str)) {
            return null;
        }
        for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
            RegisterEntity value = entry.getValue();
            if (value != null && str.equals(value.packageName)) {
                return value;
            }
        }
        return null;
    }

    public static void removeRegisterInfos(String str) {
        a(str, (byte) 1);
    }

    public static List<String> getRegisterInfos(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
                RegisterEntity value = entry.getValue();
                if (value != null && !j.b(value.packageName) && value.isRegistered()) {
                    arrayList.add(value.packageName);
                }
            }
        } catch (Throwable th) {
            TLogger.e("CacheManager", "", th);
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(context.getPackageName())) {
            arrayList.add(context.getPackageName());
        }
        return arrayList;
    }

    public static synchronized Map<Long, RegisterEntity> getRegisterEntityMap() {
        Map<Long, RegisterEntity> regInfoByApps;
        synchronized (CacheManager.class) {
            regInfoByApps = getRegInfoByApps(getContext());
        }
        return regInfoByApps;
    }

    public static RegisterEntity getCurrentAppRegisterEntity(Context context) {
        String string = PushPreferences.getString(context, a("cur.register", ".reg"), "");
        if (!j.b(string)) {
            return RegisterEntity.decode(string);
        }
        return null;
    }

    public static void setCurrentAppRegisterEntity(Context context, RegisterEntity registerEntity) {
        PushPreferences.putString(context, a("cur.register", ".reg"), RegisterEntity.encode(registerEntity));
    }

    public static Context getContext() {
        if (b.e() != null) {
            return b.e();
        }
        return XGPushManager.getContext();
    }

    public static void addRegisterInfo(RegisterEntity registerEntity) {
        if (registerEntity != null && registerEntity.accessId > 0) {
            getRegisterEntityMap().put(Long.valueOf(registerEntity.accessId), registerEntity);
        }
    }

    public static List<RegisterEntity> getRegisterInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
                RegisterEntity value = entry.getValue();
                if (value != null && value.isRegistered()) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public static RegisterEntity getRegisterInfoByPkgName(String str) {
        return findValidRegisterEntityByPkg(str);
    }

    public static void UnregisterInfoByPkgName(String str) {
        a(str, (byte) 1);
    }

    public static void UnregisterInfoSuccessByPkgName(String str) {
        a(str, (byte) 3);
    }

    private static void a(String str, byte b) {
        if (!j.b(str)) {
            for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
                RegisterEntity value = entry.getValue();
                if (value != null && !j.b(value.packageName) && str.equals(value.packageName)) {
                    value.state = b;
                }
            }
        }
    }

    public static void UninstallInfoByPkgName(String str) {
        a(str, (byte) 2);
    }

    public static void UninstallInfoSuccessByPkgName(String str) {
        a(str, (byte) 4);
    }

    public static void removeRegisterInfoByPkgName(String str) {
        a(str);
    }

    public static String getToken(Context context) {
        return GuidInfoManager.getToken(context);
    }

    public static long getGuid(Context context) {
        return GuidInfoManager.getGuid(context);
    }

    public static String getQua(Context context, long j) {
        if (context == null) {
            return "";
        }
        return Rijndael.decrypt(PushPreferences.getString(context, ".com.tencent.tpush.cache.qua." + j, ""));
    }

    public static void setQua(Context context, long j, String str) {
        if (context != null && !j.b(str) && j > 0) {
            PushPreferences.putString(context, ".com.tencent.tpush.cache.qua." + j, str);
        }
    }

    public static void saveDomain(Context context, String str) {
        if (context != null && str != null) {
            PushPreferences.putString(context, ".com.tencent.tpush.cache.domain", str);
        }
    }

    public static String getDomain(Context context) {
        if (context != null) {
            PushPreferences.getString(context, ".com.tencent.tpush.cache.domain", "");
        }
        return "";
    }

    public static void saveDomainKeyList(Context context, ArrayList<String> arrayList) {
        String str;
        if (context != null) {
            if (arrayList != null) {
                try {
                    str = f.a(arrayList);
                } catch (Throwable th) {
                    TLogger.e("CacheManager", "", th);
                    return;
                }
            } else {
                str = "";
            }
            PushPreferences.putString(context, ".com.tencent.tpush.cache.domain.key", Rijndael.encrypt(str));
        }
    }

    public static void saveDomainKey(Context context, String str) {
        ArrayList<String> arrayList;
        if (context != null) {
            try {
                arrayList = getDomainKeyList(context);
            } catch (Throwable unused) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(str);
            saveDomainKeyList(context, arrayList);
        }
    }

    public static ArrayList<String> getDomainKeyList(Context context) {
        if (context != null) {
            try {
                Object a2 = f.a(Rijndael.decrypt(PushPreferences.getString(context, ".com.tencent.tpush.cache.domain.key", "")));
                if (a2 instanceof ArrayList) {
                    return (ArrayList) a2;
                }
                throw new NullReturnException("getDomainKeyList return null,because object not instance of ArrayList<?>");
            } catch (Exception e) {
                throw new NullReturnException("getDomainKeyList return null，deseriallize err", e);
            }
        } else {
            throw new NullReturnException("getDomainKeyList return null,because ctx is null");
        }
    }

    public static void clearDomainServerItem(Context context) {
        ArrayList<String> arrayList;
        try {
            arrayList = getDomainKeyList(context);
        } catch (NullReturnException unused) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(String.valueOf((int) MobileType.CHINAMOBILE.getType()));
        arrayList.add(String.valueOf((int) MobileType.TELCOM.getType()));
        arrayList.add(String.valueOf((int) MobileType.UNICOM.getType()));
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                PushPreferences.putString(context, it2.next() + ".com.tencent.tpush.cache.server", "");
            } catch (Throwable th) {
                TLogger.e("CacheManager", "", th);
            }
        }
    }

    private static String a(String str, String str2) {
        return str + ".com.tencent.tpush.cache" + str2;
    }
}
